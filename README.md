# Spacelib

Projet de JEE de Master 1 MIAGE à Toulouse réalisé par Pierre Liaubet, Fanny Montuy et Jean-Baptiste Roubelat

Le projet est composé de plusieurs projets NetBeans :

- Spacelib : Application d'entreprise JEE (Back-end)
  - Spacelib-ear : Point d'entrée de l'application
  - Spacelib-ejb : Code métier de l'application
  - Spacelib-web : WebServices & Applications Web Mécaniciens et Usagers
- SpacelibShared : Interface de l'application back-end SpaceLib
- AdministrateurClient : Application lourde Swing pour l'administration des stations
- BorneClient : Application lourde Swing pour les différentes bornes de réservation des stations

## Avancement du projet

Nous avons une application en version 2 "fonctionnelle" dans le sens que les scénarios souhaités pour cette version sont réalisables, même si ils sont soumis à quelques problèmes (voir section Points d'amélioration)

## Reste à faire

### Rendus

#### Dossier de conception

- Squelette Dossier
- Mettre UML à jour à la fin de la V1
  - Modifier tout ce qui est lié à réservation car nouveau paramètre dateDebut partout

#### Documentation

- Javadoc (au moins les gestions)

## Installation

### Mise en place

- Le fichier glassfish-resources.xml n'est pas pris en charge automatiquement par le projet, il est donc nécessaire d'ajouter la ressource "à la main" sur le serveur Glassfish grâce à l'invite de commande et l'utilitaire asadmin.
- Construire SpacelibShared
- Construire avec les dépendances Spacelib-ear
    ==> Une page web apparaitra alors avec 2 liens correspondants aux deux applications web (Mécaniciens & Usagers)
- Vous pourrez alors utiliser AdministrateurClient ou BorneClient ainsi que les applications web

## Jeu de données fourni

### Pour la réalisation d'un voyage

- Au moins 3 stations avec des quais
- Pas de navette disponible
  - Dans l'une des stations (Terre), des quais mais pas de navettes arrimées
- Pas de quai disponible dans la station d'arrivée pour le jour prévu (Station de départ Brahe a des navettes)
  - Dans une autre station (Dimidium), quais avec des navettes arrimé + un quai avec date de réservation
- Dans la station de départ(Arion) une seule navette arrimée avec 4 places
  - test de réservation avec 6 passagers -> pas de navette disponible
  - test de réservation avec nombre de passagers <= 4

### Pour la finalisation d'un voyage

- Un usager déja créé + réservation à son nom créé + la réservation démarrée

## Points d'amélioration

### V1

#### Appli Admin

- Forcer le nom de la station créé avec un dropdown ({"Terre", "Dimidium", "Arion", "Brahe", "Amateru", "Tadmor"})

#### Application Mécanicien

- Afficher date révision

### V2

#### Carte

- Carte plus jolie et propre sur les finitions
- Carte interactive

#### Appli

- Mettre des textes pour que le site fasse plus "commercial", notamment sur la page d'acceuil
- Problème de cache au niveau des réservations supprimées
- Modifier les annotations XML pour permettre d'afficher les Stations de départ/arrivée dans "Mon Compte"

#### Back-end

- Génération de messages d'erreurs dans le webservice pour l'application lorsqu'une exception est levée car c'est actuellement une erreur 500 qui est proposée

### Autres

- Réalisation des autres versions
