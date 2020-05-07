echo off
title KafkaConsumer

set CLASSPATH=.;conf;libs\sample.jar

for %%i in ("libs\slf4j\*.jar") do call appendenv %%i
for %%i in ("libs\kafka\*.jar") do call appendenv %%i


if [%JAVA_HOME%]==[] goto setjava

echo  %JAVA_HOME%
echo  %CLASSPATH%

echo on

%JAVA_HOME%\bin\java net.atos.sample.kafka.ConsumerSample
goto :EOF

:setjava
echo JAVA_HOME not set.
goto :EOF
