@echo off
echo Starting Spring Boot Application...
java -cp "target/classes;%USERPROFILE%\.m2\repository\*" com.examly.springapp.SpringappApplication
pause