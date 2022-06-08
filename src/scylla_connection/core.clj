(ns scylla-connection.core
  (:gen-class)
  (:require [qbits.alia :as alia]
            [dotenv :refer [env]]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(def conf {:session-keyspace (env "CASSANDRA_NAME_SPACE")
           :contact-points [(env "CASSANDRA_DATABASE_ADDRESS")]
           :load-balancing-local-datacenter (env "CASSANDRA_DATA_CENTER")
           :auth-provider-user-name (env "CASSANDRA_USER_NAME")
           :auth-provider-password (env "CASSANDRA_PASSWORD")
           :auth-provider-class "PlainTextAuthProvider"})

(def session (alia/session conf))

(alia/execute session " select * from items")


;; CREATE KEYSPACE alia
;;                        WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 3};