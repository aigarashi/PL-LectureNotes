(* Works only in OCaml 4.03.0 or above *)

(* Defining the shape of trees *)
type 'elm tree =
    Lf       (* Leaf *)
  | Br of {  (* Branch *)
      left:  'elm tree;
      value: 'elm;
      right: 'elm tree;
    }

let rec size t =
  match t with
    Lf -> 0
  | Br {left=l; value=_; right=r} -> size l + size r + 1

let max(n, m) =
  if n < m then m else n

let rec depth t =
  match t with
    Lf -> 0
  | Br {left=l; value=_; right=r} -> max(depth l, depth r) + 1

let rec reflect t =
  match t with
    Lf -> Lf
  | Br {left=l; value=v; right=r} ->
     Br {left = reflect r;
         value = v;
         right = reflect l}

let rec add(t, e) =
  match t with
    Lf -> Br {left=Lf; value=e; right=Lf}
  | Br {left=l; value=v; right=r} ->
     Br {left = add(l, e);
         value = v;
         right = r}

let rec sum t =
  match t with
    Lf -> 0
  | Br {left=l; value=v; right=r} -> sum l + v + sum r

let rec string_of_int_tree t =
  match t with
    Lf -> "leaf"
  | Br {left=l; value=v; right=r} ->
      "branch(" ^ string_of_int_tree l ^ ","
                ^ string_of_int v ^ ","
                ^ string_of_int_tree r ^ ")"

let rec treemap f t =
  match t with
    Lf -> Lf
  | Br {left=l; value=v; right=r} ->
     Br {left = treemap f l;
         value = f v;
         right = treemap f r}

let rec treefold e f t =
  match t with
    Lf -> e
  | Br {left=l; value=v; right=r} ->
     f (treefold e f l)
       v
       (treefold e f r)
                                           
(* Constructing a sample tree holding integers *)
let t1 = Br {left = Lf; value = 10; right = Lf}
let t2 = Br {left = Lf; value = 25; right = Lf}
let t3 = Br {left = t1; value = 15; right = t2}
let t4 = Br {left = Lf; value = 60; right = Lf}
let t5 = Br {left = Lf; value = 48; right = t4}
let t6 = Br {left = t3; value = 30; right = t5}

let s6 = size t6
let d6 = depth t6

let t7 = reflect t6
let s7 = size t7
let d7 = depth t7

let t8 = add(t6, 100)
let s8 = size t8
let d8 = depth t8

(* Now let's construct a tree holding strings *)
let t11 = Br {left = Lf; value = "I"; right = Lf}
let t12 = Br {left = Lf; value = "love"; right = Lf}
let t13 = Br {left = t11; value = "OCaml"; right = t12}
let t14 = Br {left = Lf; value = "How"; right = Lf}
let t15 = Br {left = Lf; value = "about"; right = t14}
let t16 = Br {left = t13; value = "you?"; right = t15}

let s16 = size t16
let d16 = depth t16

let t17 = reflect t16
let s17 = size t17
let d17 = depth t17

let t18 = add(t16, "Me, too!")
let s18 = size t18
let d18 = depth t18

(* Examples of treemap: t26 is a tree of strings, each of which is
  obtained by adding a currency name; here, treemap is used to
  convert an integer tree to a string tree.

  t36 holds the lengths of strings in t16; here, treemap is used to
  convert a string tree to an int tree.  *)
let t26 = treemap (fun i -> string_of_int i ^ " yen") t6
let t36 = treemap String.length t16

(* Example of treefold: s is the sum of the lengths of strings in
   t16; the anonymous function is of type int -> string -> int -> int *)
let s = treefold 0 (fun l v r -> l + String.length v + r) t16
