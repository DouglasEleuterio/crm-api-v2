FROM maven:3.8.7-amazoncorretto-17 AS build

ARG REVISION
ARG PROFILE
ARG PROJECT

COPY . .

RUN --mount=type=cache,target=/root/.m2 mvn -B -Drevision=${REVISION} -P ${PROFILE} package -DskipTests


FROM amazoncorretto:17.0.6-alpine

#Descomentar essa parte caso a aplicação precise instalar fontes proprietárias
#RUN apk add --no-cache ttf-dejavu msttcorefonts-installer fontconfig && update-ms-fonts && fc-cache -f

ARG REVISION
ARG PROJECT

COPY --from=build ${PROJECT}/target/${PROJECT}-${REVISION}.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
