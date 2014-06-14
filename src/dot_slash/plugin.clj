(ns dot-slash.plugin)

(defn middleware
  [project]
  (if-let [{:keys [vars ns] :or {ns '.}} (:dot-slash project)]
    (let [repl-init-code
          `(do (ns ~ns
                 (:require ~'potemkin))
               (potemkin/import-vars ~@vars)
               (ns ~'user))
          current-repl-init (get-in project [:repl-options :init])
          init (if current-repl-init
                 (list 'do repl-init-code current-repl-init)
                 repl-init-code)]
      (-> project
          (assoc-in [:repl-options :init] init)
          (update-in [:dependencies] conj '[potemkin "0.3.4"])))
    project))
