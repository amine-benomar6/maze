# Projet Labyrinthe

## Description générale

Le projet **Labyrinthe** est un jeu de puzzle où les joueurs doivent naviguer à travers un labyrinthe en déplaçant des tuiles et en accomplissant des objectifs. Le jeu suit un modèle basé sur des classes représentant des éléments du jeu tels que les tuiles, le plateau, les joueurs, et les objectifs.

## Classes principales

### 1. **Classe `Tile` (Tuile)**
Cette classe représente une tuile du plateau. Elle contient des informations concernant sa capacité à être déplacée et si elle a déjà été traversée dans une direction spécifique. Les méthodes de cette classe permettent de manipuler sa position et de vérifier les directions dans lesquelles elle peut être déplacée. De plus, chaque type de tuile a des comportements de rotation spécifiques, définis dans les classes filles.

### 2. **Classe `TileT`, `TileLine`, `TileAngle`**
Ces classes représentent des variantes de tuiles avec des formes spécifiques (T, ligne, angle). Chaque classe contient des comportements uniques pour la rotation et pour identifier son type. Elles héritent de la classe `Tile` pour partager les propriétés de base, tout en introduisant des comportements supplémentaires propres à chaque forme.

### 3. **Classe `TileFactory`**
La classe `TileFactory` est responsable de la création des différentes tuiles. Elle permet de générer des instances des types de tuiles disponibles, comme les tuiles de type T, ligne, et angle. Cela centralise la logique de création des objets de type tuile et simplifie l'instanciation dans d'autres parties du jeu.

### 4. **Enum `Direction`**
L'énumération `Direction` représente les différentes directions possibles pour déplacer des éléments dans le jeu : haut, bas, gauche, droite. Elle est utilisée pour garantir que seules ces directions sont manipulées dans le code, réduisant ainsi les erreurs liées à des valeurs incorrectes.

### 5. **Enum `TypeTile`**
L'énumération `TypeTile` décrit les trois types de tuiles disponibles dans le jeu. Chaque valeur correspond à un type de tuile (T, ligne, angle). Cela permet de simplifier la gestion des tuiles en assurant que chaque tuile possède un type bien défini et reconnu dans tout le système.

### 6. **Classe `Board`**
La classe `Board` représente le plateau de jeu. Elle contient un ensemble de tuiles disposées en une grille, ainsi qu'une tuile supplémentaire qui peut être utilisée pour des manipulations spéciales. La classe permet de déplacer des lignes ou des colonnes de tuiles, de récupérer une tuile à une position donnée, et de gérer l'état général du plateau.

### 7. **Classe `Objective`**
La classe `Objective` représente les objectifs que les joueurs doivent accomplir pour gagner. Chaque objectif est lié à une position spécifique sur le plateau, et le joueur doit atteindre cette position pour le récupérer. La classe permet de définir et de récupérer la position de chaque objectif.

### 8. **Classe `Player`**
Cette classe représente un joueur dans le jeu. Elle gère la position actuelle du joueur ainsi que ses objectifs. Elle permet également de déplacer le joueur sur le plateau et de vérifier si ce dernier a atteint son objectif courant. Les méthodes associées permettent de suivre la progression du joueur et de notifier son état au système.

### 9. **Classe `Game`**
La classe `Game` orchestre l'ensemble du jeu. Elle gère l'initialisation du jeu, le démarrage, ainsi que les actions des joueurs (déplacer les joueurs et les tuiles). Elle permet de suivre l'état du jeu et de vérifier si la partie doit se terminer.

### 10. **Classe `Position`**
La classe `Position` représente une position sur le plateau. Elle contient des informations sur les coordonnées X et Y, permettant de localiser des éléments comme les joueurs, les tuiles et les objectifs. Des méthodes sont disponibles pour manipuler ces coordonnées et comparer des positions entre elles que l'on va utilisé lorsqu'on veut savoir si le joueur a trouvé son objectif courant ou s'il a gagné.

### 11. **Interface `BoardObserver`**
L'interface `BoardObserver` définit les méthodes permettant à la vue de réagir aux changements du plateau. Elle permet de recevoir des notifications lorsqu'une tuile est déplacée ou lorsque l'état général du plateau change.

### 12. **Interface `PlayerObserver`**
L'interface `PlayerObserver` définit les méthodes permettant de suivre les changements d'état d'un joueur, notamment ses déplacements et ses objectifs récupérés.

### 13. **Classes de Vue (`MainScreen`, `EndScreen`)**
Ces classes sont responsables de l'affichage du jeu à l'utilisateur. Elles réagissent aux mises à jour du plateau et des joueurs, affichant les informations du jeu en temps réel, telles que l'état du plateau, les informations des joueurs et le résultat de la partie.

### 14. **Classe `GameController`**
Le contrôleur du jeu est responsable de la gestion des actions de l'utilisateur. Il permet de manipuler les tuiles (rotation, déplacement de lignes et de colonnes) et de déplacer les joueurs en fonction des commandes fournies par l'utilisateur.

## Choix de conception

- **Enumérations** : L'énumération `Direction` a été utilisée pour limiter les directions de mouvement possibles dans le jeu à des valeurs bien définies. Cela simplifie le code et prévient les erreurs dues à des entrées incorrectes. De même, `TypeTile` permet de centraliser les types de tuiles disponibles, facilitant leur gestion.
- **Héritage** : Les classes `TileT`, `TileLine`, et `TileAngle` héritent de la classe `Tile` pour partager des comportements communs, comme la gestion de la position, tout en permettant des comportements spécifiques pour chaque type de tuile, comme la rotation.
- **Patron de conception Observer** : Les interfaces `BoardObserver` et `PlayerObserver` permettent de suivre les modifications dans le modèle et d'envoyer des mises à jour vers la vue, garantissant une séparation claire entre la logique du jeu et l'affichage.