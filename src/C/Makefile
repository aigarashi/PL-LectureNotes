CC ?= gcc
CFLAGS += -O0 -std=c99 -g -Wpedantic -Wall -Wextra

SRCS := $(wildcard */*.c)
TARGETS := $(SRCS:%.c=%.out)
TESTS := $(addprefix test/,$(TARGETS))
CLEANS := $(addprefix clean/,$(TARGETS))

all: $(TARGETS)

%.out: %.c
	$(CC) $(CFLAGS) $< -o $@

test: $(TARGETS) $(TESTS)

$(TESTS): test/%:
	$*

clean: $(CLEANS)

$(CLEANS): clean/%:
	rm -f $*

.PHONY: all test $(TESTS) $(CLEANS)
