(ns tictactoe.core
  (:require [tictactoe.root :as root]
            [tictactoe.common :refer [!state]]
            [reagent.core :as r]
            [recalcitrant.core :as rn]))

(enable-console-print!)

(defn root-container
  "Wraps root-ui. This is to make sure live reloading using boot-reload and
  reagent works as expected. Instead of editing root-container, edit root-view"
  []
  [rn/view {:style {:background-color "#F5FCFF"
                    :flex 1
                    :justify-content :center
                    :align-items :center}}
   [root/root-ui]
   [rn/drawer-ui {}
    [rn/frisk-ui !state]]])

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
