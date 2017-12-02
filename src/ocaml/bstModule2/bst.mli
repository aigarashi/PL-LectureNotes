type t

(* empty tree *)
val empty : t

(* find t n, which returns whether given integer n exists in BST t *)
val find : t * int -> bool

(* insert, which, given BST t and a new element n, returns a new
   binary search tree with n *)
val insert : t * int -> t

(* delete, which, given BST t and an element n to be deleted, returns
   a new binary search tree without n.  If n is not stored in t, it
   returns t as it is. *)
val delete : t * int -> t
