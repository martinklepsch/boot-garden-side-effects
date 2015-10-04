(ns gardentest.main
  (:require [garden.def :refer [defstyles]]
            [garden.units :refer [px percent]]))

(defstyles style
  [:body
   {:padding-top (px 70)}]
  [:#screen
   {:padding (px 10)
    :height (percent 100)
    :width (percent 100)}]
  [:.entity-panel
   {:margin 0}]
  [:.entity-panel-heading
   {:padding [[(px 5) (px 10)]]
    :flex "none"}]
  [:.entity-image
   {:border [["solid" (px 1)]]
    :width (percent 40)
    :margin (px 5)}]
  [:.own-image
   {:border [["solid" (px 1)]]
    :width (percent 20)
    :float "left"
    :margin-right (px 10)}]
  [:.chat-panel [:.nav>li>a {:padding (px 5)}]])
