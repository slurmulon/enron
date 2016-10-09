(ns enron.player)

(defprotocol Human
  "Represents a human agent that participates in a simulated society"
  (will-corrupt? [this] "Determines if an agent will perform corruption")
  (will-others-likely-agree? [this] "Determines if an agent is likely to perform corruption")
  (will-likely-get-caught? [this] "Determines if an agent is likely to get caught for performing corruption")
  (is-corrupt? [this] "Determines if an agent has performed at least one corrupt act")
  (is-jailed? [this] "Determines if agent is currently imprisoned for corruption")
  (is-free? [this] "Specifies if the agent is out of jail")
  (jailed-friends [this] "Provides a collection of related players that are currently imprisoned")
  (free-friends [this] "Provides a collection related players that are currently free")
  (is-above [this] "Determines if the player is at a higher rank than another player (i.e. can entrust acts to other player)")
  (is-below [this] "Determines if the player is at a lower rank than another player (i.e. can be entrusted to perform acts")
  (memory-length [this] "Number of rounds a person will remember the actions of a friend/colleague"))

; TODO: type hints
(defrecord Player [uuid, fname, lname, organization, friends, tendencies]
  Human
  (will-corrupt? [this] false)
  (will-others-likely-agree? [this] false)
  (will-likely-get-caught? [this] false)
  (is-corrupt? [this] false)
  (is-jailed? [this] false)
  (is-free? [this] false)
  (jailed-friends [this] false)
  (free-friends [this] false)
  (is-above [this] false)
  (is-below [this] false)
  (memory-length [this] 1)
