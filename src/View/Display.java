package View;

import Controller.GameController;
import Model.Board;
import Model.ImageHelper;
import Model.Tile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Display extends JFrame
{
    private JPanel panel;

    public Display(GameController gameController, Board board) throws IOException {
        super("Labyrinthe");
        JPanel jp2 = new JPanel(new BorderLayout());
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(jp2);
        panel.setLayout(new GridLayout(7, 7, 0, 0));
        initializeBoard(board.getTiles());
        panel.setPreferredSize(new Dimension(100, 50));

        JPanel leftPanel = new JPanel(new GridBagLayout());
        Button left = new Button("left");
        Button right = new Button("right");
        Button top = new Button("top");
        Button bottom = new Button("bottom");
        left.setPreferredSize(new Dimension(100, 50));
        right.setPreferredSize(new Dimension(100, 50));
        top.setPreferredSize(new Dimension(100, 50));
        bottom.setPreferredSize(new Dimension(100, 50));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; // Colonne 0
        gbc.gridy = 0; // Ligne 0
        gbc.anchor = GridBagConstraints.CENTER; // Centrage vertical
        leftPanel.add(left, gbc);
        gbc.gridx = 1;
        leftPanel.add(right, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        leftPanel.add(bottom, gbc);
        gbc.gridx = 1;
        gbc.gridy=  1;

        leftPanel.add(top, gbc);
        // Ajouter le panneau gauche dans la région WEST
        jp2.add(leftPanel, BorderLayout.WEST);
        jp2.add(panel, BorderLayout.CENTER);
        // Afficher la fenêtre
        setVisible(true);
    }

    public void initializeBoard(Tile[][] tiles) throws IOException
    {
        String imagePath;
        // Ajouter les images dans la grille
        for (Tile[] tile : tiles)
        {
            for (Tile currentTile : tile)
            {
                imagePath = pathImgOfTile(currentTile);
                BufferedImage baseImage = ImageIO.read(new File(imagePath));
                ImageIcon icon = new ImageIcon(baseImage);
                JLabel label = new JLabel(icon);
                panel.add(label);
            }
        }
    }

    public String pathImgOfTile(Tile tile)
    {
        return switch (tile.getType())
        {
            case T -> "img/tuileT.jpg";
            case ANGLE -> "img/tuileAngle.jpg";
            case LINE ->  "img/tuileDroit.jpg";
        };
    }
}