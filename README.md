# Labyrinthe  

Bienvenue sur le projet **Labyrinthe**, un jeu multijoueur inspiré du célèbre jeu de société du même nom.  
Ce projet est développé en **Java** avec une interface graphique en **Swing**, et conçu avec le modèle **MVC** ainsi que les **Design Patterns**, dans le cadre de ma formation.  


## Règles du jeu
Elles sont disponibles :

en version textuelle : https://www.regledujeu.fr/labyrinthe/.

en vidéo avec Ludochrono : https://www.youtube.com/watch?v=pGzenrQnJ9g.

## Matériels du jeu de société 

50 tuiles de 3 sortes :
- 20 angles dont 4 sont fixes et 16 sont déplaçables,
- 12 sections droites toutes déplaçables,
- 18 en forme de "T" dont 12 sont fixes et 10 sont déplaçables.

Il y a également 24 objectifs, avec un nombre fixe de 4 joueurs

## Fonctionnalités  
- Génération des tuiles avec une orientation initiale aléatoire
- Génération d’un labyrinthe avec les tuiles placées aléatoirement
- Ajout des objectifs sur les tuiles (un seul maximum par tuile)
- Déplacement des pions case par case
- Déplacement d'une ligne ou colonne du plateau par la tuile supplémentaire


## Prérequis
Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre système :
- [Java JDK 17+](https://www.oracle.com/java/technologies/javase-downloads.html)
- Un terminal ou une invite de commande
- Un éditeur de texte ou un IDE (optionnel, mais recommandé)

## Récupération du projet
1. Clonez le dépôt Git sur votre machine locale :
   ```bash
   git clone git@github.com:amine-benomar6/maze.git

2. Accédez au dossier du projet

## Compilation
1. Assurez-vous d'être dans le répertoire racine du projet, où se trouve le fichier src.

2. Compilez le projet avec javac :
   ```bash
   javac -d bin $(find src -name "*.java")

## Exécution
1. Une fois la compilation terminée, exécutez l'application en spécifiant la classe principale :
   ```bash
   java -cp bin <nom_du_paquet_principal>.<nom_classe_principale>
   
Remplacez <nom_du_paquet_principal> et <nom_classe_principale> par les noms correspondants.
   
