(ns tictactoe.style
  (:require [recalcitrant.core :as rn]))

(def board
  {:width (rn/window-width 0.8)
   :height (rn/window-width 0.8)})

(def cell
  {:borderRadius 5,
   :backgroundColor "#7b8994",
   :margin 5,
   :flex 1,
   :justifyContent :center,
   :alignItems :center})

(def row
  {:flex 1
   :flex-direction :row})

(def cell-text
  {:fontSize 50,
   :fontFamily "AvenirNext-Bold",})

(def button {:padding 10
             :backgroundColor "#7b8994"})

(def button-text {:font-family "AvenirNext-Bold"
                  :font-size 20})
