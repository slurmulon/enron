(ns enron.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [enron.simulation :refer [run generate-players generate-friends]])
  (:gen-class))

(def cli-options
  [["-r" "--rounds ROUNDS" "Number of rounds"
    :id :num-rounds
    :default 200
    :parse-fn #(Integer/parseInt %)
    :validate [#(< 0 % 0x10000) "Must be a number between 0 and 65536"]]

   ["-poc" nil "Pay-off for corruption"
    :id :pay-off-corruption
    :default 20
    :parse-fn #(Integer/parseInt %)]

   ["-poh" nil "Pay-off for honesty"
    :id :pay-off-honesty
    :default 1
    :parse-fn #(Integer/parseInt %)]

   ["-p" "--players PLAYERS" "Number of players"
    :id :num-players
    :default 75
    :parse-fn #(Integer/parseInt %)]

   ["-o" "--organizations ORGANIZATIONS" "Number of organizations"
    :id :num-organizations
    :default 1
    :parse-fn #(Integer/parseInt %)]

   ["-i" "--index HONESTY" "Honesty index (0 - 1)"
    :id :honesty-index
    :default 1
    :parse-fn #(Integer/parseInt %)]

   ["-jp" "--jail PERIOD" "Jail period for convicted corruption"
    :id :jail-period
    :default 5
    :parse-fn #(Integer/parseInt %)]

   ["-ns" "--network SIZE" "Number of agents in each agent's network"
    :id :network-size
    :default 5
    :parse-fn #(Integer/parseInt %)]

   ["-pc" "--capture PROBABILITY" "Probability of an agent being captured while performing corruption"
    :id :prob-capture
    :default 0.2
    :parse-fn #(Double/parseDouble %)]

   ["-m" "--memory LENGTH" "Number of rounds each agent will remember the crimes of other agents"
    :id :memory-length
    :default 7
    :parse-fn #(Integer/parseInt %)]

   ["-h" "--help"]])

(defn -main [& args]
  (let [settings (parse-opts args cli-options)]
    (println "settings" (:options settings))
    (println "players" (generate-players (:options settings)))
    (println "friends" (generate-friends (:options settings)))))
