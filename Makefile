# Paths
SRC_JAVA := src/main/java
SRC_SCALA := src/main/scala
OUT := out
SCALA_LIB := /usr/share/scala/lib/scala-library.jar

# Java files
JAVA_FILES := $(wildcard $(SRC_JAVA)/*.java)
SCALA_FILES := $(wildcard $(SRC_SCALA)/*.scala)

# Default target
all: run

# Create output directory
$(OUT):
	mkdir -p $(OUT)

# Compile Java
$(OUT)/java: $(JAVA_FILES) | $(OUT)
	javac -d $(OUT) $(JAVA_FILES)
	touch $(OUT)/java

# Compile Scala (depends on Java being compiled)
$(OUT)/scala: $(SCALA_FILES) $(OUT)/java
	scalac -classpath $(OUT) -d $(OUT) $(SCALA_FILES)
	touch $(OUT)/scala

# Run the application
run: $(OUT)/scala
	java -classpath "$(OUT):$(SCALA_LIB)" Main

# Clean compiled classes
clean:
	rm -rf $(OUT)

