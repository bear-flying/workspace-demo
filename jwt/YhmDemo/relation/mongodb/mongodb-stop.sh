#!/bin/bash

#cd bin

echo "Stop MongoDB..."

./mongod -f ../mongodb.conf -shutdown


echo "Stop OK"
