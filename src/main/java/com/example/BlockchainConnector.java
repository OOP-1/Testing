package com.example;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.crypto.Credentials;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;

public class BlockchainConnector {

    // todo : 개인 가나쉬 주소와 프라이빗키
    private static final String GANACHE_URL = "http://127.0.0.1:7545";
    private static final String PRIVATE_KEY = "0x70a052b5ecd1110c3911b100f23e9ab9e8d2b208bd5978c1a61764fd001553a3";

    public static Web3j connect() {
        return Web3j.build(new HttpService(GANACHE_URL));
    }

    public static Credentials loadCredentials() {
        return Credentials.create(PRIVATE_KEY);
    }

    public static TransactionManager createTxManager(Web3j web3j, Credentials credentials) {
        return new RawTransactionManager(web3j, credentials);
    }
}
