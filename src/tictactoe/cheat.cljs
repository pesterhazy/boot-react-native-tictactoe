
(def size 4)

;; position: #{[0 0] [1 1] [2 2]}

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

(defn cell-ui [{:keys [value key on-press color]}]
  [rn/touchable-opacity {:style s/cell
                         :on-press on-press}
   [rn/text {:style (assoc s/cell-text :color color)}
    (or (some-> value name clojure.string/upper-case)
        " ")]])

(defn move [state x y]
  (if (get state [x y])
    state
    (assoc state [x y] (if (zero? (mod (count state) 2))
                         :x
                         :o))))

(defn all [state player]
  (->> state (keep (fn [[k v]] (when (= player v) k))) set))

(defn winning [state player]
  (some #(when (clojure.set/subset? % (all state player))
           %)
        wins))

(defn root-ui []
  (let [win (or (winning @!state :x)
                (winning @!state :o))]
    [rn/view
     [rn/view {:style s/board}
      (doall
       (map (fn [y]
              [rn/view {:key y :style s/row}
               (doall
                (map (fn [x] [cell-ui {:key x
                                       :color (if (get win [x y]) :red :white)
                                       :on-press #(swap! !state move x y)
                                       :value (get @!state [x y])}])
                     (range size)))])
            (range size)))]
     [rn/touchable-opacity {:style s/button
                            :on-press #(reset! !state nil)}
      [rn/text {:style s/button-text}
       "try again"]]]))
