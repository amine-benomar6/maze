package Controller;

import Model.*;

public class Game {
    public static void main(String[] args){
        Board board = new Board();
        Position positionJ1 = new Position(3,4);
        Player player = new Player(1,positionJ1);
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++)
            {
                System.out.print(board.getTile(new Position(i,j)).affichage());
            }
            System.out.print("\n");
        }

        System.out.println("\n"+board.getExtraTile().affichage());

        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++)
            {
                if(i==player.getPosition().getPositionX() && j==player.getPosition().getPositionY()){
                    System.out.print(player.affichage());
                }
                else {
                    System.out.print(board.getTile(new Position(i, j)).affichage());
                }
            }
            System.out.print("\n");
        }

        System.out.println("\n"+board.getExtraTile().affichage());

    }
}
