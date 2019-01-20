(defproject play-clj "1.2.1-SNAPSHOT"
  :description "A libGDX wrapper for easy cross-platform game development"
  :url "https://github.com/oakes/play-clj"
  :license {:name "Public Domain"
            :url "http://unlicense.org/UNLICENSE"}
  :dependencies [[com.badlogicgames.gdx/gdx "1.9.9"]
                 [com.badlogicgames.gdx/gdx-box2d "1.9.9"]
                 [com.badlogicgames.gdx/gdx-bullet "1.9.9"]
                 [org.clojure/clojure "1.10.0"]]
  :repositories [["sonatype"
                  "https://oss.sonatype.org/content/repositories/releases/"]]
  :source-paths ["src"]
  :java-source-paths ["src-java"]
  :javac-options ["-target" "1.8" "-source" "1.8" "-Xlint:-options"])
