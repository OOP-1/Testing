// SPDX-License-Identifier: MIT
pragma solidity ^0.8.19;

contract MessageStore {
    mapping(string => string) public messages;

    function storeMessage(string memory key, string memory hash) public {
        messages[key] = hash;
    }

    function getMessage(string memory key) public view returns (string memory) {
        return messages[key];
    }

    function hasMessage(string memory key) public view returns (bool) {
        return bytes(messages[key]).length > 0;
    }
}
