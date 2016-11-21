(ns tictactoe.root
  (:require [reagent.core :as r]
            [recalcitrant.core :as rn]))

(def default-font {:font-family "Helvetica"
                   :font-size 20})

(def cell-style
  {:width 80,
   :height 80,
   :borderRadius 5,
   :backgroundColor "#7b8994",
   :margin 5,
   :flex 1,
   :justifyContent :center,
   :alignItems :center})

(def cell-text-style
  {:fontSize 50,
   :fontFamily "AvenirNext-Bold",})

(defonce !state (r/atom nil))

(defn cell [{:keys [on-press value winner?]}]
  [rn/touchable-highlight {:on-press on-press}
   [rn/view {:style cell-style}
    [rn/text {:style [cell-text-style (when winner? {:color :red})]}
     (case value
       :x "X"
       :o "O"
       "")]]])

(def size 3)

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
                (map (fn [x] [cell {:value (get-in @!state [:board x y])
                                    :winner? (some-> @!state :board winner set (get [x y]))
                                    :on-press #(swap! !state move x y)}]) (range size))))
             (range size))))

(defn root-view
  []
  [rn/view {:style {:flex 1
                    :justify-content :center
                    :align-items :center}}
   [board-ui]
   [rn/touchable-highlight {:on-press #(reset! !state nil)}
    [rn/view {:style {:margin-top 10
                      :padding 10
                      :backgroundColor "#7b8994"}}
     [rn/text {:style default-font} "Reset"]]]])
