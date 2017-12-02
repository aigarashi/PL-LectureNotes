open Bst

(* Constructing a sample tree *)
let t0 = empty
let t1 = insert(t0, 30)
let t2 = insert(t1, 15)
let t3 = insert(t2, 48)
let t4 = insert(t3, 10)
let t5 = insert(t4, 25)
let t6 = insert(t5, 60)

(* Testing find *)
let test1 = find(t6, 30)  (* should be true *)
let test2 = find(t6, 13)  (* should be false *)

(* Testing insert *)
let t7 = insert(t6, 23)
let t8 = insert(t6, 0)
let test3 = find(t7, 23)  (* should return true *)
let test4 = find(t8, 30)  (* should return false *)
let test5 = find(t8, 23)  (* should return false *)

(* Testing delete *)
let t9 = delete(t8, 30)
let test6 = find(t9, 30)
let test7 = find(t9, 48)

let print_bool b = if b then print_string "true" else print_string "false"

let () =
  print_bool test1;
  print_newline ();
  print_bool test2;
  print_newline ();
  print_bool test3;
  print_newline ();
  print_bool test4;
  print_newline ();
  print_bool test5;
  print_newline ();
  print_bool test6;
  print_newline ();
  print_bool test7;
  print_newline ()
  
