(set-env!
 :source-paths #{"src/clj" "src/styles" "dev"}
 :dependencies '[[org.martinklepsch/boot-garden "1.2.5-7" :scope "test"]

                 [com.stuartsierra/component "0.3.0"]
                 [garden "1.3.0-SNAPSHOT" :exclusions [cider/cider-nrepl]]
                 [org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.122"]
                 [org.clojure/tools.namespace "0.2.11"]
                 [suspendable "0.1.0"]
                 ])

(require
 '[reloaded :refer :all]
 '[org.martinklepsch.boot-garden :refer [garden]]
 )

(task-options!
 garden {:styles-var 'gardentest.main/style
         :output-to "public/css/main.css"
         :pretty-print true})
