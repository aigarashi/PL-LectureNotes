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
let rec find(t, n) =
  match t with
    Lf -> false
  | Br {left=l; value=v; right=r} ->
     if n = v then true
     else if n < v then find(l, n)
     else (* n > v *)   find(r, n)

(* (Recursive) function insert, which, given BST t and a new element n, returns
   a new binary search tree with n *)
let rec insert(t, n) =
  match t with
    Lf -> Br {left=Lf; value=n; right=Lf}
  | Br ({left=l; value=v; right=r} as br) ->
     if n = v then t
     else if n < v then (br.left <- insert(l, n); t)
     else (br.right <- insert(r, n); t)

(* Function min, which, given BST t, returns the minimum value stored in t.
   If t is empty, it returns -255. *)
let rec min t =
  match t with
    Lf -> -255
  | Br {left=Lf; value=v; right=_} -> v
  | Br {left=l;  value=_; right=_} -> min l

(* (Recursive) function delete, which, given BST t and an element n to
   be deleted, returns a new binary search tree without n.  If n is not
   stored in t, it returns t as it is. *)
let rec delete(t, n) =
  match t with
    Lf -> t
  | Br ({left=l; value=v; right=r} as br) ->
     if n = v then
       match l, r with
	 Lf, Lf -> Lf
       | Br _, Lf -> l
       | Lf, Br _ -> r
       | Br _, Br _ ->
	  let m = min r in
          br.value <- m;
	  br.right <- delete(r, m);
	  t
     else if n < v then (br.left <- delete(l, n); t)
     else (* n > v *) (br.right <- delete(r, n); t)

(* Constructing a sample tree *)
let t1 = Br {left = Lf; value = 10; right = Lf}
let t2 = Br {left = Lf; value = 25; right = Lf}
let t3 = Br {left = t1; value = 15; right = t2}
let t4 = Br {left = Lf; value = 60; right = Lf}
let t5 = Br {left = Lf; value = 48; right = t4}
let t6 = Br {left = t3; value = 30; right = t5}

(* Testing find *)
let test1 = find(t6, 30)  (* should be true *)
let test2 = find(t6, 13)  (* should be false *)

(* Testing insert *)
let t7 = insert(t6, 23)
let test3 = find(t7, 23)  (* should return true *)
let test4 = find(t7, 30)  (* should return true *)

(* Testing delete *)
let t8 = delete(t7, 30)
let test5 = find(t8, 30)  (* should return false *)
let test6 = find(t8, 48)  (* should return true *)
