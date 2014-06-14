(ns dot-slash.plugin)

(defn middleware
  [project]
  (if-let [{:keys [vars ns] :or {ns '.}} (:dot-slash project)]
    (let [namespaces (->> vars
                          (map (fn [var-decl]
                                 (cond (symbol? var-decl)
                                       (symbol (namespace var-decl))

                                       (vector? var-decl)
                                       (first var-decl))))
                          (distinct))
          repl-init-code
          `(do (ns ~ns
                 (:require ~'potemkin ~@namespaces))
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
