(ns enron.simulate)

(defrecord settings
  [pay-off-corruption ; 20
   pay-off-honest ; 1
   dist-honesty-index ; Random distribution (gaussian) among agents
   num-agents ; 75 members of P, 75 members of G
   honesty-index ; 0-1
   jail-period ; 5 rounds
   network-size ; 5 agents
   prob-capture ; 0.2
   num-rounds ; 200 rounds]) 

(defn run [settings])

(defn generate-players [])
