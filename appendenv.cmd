@echo off
:appendone
if ""%1"" == """" goto done
set CLASSPATH=%CLASSPATH%;%1
shift
goto appendone
:done
