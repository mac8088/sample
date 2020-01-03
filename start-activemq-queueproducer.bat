echo off
title QueueProducer

set CLASSPATH=.;libs\sample.jar

for %%i in ("libs\activemq\*.jar") do call appendenv %%i


if [%JAVA_HOME%]==[] goto setjava

@rem start javaw 
rem echo  %CLASSPATH%
rem echo  %JAVA_HOME%

echo on

%JAVA_HOME%\bin\java net.atos.sample.mymq.activemq.QueueProducer >> queueproducer.log
goto :EOF

:setjava
echo JAVA_HOME not set.
goto :EOF
