package Model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private Tile[][] tiles; //Tableau 2D qui va représenter le plateau

    private TileFactory tileFactory = new TileFactory(); //La factory des tuiles

    private List<BoardObserver> observers = new ArrayList<>();


    public Board() {
        tiles = new Tile[7][7];
        initializeBoard(); //Appel de la fonction qui va initialiser le plateau
    }

    /**
     * Initialise le plateau
     */
    public void initializeBoard()
    {
        List<Tile> shuffledTiles=shuffleTiles();
        tiles[0][0] = tileFactory.createTileAngle();
        tiles[0][6] = tileFactory.createTileAngle();
        tiles[6][0] = tileFactory.createTileAngle();
        tiles[6][6] = tileFactory.createTileAngle();

        for (int line = 0; line < 7; line++)
        {
            for (int colum = 0; colum < 7; colum++)
            {
                if ((line == 0 && (colum == 0 || colum == 6)) || (line == 6 && (colum == 0 || colum == 6))) {
                    continue;
                }

                Tile tile = shuffledTiles.remove(0);
                tile.setPosition(new Position(line, colum));
                tiles[line][colum] = tile;
            }
        }
    }

    /**
     * Retourne le Tableau 2D tiles
     *
     * @return le tableau 2D de Tile
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    public List<Tile> shuffleTiles(){
        List<Tile> shuffledTiles=new ArrayList<>();
        int angle = 16;
        int t = 12;
        int droit = 17;
        for(int i=0; i<45; i++){
            if(angle!=0){
                shuffledTiles.add(tileFactory.createTileAngle());
                angle--;
            }
            else if(t!=0){
                shuffledTiles.add(tileFactory.createTileT());
                t--;
            }
            else if(droit!=0){
                shuffledTiles.add(tileFactory.createTileLine());
                droit--;
            }

        }
        Collections.shuffle(shuffledTiles);
        return shuffledTiles;
    }


    /**
     * Pousser une ligne de la gauche vers la droite
     * @param row ligne à pousser
     */
    public void pushRowLeft(int row)
    {
        for (int i = 6; i > 0; i--)
        {
            tiles[row][i] = tiles[row][i - 1];
        }
        notifyObserversUpdatePushRow(row, Direction.LEFT);
    }

    /**
     * Pousser une ligne de la droite vers la gauche
     * @param row ligne à pousser
     */
    public void pushRowRight(int row)
    {
        for (int i = 0; i < 6; i++)
        {
            tiles[row][i] = tiles[row][i + 1];
        }
        notifyObserversUpdatePushRow(row, Direction.RIGHT);
    }

    /**
     * Pour obtenir la tuile à la position souhaité
     * @param position position de la tuile
     * @return Tuile à la position
     */
    public Tile getTile(Position position)
    {
        return tiles[position.getPositionX()][position.getPositionY()];
    }

    /**
     * Pousser une colonne du haut vers le bas
     * @param column colonne à pousser
     */
    public void pushColumnTop(int column)
    {
        for (int i = 6; i > 0; i--)
        {
            tiles[i][column] = tiles[i - 1][column];
        }
        notifyObserversUpdatePushColumn(column, Direction.TOP);
    }

    /**
     * Pousser une colonne du bas vers le haut
     * @param column colonne à pousser
     */
    public void pushColumnBottom(int column)
    {
        for (int i = 0; i < 6; i++)
        {
            tiles[i][column] = tiles[i + 1][column];
        }
        notifyObserversUpdatePushColumn(column, Direction.BOTTOM);
    }


    /**
     * Mettre une tuile dans le plateau à une position donné
     * @param tile tuile à mettre dans le plateau
     * @param position la position où on veut la mettre
     */
    public void setTileAt(Tile tile, Position position)
    {
        tiles[position.getPositionX()][position.getPositionY()]=tile;
    }


    /**
     * Pour ajouter un observeur du plateau
     * @param observer observeur à rajouter
     */
    public void addObserver(BoardObserver observer) {
        observers.add(observer);
    }

    /**
     * Pour notifier d'une ligne poussé
     * @param index l'index de la ligne poussé
     * @param direction direction (gauche ou droite)
     */
    public void notifyObserversUpdatePushRow(int index, Direction direction) {
        for (BoardObserver observer : observers) {
            observer.updatePushRow(index, direction);
        }
    }

    /**
     * Pour notifier d'une colonne poussé
     * @param index l'index de la colonne poussé
     * @param direction direction (haut ou bas)
     */
    public void notifyObserversUpdatePushColumn(int index, Direction direction) {
        for (BoardObserver observer : observers) {
            observer.updatePushColumn(index, direction);
        }
    }

}
