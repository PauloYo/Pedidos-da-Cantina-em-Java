#!/bin/bash

SRC_DIR="src"
OUT_DIR="compiled"

if [ ! -d "$OUT_DIR" ]; then
  mkdir "$OUT_DIR"
fi

echo "Compiling the program..."

javac -d "$OUT_DIR" "$SRC_DIR"/*.java

echo "Compilation finished."
echo "Running the program..."

java -cp "$OUT_DIR" Main

echo "Program finished."