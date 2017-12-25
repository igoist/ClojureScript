(ns instgram-rum.core
  (:require [rum.core :as rum]))

(enable-console-print!)

;; (defonce app-state (atom {:text "Hello Chestnut!"}))

;; (rum/defc greeting < rum/reactive []
;;    [:h1 (:text (rum/react app-state))])

(rum/defc Header []
  [:nav
   [:h2
    [:a {:href "//2017bestnine.com"}
     [:img {:src "/img/2017bestnine.png"}]]]
   [:ul
    [:li {:key "1"}
     [:a {:href "#"}
      [:img {:src "/img/twitterwhite.png"}]]]
    [:li {:key "2"}
     [:a {:href "#"}
      [:img {:src "/img/fbwhite.png"}]]]]])

(rum/defc Main []
  [:section.get-your-best
   [:div.container {:style {:margin-bottom "60px"}}
    [:h1.title
     "Get your 2017 best nine"
     [:br]
     "on Instagram!"]
    [:form.input-group.input-instagram {:action "/result" :method "POST"}
     [:input.form-control {:name "username" :type "text" :placeholder "Instagram ID"}]
     [:input.getyourbest {:type "submit" :value "GET"}]]]])

(rum/defc Wrap []
  [:div.body-wrapper
   [(Header)]
   [(Main)]
   [:h2 (.toISOString (js/Date.))]])

(defn render []
  (rum/mount (Wrap) (. js/document (getElementById "app"))))
