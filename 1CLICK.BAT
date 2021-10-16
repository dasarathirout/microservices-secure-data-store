cls
set service=%1

if "%service%" == "" goto serviceRoot
if "%service%" == "0" goto serviceCore
if "%service%" == "1" goto serviceOne
if "%service%" == "2" goto serviceTwo

:serviceRoot
call gradlew clean
call gradlew build
goto completed

:serviceCore
call gradlew service-core:clean
call gradlew service-core:build
call gradlew service-core:run
goto completed


:serviceOne
call gradlew service-one:clean
call gradlew service-one:build
call gradlew service-one:run
goto completed


:serviceTwo
call gradlew service-two:clean
call gradlew service-two:build
call gradlew service-two:run
goto completed

:completed
echo '-- DONE ! --'
