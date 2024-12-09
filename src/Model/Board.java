package Model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Board {
    private Tile[][] tiles; //Tableau 2D qui va représenter le plateau

    private TileFactory tileFactory = new TileFactory(); //La factory des tuiles

    private List<BoardObserver> observers = new ArrayList<>();

    /*
    * Constructeur de board
    */
    public Board() {
        tiles = new Tile[7][7];
        initializeBoard(); //Appel de la fonction qui va initialiser le plateau
    }

    /**
     * Initialise le plateau
     */
    public void initializeBoard(){
        int totalIndex = 0; //L'index commence à 0

        //Boucle pour placer tout les tuiles en angles
        for(int i=0; i<20; i++){
            int line = totalIndex / 7; //Exemple : 4/7 = 0 donc line = 0, 10/7 = 1 donc line = 1
            int colum = totalIndex % 7; //Exemple : 2/7 = 2 donc column = 2
            Position position=new Position(line,colum); //Initialise la position de la tuile
            tiles[line][colum] = tileFactory.createTileAngle(); //Créer une nouvelle tuile en angle
            tiles[line][colum].setPosition(position); //Met la position de la tuile
            totalIndex++; //Augmente l'index
        }

        for(int i=0; i<12; i++) {
            int line = totalIndex / 7;
            int colum = totalIndex % 7;
            Position position=new Position(line,colum);
            tiles[line][colum] = tileFactory.createTileLine();
            tiles[line][colum].setPosition(position);
            totalIndex++;
        }

        for(int i=0; i<17; i++){
            int line = totalIndex / 7;
            int colum = totalIndex % 7;
            Position position=new Position(line,colum);
            tiles[line][colum] = tileFactory.createTileT();
            tiles[line][colum].setPosition(position);
            totalIndex++;
        }

    }

    /**
     * Retourne le Tableau 2D tiles
     *
     * @return tiles le tableau 2D de Tile
     */
    public Tile[][] getTiles() {
        return tiles;
    }


    /**
     * Pousser une ligne du plateau
     *
     * @param row ligne à pousser
     */
    public void pushRowLeft(int row) {
        for (int i = 6; i > 0; i--) {
            tiles[row][i] = tiles[row][i - 1];
        }
        notifyObserversUpdatePushRow(row, Direction.LEFT);
    }

    public void pushRowRight(int row){
        for (int i = 0; i < 6; i++) {
            tiles[row][i] = tiles[row][i + 1];
        }
        notifyObserversUpdatePushRow(row, Direction.RIGHT);
    }

    public void pushColumnTop(int column){
        for (int i = 6; i > 0; i--) {
            tiles[i][column] = tiles[i - 1][column];
        }
        notifyObserversUpdatePushColumn(column, Direction.TOP);
    }

    public void pushColumnBottom(int column){
        for (int i = 0; i < 6; i++) {
            tiles[i][column] = tiles[i + 1][column];
        }
        notifyObserversUpdatePushColumn(column, Direction.BOTTOM);
    }

    /**
     * Pousser une colonne du plateau
     *
     * @param column colonne à pousser
     * @param direction direction pour pousser la colonne
     */


    /**
     * Obtenir une tuile à une position donné
     *
     * @param position position de la tuile qu'on veut obtenir
     * @return Tile à la position donné
     */
    public Tile getTile(Position position){
        return tiles[position.getPositionX()][position.getPositionY()];
    }

    public void setTileAt(Tile tile, Position position){
        tiles[position.getPositionX()][position.getPositionY()]=tile;
    }


    public void addObserver(BoardObserver observer) {
        observers.add(observer);
    }

    public void notifyObserversUpdatePushRow(int index, Direction direction) {
        for (BoardObserver observer : observers) {
            observer.updatePushRow(index, direction);
        }
    }

    public void notifyObserversUpdatePushColumn(int index, Direction direction) {
        for (BoardObserver observer : observers) {
            observer.updatePushColumn(index, direction);
        }
    }

}
