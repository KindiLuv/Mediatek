# Mediatek 2021

Une simulation d'interface d'intranet pour une mediateque, dans le but d'ajouter ou reitrer des documents de la banque de donnees.

Un projet par Lucas SERVAIN et David BENIBRI.

- [Mediatek 2021](#mediatek-2021)
  - [Sujet](#sujet)
  - [Approche](#approche)
  - [Difficultes](#difficultes)
  - [Conclusion](#conclusion)
## Sujet
Pour ce projet de programmation repartie, il nous a ete de demande de creer une application web pouvant gerer la banque de documents d'une mediatheque. Les demandes etaient simple: il fallait un service d'authentification, une page pour ajouter un document ainsi qu'une page pour retirer un document de la banque. Cette implementation avait une containte supplementaire, isoler les servlets de la base de donnees en limitant les dependance uniquement vers une librairie qui nous etait fournie. Cette structure permet de dissocier totalement la partie base de donnees des interactions web, protegeant en premier lieu des injections SQL mais surtout permetant de change la base de donnees ou les pages web sans avoir de reel conflit avec l'autre partie.
## Approche
Pour ce projet nous avons donc decide de creer 3 servlets pour 4 pages plus une servlet d'initialisation des donnees. En premier lieu, une page d'authentification avec login et mot de passe qui va regarder si l'utilisateur est dans la base de donnees. Il n'y a pas de moyen de s'ajouter a la liste des utilisateurs car nous sommes parti du principe qu'etant propre a un reseau intranet, l'ajout se ferait directement dans la base de donnees aux vues des peu nombreuses fluctuations du personnel de mediatheque. Apres s'etre identifie, l'utilisateur pourra choisir s'il souhaites ajouter ou retirer un document. Apres ce choix, s'il a choisi d'ajouter un document, il lui sera presente un formulaire ou il pourra inserer les informations necessaires a l'ajout, celui ci sera en premier lieu verifie afin de ne pas avoir de doublons. Il sera ensuite redirige vers la page de choix des options. S'il se dirige vers le retrait de document, dans une comboBox, il pourra choisir le type de document a afficher. Apres cet affichage, il pourra voir les identifiants de document et entrer celui qu'il souhaite supprimer dans l'input dedie a cet effet.

## Difficultes
En premier lieu tomcat fut une epreuve, David n'arrivait pas a le lier au projet intelliJ pendant que Lucas pouvait deja commencer le projet. Ensuite, les deux premieres sceances furent beaucoup d'explications du cours en detail car toutes le notions n'etaient pas comprises par au moins un membre du binome. Nous avons decide de ne pas faire de mise en forme CSS, notre affinite avec ce language n'etant pas des meilleures, c'aurait ete une contrainte plus qu'un atout lors de ce projet.
## Conclusion
Pour finir, nous avons pu confirmer nos connaissances dans les technologies java et JSP grace a ce projet. Celui ci fut par moment complexe mais dans l'ensemble un projet somme toutes agreable a faire. Pour notre part, certaines des fonctionnalites ne fonctionnent pas vraiment bien, voici onc un tableau qui aidera a la visualisation de notre progression.

Fonctionnalite |Authentification | Ajout Document | Retrait document
-|:-:|:-: | :-:
 Code implemente | oui | oui | oui 
 Code fonctionnel | oui | oui | non
