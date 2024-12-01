package Controller;

import Model.*;

public class Game {
    public static void main(String[] args){
        Board board = new Board();
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++)
            {
                System.out.print(board.getTile(new Position(i,j)).affichage());
            }
            System.out.print("\n");
        }

        System.out.println("\n"+board.getExtraTile().affichage());


        System.out.println("\nPousser de la ligne 0 avec la extraTile");
        board.pushRow(2, Direction.LEFT);

        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++)
            {
                System.out.print(board.getTile(new Position(i,j)).affichage());
            }
            System.out.print("\n");
        }

        System.out.println("\n"+board.getExtraTile().affichage());
        System.out.println("\nPousser de la colonne 2 avec la extraTile");
        board.pushColumn(6, Direction.BOTTOM);

        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++)
            {
                System.out.print(board.getTile(new Position(i,j)).affichage());
            }
            System.out.print("\n");
        }

        System.out.println("\n"+board.getExtraTile().affichage());
    }
}
