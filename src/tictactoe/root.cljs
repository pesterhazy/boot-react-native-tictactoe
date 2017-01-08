(ns tictactoe.root
  (:require [reagent.core :as r]
            [recalcitrant.core :as rn]
            [tictactoe.common :refer [!state]]
            [tictactoe.style :as s]))

(def size 3)

(defn cell-ui [props]
  [rn/view (merge props {:style s/cell})
   [rn/text {:style s/cell-text} "X"]])

(defn root-ui []
  [rn/view {:style s/board}
   (map (fn [y]
          [rn/view {:style s/row}
           (map (fn [x] [cell-ui])
                (range size))])
        (range size))])
