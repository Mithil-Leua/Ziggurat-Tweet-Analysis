(ns sentiment-analyzer.sentiment
  (:require [damionjunk.nlp.stanford :as nlp]))

(defn get-sentiment [text]
  (nlp/sentiment-maps text))

(defn get-vector [text]
  (vec (map #(get-in % [:sentiment]) (get-sentiment text))))

(defn get-average [sentiments]
  (if (empty? sentiments) 0 (int (Math/floor (/ (reduce + sentiments) (count sentiments))))))

(defn sentiment-value [text]
  (get-average (get-vector text)))
