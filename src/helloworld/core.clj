(ns helloworld.core
  (:require [ziggurat.init :as ziggurat]
            [ziggurat.middleware.json :as mw]
            [clojure.tools.logging :as log]
            [helloworld.sentiment :as sentiment]
            [helloworld.routes :as rts])
  (:gen-class))

(defn start-fn []
  (log/info "start"))

(defn stop-fn []
  (log/info "end"))

(defn get-text [map]
  (get map :text))

(defn main-fn
  [message]
  (println (sentiment/sentiment-value (get-text message)))
  :success)

(def handler-fn
  (-> main-fn
      (mw/parse-json :stream-id)))

(defn -main [& args]
  (ziggurat/main start-fn stop-fn {:stream-id {:handler-fn handler-fn}} rts/routes))
