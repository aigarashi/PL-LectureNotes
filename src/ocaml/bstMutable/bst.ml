(* Works only in OCaml 4.03.0 or above *)
(* Mutable binary search tree *)

(* Defining the shape of trees *)
type tree =
    Lf       (* Leaf *)
  | Br of {  (* Branch *)
      mutable left:  tree;  (* all fields are mutable *)
      mutable value: int;
      mutable right: tree;
    }
(* (Recursive) function find, which returns whether given integer n exists in BST t *)
let rec find t n =
  match t with
    Lf -> false
  | Br {left=l; value=v; right=r} ->
     if n = v then true
     else if n < v then find l n
     else find r n

(* (Recursive) function insert, which, given BST t and a new element n, returns 
   a new binary search tree with n *)
let rec insert t n =
  match t with
    Lf -> Br {left=Lf; value=n; right=Lf}
  | Br br ->
     if n = br.value then t
     else if n < br.value then (br.left <- insert br.left n; t)
     else (br.right <- insert br.right n; t)

(* Function min, which, given BST t, returns the minimum value stored in t.
   If t is empty, it returns -255. *)
let rec min t =
  match t with
    Lf -> -255
  | Br {left=Lf; value=v; right=_} -> v
  | Br {left=l; value=_; right=_} -> min l
      
(* (Recursive) function delete, which, given BST t and an element n to
   be deleted, returns a new binary search tree without n.  If n is not
   stored in t, it returns t as it is. *)

let rec delete t n =
  match t with
    Lf -> t
  | Br br ->
     if n = br.value then 
       match br.left, br.right with
	 Lf, Lf -> Lf
       | Br _, Lf -> br.left
       | Lf, Br _ -> br.right
       | Br _, Br _ ->
	  let m = min br.right in
	  br.right <- delete br.right m;
	  t
     else if n < br.value then (br.left <- delete br.left n; t)
     else (* n > br.value *) (br.right <- delete br.right n; t)

(* These functions could be used directly but a user has to maintain
   the returned root.  Code below is to make code "more imperative" *)
			       
(* Another datatype to represent the root of a tree *)
type bst = {mutable root: tree} 
	     
(* Proxy functions.  They have the same name to prevent the original
   definitions from being called by mistake *)

(* find : bst -> int *)
let find r n = find r.root n

(* insert : bst -> unit *)
let insert t n =
  t.root <- insert t.root n

(* delete : bst -> unit *)
let delete r n =
  r.root <- delete r.root n

		   
(* Constructing a sample tree *)
let t1 = Br {left = Lf; value = 10; right = Lf}
let t2 = Br {left = Lf; value = 25; right = Lf}
let t3 = Br {left = t1; value = 15; right = t2}
let t4 = Br {left = Lf; value = 60; right = Lf}
let t5 = Br {left = Lf; value = 48; right = t4}
let t6 = Br {left = t3; value = 30; right = t5}
let t = {root = t6}

(* Testing find *)
let test1 = find t 30  (* should be true *)
let test2 = find t 13  (* should be false *)

(* Testing insert *)
let () = insert t 23
let () = insert t 0
let test3 = find t 23  (* should return true *)
let test4 = find t 30  (* should return false *)
let test5 = find t 23  (* should return false *)

(* Testing delete *)
let () = delete t 30
let test6 = find t 30
let test7 = find t 48
	     
module Aux =
struct
  let rec preorder t =
    match t with
      Lf -> []
    | Br {left=l; value=v; right=r} ->
       preorder l @ v :: preorder r
end
