### To run locally

***Bash***
```
git clone https://github.com/harshpx/CodeboxServer.git

cd CodeboxServer

cat ./src/main/resources/sample.secrets.properties > ./src/main/resources/s
ecrets.properties

### Now add your api keys inside secrets.properties ###

mvn clean install && mvn spring-boot:run
```