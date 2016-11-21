(ns tictactoe.root
  (:require [reagent.core :as r]
            [recalcitrant.core :as rn]
            [tictactoe.style :as s]))

(defonce !state (r/atom nil))

(def size 3)

(defn cell-ui [{:keys [on-press value winner?]}]
  [rn/touchable-highlight {:on-press on-press}
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
  (let [fields (map #(get-in board %) combination)]
    (when (and (apply = fields) (first fields))
      combination)))

(defn winner [board]
  (some (partial wins? board) combinations))

(defn turn [board]
  ({0 :x 1 :o}
   (mod (->> board
             vals
             (mapcat vals)
             count)
        2)))

(defn move [state x y]
  (if (or (-> state :board winner) (get-in state [:board x y]))
    state
    (assoc-in state [:board x y] (turn (:board state)))))

(defn board-ui []
  (into [rn/view]
        (map (fn [y]
               (into
                [rn/view {:style {:flex-direction :row}}]
                (map (fn [x] [cell-ui {:value (get-in @!state [:board x y])
                                       :winner? (some-> @!state :board winner set (get [x y]))
                                       :on-press #(swap! !state move x y)}]) (range size))))
             (range size))))

(defn root-ui
  []
  [rn/view {:style s/container}
   [board-ui]
   [rn/touchable-highlight {:on-press #(reset! !state nil)}
    [rn/view {:style s/button}
     [rn/text {:style s/button-text} "Try again"]]]])
