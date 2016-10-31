(ns enron.player)

(defprotocol Human
  "Represents a human agent that participates in a simulated society"

  (will-corrupt? [this] "Determines if an agent will perform corruption")
  (will-others-likely-agree? [this] "Numerical value that determines if an agent is likely to perform corruption")
  (will-likely-get-caught? [this] "Numerical value that determines if an agent is likely to get caught performing corruption")

  (greed-index [this payoff] "Scalar value that determines how greedy an agent is (0-1)")
  (honest-index [this payoff] "Scalar value that determines the expectation of each agent one every round's payoff (0-1)")
  (decision-index [this payoff-honest jail-term] "Scalar value representing if an agent is likely to commit corruption (> (result payoff))")

  (is-greedy? [this] "Determines if an agent is greedy enough to perform corruption")
  (is-corrupt? [this] "Determines if an agent has performed at least one corrupt act")
  (is-jailed? [this] "Determines if agent is currently imprisoned for corruption")
  (is-free? [this] "Specifies if the agent is out of jail")
  (is-above? [this other] "Determines if the player is at a higher rank than another player (i.e. can entrust acts to other player)")
  (is-below? [this other] "Determines if the player is at a lower rank than another player (i.e. can be entrusted to perform acts")
  (memory-length [this] "Number of rounds a person will remember the actions of a friend/colleague")

  (corrupt-friends [this] "Provides a collection of related players that are engaging in corrupt activities")
  (jailed-friends [this] "Provides a collection of related players that are currently imprisoned")
  (free-friends [this] "Provides a collection related players that are currently free"))

; TODO: type hints
(defrecord Player [uuid, fname, lname, organization, friends, tendencies, corrupt? jailed?]
  Human
  (will-corrupt? [this, payoff-honest] (> decision-index payoff-honest)) ; E(x)
  (will-others-likely-agree? [this] (/ (count corrupt-friends) (memory-length)))
  (will-likely-get-caught? [this] (/ (count jailed-friends) (count corrupt-friends)))

  (greed-index [this payoff] (* (- (1 honest-index)) payoff)) ; a* = (1 - i)a
  (honest-index [this payoff] (rand)) ; i
  (decision-index [this payoff-honest jail-term]
    (+ (* (will-others-likely-agree?) honest-index (- 1 (will-likely-get-caught?)))
       (* (payoff-honest) (- 1 (will-others-likely-agree?)))
       (* (will-likely-get-caught?) (- payoff-honest (* payoff-honest jail-term)))))

  (is-greedy? [this, payoff-honest] (> (will-corrupt?) payoff-honest)) ; E(x) > B (B = payoff)
  (is-corrupt? [this] (:corrupt? this))
  (is-jailed? [this] (:jailed? this))
  (is-free? [this] (not (:is-jailed? this)))
  (is-above? [this other] (contains? (:friends this) other))
  (is-below? [this other] (contains? (:friends other) this))
  (memory-length [this] 1) ; TODO: base on settings

  (corrupt-friends [this] (filter #(.is-corrupt? %) (:friends this)))
  (jailed-friends [this] (filter #(.is-jailed? %) (:friends this)))
  (free-friends [this] (filter #(.is-free? %) (:friends this)))
