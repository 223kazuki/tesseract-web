(ns tesseract.main
  (:gen-class)
  (:require [clojure.java.io :as io]
            [duct.core :as duct]))

(defn -main [& args]
  (duct/exec (duct/read-config (io/resource "tesseract/config.edn"))
             (duct/parse-keys args)))
