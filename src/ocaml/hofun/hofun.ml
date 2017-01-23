(* an example of higher-order functions *)
let rec sigma(f, n) =
  if n < 1 then f 0
  else f n + sigma(f, n-1)

let square n = n * n
let cube n = n * n * n

let a = sigma(square, 20)
let b = sigma(cube, 20)

(* anonymous functions *)
let c = sigma ((fun n -> n*n), 20)
let d = sigma ((fun n -> n*n*n), 20)

(* Currying *)
type gender = Male | Female

let greeting(gen, name) =
  match gen with
    Male -> "Hello, Mr. " ^ name
  | Female -> "Hello, Ms. " ^ name

let curried_greeting gen = fun name ->
  match gen with
    Male -> "Hello, Mr. " ^ name
  | Female -> "Hello, Ms. " ^ name

let greeting_for_men = curried_greeting Male
let greeting_for_women = curried_greeting Female

let g1 = greeting_for_men "Igarashi"
let g2 = greeting_for_women "Koike"

(* higher-order functions for binary trees (holding integers) *)
type tree =
  Lf
| Br of {
    left:  tree;
    value: int;
    right: tree;
  }

let rec treemap f t =
  match t with
    Lf -> Lf
  | Br {left=l; value=v; right=r} ->
     Br {left  = treemap f l;
         value = f v;
         right = treemap f r}

let rec treefold e f t =
  match t with
    Lf -> e
  | Br {left=l; value=v; right=r} ->
     f (treefold e f l)
       v
       (treefold e f r)

let t1 = Br {left = Lf; value = 10; right = Lf}
let t2 = Br {left = Lf; value = 25; right = Lf}
let t3 = Br {left = t1; value = 15; right = t2}
let t4 = Br {left = Lf; value = 60; right = Lf}
let t5 = Br {left = Lf; value = 48; right = t4}
let t6 = Br {left = t3; value = 30; right = t5}

(* Let's double the values in t6 keeping its shape *)
let t7 = treemap (fun n -> n * 2) t6

(* Interpret Lf as 0 and Br as addition *)
let s6 = treefold 0 (fun l v r -> l + v + r) t6
let s7 = treefold 0 (fun l v r -> l + v + r) t7

(* Conversion to a string can be written in terms of fold *)
let str6 = treefold "leaf" (fun l v r -> "branch(" ^ l ^ ", " ^ (string_of_int v) ^ ", " ^ r ^ ")") t6
let str7 = treefold "leaf" (fun l v r -> "branch(" ^ l ^ ", " ^ (string_of_int v) ^ ", " ^ r ^ ")") t7
                  
