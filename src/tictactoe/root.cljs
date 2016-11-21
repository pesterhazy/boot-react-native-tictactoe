(ns tictactoe.root
  (:require [reagent.core :as r]
            [recalcitrant.core :as rn]
            [tictactoe.style :as s]))

(defonce !board (r/atom nil))

(def size 3)

(defn cell-ui [{:keys [on-press value winner?]}]
  [rn/touchable-highlight {:underlay-color :transparent
                           :on-press on-press}
   [rn/view {:style s/cell}
    [rn/text {:style [s/cell-text (when winner? {:color :red})]}
     (case value
       :x "X"
       :o "O"
       "")]]])

(def combinations
  (concat (map #(map vector (repeat %) (range size)) (range size))
          (map #(map vector (range size) (repeat %)) (range size))
          [(map #(vector % %) (range size))
           (map #(vector % (dec (- size %))) (range size))]))

(defn wins? [board combination]
  (let [fields (map #(get board %) combination)]
    (when (and (apply = fields) (first fields))
      combination)))

(defn winner [board]
  (some (partial wins? board) combinations))

(defn turn [board]
  (-> board vals count (mod 2) {0 :x 1 :o}))

(defn move [board x y]
  (if (or (winner board) (get board [x y]))
    board
    (assoc board [x y] (turn board))))

(defn board-ui []
  (into [rn/view]
        (map (fn [y]
               (into
                [rn/view {:style {:flex-direction :row}}]
                (map (fn [x] [cell-ui {:value (get @!board [x y])
                                       :winner? (some-> @!board winner set (get [x y]))
                                       :on-press #(swap! !board move x y)}]) (range size))))
             (range size))))

(defn reset-ui []
  [rn/view {:style {:margin-top 10}}
   [rn/touchable-highlight {:on-press #(reset! !board nil)
                            :underlay-color :transparent}
    [rn/view {:style s/button}
     [rn/text {:style s/button-text} "Try again"]]]])

(defn debug-ui []
  [rn/view {:style {:margin-top 20}}
   [rn/text (pr-str @!board)]])

(defn root-ui
  []
  [rn/view {:style s/container}
   [board-ui]
   [reset-ui]
   [debug-ui]])
