package com.example;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/hyperledger-web3j/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.6.3.
 */
@SuppressWarnings("rawtypes")
public class MessageStore extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5061092c806100206000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80630cc4e8d814610051578063385c828c1461008157806357545e4d146100b157806377c2e481146100cd575b600080fd5b61006b60048036038101906100669190610423565b6100fd565b60405161007891906104eb565b60405180910390f35b61009b60048036038101906100969190610423565b6101ad565b6040516100a891906104eb565b60405180910390f35b6100cb60048036038101906100c6919061050d565b610263565b005b6100e760048036038101906100e29190610423565b610293565b6040516100f491906105a0565b60405180910390f35b606060008260405161010f91906105f7565b908152602001604051809103902080546101289061063d565b80601f01602080910402602001604051908101604052809291908181526020018280546101549061063d565b80156101a15780601f10610176576101008083540402835291602001916101a1565b820191906000526020600020905b81548152906001019060200180831161018457829003601f168201915b50505050509050919050565b60008180516020810182018051848252602083016020850120818352809550505050505060009150905080546101e29061063d565b80601f016020809104026020016040519081016040528092919081815260200182805461020e9061063d565b801561025b5780601f106102305761010080835404028352916020019161025b565b820191906000526020600020905b81548152906001019060200180831161023e57829003601f168201915b505050505081565b8060008360405161027491906105f7565b9081526020016040518091039020908161028e9190610824565b505050565b6000806000836040516102a691906105f7565b908152602001604051809103902080546102bf9061063d565b9050119050919050565b6000604051905090565b600080fd5b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b610330826102e7565b810181811067ffffffffffffffff8211171561034f5761034e6102f8565b5b80604052505050565b60006103626102c9565b905061036e8282610327565b919050565b600067ffffffffffffffff82111561038e5761038d6102f8565b5b610397826102e7565b9050602081019050919050565b82818337600083830152505050565b60006103c66103c184610373565b610358565b9050828152602081018484840111156103e2576103e16102e2565b5b6103ed8482856103a4565b509392505050565b600082601f83011261040a576104096102dd565b5b813561041a8482602086016103b3565b91505092915050565b600060208284031215610439576104386102d3565b5b600082013567ffffffffffffffff811115610457576104566102d8565b5b610463848285016103f5565b91505092915050565b600081519050919050565b600082825260208201905092915050565b60005b838110156104a657808201518184015260208101905061048b565b60008484015250505050565b60006104bd8261046c565b6104c78185610477565b93506104d7818560208601610488565b6104e0816102e7565b840191505092915050565b6000602082019050818103600083015261050581846104b2565b905092915050565b60008060408385031215610524576105236102d3565b5b600083013567ffffffffffffffff811115610542576105416102d8565b5b61054e858286016103f5565b925050602083013567ffffffffffffffff81111561056f5761056e6102d8565b5b61057b858286016103f5565b9150509250929050565b60008115159050919050565b61059a81610585565b82525050565b60006020820190506105b56000830184610591565b92915050565b600081905092915050565b60006105d18261046c565b6105db81856105bb565b93506105eb818560208601610488565b80840191505092915050565b600061060382846105c6565b915081905092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b6000600282049050600182168061065557607f821691505b6020821081036106685761066761060e565b5b50919050565b60008190508160005260206000209050919050565b60006020601f8301049050919050565b600082821b905092915050565b6000600883026106d07fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82610693565b6106da8683610693565b95508019841693508086168417925050509392505050565b6000819050919050565b6000819050919050565b600061072161071c610717846106f2565b6106fc565b6106f2565b9050919050565b6000819050919050565b61073b83610706565b61074f61074782610728565b8484546106a0565b825550505050565b600090565b610764610757565b61076f818484610732565b505050565b5b818110156107935761078860008261075c565b600181019050610775565b5050565b601f8211156107d8576107a98161066e565b6107b284610683565b810160208510156107c1578190505b6107d56107cd85610683565b830182610774565b50505b505050565b600082821c905092915050565b60006107fb600019846008026107dd565b1980831691505092915050565b600061081483836107ea565b9150826002028217905092915050565b61082d8261046c565b67ffffffffffffffff811115610846576108456102f8565b5b610850825461063d565b61085b828285610797565b600060209050601f83116001811461088e576000841561087c578287015190505b6108868582610808565b8655506108ee565b601f19841661089c8661066e565b60005b828110156108c45784890151825560018201915060208501945060208101905061089f565b868310156108e157848901516108dd601f8916826107ea565b8355505b6001600288020188555050505b50505050505056fea264697066735822122053b1c667ff67d95ddd8a19fe3a9ca3d9bc1792362d06a4fc5c030a34b64b6e1e64736f6c63430008130033";

    private static String librariesLinkedBinary;

    public static final String FUNC_GETMESSAGE = "getMessage";

    public static final String FUNC_HASMESSAGE = "hasMessage";

    public static final String FUNC_MESSAGES = "messages";

    public static final String FUNC_STOREMESSAGE = "storeMessage";

    @Deprecated
    protected MessageStore(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MessageStore(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MessageStore(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MessageStore(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> getMessage(String key) {
        final Function function = new Function(FUNC_GETMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Boolean> hasMessage(String key) {
        final Function function = new Function(FUNC_HASMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(key)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<String> messages(String param0) {
        final Function function = new Function(FUNC_MESSAGES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> storeMessage(String key, String hash) {
        final Function function = new Function(
                FUNC_STOREMESSAGE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(key), 
                new org.web3j.abi.datatypes.Utf8String(hash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static MessageStore load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new MessageStore(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MessageStore load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MessageStore(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MessageStore load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new MessageStore(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MessageStore load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MessageStore(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MessageStore> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MessageStore.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<MessageStore> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MessageStore.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    public static RemoteCall<MessageStore> deploy(Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MessageStore.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), "");
    }

    @Deprecated
    public static RemoteCall<MessageStore> deploy(Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MessageStore.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), "");
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }
}
