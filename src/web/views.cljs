(ns web.views
  (:require
    [clojure.string :as str]
    [re-frame.core :as rf]
    [web.events]))

(defn clock []
  [:div.example-clock
   {:style {:color @(rf/subscribe [:time-color])}}
   (-> @(rf/subscribe [:time])
       .toTimeString
       (str/split " ")
       first)])

(defn color-input []
  [:div.color-input
   "Time color: "
   [:input {:type "text"
            :value @(rf/subscribe [:time-color])
            :on-change #(rf/dispatch [:time-color-change (-> % .-target .-value)])}]])  ;; <---

(defn app []
  [:div
   [:h1 "Hello world, it is now"]
   [clock]
   [color-input]])
