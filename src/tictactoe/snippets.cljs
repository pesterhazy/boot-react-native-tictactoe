(defn line [size x f]
  (set (for [y (range size)] (f x y))))

(defn lines [size f]
  (for [x (range size)]
    (line size x f)))

(defn diagonal [size f]
  (set (for [x (range size)] (f x))))

(def wins
  (-> #{}
      (into (lines size vector))
      (into (lines size (fn [x y] [y x])))
      (conj (diagonal size (fn [x] [x x])))
      (conj (diagonal size (fn [x] [x (- size x 1)])))))
