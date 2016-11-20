(ns enron.organization)

(defrecord Organization [uuid, title, address, funds])

; TODO: is-corrupt (i.e. are the majority of the members in the organization involved in corruption)
