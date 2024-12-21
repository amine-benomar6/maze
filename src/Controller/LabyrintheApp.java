package Controller;

import Model.*;
import View.BoardTextManager;
import View.GameDisplay;
import View.PlayerTextManager;
import View.TileTextManager;
import View.Display;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LabyrintheApp
{
    public static void main(String[] args) throws IOException
    {
        Board board = new Board();

        Player player = new Player(new Position(3, 0), board);
        List<Player> players = new ArrayList<>();
        players.add(player);

        Tile extraTile = new TileT(true);

        Game game = new Game(board, players, extraTile);

        GameDisplay gameDisplay = new GameDisplay(game);

        TileTextManager tileTextManager = new TileTextManager();
        for (Tile[] row : board.getTiles())
        {
            for (Tile tile : row)
            {
                tile.addObserver(tileTextManager);
            }
        }

        PlayerTextManager playerTextManager = new PlayerTextManager();
        player.addObserver(playerTextManager);

        BoardTextManager boardTextManager = new BoardTextManager();
        board.addObserver(boardTextManager);


        Display ecran = new Display(new GameController(game), game);


        gameDisplay.Display();
    }
}