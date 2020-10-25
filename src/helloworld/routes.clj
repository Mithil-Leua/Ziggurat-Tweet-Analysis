(ns helloworld.routes)

(defn api-handler [_request]
  {:status  200
   :headers {"Content-Type" "application/json"}
   :body    {:ping "pong"}})

(def routes [["test" {:get api-handler}]])