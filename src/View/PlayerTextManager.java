package View;

import Model.PlayerObserver;
import Model.Position;

public class PlayerTextManager implements PlayerObserver {
    @Override
    public void updatePosition(Position newPosition) {
        System.out.println("\nLe joueur s'est déplacé à la position : "+newPosition+"\n");
    }
}
