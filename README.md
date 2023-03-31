###Lancer la partie JPA :

Lancer la classe JPATest

Vous pouvez ensuite accéder à la liste des données de la base en allant sur la page http://localhost:8080/UserInfo ou http://localhost:8080/FicheInfo
(Après avoir lancer la partie SERVLET avec la commande ``mvn compile jetty:run``)

###Lancer la partie SERVLET :
Lancer la commande maven : 

``mvn compile jetty:run`` 

Puis aller sur la page http://localhost:8080/myform.html pour remplir un formulaire et ajouter un user à la base de données

Ou aller sur la page http://localhost:8080/form_fiche.html pour remplir un formulaire pour ajouter une fiche à la base de données.

Après avoir rempli un formulaire, une page de récapitulation s'affichera avec les données précédemment remplies.