package View;

import Model.Game;
import Model.Player;
import Model.Position;

public class GameDisplay {
    Game game;
    public GameDisplay(Game game){
        this.game=game;
    }
    public void Display(){
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++)
            {
                for (Player player: game.getPlayers())
                {
                    if(player.getPosition().getPositionX() == i && player.getPosition().getPositionY() == j){
                        System.out.print(player.affichage());
                    }
                }

                System.out.print(game.getBoard().getTile(new Position(i,j)).affichage());
            }
            System.out.print("\n");
        }

        System.out.println("\n"+game.getExtraTile().affichage());
    }

}
