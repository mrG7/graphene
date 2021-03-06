@echo off
echo Building offline
echo Cleaning all target directories, twice. Sometimes Windows holds onto file handles.
echo.
echo Run 'mvn clean' by itself if there is a failure in cleaning, and make sure no files in any of the target directories is open or being used.
echo if tests fail, add '-DskipTests=true' after the 'mvn install' goal.
mvn clean -Dmaven.clean.failOnError=false && mvn clean -Dmaven.clean.failOnError=false && mvn install -o