package Controller;

import Model.*;
import View.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    private Game game;
    public GameController(Game game){
        this.game=game;
    }

    /**
     * Permet de bouger le joueur dans une direction
     * @param direction direction dans laquelle le joueur va se déplacer
     */
    public void movePlayer(Direction direction){
        game.movePlayer(game.getCurrentPlayer(), direction);
    }

    /**
     * Permet de passer au tour suivant
     */
    public void endOfRound(){
        game.switchCurrentPlayer();
    }


    /**
     * Permet de tourner l'extra tuile
     */
    public void rotateExtraTile(){
        game.getExtraTile().rotate(Direction.RIGHT);
    }

    /**
     * Permet d'obtenir les tuiles du plateaux
     * @return les tuiles du plateau
     */
    public Tile[][] getBoardTiles(){
        return game.getBoard().getTiles();
    }

}
