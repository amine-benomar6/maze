package View;

import Model.PlayerObserver;
import Model.Position;

public class PlayerTextManager implements PlayerObserver {
    /**
     * Affiche la nouvelle position du joueur
     * @param newPosition nouvelle position
     */
    @Override
    public void updatePosition(Position newPosition) {
        System.out.println("\nLe joueur s'est déplacé à la position : "+newPosition+"\n");
    }
}
