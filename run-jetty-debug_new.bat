set MAVEN_OPTS=-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8484,server=y,suspend=n -Xmx512m -XX:MaxPermSize=128m -Dfile=C:\Users\harikesh.kumar\.m2\repository\com\oracle\ojdbc6\11.2.0.4\ojdbc6-11.2.0.4.jar -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.4.0 -Dpackaging=jar
call mvn clean jetty:run %1
