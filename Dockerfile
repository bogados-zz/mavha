FROM jboss/wildfly
ADD test-mavha-1.0.0-SNAPSHOT.war /opt/jboss/wildfly/standalone/deployments/
EXPOSE 8080 9990