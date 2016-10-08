(ns enron.trust)

(deftype Trust [uuid, from-players, to-players])

(defmethod is-pristine? Trust [trust] true)
(defmethod is-abused? Trust [trust] false)
