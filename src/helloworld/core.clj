(ns helloworld.core
  (:require [ziggurat.init :as ziggurat]
            [ziggurat.middleware.json :as mw]
            [clojure.tools.logging :as log]
            [helloworld.sentiment :as sentiment])
  (:gen-class))

(defn start-fn []
  (log/info "start"))

(defn stop-fn []
  (log/info "end"))

(defn get-text [json]
  (get json :text))

(defn get-topic [json]
  (get json :topic))

(defn main-fn
  [message]
  (cond
    (= (sentiment/sentiment-value (get-text message)) 0) (println "very-negative" (get-text message) (get-topic message))
    (= (sentiment/sentiment-value (get-text message)) 1) (println "negative" (get-text message) (get-topic message))
    (= (sentiment/sentiment-value (get-text message)) 2) (println "neutral" (get-text message) (get-topic message))
    (= (sentiment/sentiment-value (get-text message)) 3) (println "positive" (get-text message) (get-topic message))
    (= (sentiment/sentiment-value (get-text message)) 4) (println "very-positive" (get-text message) (get-topic message))
    :else (println "nothing"))
  :success)

(def handler-fn
  (-> main-fn
      (mw/parse-json :stream-id)))

(defn -main [& args]
  (ziggurat/main start-fn stop-fn {:stream-id {:handler-fn handler-fn}}))
