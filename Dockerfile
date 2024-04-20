FROM amazoncorretto:17 AS builder

WORKDIR /app
COPY build/libs/*-SNAPSHOT.jar app.jar

FROM amazoncorretto:17

WORKDIR /app
COPY --from=builder /app/app.jar app.jar

ENV PROFILE="dev"

ENTRYPOINT java -jar app.jar --spring.profiles.active=$PROFILE