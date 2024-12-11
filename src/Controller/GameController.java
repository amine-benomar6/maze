package Controller;

import Model.Direction;
import Model.Game;

public class GameController {
    private Game game;
    public GameController(Game game){
        this.game=game;
    }

    public void movePlayerUp(){
        game.movePlayer(game.getPlayers().get(0), Direction.TOP);
    }

    public void movePlayerBottom(){
        game.movePlayer(game.getPlayers().get(0), Direction.BOTTOM);
    }

}
