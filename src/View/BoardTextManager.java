package View;

import Model.Board;
import Model.BoardObserver;
import Model.Direction;

public class BoardTextManager implements BoardObserver {
    /**
     * Affiche la ligne poussé
     * @param index index de la ligne poussé
     * @param direction direction de la ligne poussé
     */
    @Override
    public void updatePushRow(int index, Direction direction) {
        System.out.println("\nLa ligne " + index + " a été poussé par le coté "+ direction);
    }

    /**
     * Affiche la colonne poussé
     * @param index index de la colonne poussé
     * @param direction direction de la colonne poussé
     */
    @Override
    public void updatePushColumn(int index, Direction direction) {
        System.out.println("\nLa colonne " + index + " a été poussé par le coté "+ direction);
    }

}
