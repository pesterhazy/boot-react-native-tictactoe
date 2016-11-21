(ns tictactoe.core
  (:require [reagent.core :as r]
            [recalcitrant.core :as rn]))

(enable-console-print!)

;; Assets need to be relative path, starting from the `app/build/node_modules'
;; directory. The packager only finds images located in the `app/' folder
;; (the directory that contains package.json) or below.
;;
;; We use `defonce' to prevent errors on subsequent reloads.

(defonce logo (js/require "../../assets/cljs.png"))

(defonce !state (r/atom {:count 0}))

(defn root-view
  []
  [rn/view {:style {:margin-top 50
                    :margin-left 8
                    :justify-content "center"
                    :align-items "center"}}
   [rn/text {:style {:font-family "Helvetica"
                     :font-size 20
                     :margin-bottom 20}}
    "Welcome to boot-react-native"]
   [rn/image {:style {:width 350
                      :height 348
                      :margin-bottom 20}
              :source logo}]
   [rn/touchable-highlight {:style {:padding 20
                                    :background-color "#e0e0e0"}
                            :on-press (fn []
                                        (swap! !state update :count inc))
                            :underlay-color "#f0f0f0"}
    [rn/text {:style {:font-family "Helvetica"
                      :font-size 14}}
     "Count: " (:count @!state) ", click to increase"]]])

(defn root-container
  "Wraps root-view. This is to make sure live reloading using boot-reload and
  reagent works as expected. Instead of editing root-container, edit root-view"
  []
  [root-view])

(defn ^:export main
  []
  (js/console.log "MAIN")
  (enable-console-print!)
  (.registerComponent (.-AppRegistry rn/react)
                      "TicTacToe"
                      #(r/reactify-component #'root-container)))

(defn on-js-reload
  []
  (println "on-js-reload. state:" (pr-str @!state))

  ;; Force re-render
  ;;
  ;; In React native, there are no DOM nodes. Instead, mounted
  ;; components are identified by numbers. The first root components
  ;; is assigned the number 1.

  (r/render #'root-container 1))
