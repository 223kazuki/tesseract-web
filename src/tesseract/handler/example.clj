(ns tesseract.handler.example
  (:require [clojure.java.io :as io]
            [clojure.java.shell :refer [sh]]
            [compojure.core :refer :all]
            [integrant.core :as ig]
            [me.raynes.fs :as fs]))

(defmethod ig/init-key :tesseract.handler/example [_ options]
  (context "/" []
           (GET "/" [] (io/resource "tesseract/handler/index.html"))
           (POST "/file-upload" []
                 (fn [context]
                   (let [{:keys [filename tempfile] :as file}  (get (:multipart-params context) "file")]
                     (fs/copy+ tempfile (io/file "data" filename))
                     (let [{:keys [out err] :as result} (sh "tesseract" "--tessdata-dir" "." (str "data/" filename) "stdout" "-l" "jpn" "-psm" "6")]
                       (println out)
                       (println result)
                       out))))))
