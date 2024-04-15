FROM amazoncorretto:17 AS builder

WORKDIR /app
COPY build/libs/jenkins-project-*.jar app.jar

FROM amazoncorretto:17

WORKDIR /app
COPY --from=builder /app/app.jar app.jar

ENTRYPOINT java -jar app.jar

# ARG를 통해 빌드 시 사용하는 환경 변수 정의
#ARG APPLICATION_VALUE1
#ARG APPLICATION_VALUE2

#FROM amazoncorretto:17 AS builder
#
#WORKDIR /app
#COPY gradlew build.gradle settings.gradle ./
#COPY gradle ./gradle
#COPY src/main ./src/main
#RUN chmod +x ./gradlew && \
#    sed -i 's/\r//' ./gradlew && \
#    ./gradlew bootJar
#
#FROM amazoncorretto:17
#
#WORKDIR /app
#COPY --from=builder /app/build/libs/jenkins-project-*.jar app.jar
#
#ENTRYPOINT java -jar app.jar

# 환경 변수 설정 (기본값은 ARG로 정의한 값 사용)
#ENV APPLICATION_VALUE1 $APPLICATION_VALUE1
#ENV APPLICATION_VALUE2 $APPLICATION_VALUE2

