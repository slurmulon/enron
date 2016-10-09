(ns enron.trust)

(defprotocol Trustable
  (is-pristine? [this] "Determines if the trust has been enacted upon in any way")
  (is-abused? [this] "Determines if the trust has been abused due to corruption"))

(defrecord Trust [uuid, from-players, to-players, greed-payoff, honest-payoff]
  Trustable
  (is-pristine? [this] true)
  (is-abused? [this] true))

