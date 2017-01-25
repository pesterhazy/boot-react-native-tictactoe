(ns tictactoe.game
  (:require [reagent.core :as r]
            [recalcitrant.core :as rn]
            [tictactoe.common :refer [!state]]
            [tictactoe.style :as s]))

;; {[1 1] :x [2 1] :o}

(def size 4)

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

;; #{[0 0] [1 1] [2 2]}


(defn cell-ui [{:keys [value on-press color]}]
  [rn/touchable-opacity {:style s/cell
                         :on-press on-press}
   [rn/text {:style (assoc s/cell-text :color color)} value]])

(defn move [state x y]
  (assoc state [x y] ({0 :x
                       1 :o} (-> state count (mod 2)))))


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
     (into [rn/view {:style s/board}]
           (map (fn [x]
                  (into [rn/view {:style s/row}]
                        (map (fn [y] (cell-ui {:value (get @!state [x y])
                                               :color (if (get win [x y])
                                                        :red
                                                        :white)
                                               :on-press #(swap! !state move x y)}))
                             (range size))))
                (range size)))
     [rn/touchable-opacity {:style s/button
                            :on-press #(reset! !state nil)}
      [rn/text {:style s/button-text} "Try again"]]]))
