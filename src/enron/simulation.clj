(ns enron.simulation
  (:use (faker name address))
  (:require [enron.player :refer (->Player)]
            [enron.organization :refer (->Organization)]
            [clojure.data.generators :as random]
            [faker.name    :as fake-person]
            [faker.company :as fake-company]
            [faker.address :as fake-address]))

(defrecord settings
  [pay-off-corruption ; 20
   pay-off-honest ; 1
   dist-honesty-index ; Random distribution (gaussian) among agents
   num-players ; 75 members of P, 75 members of G
   honesty-index ; 0-1
   jail-period ; 5 rounds
   network-size ; 5 agents
   prob-capture ; 0.2
   memory-length ; 7 (TODO: verify this default value)
   num-organizations ; 1 company
   num-rounds]) ; 200 rounds

(defn run [settings])

(defn generate-organizations [settings]
  (map (fn [_]
         (->Organization (random/uuid) (first (fake-company/names)) (fake-address/street-address) (random/float)))
       (range (:num-organizations settings))))

; TODO: consider Trustor, Gurantee, Corruptor
(defn generate-players [settings]
  (map (fn [_]
         (let [organization (first (shuffle (generate-organizations settings)))]
           (->Player (random/uuid) (fake-person/first-name) (fake-person/last-name) organization [] settings false false)))
       (range (:num-players settings))))

; TODO: might want to use map->Player
; @see: https://clojuredocs.org/clojure.core/defrecord#example-542692d2c026201cdc326f8b
(defn generate-friends [settings]
  (let [players (shuffle (generate-players settings))]
  (map (fn [player]
         (let [other-players (filter #(not player %) players)
               network-size (int (* rand (:network-size settings)))]
           (merge player {:friends (take network-size other-players)})))
       players)))

(defn generate-relationships [settings]) ; Family, Friend, Workers

(defn generate-trusts [settings]) ; from-players, to-players, greed-payoff, honest-payoff

(defn generate-rounds [settings])
