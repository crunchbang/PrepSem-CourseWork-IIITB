CC = gcc 
CFLAGS = -Wall -Wextra -DDEBUG
C_FILES = $(wildcard src/*.c)
O_FILES = $(patsubst %.c,%.o,$(C_FILES))

.PHONY: all clean
.DEFAULT: all

all: virtualFS

virtualFS: $(O_FILES)
	gcc -o $@ $^

build:
	mkdir -p build

build/%.o: src/%.c | build
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -f $(O_FILES)
	rm -f program
	rm -rf build

