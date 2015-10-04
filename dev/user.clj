(ns user
  (:require [reloaded :refer [resume
                              set-init!
                              stop
                              clear
                              suspend
                              resume
                              reset]]))

 ;; The problem is here
(set-init! nil)
