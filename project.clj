(defproject com.gfredericks/dot-slash "0.1.0-SNAPSHOT"
  :description "Simple setup for a custom repl utils namespace."
  :url "https://github.com/gfredericks/dot-slash"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :eval-in-leiningen true
  :plugins [[lein-release "1.0.5"]]
  :lein-release {:deploy-via :clojars})
