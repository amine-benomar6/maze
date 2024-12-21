package View;

import Controller.GameController;
import Model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Display extends JFrame {
    private JPanel panel;
    private JPanel leftPanel;
    private JPanel centerPanel;
    private JLabel extraTileLabel;
    private JLabel currentPlayerImage;
    private BufferedImage originalImage;
    private BufferedImage rotatedImage;
    private double rotationAngle = 0;

    String[] playerImagePaths = {
            "img/RondRouge.png",   // Joueur 1
            "img/RondBleu.png",    // Joueur 2
            "img/RondVert.png",    // Joueur 3
            "img/RondJaune.png"    // Joueur 4
    };

    public Display(GameController gameController, Game game) throws IOException {
        super("Labyrinthe");
        JPanel jp2 = new JPanel(new BorderLayout());
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(jp2);

        centerPanel = new JPanel(new BorderLayout());

        panel = new JPanel(new GridLayout(7, 7, 2, 2));
        centerPanel.setPreferredSize(new Dimension(200,200));
        initializeBoard(gameController.getBoardTiles(), game.getPlayers());

        addPushButtons(gameController, game);

        centerPanel.add(panel, BorderLayout.CENTER);

        leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setPreferredSize(new Dimension(500, getHeight()));

        // Ajouter l'affichage du joueur actuel
        String playerImagePath = playerImagePaths[game.getPlayers().indexOf(game.getCurrentPlayer()) % playerImagePaths.length];
        BufferedImage playerImage = ImageIO.read(new File(playerImagePath));
        currentPlayerImage = new JLabel(new ImageIcon(playerImage));
        JButton endTurnButton = new JButton("Fin du tour");
        endTurnButton.addActionListener(e -> {
            gameController.endOfRound(); // Passer au joueur suivant
            try {
                updateCurrentPlayerDisplay(game); // Mettre à jour l'affichage
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        originalImage = ImageIO.read(new File(pathImgOfTile(game.getExtraTile())));
        rotatedImage = originalImage; // Initialiser avec l'image originale
        extraTileLabel = new JLabel(new ImageIcon(rotatedImage));

        JButton left = new JButton("Left");
        left.addActionListener(e -> moveAndUpdate(gameController, Direction.LEFT, game));

        JButton right = new JButton("Right");
        right.addActionListener(e -> moveAndUpdate(gameController, Direction.RIGHT, game));

        JButton top = new JButton("Top");
        top.addActionListener(e -> moveAndUpdate(gameController, Direction.TOP, game));

        JButton bottom = new JButton("Bottom");
        bottom.addActionListener(e -> moveAndUpdate(gameController, Direction.BOTTOM, game));

        JButton rotateButton = new JButton("Rotate");
        rotateButton.setPreferredSize(new Dimension(150, 150)); // Dimension plus petite pour le bouton
        rotateButton.addActionListener(e -> {
            try {
                gameController.rotateExtraTile();
                rotateExtraTile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER; // Centrer les composants
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        leftPanel.add(extraTileLabel, gbc);

        gbc.gridy = 1;
        leftPanel.add(rotateButton, gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;
        leftPanel.add(top, gbc);

        gbc.gridy = 3;
        gbc.gridx = 0;
        leftPanel.add(left, gbc);

        gbc.gridx = 2;
        leftPanel.add(right, gbc);

        gbc.gridy = 4;
        gbc.gridx = 1;
        leftPanel.add(bottom, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        leftPanel.add(currentPlayerImage, gbc);

        gbc.gridx = 1;
        leftPanel.add(endTurnButton, gbc);


        jp2.add(leftPanel,BorderLayout.WEST);
        jp2.add(centerPanel, BorderLayout.CENTER);

        leftPanel.setPreferredSize(new Dimension(300, getHeight()));  // Ajuster la largeur pour plus d'espace

        setVisible(true);


    }

    private void updateCurrentPlayerDisplay(Game game) throws IOException {
        int currentPlayerIndex = game.getPlayers().indexOf(game.getCurrentPlayer());
        BufferedImage playerImage = ImageIO.read(new File(playerImagePaths[currentPlayerIndex]));
        ImageIcon playerIcon = new ImageIcon(playerImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        currentPlayerImage.setIcon(playerIcon);
    }

    public void initializeBoard(Tile[][] tiles, List<Player> players) throws IOException {
        panel.removeAll();

        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                Tile currentTile = tiles[i][j];
                String imagePath = pathImgOfTile(currentTile);

                BufferedImage baseImage = ImageIO.read(new File(imagePath));
                ImageIcon icon = new ImageIcon(baseImage);

                JLabel label = new JLabel(icon);
                label.setLayout(new OverlayLayout(label));
                panel.add(label);

                for (int p=0; p< players.size();p++) {
                    Player player = players.get(p);
                    if (player.getPosition().getPositionX() == i && player.getPosition().getPositionY() == j) {
                        String playerImagePath = playerImagePaths[p % playerImagePaths.length];
                        BufferedImage playerImage = ImageIO.read(new File(playerImagePath));
                        ImageIcon playerIcon = new ImageIcon(playerImage);

                        JLabel playerLabel = new JLabel(playerIcon);
                        playerLabel.setPreferredSize(new Dimension(20, 20));
                        playerLabel.setOpaque(false);
                        label.add(playerLabel);
                    }
                }
            }
        }

        panel.revalidate();
        panel.repaint();
    }

    private void addPushButtons(GameController gameController, Game game) {
        // Panneaux pour les boutons des lignes et colonnes
        JPanel rowButtonsLeft = new JPanel(new GridLayout(7, 1));
        JPanel columnButtonsTop = new JPanel(new GridLayout(1, 7));
        JPanel rowButtonsRight = new JPanel(new GridLayout(7, 1));
        JPanel columnButtonsBottom = new JPanel(new GridLayout(1, 7));

        for (int i = 0; i < 7; i++) {
            if (i % 2 == 1) {
                // Boutons pour les lignes impaires (gauche et droite)
                JButton pushRowLeftButton = new JButton("← Ligne " + i);
                int rowIndex = i;
                pushRowLeftButton.addActionListener(e -> game.pushRow(rowIndex, Direction.LEFT));
                rowButtonsLeft.add(pushRowLeftButton);

                JButton pushRowRightButton = new JButton("→ Ligne " + i);
                pushRowRightButton.addActionListener(e ->
                {
                    game.pushRow(rowIndex, Direction.RIGHT);
                    updateExtraTile(game.getExtraTile());
                    try {
                        updateBoard(game);

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                rowButtonsRight.add(pushRowRightButton);

                // Boutons pour les colonnes impaires (haut et bas)
                JButton pushColumnTopButton = new JButton("↑ Colonne " + i);
                int columnIndex = i;
                pushColumnTopButton.addActionListener(e -> game.pushColumn(rowIndex, Direction.TOP));
                columnButtonsTop.add(pushColumnTopButton);

                JButton pushColumnBottomButton = new JButton("↓ Colonne " + i);
                pushColumnBottomButton.addActionListener(e -> game.pushColumn(rowIndex, Direction.BOTTOM));
                columnButtonsBottom.add(pushColumnBottomButton);
            } else {
                // Ajouter des espaces pour garder l'alignement
                rowButtonsLeft.add(new JLabel(""));
                rowButtonsRight.add(new JLabel(""));
                columnButtonsTop.add(new JLabel(""));
                columnButtonsBottom.add(new JLabel(""));
            }
        }

        // Ajouter les boutons aux côtés du panneau central
        centerPanel.add(rowButtonsLeft, BorderLayout.WEST);
        centerPanel.add(columnButtonsTop, BorderLayout.NORTH);
        centerPanel.add(rowButtonsRight, BorderLayout.EAST);
        centerPanel.add(columnButtonsBottom, BorderLayout.SOUTH);
    }


    public void updateBoard(Game game) throws IOException {
        initializeBoard(game.getBoard().getTiles(), game.getPlayers());
    }

    public void rotateExtraTile() throws IOException {
        rotationAngle += Math.toRadians(90);
        rotatedImage = rotate(originalImage, rotationAngle);
        extraTileLabel.setIcon(new ImageIcon(rotatedImage));
    }

    private void updateExtraTile(Tile tile) {
        // Récupérer le chemin de l'image de la tuile
        String imagePath = pathImgOfTile(tile);

        // Charger l'image de la tuile
        try {
            BufferedImage newImage = ImageIO.read(new File(imagePath));  // Charger l'image
            rotatedImage = newImage;
            originalImage = rotatedImage;// Mettre à jour l'image de l'`extraTile`
            extraTileLabel.setIcon(new ImageIcon(rotatedImage));  // Mettre à jour l'icône de `extraTileLabel`
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void moveAndUpdate(GameController gameController, Direction direction, Game game) {
        gameController.movePlayer(direction);
        try {
            updateBoard(game);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public String pathImgOfTile(Tile tile) {
        return switch (tile.getType()) {
            case T -> "img/tuileT.jpg";
            case ANGLE -> "img/tuileAngle.jpg";
            case LINE -> "img/tuileDroit.jpg";
        };
    }

    public static BufferedImage rotate(BufferedImage original, double angle) throws IllegalArgumentException {
        if (original.getWidth() != original.getHeight())
            throw new IllegalArgumentException("Original image must have same width and height.");
        BufferedImage rotated = new BufferedImage(original.getWidth(), original.getHeight(), original.getType());
        Graphics2D graphic = rotated.createGraphics();
        graphic.rotate(angle, original.getWidth() / 2.0, original.getHeight() / 2.0);
        graphic.drawRenderedImage(original, null);
        graphic.dispose();
        return rotated;
    }
}


