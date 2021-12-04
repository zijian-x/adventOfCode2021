SRC_DIR := src/day4
src = $(wildcard $(SRC_DIR)/*.java)
BIN_DIR := bin
.class = $(patsubst src/%.java,$(BIN_DIR)/%.class,$(src))
MAIN := Main
ARGS = 

J := java
JOPT := -cp $(BIN_DIR)
JC := javac
JCOPT:= -g -cp $(SRC_DIR) -d $(BIN_DIR)

all: run

run: $(.class)
	$J $(JOPT) $(patsubst src/%,%,$(SRC_DIR)).$(MAIN) $(ARGS)

$(.class): $(src)
	$(JC) $(JCOPT) $(src)

compile:
	$(JC) $(JCOPT) $(src)

clean:
	$(RM) -rf $(.class)

clean_all:
	$(RM) -rf $(BIN_DIR)/*
