package Model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Board {
    private Tile[][] tiles; //Tableau 2D qui va représenter le plateau
    private Tile extraTile; //Tuile restante
    private TileFactory tileFactory = new TileFactory(); //La factory des tuiles

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


        extraTile=tileFactory.createTileT(); //Tuile restante par défaut en T
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
     * @param direction direction dans laquelle pousser la ligne
     */
    public void pushRow(int row, Direction direction){
        Tile extraTileTemp=getExtraTile();
        if(direction==Direction.LEFT){
            extraTile=tiles[row][6];
            for(int i=6; i>0; i--){
                tiles[row][i]=tiles[row][i-1];
            }
            tiles[row][0]=extraTileTemp;}
        else if(direction==Direction.RIGHT){
            extraTile = tiles[row][0];
            for (int i = 0; i < 6; i++) {
                tiles[row][i] = tiles[row][i + 1];
            }
            tiles[row][6] = extraTileTemp;
        }
        else{
            throw new IllegalArgumentException("Direction invalide. Utilisez RIGHT ou LEFT.");
        }
    }

    /**
     * Pousser une colonne du plateau
     *
     * @param colum colonne à pousser
     * @param direction direction pour pousser la colonne
     */
    public void pushColumn(int colum, Direction direction) {
        Tile extraTileTemp = getExtraTile();

        if (direction == Direction.TOP) {
            extraTile = tiles[6][colum];
            for (int i = 6; i > 0; i--) {
                tiles[i][colum] = tiles[i - 1][colum];
            }
            tiles[0][colum] = extraTileTemp;
        } else if (direction == Direction.BOTTOM) {
            extraTile = tiles[0][colum];
            for (int i = 0; i < 6; i++) {
                tiles[i][colum] = tiles[i + 1][colum];
            }
            tiles[6][colum] = extraTileTemp;

        } else {
            throw new IllegalArgumentException("Direction invalide. Utilisez TOP ou BOTTOM.");
        }
    }

    /**
     * Obtenir une tuile à une position donné
     *
     * @param position position de la tuile qu'on veut obtenir
     * @return Tile à la position donné
     */
    public Tile getTile(Position position){
        return tiles[position.getPositionX()][position.getPositionY()];
    }

    /**
     * Obtenir la tuile restante
     *
     * @return extraTile tuile restante
     */
    public Tile getExtraTile() {
        return extraTile;
    }

    /**
     * Permet de définir une nouvelle extraTile
     *
     * @param extraTile Tile qui va devenir la nouvelle extraTile
     */
    public void setExtraTile(Tile extraTile) {
        this.extraTile=extraTile;
    }

    public boolean playerOnLine(int index, Player player){
        for(int i=0; i<7; i++){
            if(player.getTilePlayer()==tiles[index][i]){
                return true;
            }
        }
        return false;
    }

}
