package Controller;

import Model.Board;
import Model.Tile;
import Model.TileFactory;
import Model.TileL;

public class Game {
    public static void main(String[] args){
        Board board = new Board();
        for(int i=0; i<49; i++){
            System.out.print(board.getTiles().get(i).affichage());
            if((i+1)%7==0){
                System.out.print("\n");
            }
        }

        System.out.println("\n"+board.getExtraTile().affichage());

    }
}
