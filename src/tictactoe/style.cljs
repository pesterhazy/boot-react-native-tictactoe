(ns tictactoe.style
  (:require [recalcitrant.core :as rn]))

(def board
  {:width (rn/window-width 0.8)
   :height (rn/window-width 0.8)})

(def cell
  {:border-radius 5,
   :background-color "#7b8994",
   :margin 5,
   :flex 1,
   :justify-content :center,
   :align-items :center})

(def row
  {:flex 1
   :flex-direction :row})

(def cell-text
  {:font-size 50,
   :font-family "AvenirNext-Bold",
   :color :white})

(def button {:margin-top 15
             :width 200
             :border-radius 5
             :align-self :center
             :padding 10
             :background-color "#7b8994"})

(def button-text {:align-self :center
                  :color :white
                  :font-family "AvenirNext-Bold"
                  :font-size 20})
