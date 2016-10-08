(ns enron.relation)

(defrecord Relation [trustor, trustee, corruptor]) ; TODO: may want to make this support collections of each
