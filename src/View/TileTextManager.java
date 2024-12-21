package View;

import Model.Direction;
import Model.Tile;
import Model.TileObserver;

public class TileTextManager implements TileObserver {
    /**
     * Affiche la rotation de la tuile
     * @param direction direction de la rotation
     * @param tile tuile qui a tourné
     */
    @Override
    public void updateRotate(Direction direction, Tile tile) {
        System.out.println("Tuile à la place : "+tile.getPosition()+" en direction : "+direction
        + "\nPositon HAUT Ouverte : "+tile.getIsOpenTop()
        + "\nPositon DROITE Ouverte : "+tile.getIsOpenRight()
        + "\nPositon BAS Ouverte : "+tile.getIsOpenBottom()
        + "\nPositon GAUCHE Ouverte : "+tile.getIsOpenLeft()+"\n");
    }
}
