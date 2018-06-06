(ns foo.core
  (:gen-class))

(defn dial-up [arg] {:succ arg})
(defn dial-down [arg] (:succ arg))

(def one (dial-up nil))
(defn one? [arg] (-> arg dial-down nil?))

(defn add [arg1 arg2]
  (if (one? arg1)
    (dial-up arg2)
    (add (dial-down arg1) (dial-up arg2))))

(defn subtract [arg1 arg2]
  (cond
    (one? arg1) nil
    (one? arg2) (dial-down arg1)
    :else (subtract (dial-down arg1) (dial-down arg2))))

(one? one)
(one? nil)
(one? two)
(def two (dial-up one))
(def three (dial-up two))
(add (dial-up one) three)
(subtract three one)
