FROM bellsoft/liberica-openjdk-alpine:latest
RUN apk add -U tzdata
ENV TZ America/Lima
RUN ln -snf /usr/share/zoneinfo/${TZ} /etc/localtime
RUN echo "${TZ}" > /etc/timezone
VOLUME /tmp
EXPOSE 8009
ADD ./target/ayllusinchi-servicio-proyecto-0.0.1-SNAPSHOT.jar ayllusinchi-servicio-proyecto-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/ayllusinchi-servicio-proyecto-0.0.1-SNAPSHOT.jar"]