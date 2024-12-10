package View;

import Model.Board;
import Model.BoardObserver;
import Model.Direction;

public class BoardTextManager implements BoardObserver {
    @Override
    public void updatePushRow(int index, Direction direction) {
        System.out.println("\nLa ligne " + index + " a été poussé par le coté "+ direction);
    }

    @Override
    public void updatePushColumn(int index, Direction direction) {
        System.out.println("\nLa colonne " + index + " a été poussé par le coté "+ direction);
    }

    public void boardDisplay(Board board){

    }
}
