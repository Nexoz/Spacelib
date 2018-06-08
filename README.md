# Spacelib
Projet de JEE de Master 1 MIAGE à Toulouse

Le projet est composé de plusieurs projets NetBeans :

- Spacelib : Application d'entreprise JEE (Back-end)
  - Spacelib-ear : Point d'entrée de l'application
  - Spacelib-ejb : Code métier de l'application
  - Spacelib-web : WebServices & Applications Web Mécaniciens et Usagers
- SpacelibShared : Interface de l'application back-end SpaceLib
- AdministrateurClient : Application lourde Swing pour l'administration des stations
- BorneClient : Application lourde Swing pour les différentes bornes de réservation des stations

## Reste à faire

### Rendus

#### Dossier de conception

- Squelette Dossier
- Mettre UML à jour à la fin de la V1

#### Documentation

- Javadoc (au moins les gestions)
- Ce README a mettre au propre (pour dire brièvement que fait l'appli, qu'est-ce qu'on a codé, comment elle se lance, et si y a des choses praticulières à dire -choix de conceptions...-)

### V1

#### Appli Admin

- Forcer le nom de la station créé avec un dropdown ({"Terre", "Dimidium", "Arion", "Brahe", "Amateru", "Tadmor"})

#### Borne

- Vérifier que le login est unique (et pas uniquement avec les usagers, inclure mécanos et admins)

#### Application Mécanicien

- Afficher date révision ???
- Brancher débuter une révision
- Brancher finir une révision

### V2

#### Carte

- Carte des stations à dessiner
- Mettre à la place de l'image d'espace en placeholder sur l'acceuil

#### Appli

- Changer le index.html de la page Hello World (index.html à la racine) pour que ce soit un peu plus voyant
- Mettre du blabla sur la page d'acceuil
- Brancher nouvelle réservation
- Afficher les réservation d'un client
- Méthode d'annulation d'une réservation + Brancher au bouton

### V3

- Estimer le temps à mettre, sachant que l'appli web est quasiement uniquement du CtrlC/CtrlV

### V4

- Code pour enlever les réservation rapide à faire

## Installation

### Mise en place

- Le fichier glassfish-resources.xml n'est pas pris en charge automatiquement par le projet, il est donc nécessaire d'ajouter la ressource "à la main" sur le serveur Glassfish grâce à l'invite de commande et l'utilitaire asadmin.
- Construire SpacelibShared
- Construire avec les dépendances Spacelib-ear
    ==> Une page web apparaitra alors avec 2 liens correspondants aux deux applications web (Mécaniciens & Usagers)
- Vous pourrez alors utiliser AdministrateurClient ou BorneClient ainsi que les applications web

## Avancement du projet

Dire ce qu'on a codé
+ Choix de conception

## Jeux de données
###Pour la réalisation d'un voyage :
-Au moins 3 stations avec des quais
- Pas de navette disponible
	- Dans l'une des stations (Terre), des quais mais pas de navette arrimé
- Pas de quai disponible dans la station d'arrivée pour le jour prévu (Station de départ Brahe a des navettes)
	- Dans une autre station (Dimidium), quais avec des navettes arrimé + un quai avec date de réservation
-Dans la station de départ(Arion) une seul navette arrimé avec 4 places
	- test de réservation avec 6 passagers -> pas de navette disponible
	- test de réservation avec nombre de passager <=4
###Pour la finalisation d'un voyage
- Un usager déja créé + réservation à son nom créé + la réservation démarrer
