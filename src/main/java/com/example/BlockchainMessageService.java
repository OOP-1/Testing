package com.example;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

public class BlockchainMessageService {
    private final MessageStore contract;

    public BlockchainMessageService(Web3j web3j, Credentials credentials, String contractAddress) {
        TransactionManager txManager = BlockchainConnector.createTxManager(web3j, credentials);
        this.contract = MessageStore.load(contractAddress, web3j, txManager, new DefaultGasProvider());
    }

    public void store(String key, String hash) throws Exception {
        contract.storeMessage(key, hash).send();
    }

    public String load(String key) throws Exception {
        return contract.getMessage(key).send();
    }
}
