# INSTALL.md

## Prérequis
Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre système :
- [Java JDK 17+](https://www.oracle.com/java/technologies/javase-downloads.html)
- Un terminal ou une invite de commande
- Un éditeur de texte ou un IDE (optionnel, mais recommandé)

## Récupération du projet
1. Clonez le dépôt Git sur votre machine locale :
   ```bash
   git clone git@git.unistra.fr:benomar-sami/a31-labyrinthe.git

2. Accédez au dossier du projet

## Compilation
1. Assurez-vous d'être dans le répertoire racine du projet, où se trouve le fichier src.

2. Compilez le projet avec javac :
   ```bash
   javac -d bin $(find src -name "*.java")

## Execution
1. Une fois la compilation terminée, exécutez l'application en spécifiant la classe principale :
   ```bash
   java -cp bin <nom_du_paquet_principal>.<nom_classe_principale>
   
Remplacez <nom_du_paquet_principal> et <nom_classe_principale> par les noms correspondants.
   
