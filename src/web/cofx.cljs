(ns web.cofx
  (:require
    [cljs.reader]
    [cljs.spec.alpha :as s]
    [re-frame.core :as rf]))

(def default-db
  {:time-color "#f88"})

(rf/reg-cofx :now 
   (fn [cofx _]
     (assoc cofx :now (js/Date.))))
