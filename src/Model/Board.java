package Model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Board {
    private Tile[][] tiles;
    private Tile extraTile;
    private TileFactory tileFactory = new TileFactory();

    public Board() {
        tiles = new Tile[7][7];
        initializeBoard();
    }

    public void initializeBoard()
    {
        int angle = 16;
        int t = 12;
        int droit = 17;
        for(int line = 0; line < 7; line++)
        {
            for (int colum = 0; colum < 7; colum++)
            {
                Position position = new Position(line,colum);
                if((line == 0 && (colum == 0 || colum == 6)) || (line == 6 && (colum == 0 || colum == 6)))
                {
                    tiles[line][colum] = tileFactory.createTileAngle(true);
                }
                else if(angle !=0 )
                {
                    tiles[line][colum] = tileFactory.createTileAngle(true);
                    angle--;
                }
                else if(t != 0)
                {
                    tiles[line][colum] = tileFactory.createTileT(true);
                    t--;
                }
                else if(droit != 0)
                {
                    tiles[line][colum] = tileFactory.createTileLine(true);
                    droit--;
                }
                tiles[line][colum].setPosition(position);
            }
        }
        this.extraTile = tileFactory.createTileT(true);
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public void pushRow(int row, Direction direction)
    {
        Tile extraTileTemp=getExtraTile();
        if(direction==Direction.LEFT)
        {
            extraTile=tiles[row][6];
            for(int i=6; i>0; i--)
            {
                tiles[row][i]=tiles[row][i-1];
            }
            tiles[row][0] = extraTileTemp;
        }
        else if(direction==Direction.RIGHT)
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
    }

    public void pushColumn(int colum, Direction direction)
    {
        Tile extraTileTemp = getExtraTile();

        if (direction == Direction.TOP)
        {
            extraTile = tiles[6][colum];
            for (int i = 6; i > 0; i--)
            {
                tiles[i][colum] = tiles[i - 1][colum];
            }
            tiles[0][colum] = extraTileTemp;
        }
        else if (direction == Direction.BOTTOM)
        {
            extraTile = tiles[0][colum];
            for (int i = 0; i < 6; i++)
            {
                tiles[i][colum] = tiles[i + 1][colum];
            }
            tiles[6][colum] = extraTileTemp;

        }
        else
        {
            throw new IllegalArgumentException("Direction invalide. Utilisez TOP ou BOTTOM.");
        }
    }

    public Tile getTile(Position position)
    {
        return tiles[position.getPositionX()][position.getPositionY()];
    }

    public Tile getExtraTile()
    {
        return extraTile;
    }

    public void setExtraTile(Tile extraTile)
    {
        this.extraTile = extraTile;
    }

}
