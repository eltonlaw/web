(ns web.core
  (:require 
    [devtools.core :as devtools]
    [reagent.core :as reagent]
    [re-frame.core :as rf]
    [web.events] ; force runs every reg-event-*
    [web.subs]   ; force runs every reg-sub
    [web.views :as views]))
            
;; Debugging 
(devtools/install!)
(enable-console-print!)

(defonce do-timer
  (js/setInterval #(rf/dispatch [:timer])
                  1000))

(defn render []
  (reagent/render [views/app]
                  (js/document.getElementById "app")))

(defn ^:dev/after-load clear-cache-and-render!  []
  (rf/clear-subscription-cache!)
  (render))

(defn run []
  (rf/dispatch-sync [:initialize-db])
  (render))
