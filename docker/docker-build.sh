#!/bin/bash
cp ../target/test-mavha-1.0.0-SNAPSHOT.war .
docker build -t soyseeb/mavha-test-app .
read -rsp $'Press enter to continue...\n'