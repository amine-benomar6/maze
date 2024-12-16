package Controller;

import Model.Direction;
import Model.Game;

public class GameController {
    private Game game;
    public GameController(Game game){
        this.game=game;
    }

    public void movePlayer(Direction direction){
        game.movePlayer(game.getPlayers().get(0), direction);
    }

    public void rotateExtraTile(){
        System.out.println("ez");
        game.getExtraTile().rotate(Direction.RIGHT);
    }

}
