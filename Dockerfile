FROM tomcat:7-jdk8-openjdk-slim

ADD ./webapp $CATALINA_HOME/webapps/ROOT/

CMD ["catalina.sh", "run"]
