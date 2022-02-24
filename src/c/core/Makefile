
CC = gcc
CFLAGS = -Wall -O -g

LIB = libRegister.a # 目标文件名
OBJS = register.o

all : $(LIB)

%.o : %.c
	$(CC) $(CFLAGS) -c $< -o $@

$(LIB) : $(OBJS)
	ar cr $@ $(OBJS)

clean:
	rm -rf $(OBJS) $(LIB)
