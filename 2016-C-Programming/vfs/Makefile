C_FILES = $(wildcard src/*.c)
O_FILES = $(patsubst %.c,%.o,$(C_FILES))

.PHONY: all clean
.DEFAULT: all

all: program

program: $(O_FILES)
	gcc -o $@ $^

build:
	mkdir -p build

build/%.o: src/%.c | build
	gcc -c -Wall -Wextra $< -o $@

clean:
	rm -f $(O_FILES)
	rm -f program
	rm -rf build

