(ns enron.relation)

; FIXME support adjacency matrix somehow (currently using an adjacency list).
; Much more efficient for graphs with high number of edges.
(defprotocol Relation)

(defrecord Family [trustor, trustee, corruptor] Relation) ; TODO: may want to make this support collections of each
(defrecord Friend [trustor, trustee, corruptor] Relation)
(defrecord Worker [trustor, trustee, corruptor] Relation)
