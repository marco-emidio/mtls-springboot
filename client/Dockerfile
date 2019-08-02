FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
ADD target/client-1.0.jar client-1.0.jar
EXPOSE 8222
ENTRYPOINT exec java $JAVA_OPTS -Djavax.net.debug=ssl -jar client-1.0.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Djavax.net.debug=ssl -jar client-1.0.jar
