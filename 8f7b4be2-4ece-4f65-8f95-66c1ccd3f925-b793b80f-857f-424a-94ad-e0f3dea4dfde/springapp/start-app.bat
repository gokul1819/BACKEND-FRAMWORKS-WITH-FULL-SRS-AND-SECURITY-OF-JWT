@echo off
echo ========================================
echo Spring Boot Application Startup
echo ========================================

echo Checking MySQL connection...
netstat -an | findstr 3306 >nul
if %errorlevel% neq 0 (
    echo ERROR: MySQL is not running on port 3306
    echo Please start MySQL service first
    pause
    exit /b 1
)
echo MySQL is running ✓

echo.
echo Starting Spring Boot Application...
echo Application will be available at: http://localhost:8080
echo Test endpoint: http://localhost:8080/test
echo Health check: http://localhost:8080/health
echo.

cd /d "%~dp0"
java -Dspring.profiles.active=default ^
     -Dserver.port=8080 ^
     -cp "target/classes" ^
     com.examly.springapp.SpringappApplication

echo.
echo Application stopped.
pause