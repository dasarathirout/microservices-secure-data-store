@echo off
cls
set service=%1

if "%service%" == "" goto serviceRoot
if "%service%" == "0" goto serviceCore
if "%service%" == "1" goto serviceOne
if "%service%" == "2" goto serviceTwo
echo '====================== Welcome ============================'

:help
title HELP
echo 'GO TO THE PROJECT ROOT DIR'
echo '1CLICK.BAT (For microservices-secure-data-store CLEAN=BUILD)'
echo '1CLICK.BAT 0 (For service-core CLEAN=BUILD=RUN)'
echo '1CLICK.BAT 1 (For service-one CLEAN=BUILD=RUN)'
echo '1CLICK.BAT 2 (For service-two CLEAN=BUILD=RUN)'
goto completed

:serviceRoot
title ServiceRoot
echo '====================== microservices-secure-data-store CLEAN=BUILD ============================'
call gradlew clean
call gradlew build
goto completed

:serviceCore
title ServiceCore
echo '====================== service-core CLEAN=BUILD=RUN ============================'
call gradlew service-core:clean
call gradlew service-core:build
call gradlew service-core:generateProto
call gradlew service-core:run
goto completed

:serviceOne
title ServiceOne
echo '====================== service-one CLEAN=BUILD=RUN ============================'
call gradlew service-one:clean
call gradlew service-one:build
call gradlew service-one:run
goto completed

:serviceTwo
title ServiceTwo
echo '====================== service-two CLEAN=BUILD=RUN ============================'
call gradlew service-two:clean
call gradlew service-two:build
call gradlew service-two:run
goto completed

:completed
echo '====================== DONE! Bye Bye ============================'
goto endWorld
:endWorld
