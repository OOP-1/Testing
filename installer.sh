#!/bin/bash

set -e

WEB3J_VERSION=$(curl --silent "https://api.github.com/repos/LFDT-web3j/web3j-cli/releases/latest" | grep tag_name | cut -d '"' -f 4 | sed 's/v//')
INSTALL_DIR="$HOME/.web3j"
DOWNLOAD_URL="https://github.com/LFDT-web3j/web3j-cli/releases/download/v${WEB3J_VERSION}/web3j-cli-shadow-${WEB3J_VERSION}.tar"
ARCHIVE_NAME="web3j-cli-shadow-${WEB3J_VERSION}.tar"
TARGET_DIR="${INSTALL_DIR}/web3j-cli-shadow-${WEB3J_VERSION}"

echo "📦 Installing Web3j CLI v${WEB3J_VERSION}..."
mkdir -p "$INSTALL_DIR"

echo "⬇️  Downloading Web3j from:"
echo "$DOWNLOAD_URL"
curl -L -o "${INSTALL_DIR}/${ARCHIVE_NAME}" "$DOWNLOAD_URL"

echo "📂 Extracting..."
tar -xf "${INSTALL_DIR}/${ARCHIVE_NAME}" -C "$INSTALL_DIR"

# Cleanup
rm "${INSTALL_DIR}/${ARCHIVE_NAME}"

# Symlink 생성
ln -sf "${TARGET_DIR}/bin/web3j" "${INSTALL_DIR}/web3j"

# 자동 source 추가 (.zshrc 우선, 없으면 .bash_profile)
SOURCE_LINE='export PATH="$HOME/.web3j:$PATH"'
SHELL_CONFIG=""

if [ -f "$HOME/.zshrc" ]; then
    SHELL_CONFIG="$HOME/.zshrc"
elif [ -f "$HOME/.bash_profile" ]; then
    SHELL_CONFIG="$HOME/.bash_profile"
else
    SHELL_CONFIG="$HOME/.profile"
fi

if ! grep -q 'web3j' "$SHELL_CONFIG"; then
    echo "$SOURCE_LINE" >> "$SHELL_CONFIG"
    echo "✅ PATH 설정을 $SHELL_CONFIG 에 추가했습니다."
fi

echo "✅ 설치 완료!"
echo "🔁 현재 셸에서 바로 사용하려면 다음을 실행하세요:"
echo "source $SHELL_CONFIG"
echo "🧪 버전 확인: web3j version"
