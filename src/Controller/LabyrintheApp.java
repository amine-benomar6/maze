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

public class LabyrintheApp {
    public static void main(String[] args) throws IOException {

        Board board = new Board();

        Player player1 = new Player(new Position(0, 0));
        Player player2 = new Player(new Position(6, 0));
        Player player3 = new Player(new Position(0, 6));
        Player player4 = new Player(new Position(6, 6));
        List<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        Tile extraTile = new TileT();

        Game game = new Game(board, players, extraTile);

        GameDisplay gameDisplay = new GameDisplay(game);

        TileTextManager tileTextManager = new TileTextManager();
        for (Tile[] row : board.getTiles()) {
            for (Tile tile : row) {
                tile.addObserver(tileTextManager);
            }
        }

        PlayerTextManager playerTextManager = new PlayerTextManager();
        player1.addObserver(playerTextManager);
        player2.addObserver(playerTextManager);
        player3.addObserver(playerTextManager);
        player4.addObserver(playerTextManager);

        BoardTextManager boardTextManager = new BoardTextManager();
        board.addObserver(boardTextManager);


        Display ecran = new Display(new GameController(game), game);

        gameDisplay.Display();

    }


}
