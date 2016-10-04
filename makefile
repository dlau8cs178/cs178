# David Lau
# CS 178 Fall 2016
# Description: Makefile to build and run ServerCountThrees.

test : ServerCountThrees
	mkdir test
	cp ServerCountThrees threesData.bin test
	./test/ServerCountThrees

ServerCountThrees : ServerCountThrees.o readInt32BitLE.o
	gcc -o ServerCountThrees ServerCountThrees.o readInt32BitLE.o

ServerCountThrees.o : ServerCountThrees.c readInt32BitLE.h
	gcc -c ServerCountThrees.c

readInt32BitLE.o : readInt32BitLE.c readInt32BitLE.h
	gcc -c readInt32BitLE.c

clean:
	rm ServerCountThrees ServerCountThrees.o readInt32BitLE.o
	rm -r test

