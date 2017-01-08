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
