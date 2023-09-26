@echo off    
echo Compiling class and jar files

for /r %%a in (.) do (javac %%a\*.java)

jar cfe Spil.jar Spil.Spil Spil/*.class
jar cfe Test.jar Test.Test Spil/*.class Test/*.class