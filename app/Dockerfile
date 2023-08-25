FROM public.ecr.aws/amazoncorretto/amazoncorretto:11 AS base

LABEL MAINTENER="Marcos Vinicius A.Rocha"

ENV PORT=8081

ARG JAR_FILE=vinychat-api-application.jar

ADD ${JAR_FILE} app.jar
ADD app.sh /

RUN chmod 0755 /app.sh

CMD /app.sh

EXPOSE ${PORT}