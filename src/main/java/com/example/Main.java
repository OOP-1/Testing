package com.example;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.DefaultGasProvider;

public class Main {
    public static void main(String[] args) throws Exception {
        Web3j web3j = BlockchainConnector.connect();
        Credentials credentials = BlockchainConnector.loadCredentials();

        // todo : 개인 컨트렉트 어드레스
        String contractAddress = "0xe1497ab3212196dea65834f1f61abae9156673b5";
        MessageStore contract = MessageStore.load(
                contractAddress,
                web3j,
                BlockchainConnector.createTxManager(web3j, credentials),
                new DefaultGasProvider()
        );
        BlockchainMessageService service = new BlockchainMessageService(web3j, credentials, contractAddress);

        String originalMessage = "블록체인에 저장될 메시지";
        String key = "msg1";
        String hash = HashUtil.sha256(originalMessage);

        // 메시지 저장
        service.store(key, hash);
        System.out.println("✅ 메시지 해시 저장 완료");

        System.out.println("✅ 저장 완료. 2초 대기 후 조회...");
        Thread.sleep(2000);

        // 메시지 조회
        Boolean exists = contract.hasMessage(key).send();
        System.out.println("🔍 해당 key 존재함? " + exists);

        if (exists) {
            String saved = contract.getMessage(key).send();
            System.out.println("📦 저장된 해시: " + saved);

            // 6. 검증
            if (saved.equals(hash)) {
                System.out.println("✅ 해시 일치: 위변조 없음");
            } else {
                System.out.println("❌ 해시 불일치: 데이터 위변조 가능성 있음");
            }
        } else {
            System.out.println("❌ 해당 key에 대한 메시지가 없습니다.");
        }
    }
}
