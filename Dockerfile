FROM tomcat:jre17-temurin-noble
LABEL maintainer="milan.karajovic.eng@gmal.com"

ADD build/libs/test-milan-karajovic-presscetnric-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml

EXPOSE 8080
CMD ["catalina.sh", "run"]