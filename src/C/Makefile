CC ?= gcc
CFLAGS += -pedantic -std=c99

SRCS := $(wildcard */*.c)
OBJS := $(SRCS:%.c=%.out)
TESTS := $(addprefix test_,$(OBJS))
CLEANS := $(addprefix clean_,$(OBJS))

all: $(OBJS)

%.out: %.c
	$(CC) $(CFLAGS) $< -o $@

test: $(TESTS)

$(TESTS): test_%:
	$*

clean: $(CLEANS)

$(CLEANS): clean_%:
	rm -f $*

.PHONY: all test $(TESTS) $(CLEANS)
