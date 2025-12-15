Run from command line:
mvn clean test -Dbrowser=chrome -Denvironment=standard_user
mvn clean test -Dbrowser=chrome -Denvironment=standard_user -Dsurefire.suiteXmlFiles=src/test/resources/testng-smoke.xml