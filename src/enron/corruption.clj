(ns enron.corruption)

(defprotocol Corruption
  "Represents an act of corruption"
  (is [elem] "Identifies the type of corruption that has occured (for subclass implementors)"))

(defrecord Administrative []
  Corruption
  ; Intentional imposition by state or non-state actors to distort existing laws, policies, regulations for their own advantages
  (is [elem] false))

(defrecord StateCapture []
  Corruption
  ; Illegal actions by firms or individuals to influence the formulation of laws, policies, regulations for their own advantage
  (is [elem] false))
