package hw8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class BattleField extends JPanel {
    static int padding;
    private GameWindow gameWindow;
    private int gameMode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    private int cellWidth;
    private int cellHeight;

    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if (!Logic.finishedGame) {
                    Logic.humanTurn(cellX, cellY);
                }

                if (!Logic.finishedGame) {
                    Logic.aiTurn();
                }

                repaint();

                if (Logic.finishedGame) {
                    Dialog dialog = new Dialog(gameWindow, Logic.theWinner);
                    dialog.setLocationRelativeTo(gameWindow);
                    dialog.setVisible(true);
                }
            }
        });

    }

    public void startNewGame(int gameMode, int fieldSize, int winningLength) {
        this.gameMode = gameMode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;
        isInit = true;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSize;
        cellHeight = panelHeight / fieldSize;

        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 1; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }

        if (Logic.thereIsWinner) {
            for (int i = 0; i < Logic.arr.length; i++) {
                for (int j = 0; j < Logic.arr.length; j++) {
                    if (Logic.arr[j][i] == 1) {
                        switch (Logic.dr) {
                            case 0:
                                drawLine0(g, i, j);
                                break;
                            case 1:
                                drawLine1(g, i, j);
                                break;
                            case 2:
                                drawLine2(g, i, j);
                                break;
                            case 3:
                                drawLine3(g, i, j);
                                break;
                        }
                    }
                }
            }
            for (int[] row : Logic.arr)
                Arrays.fill(row, 0);
        }
    }

    void drawX(Graphics g, int x, int y) {
        padding = (int) (cellWidth * 0.20);
        g.setColor(Color.BLACK);
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.drawLine(x * cellWidth + padding, y * cellHeight + padding,
                (x + 1) * cellWidth - padding, (y + 1) * cellHeight - padding);

        g.drawLine((x + 1) * cellWidth - padding, y * cellHeight + padding,
                x * cellWidth + padding, (y + 1) * cellHeight - padding);
    }

    void drawO(Graphics g, int x, int y) {
        padding = (int) (cellWidth * 0.15);
        g.setColor(Color.RED);
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.drawOval(x * cellWidth + padding, y * cellHeight + padding,
                cellWidth - 2 * padding, cellHeight - 2 * padding);
    }

    void drawLine0(Graphics g, int x, int y) {
        g.setColor(Color.CYAN);
        ((Graphics2D) g).setStroke(new BasicStroke(3));
        g.drawLine(x * cellWidth, (int) ((y + 0.5) * cellHeight), (x + 1) * cellWidth, (int) ((y + 0.5) * cellHeight));
    }

    void drawLine1(Graphics g, int x, int y) {
        g.setColor(Color.WHITE);
        ((Graphics2D) g).setStroke(new BasicStroke(3));
        g.drawLine((int) ((x + 0.5) * cellWidth), y * cellHeight, (int) ((x + 0.5) * cellWidth), (y + 1) * cellHeight);
    }

    void drawLine2(Graphics g, int x, int y) {
        g.setColor(Color.GREEN);
        ((Graphics2D) g).setStroke(new BasicStroke(2));
        g.drawLine(x * cellWidth, y * cellHeight, (x + 1) * cellWidth, (y + 1) * cellHeight);
    }

    void drawLine3(Graphics g, int x, int y) {
        g.setColor(Color.GRAY);
        ((Graphics2D) g).setStroke(new BasicStroke(3));
        g.drawLine((x + 1) * cellWidth, y * cellHeight, x * cellWidth, (y + 1) * cellHeight);
    }
}
