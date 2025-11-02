# Rapport sur l'architecture du jeu "Labyrinthe"

## Introduction

Le projet "Labyrinthe" est un jeu basé sur une grille de tuiles. Le but du jeu est d'aider un ou plusieurs joueurs à atteindre leurs objectifs en manipulant des tuiles et en déplaçant des pions sur un plateau de jeu. Ce rapport décrit l'architecture du projet basée sur le diagramme UML fourni, en détaillant les principaux composants du système, leurs interactions et leurs responsabilités.

## Composants Principaux

### 1. Modèle (Model)

Le modèle est responsable de la logique de jeu, y compris la gestion des tuiles, du plateau, des joueurs et des objectifs.

#### Tile (Tuile)
Classe abstraite représentant une tuile. Chaque tuile peut avoir différentes configurations d'ouverture (haut, bas, gauche, droite) et peut être de différents types : T, Angle, ou Ligne.

**Méthodes principales :**
- `rotate(direction : Direction)` : Permet de faire pivoter la tuile.
- `getType()` : Renvoie le type de la tuile.
- `output()` : Retourne une représentation textuelle de la tuile.

#### TileFactory (Usine de tuiles)
Crée différentes tuiles (T, Angle, Ligne). Cette classe est responsable de la création des objets Tile.

#### Board (Plateau)
Représente le plateau de jeu sous forme de grille de tuiles. Il contient des méthodes pour manipuler les lignes et les colonnes du plateau (pousser les lignes/colonnes, ajouter des observateurs, etc.).

#### Player (Joueur)
Représente un joueur avec un objectif à atteindre sur le plateau. Il suit sa position et les objectifs qu'il doit accomplir.

#### Objective (Objectif)
Un objectif est une case spécifique que le joueur doit atteindre. Chaque objectif a une position associée.

#### Game (Jeu)
Gère l'état du jeu, le tour des joueurs, les mouvements des joueurs, et la gestion des objectifs. Il gère également les interactions entre les différents composants du modèle.

#### Position (Position)
Représente une position sur le plateau avec des coordonnées X et Y.

### 2. Observateurs

Plusieurs classes d'observateurs sont définies pour mettre à jour les différentes parties du jeu lorsque des changements se produisent.

#### BoardObserver (Observateur de Plateau)
Permet de recevoir des notifications lors des changements sur le plateau, par exemple lors du déplacement d'une ligne ou d'une colonne.

#### PlayerObserver (Observateur de Joueur)
Reçoit des notifications concernant la position du joueur et l'état des objectifs.

#### TileObserver (Observateur de Tuile)
Gère les notifications concernant les rotations des tuiles.

### 3. Vue (View)

La vue est responsable de l'affichage des informations et de l'interaction avec l'utilisateur.

#### BoardTextManager, PlayerTextManager, TileTextManager
Ces classes implémentent les interfaces d'observateurs pour afficher les informations pertinentes sur les tuiles, le joueur, et le plateau.

#### GameDisplay
Affiche l'état du jeu, y compris le plateau et les informations du joueur. Elle initialise le plateau, affiche les joueurs et gère les interactions.

#### EndScreen
Affiche l'écran de fin, y compris le gagnant du jeu.

### 4. Contrôleur (Controller)

Le contrôleur gère l'interaction entre la vue et le modèle.

#### GameController
Gère les actions du jeu telles que les rotations des tuiles, le déplacement des joueurs, et la gestion des tours de jeu. Il est responsable de la mise à jour de l'état du jeu en fonction des actions du joueur.

#### LabyrintheApp
Point d'entrée principal de l'application. Elle initialise le jeu et l'affichage.

## Relations entre les Composants

- Le `TileFactory` est utilisé pour créer des instances des différentes tuiles (T, Angle, Ligne).
- `LabyrintheApp` utilise plusieurs composants, notamment le plateau (`Board`), les joueurs (`Player`), et l'affichage (`Display`).
- Le `Game` gère l'état du jeu, en reliant les tuiles, les objectifs et les joueurs.
- Le `GameController` interagit avec les composants de la vue et du modèle pour mettre à jour l'état du jeu.
- Le modèle observe les changements dans la vue à travers les interfaces d'observateurs, et la vue réagit aux modifications du modèle pour mettre à jour l'affichage.

## Conclusion

On a pas fini le jeu, il y'avait encore les objectifs à implémenter. On avait de nombreuses idées qu'on a malheuresement pas pu finir.
Ce qui nous manque :
- Il y'a un probleme sur l'affichage quand on rotate l'extra tuile elle ne s'affiche pas correctement quand on la push dans le board
- Les objectifs
- L'écran de fin
