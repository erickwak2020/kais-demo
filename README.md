# kais-demo
kais 차세대 파일럿 프로젝트

# 환경 설정 분리
## 빌드 스크립트
### Gradle CLI 사용하기
```
#! prod
gradle clean build -Pprofile=prod
#! dev
gradle clean build
```
### Gradlew 사용하기(Gradle CLI 설치 안 한 경우)
```
 #! prod
./gradlew clean build -Pprofile=prod
#! dev
./gradlew clean build
```

## 빌드 실행하기
```
#! prod
java -jar -Dspring.profiles.active=prod application.jar

#! dev
java -jar -Dspring.profiles.active=dev application.jar

#! local pc
개발툴에서는 자바 실행 옵션에 -Dspring.profiles.active=local 추가
java -jar -Dspring.profiles.active=local application.jar

```