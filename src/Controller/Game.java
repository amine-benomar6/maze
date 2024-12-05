package Controller;

import Model.*;
import View.PlayerTextManager;

public class Game {
    public static void main(String[] args){
        Board board = new Board();
        Player player = new Player(new Position(0,0), board);
        player.setTilePlayer(board.getTile(player.getPosition()));

        PlayerTextManager playerTextManager = new PlayerTextManager();
        player.addObserver(playerTextManager);

        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++)
            {
                if(player.getPosition().getPositionX() == i && player.getPosition().getPositionY() == j){
                    System.out.print(player.affichage());
                }
                System.out.print(board.getTile(new Position(i,j)).affichage());
            }
            System.out.print("\n");
        }

        System.out.println("\n"+board.getExtraTile().affichage());

        board.getTile(player.getPosition()).rotate(Direction.BOTTOM);
        player.move(Direction.BOTTOM);
        player.move(Direction.TOP);

        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++)
            {
                if(player.getPosition().getPositionX() == i && player.getPosition().getPositionY() == j){
                    System.out.print(player.affichage());
                }
                System.out.print(board.getTile(new Position(i,j)).affichage());
            }
            System.out.print("\n");
        }

        System.out.println("\n"+board.getExtraTile().affichage());

    }


}
