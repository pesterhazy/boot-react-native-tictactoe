(ns recalcitrant.core
  (:require [reagent.core :as r]))

;; TODO: do we need set! for advanced compilation?

(defonce react (js/require "react-native/Libraries/react-native/react-native.js"))

(def view (r/adapt-react-class (.-View react)))
(def text (r/adapt-react-class (.-Text react)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight react)))
(def image (r/adapt-react-class (.-Image react)))
(def dimensions (.-Dimensions react))
(defn window-width []
  (.-width (.get dimensions "window")))

(defn frisk-ui [state]
  [text {:style {:font-family "Menlo-Regular"
                 :font-size 16}}
   (pr-str @state)])

(defn drawer-ui []
  (let [!open (r/atom nil)]
    (fn [{:keys [height]} & children]
      (if @!open
        [touchable-highlight {:on-press #(swap! !open not)}
         (into [view {:style {:background-color "#e0e0e0"
                              :position :absolute
                              :bottom 0
                              :height (or height 150)
                              :padding 5
                              :width (window-width)}}]
               children)]
        [touchable-highlight {:on-press #(swap! !open not)}
         [view {:style {:background-color "#e0e0e0"
                        :position :absolute
                        :bottom 0
                        :height 20
                        :padding 5
                        :width (window-width)}}
          [text {:style {:text-align :center}}
           "^^"]]]))))
