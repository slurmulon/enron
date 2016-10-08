(ns enron.player)

(deftype Player [uuid, fname, lname, organization, friends, tendencies])

(defmethod is-corrupt? Player [player] false)
(defmethod is-jailed? Player [player] false)
(defmethod is-free? Player [player] (= (not (player/is-jailed)) true)
(defmethod jailed-friends Player [player] [])
(defmethod free-friends Player [player] [])
(defmethod is-above Player [player, other] false)
(defmethod is-below Player [player, other] true)
