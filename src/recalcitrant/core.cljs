(ns recalcitrant.core
  (:require [reagent.core :as r]))

;; TODO: do we need set! for advanced compilation?

(defonce react (js/require "react-native/Libraries/react-native/react-native.js"))

(def view (r/adapt-react-class (.-View react)))
(def text (r/adapt-react-class (.-Text react)))
(def touchable-highlight (r/adapt-react-class (.-TouchableHighlight react)))
(def touchable-opacity (r/adapt-react-class (.-TouchableOpacity react)))
(def image (r/adapt-react-class (.-Image react)))
(def dimensions (.-Dimensions react))

(defn window-width []
  (.-width (.get dimensions "window")))

(defn window-height []
  (.-height (.get dimensions "window")))

(defn frisk-ui [state]
  [text {:style {:font-family "Menlo-Regular"
                 :font-size 16}}
   (pr-str @state)])

(defn drawer-ui []
  (let [!open (r/atom nil)]
    (fn [{:keys [height]} & children]
      [view {:style {:background-color "#e0e0e0"
                     :position :absolute
                     :bottom 0
                     :height (if @!open (or height 150) 20)
                     :width (window-width)}}
       [touchable-opacity {:style {:flex 1}
                           :on-press #(swap! !open not)}
        [view {:style {:padding 5}}
         (if @!open
           (into [view] children)
           [text {:style {:text-align :center}} "^^"])]]])))
