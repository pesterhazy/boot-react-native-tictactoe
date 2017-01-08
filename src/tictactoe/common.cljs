(ns tictactoe.common
  (:require [reagent.core :as r]))

(defonce !state (r/atom nil))
