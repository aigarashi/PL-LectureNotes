(* Works only in OCaml 4.03.0 or above *)

(* Defining the shape of trees *)
type 'elm tree =
    Lf       (* Leaf *)
  | Br of {  (* Branch *)
      left:  'elm tree;
      value: 'elm;
      right: 'elm tree;
    }

(* (Recursive) function find, which returns whether given integer n exists in BST t *)
let rec find cmp t n =
  (* cmp is a function parameter; it takes two arguments x and y of
     the same type and returns 0 if x is equal to y, a negative
     integer if x is less than y, and a positive integer if x is
     greater than y. *)
  match t with
    Lf -> false
  | Br {left=l; value=v; right=r} ->
     if cmp n v = 0 then true
     else if cmp n v < 0 then find cmp l n
     else (* n > v *) find cmp r n

(* (Recursive) function insert, which, given BST t and a new element n, returns
   a new binary search tree with n *)
let rec insert cmp t n =
  match t with
    Lf -> Br {left=Lf; value=n; right=Lf}
  | Br {left=l; value=v; right=r} ->
     if cmp n v = 0 then t
     else if cmp n v < 0 then Br {left=insert cmp l n; value=v; right=r}
     else (* n > v *) Br {left=l; value=v; right=insert cmp r n}

(* Function min, which, given BST t, returns the minimum value stored in t.
   If t is empty, it fails. *)
let rec min t =
  match t with
    Lf -> invalid_arg "Input can't be a leaf!"
  | Br {left=Lf; value=v; right=_} -> v
  | Br {left=l; value=_; right=_} -> min l

(* (Recursive) function delete, which, given BST t and an element n to
   be deleted, returns a new binary search tree without n.  If n is not
   stored in t, it returns t as it is. *)

let rec delete cmp t n =
  match t with
    Lf -> t
  | Br {left=l; value=v; right=r} ->
     if cmp n v = 0 then
       match l, r with
	 Lf, Lf -> Lf
       | Br _, Lf -> l
       | Lf, Br _ -> r
       | Br _, Br _ ->
	  let m = min r in
	  Br {left=l; value=m; right=delete cmp r m}
     else if cmp n v < 0 then Br {left=delete cmp l n; value=v; right=r}
     else (* n > v *) Br {left=l; value=v; right=delete cmp r n}

(* Constructing a sample tree *)
let t1 = Br {left = Lf; value = 10; right = Lf}
let t2 = Br {left = Lf; value = 25; right = Lf}
let t3 = Br {left = t1; value = 15; right = t2}
let t4 = Br {left = Lf; value = 60; right = Lf}
let t5 = Br {left = Lf; value = 48; right = t4}
let t6 = Br {left = t3; value = 30; right = t5}

(* Testing find *)
let test1 = find (fun x y -> x - y) t6 30  (* should be true *)
let test2 = find (fun x y -> x - y) t6 13  (* should be false *)

(* Testing insert *)
let t7 = insert (fun x y -> x - y) t6 23
let t8 = insert (fun x y -> x - y) t6 0
let test3 = find (fun x y -> x - y) t7 23  (* should return true *)
let test4 = find (fun x y -> x - y) t8 30  (* should return false *)
let test5 = find (fun x y -> x - y) t8 23  (* should return false *)

(* Testing delete *)
let t9 = delete (fun x y -> x - y) t8 30
let test6 = find (fun x y -> x - y) t9 30
let test7 = find (fun x y -> x - y) t9 48

(* Constructing another sample tree *)
let t11 = Br {left = Lf; value = "I"; right = Lf}
let t12 = Br {left = Lf; value = "love"; right = Lf}
let t13 = Br {left = t11; value = "OCaml"; right = t12}
let t14 = Br {left = Lf; value = "you"; right = Lf}
let t15 = Br {left = Lf; value = "think"; right = t14}
let t16 = Br {left = t13; value = "so?"; right = t15}

(* Testing find *)
let test11 = find String.compare t16 "so?"  (* should be true *)
let test12 = find String.compare t16 "Ocaml"  (* should be false *)

(* Testing insert *)
let t17 = insert String.compare t16 "Me"
let t18 = insert String.compare t16 "too"
let test13 = find String.compare t17 "Me"  (* should return true *)
let test14 = find String.compare t18 "Why"  (* should return false *)
let test15 = find String.compare t18 "Me"  (* should return false *)

(* Testing delete *)
let t19 = delete String.compare t18 "Why"
let test16 = find String.compare t19 "Why" (* should return false *)
let test17 = find String.compare t19 "She" (* should return false *)
