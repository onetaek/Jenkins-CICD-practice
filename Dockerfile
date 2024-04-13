# ARG를 통해 빌드 시에 받을 환경 변수를 정의합니다.
ARG APPLICATION_VALUE1
ARG APPLICATION_VALUE2

FROM amazoncorretto:17 AS builder

# Dockerfile에서 ARG로 받은 환경 변수를 ENV로 설정합니다.
ENV APPLICATION_VALUE1=${APPLICATION_VALUE1}
ENV APPLICATION_VALUE2=${APPLICATION_VALUE2}

WORKDIR /app
COPY gradlew build.gradle settings.gradle ./
COPY gradle ./gradle
COPY src/main ./src/main
RUN chmod +x ./gradlew && \
    sed -i 's/\r//' ./gradlew && \
    ./gradlew bootJar

# Final stage
FROM amazoncorretto:17

WORKDIR /app
COPY --from=builder /app/build/libs/jenkins-project-*.jar app.jar

ENTRYPOINT java -jar app.jar

#ENV PROFILE="dev"

#ENTRYPOINT java -jar app.jar --spring.profiles.active=$PROFILE