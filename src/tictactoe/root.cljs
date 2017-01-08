(ns tictactoe.root
  (:require [reagent.core :as r]
            [recalcitrant.core :as rn]
            [tictactoe.common :refer [!state]]
            [tictactoe.style :as s]))

(defn root-ui []
  [rn/view
   [rn/text "Tic Tac Toe"]])
