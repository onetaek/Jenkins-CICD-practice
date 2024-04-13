FROM amazoncorretto:17 AS builder

WORKDIR /app
COPY gradlew build.gradle settings.gradle ./
COPY gradle ./gradle
COPY src/main ./src/main
RUN sed -i 's/\r//' ./gradlew && ./gradlew bootJar

# Final stage
FROM amazoncorretto:17

WORKDIR /app
COPY --from=builder /app/build/libs/jenkins-project-*.jar app.jar

#ENV PROFILE="dev"

#ENTRYPOINT java -jar app.jar --spring.profiles.active=$PROFILE
ENTRYPOINT java -jar app.jar