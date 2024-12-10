package Model;
import java.util.ArrayList;
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

    public void initializeBoard()
    {
        int angle = 16;
        int t = 12;
        int droit = 17;
        for (int line = 0; line < 7; line++)
        {
            for (int colum = 0; colum < 7; colum++)
            {
                Position position = new Position(line, colum);
                if ((line == 0 && (colum == 0 || colum == 6)) || (line == 6 && (colum == 0 || colum == 6)))
                {
                    tiles[line][colum] = tileFactory.createTileAngle(true);
                }
                else if (angle != 0)
                {
                    tiles[line][colum] = tileFactory.createTileAngle(true);
                    angle--;
                }
                else if (t != 0)
                {
                    tiles[line][colum] = tileFactory.createTileT(true);
                    t--;
                }
                else if (droit != 0)
                {
                    tiles[line][colum] = tileFactory.createTileLine(true);
                    droit--;
                }
                tiles[line][colum].setPosition(position);
            }
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


 /*   public void pushRow(int row, Direction direction)
    {
        Tile extraTileTemp = getExtraTile();
        if (direction == Direction.LEFT)
        {
            extraTile = tiles[row][6];
            for (int i = 6; i > 0; i--)
            {
                tiles[row][i] = tiles[row][i - 1];
            }
            tiles[row][0] = extraTileTemp;
        }
        else if (direction == Direction.RIGHT)
        {
            extraTile = tiles[row][0];
            for (int i = 0; i < 6; i++)
            {
                tiles[row][i] = tiles[row][i + 1];
            }
            tiles[row][6] = extraTileTemp;
        }
        else
        {
            throw new IllegalArgumentException("Direction invalide. Utilisez RIGHT ou LEFT.");
        }
    }*/
    /**
     * Pousser une ligne du plateau
     *
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
     * Pousser une colonne du plateau
     *
   //  * @param column colonne à pousser
   //  * @param direction direction pour pousser la colonne
     */
    /*public void pushColumn(int column, Direction direction)
    {
        Tile extraTileTemp = getExtraTile();

        if (direction == Direction.TOP)
        {
            extraTile = tiles[6][column];
            for (int i = 6; i > 0; i--)
            {
                tiles[i][column] = tiles[i - 1][column];
            }
            tiles[0][column] = extraTileTemp;
        }
        else if (direction == Direction.BOTTOM)
        {
            extraTile = tiles[0][column];
            for (int i = 0; i < 6; i++)
            {
                tiles[i][column] = tiles[i + 1][column];
            }
            tiles[6][column] = extraTileTemp;

        }
        else
        {
            throw new IllegalArgumentException("Direction invalide. Utilisez TOP ou BOTTOM.");
        }
    }*/

    public void pushRowRight(int row)
    {
        for (int i = 0; i < 6; i++)
        {
            tiles[row][i] = tiles[row][i + 1];
        }
        notifyObserversUpdatePushRow(row, Direction.RIGHT);
    }

    public Tile getTile(Position position)
    {
        return tiles[position.getPositionX()][position.getPositionY()];
    }

    public void pushColumnTop(int column)
    {
        for (int i = 6; i > 0; i--)
        {
            tiles[i][column] = tiles[i - 1][column];
        }
        notifyObserversUpdatePushColumn(column, Direction.TOP);
    }

    public void pushColumnBottom(int column)
    {
        for (int i = 0; i < 6; i++)
        {
            tiles[i][column] = tiles[i + 1][column];
        }
        notifyObserversUpdatePushColumn(column, Direction.BOTTOM);
    }



    public void setTileAt(Tile tile, Position position)
    {
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
