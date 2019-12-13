(ns web.events
  (:require
    [re-frame.core :as rf]
    [web.cofx :as cofx]))

(rf/reg-event-fx
  :initialize-db
  [(rf/inject-cofx :now)]
  (fn [cofx _]
    {:db (assoc cofx/default-db
                :time (:now cofx))}))

(rf/reg-event-db
  :time-color-change
  (fn [db [_ new-color-value]]
    (assoc db :time-color new-color-value)))

(rf/reg-event-fx
  :timer
  [(rf/inject-cofx :now)]
  (fn [{:keys [db now]} _]
    {:db (assoc db :time now)}))
