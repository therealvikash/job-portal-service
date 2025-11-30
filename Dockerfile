# ----------------------------
# 1) BUILD STAGE
# ----------------------------
FROM gradle:8-jdk21 AS build
WORKDIR /app

# copy everything into container
COPY --chown=gradle:gradle . .

# build the Spring Boot fat jar
RUN gradle clean bootJar --no-daemon


# ----------------------------
# 2) RUNTIME STAGE
# ----------------------------
FROM eclipse-temurin:21-jre
WORKDIR /app

# copy jar from the build stage (automatically picks your bootJar)
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

