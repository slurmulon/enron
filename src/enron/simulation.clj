(ns enron.simulation)

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
   num-rounds]) ; 200 rounds

(defn run [settings])

; TODO: consider Trustor, Gurantee, Corruptor
(defn generate-players [settings]
  (map #(Player. "49c6d00d-a18e-4078-9b47-7959164e3e67" "Bob" "Saget" nil [] settings) [_ (range (:num-players settings))]))

; (defn generate-organizations [settings])

; TODO: might want to use map->Player
; @see: https://clojuredocs.org/clojure.core/defrecord#example-542692d2c026201cdc326f8b
(defn generate-friends [settings]
  (map
    (fn [player]
      (merge player {:friends (take (int (* rand 5)) (filter #(not player %) players))}))
    (shuffle (generate-players settings))))

(defn generate-family [settings])

(defn generate-relationships [settings])

(defn generate-trusts [settings])

(defn generate-rounds [settings])

