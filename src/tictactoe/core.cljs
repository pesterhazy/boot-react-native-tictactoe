(ns tictactoe.core
  (:require [tictactoe.root :as root]
            [reagent.core :as r]
            [recalcitrant.core :as rn]))

(enable-console-print!)

(defn root-container
  "Wraps root-view. This is to make sure live reloading using boot-reload and
  reagent works as expected. Instead of editing root-container, edit root-view"
  []
  [root/root-view])

(defn ^:export main
  []
  (js/console.log "MAIN")
  (enable-console-print!)
  (.registerComponent (.-AppRegistry rn/react)
                      "TicTacToe"
                      #(r/reactify-component #'root-container)))

(defn on-js-reload
  []
  ;; Force re-render
  ;;
  ;; In React native, there are no DOM nodes. Instead, mounted
  ;; components are identified by numbers. The first root components
  ;; is assigned the number 1.

  (r/render #'root-container 1))
