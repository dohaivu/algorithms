# Overview

Problems in Computer Science

## Build

```bash
mvn compile

java -cp target/classes study.tree.BinarySearchTree

javac -d target/classes src/main/java/study/Warmup.java

# dependency
javac -d target/classes src/main/java/study/Utils.java src/main/java/study/array/RotateMatrix.java
javac -d target/classes src/main/java/study/*.java src/main/java/study/tree/*.java

python src/main/python/solution.py
```

### Kotlin

```bash
kotlinc -d target/classes/ src/main/kotlin/hello.kt
java -cp /usr/local/Cellar/kotlin/1.2.31/libexec/lib/kotlin-runtime.jar:target/classes HelloKt
```