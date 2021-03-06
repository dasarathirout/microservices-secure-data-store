
# Microservices Secure Data Store (M-SDS)

### https://github.com/dasarathirout/microservices-secure-data-store

### Individual Service Build & Run.
| USE CASE    | Command Description |
| ----------- | ------------------- |
| CLONE REPO| `git clone https://github.com/dasarathirout/microservices-secure-data-store.git` |
| GO TO REPO ROOT DIR | `cd microservices-secure-data-store` |
| FOR BUILD HELP | `1CLICK.BAT` Show Help Options For CLI|
| SERVICE-CORE BUILD & RUN | `1CLICK.BAT 0` Do Gradle Build For Service-Core & Run on `8080` |
| SERVICE-ONE BUILD & RUN | `1CLICK.BAT 1` Do Gradle Build For Service-One & Run on `8181`|
| SERVICE-TWO BUILD & RUN | `1CLICK.BAT 2` Do Gradle Build For Service-One & Run on `8282`|
#### Everytime service-core build , we need to run `gradlew service-core:generateProto` along with.
#### As gRPC proto definition is on service-core repo, so we need to generate java stubs through gradle plugin.
https://github.com/dasarathirout/microservices-secure-data-store/blob/master/service-core/src/main/proto/services/updateuser.proto
 
### Single Click Build & Run.
| USE CASE    | Command Description |
| ----------- | ------------------- |
| CLONE REPO| `git clone https://github.com/dasarathirout/microservices-secure-data-store.git` |
| GO TO REPO ROOT DIR | `cd microservices-secure-data-store` |
| ALL SERVICES BUILD & RUN | `2RUN.BAT` Build Compile & Run All Services|

#### Data Are Saved Under Respective Format :
`microservices-secure-data-store\service-core\FDB\CSV`,
`microservices-secure-data-store\service-core\FDB\JSON`,
`microservices-secure-data-store\service-core\FDB\XML`,

#### Postman API Test Collections `microservices-secure-data-store\utility`
https://github.com/dasarathirout/microservices-secure-data-store/blob/master/utility/SB-SDS-MB.postman-api-collection.json
