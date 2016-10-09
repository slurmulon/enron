(ns enron.relation)

; NOTE: may end up deprecating this in favor of Trust
(defrecord Relation [trustor, trustee, corruptor]) ; TODO: may want to make this support collections of each
