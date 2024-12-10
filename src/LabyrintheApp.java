import Controller.GameController;
import Model.Board;
import view.Display;

import java.io.IOException;

public class LabyrintheApp
{
    public static void main(String[] args) throws IOException {
        Display ecran = new Display(new GameController(), new Board());
    }
}
