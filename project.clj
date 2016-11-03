(defproject enron "0.1.0-SNAPSHOT"
  :description "Modeling and analyzing the dynamics of corruption with Clojure"
  :url "http://enron.madhax.io"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"] [org.clojure/tools.cli "0.3.5"]]
  :main ^:skip-aot enron.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
