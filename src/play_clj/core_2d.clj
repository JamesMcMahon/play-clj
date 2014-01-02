(in-ns 'play-clj.core)

; drawing

(defn draw! [{:keys [renderer]} entities]
  (assert renderer)
  (let [batch (.getSpriteBatch renderer)]
    (.begin batch)
    (doseq [e entities]
      (cond
        (map? e)
        (let [{:keys [image x y width height]} e]
          (.draw batch image (float x) (float y) (float width) (float height)))
        (isa? (type e) Actor)
        (.draw e batch 1)))
    (.end batch))
  entities)

; textures

(defn image
  [val]
  (if (string? val)
    (-> val Texture. TextureRegion.)
    (TextureRegion. val)))

(defn split-image
  ([val size]
    (split-image val size size))
  ([val width height]
    (-> val image (.split width height))))

(defn flip-image
  [val x? y?]
  (doto (image val) (.flip x? y?)))

(defmacro animation
  [duration images & args]
  `(Animation. ~duration
               (utils/gdx-into-array ~images)
               (utils/gdx-static-field :graphics :g2d :Animation
                                       ~(or (first args) :normal))))

(defn get-key-frame
  ([screen ^Animation animation]
    (.getKeyFrame animation (:total-time screen) true))
  ([screen ^Animation animation is-looping?]
    (.getKeyFrame animation (:total-time screen) is-looping?)))
