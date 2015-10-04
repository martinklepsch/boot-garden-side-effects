(ns reloaded
  (:require [com.stuartsierra.component :as component]
            [clojure.tools.namespace.repl :refer [disable-reload! refresh]]
            [suspendable.core :as suspendable]))

(disable-reload!)

(def system nil)

(def ^:private initializer nil)

(defn set-init! [init]
  (alter-var-root #'initializer (constantly init)))

(defn- stop-system [s]
  (if s (component/stop s)))

(defn stop []
  (alter-var-root #'system stop-system)
  :stopped)

(defn clear []
  (alter-var-root #'system #(do (stop-system %) nil))
  :ok)

(defn suspend []
  (alter-var-root #'system #(if % (suspendable/suspend %)))
  :suspended)

(defn resume []
  (alter-var-root #'system #(try
                              (suspendable/resume (initializer) %)
                              (catch Throwable t
                                (let [{:keys [system]} (ex-data t)]
                                  (println "exception")
                                  (component/stop system)
                                  (throw (component/ex-without-components t))))))
  :resumed)

(defn reset []
  (suspend)
  (refresh :after 'reloaded/resume))
