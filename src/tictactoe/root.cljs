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

(defn player []
  (:player @!state :x))

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

(defn move [x y]
  (swap! !state (fn [state]
                  (-> state
                      (assoc-in [:board x y] (player))
                      (assoc :player (if (= :o (player)) :x :o))))))

(defn board []
  (into [rn/view]
        (map (fn [y]
               (into
                [rn/view {:style {:flex-direction :row}}]
                (map (fn [x] [cell {:value (get-in @!state [:board x y])
                                    :on-press #(move x y)}]) (range size))))
             (range size))))

(defn root-view
  []
  [rn/view {:style {:flex 1
                    :justify-content :center
                    :align-items :center}}
   [board]
   [rn/touchable-highlight {:on-press #(reset! !state nil)}
    [rn/view {:style {:margin-top 10
                      :padding 10
                      :backgroundColor "#7b8994"}}
     [rn/text {:style default-font} "Reset"]]]])
