all: bst.cmx main.cmx
	ocamlopt -o main.out bst.cmx main.cmx

%.cmi: %.mli
	ocamlopt -c $<

%.cmx: %.ml
	ocamlopt -c $<


bst.cmx: bst.cmi
