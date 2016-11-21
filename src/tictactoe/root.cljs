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

(prn @!state)

(defn cell [{:keys [on-press value]}]
  [rn/touchable-highlight {:on-press on-press}
   [rn/view {:style cell-style}
    [rn/text {:style cell-text-style}
     (case value
       :x "X"
       :o "O"
       "")]]])

(def size 3)

(defn board []
  (into [rn/view]
        (map (fn [y]
               (into
                [rn/view {:style {:flex-direction :row}}]
                (map (fn [x] [cell {:value (get-in @!state [:board x y])
                                    :on-press #(swap! !state assoc-in [:board x y] :o)}]) (range size))))
             (range size))))

(defn root-view
  []
  [rn/view {:style {:flex 1
                    :justify-content :center
                    :align-items :center}}
   [board]])
