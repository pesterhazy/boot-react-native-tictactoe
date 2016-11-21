(ns tictactoe.style)

(def container {:flex 1
                :justify-content :center
                :align-items :center})

(def cell
  {:width 80,
   :height 80,
   :borderRadius 5,
   :backgroundColor "#7b8994",
   :margin 5,
   :flex 1,
   :justifyContent :center,
   :alignItems :center})

(def cell-text
  {:fontSize 50,
   :fontFamily "AvenirNext-Bold",})

(def button {:margin-top 10
             :padding 10
             :backgroundColor "#7b8994"})

(def button-text {:font-family "AvenirNext-Bold"
                  :font-size 20})
