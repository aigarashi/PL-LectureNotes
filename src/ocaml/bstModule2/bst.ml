(* Works only in OCaml 4.03.0 or above *)

(* Defining the shape of trees *)
type t =
    Lf       (* Leaf *)
  | Br of {  (* Branch *)
      left:  t;
      value: int;
      right: t;
    }

let empty = Lf

(* (Recursive) function find, which returns whether given integer n exists in BST t *)
let rec find(t, n) =
  match t with
    Lf -> false
  | Br {left=l; value=v; right=r} ->
     if n = v then true
     else if n < v then find(l, n)
     else (* n > v *) find(r, n)

(* (Recursive) function insert, which, given BST t and a new element n, returns
   a new binary search tree with n *)
let rec insert(t, n) =
  match t with
    Lf -> Br {left=Lf; value=n; right=Lf}
  | Br {left=l; value=v; right=r} ->
     if n = v then t
     else if n < v then Br {left=insert(l, n); value=v; right=r}
     else (* n > v *) Br {left=l; value=v; right=insert(r, n)}

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

let rec delete(t, n) =
  match t with
    Lf -> t
  | Br {left=l; value=v; right=r} ->
     if n = v then
       match l, r with
	 Lf, Lf -> Lf
       | Br _, Lf -> l
       | Lf, Br _ -> r
       | Br _, Br _ ->
	  let m = min r in
	  Br {left=l; value=m; right=delete(r, m)}
     else if n < v then Br {left=delete(l, n); value=v; right=r}
     else (* n > v *) Br {left=l; value=v; right=delete(r, n)}
