package spaceinvaders;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static spaceinvaders.GameDatas.*;

public class GameFrame extends JFrame implements KeyListener {
    private GamePanel gamePanel;
    GameFrame() {
        gamePanel = new GamePanel();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(gamePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                leftDown = true;
                break;
            }

            case KeyEvent.VK_RIGHT: {
                rightDown = true;
                break;
            }

            case KeyEvent.VK_SPACE: {
                spaceDown = true;
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                leftDown = false;
                break;
            }

            case KeyEvent.VK_RIGHT: {
                rightDown = false;
                break;
            }

            case KeyEvent.VK_SPACE: {
                spaceDown = false;
                break;
            }
        }
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
    }
}
