@echo off
set SRC_DIR=src
set OUT_DIR=compiled

if not exist %OUT_DIR% (
    mkdir %OUT_DIR%
)

echo Compiling the program...

javac -d %OUT_DIR% %SRC_DIR%\*.java

echo Compilation finished.
echo Running the program...

java -cp %OUT_DIR% Main

echo Program finished.

pause