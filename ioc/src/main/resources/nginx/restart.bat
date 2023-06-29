@echo off
echo Stopping nginx...
taskkill /F /IM nginx.exe > nul
echo Stopping nginx over


set nginx_home=./

echo Starting nginx...
RunHiddenConsole %nginx_home%/nginx.exe -p %nginx_home%
echo Starting nginx over
