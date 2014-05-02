(defproject tekken "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "https://github.com/ivo-/tekken"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}

  :source-paths ["src"]
  :test-source-paths ["test"]

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2173"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [secretary "1.0.3"]
                 [om "0.5.3"]
                 [com.cemerick/piggieback "0.1.3"]]

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  :injections [(require '[cljs.repl.browser :refer (repl-env)]
                        '[cemerick.piggieback :refer (cljs-repl)])
               (defn brepl []
                 (cljs-repl :repl-env (repl-env :port 9000)))]

  :plugins [[lein-cljsbuild "1.0.2"]]

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src"]
                        :compiler {:output-to "target/main-debug.js"
                                   :output-dir "target/dev"
                                   :optimizations :none
                                   :source-map true}}
                       {:id "prod"
                        :source-paths ["src/tekken"]
                        :compiler {
                                   :output-to "app/app.js"
                                   :optimizations :simple
                                   :elide-asserts true
                                   :pretty-print false
                                   :output-wrapper false
                                   :preamble ["react/react.min.js"]
                                   :externs ["react/externs/react.js"]}}]})
