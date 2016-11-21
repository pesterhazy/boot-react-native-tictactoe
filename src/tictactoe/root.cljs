(ns tictactoe.root
  (:require [reagent.core :as r]
            [recalcitrant.core :as rn]))

(def default-font {:font-family "Helvetica"
                   :font-size 20})

(defonce !state (r/atom nil))

(defn root-view
  []
  [rn/view {:style {:flex 1
                    :justify-content :center
                    :align-items :center}}
   [rn/text {:style default-font}
    (str "Welcome to boot-react-native")]])
