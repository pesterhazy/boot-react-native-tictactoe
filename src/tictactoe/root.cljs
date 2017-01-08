(ns tictactoe.root
  (:require [reagent.core :as r]
            [recalcitrant.core :as rn]
            [tictactoe.style :as s]))

(defonce !board (r/atom nil))

(def size 3)

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
  (-> board vals count (mod 2) {0 "x" 1 "o"}))

(defn move [board x y]
  (if-not (get board [x y])
    (assoc board [x y] (turn board))
    board))

(defn cell [x y]
  (let [combo (set (winner @!board))
        _ (prn combo)
        winner? (combo [x y])]
    [rn/touchable-highlight {:on-press #(swap! !board move x y)}
     [rn/view {:style s/cell}
      [rn/text {:style [s/cell-text (when winner? {:color :red})]}
       (get @!board [x y])]]]))

(defn row [y]
  (into [rn/view {:style {:flex-direction :row}}]
        (map (fn [x]
               [cell x y])
             (range size))))

(defn board []
  (into [rn/view]
        (map (fn [y]
               [row y])
             (range size))))

(defn reset-ui []
  [rn/view {:style {:margin-top 10}}
   [rn/touchable-highlight {:on-press #(reset! !board nil)
                            :underlay-color :transparent}
    [rn/view {:style s/button}
     [rn/text {:style s/button-text} "Try again"]]]])

(defn content-ui []
  [rn/view {:style s/container}
   [board]
   [reset-ui]])

(defn root-ui
  []
  [rn/view {:style {:background-color "#f8f8f8" :flex 1}}
   [content-ui]
   [rn/drawer-ui {}
    [rn/frisk-ui !board]]])
