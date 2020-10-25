(ns helloworld.core
  (:require [ziggurat.init :as ziggurat]
            [ziggurat.middleware.json :as mw]
            [clojure.tools.logging :as log]
            [damionjunk.nlp.stanford :as nlp]
            [helloworld.routes :as rts])
  (:gen-class))

(defn start-fn []
  (log/info "start"))

(defn stop-fn []
  (log/info "end"))

(defn get-sentiment [text]
  (nlp/sentiment-maps text))

(defn main-fn
  [message]
  (println (get-sentiment message))
  :success)

(def handler-fn
  (-> main-fn
      (mw/parse-json :stream-id false)))

(defn -main [& args]
  (ziggurat/main start-fn stop-fn {:stream-id {:handler-fn handler-fn}} rts/routes))