@echo off
call mvn clean package
call docker build -t ca.baskwo/client .
call docker rm -f client
call docker run -d -p 9080:9080 -p 9443:9443 --name client ca.baskwo/client