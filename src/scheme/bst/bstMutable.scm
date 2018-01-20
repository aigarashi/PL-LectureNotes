;; Defining the shape of trees
;; tree is either a symbol 'Lf or a four-element list ('Br left value right)
;; where left and right are trees and value is an integer.

;; constructor functions
(define (newbranch l v r)
  (list 'Br l v r)) ;; could be written `(Br ,l ,v ,r)
(define (newleaf)
  (list 'Lf))       ;; could be written '(Lf)

;; predicates to see if a given tree is a leaf (or a branch)
(define (leaf? t)
  (eq? (car t) 'Lf))
(define (branch? t)
  (eq? (car t) 'Br))

;; selector functions
(define (branch-left t) (cadr t))
(define (branch-value t) (caddr t))
(define (branch-right t) (cadddr t))

;; mutator functions
(define (set-branch-left! t newleft)
  (set-car! (cdr t) newleft))
(define (set-branch-value! t newval)
  (set-car! (cddr t) newval))
(define (set-branch-right! t newright)
  (set-car! (cdddr t) newright))

;; (Recursive) function find, which returns whether given integer n exists in BST t.
(define (find t n)
  (cond
   ((leaf? t) #f)
   ((branch? t)
    (let ((l (branch-left t))
          (v (branch-value t))
          (r (branch-right t)))
      (cond
       ((= n v) #t)
       ((< n v) (find l n))
       (else (find r n)))))))
  
;; (Recursive) function insert, which, given BST t and a new element n, returns
;; a new binary search tree with n.
(define (insert t n)
  (cond
   ((leaf? t)
    (newbranch (newleaf) n (newleaf)))
   ((branch? t)
    (let ((l (branch-left t))
          (v (branch-value t))
          (r (branch-right t)))
      (cond
       ((= n v) t)
       ((< n v)
        (set-branch-left! t (insert l n))
        t)
       (else
        (set-branch-right! t (insert r n))
        t))))))
  
;; Function min, which, given BST t, returns the minimum value stored in t.
;; If t is empty, it signals a run-time error.
(define (min t)
  (cond
   ((leaf? t) (error "Invalid argument" t))
   ((and (branch? t)
         (leaf? (branch-left t)))
    (branch-value t))
   (else (min (branch-left t)))))

;; (Recursive) function delete, which, given BST t and an element n to
;; be deleted, returns a new binary search tree without n.  If n is not
;; stored in t, it returns t as it is.
(define (delete t n)
  (cond
   ((leaf? t) t)
   ((branch? t)
    (let ((l (branch-left t))
          (v (branch-value t))
          (r (branch-right t)))
      (cond
       ((= n v)
        (cond
         ((and (leaf? l) (leaf? r)) (newleaf))
         ((and (branch? l) (leaf? r)) l)
         ((and (leaf? l) (branch? r)) r)
         (else
          (let ((m (min r)))
            (set-branch-value! t m)
            (set-branch-right! t (delete r m))
            t))))
       ((< n v)
        (set-branch-left! (delete l n))
        t)
       (else
        (set-branch-right! (delete r n))
        t))))))
  
;; Constructing a sample tree
(define t1 (newbranch (newleaf) 10 (newleaf)))
(define t2 (newbranch (newleaf) 25 (newleaf)))
(define t3 (newbranch t1 15 t2))
(define t4 (newbranch (newleaf) 60 (newleaf)))
(define t5 (newbranch (newleaf) 48 t4))
(define t6 (newbranch t3 30 t5))

;; Testing find
(define test1 (find t6 30)) ; should return #t
(define test2 (find t6 13)) ; should return #f

;; Testing insert
(define t7 (insert t6 23))
(define test3 (find t7 23)) ; should return #t
(define test4 (find t7 30)) ; should return #t

;; Testing delete
(define t8 (delete t7 30))
(define test5 (find t8 30)) ; should return #f
(define test6 (find t8 48)) ; should return #t
