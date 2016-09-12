CC ?= gcc
CFLAGS += -pedantic -std=c99

SRCS := $(wildcard */*.c)
OBJS := $(SRCS:%.c=%.out)
TESTS := $(addprefix test/,$(OBJS))
CLEANS := $(addprefix clean/,$(OBJS))

all: $(OBJS)

%.out: %.c
	$(CC) $(CFLAGS) $< -o $@

test: $(TESTS)

$(TESTS): test/%:
	$*

clean: $(CLEANS)

$(CLEANS): clean/%:
	rm -f $*

.PHONY: all test $(TESTS) $(CLEANS)
