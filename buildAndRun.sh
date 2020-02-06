#!/bin/sh
mvn clean package && docker build -t ca.baskwo/client .
docker rm -f client || true && docker run -d -p 9080:9080 -p 9443:9443 --name client ca.baskwo/client