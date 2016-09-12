Project Name : inventory-webapp-master
prerequisites:
1. IDE: Eclipse IDE
2. Server : jetty server
3. JAVA : 1.8

Steps:
1- Make the db (userName : practice and passwpord : practice) in oracle.
NOTE : DB username/password details can be configured at
inventory-webapp\src\main\resources\spring_config\rootApplicationContext.xml  file

2- path of oracle jar file need to be configured in two files :
pom.xml
run-jetty-debug_new.bat

3- build the project by "using mvn clean install"
4- start the run-jetty-debug_new.bat
5- hit the url : http://localhost:8080/
   login details : superadmin/superadmin
