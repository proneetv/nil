(defproject foo "0.0.0.1"
  :description "foo"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot foo.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
