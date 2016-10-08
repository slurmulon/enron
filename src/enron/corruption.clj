(ns enron.corruption)

(defprotocol Corruption)

(extend-protocol Corruption
  Administrative
    ; Intentional imposition by state or non-state actors to distort existing laws, policies, regulations for their own advantages.
    (is [elem] false)
  StateCapture
    ; Illegal actions by firms or individuals to influence the formulation of laws, policies, regulations for their own advantage.
    (is [elem] false))

