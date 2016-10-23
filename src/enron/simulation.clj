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
   num-rounds]) ; 200 rounds

(defn run [settings])

(defn generate-players [settings]
  (map #(Player. "49c6d00d-a18e-4078-9b47-7959164e3e67" "Bob" "Saget" nil [] nil) [_ (range (:num-players settings))]))

; (defn generate-organizations [settings])

; TODO: might want to use map->Player
; @see: https://clojuredocs.org/clojure.core/defrecord#example-542692d2c026201cdc326f8b
(defn generate-friends [settings]
  (let [players (shuffle (generate-players settings))]
    (map
      (fn [player]
        (let [friends (take (int (* rand 5)) (filter #(not player %) players))]
          (merge player {:friends friends})))
      players)))

(defn generate-family [settings])

(defn generate-relationships [settings])

(defn generate-trusts [settings])

(defn generate-rounds [settings])

