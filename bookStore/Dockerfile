# #
# # Build stage
# #
# FROM maven:4.0.0-openjdk-21 AS build
# COPY . .
# RUN mvn clean package -DskipTests

# #
# # Package stage
# #
# FROM openjdk:21-jdk-slim
# COPY --from=build /target/bookStore-0.0.1-SNAPSHOT.jar demo.jar
# # ENV PORT=8080
# EXPOSE 8080
# ENTRYPOINT ["java","-jar","demo.jar"] 
# ------------------------------------
# Stage 1: Build the application (using Temurin JDK 21 with Maven)
# ------------------------------------
# FROM maven:3.9-eclipse-temurin-21 AS build
# COPY . .
# RUN mvn clean package -DskipTests

# # ------------------------------------
# # Stage 2: Package and Run the application (using a smaller JDK 21 image)
# # ------------------------------------
# FROM openjdk:21-jdk-slim
# COPY --from=build /target/bookStore-0.0.1-SNAPSHOT.jar demo.jar
# EXPOSE 8080
# ENTRYPOINT ["java","-jar","demo.jar"]

# ------------------------------------
# Stage 1: Build the application
# Use a common, maintained Maven/JDK image for building
# ------------------------------------
FROM maven:3.9-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

# ------------------------------------
# Stage 2: Package and Run the application
# Use a small JRE-only image for the final deployment
# ------------------------------------
FROM eclipse-temurin:21-jre-jammy  <-- THIS IS THE FIX
COPY --from=build /target/bookStore-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]