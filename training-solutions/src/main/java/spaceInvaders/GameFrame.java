package spaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame implements KeyListener {
    private GamePanel gamePanel;
    GameFrame() {
        gamePanel = new GamePanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(gamePanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: {
                gamePanel.getPlayer().setPosX(gamePanel.getPlayer().getPosX()-5);
                break;
            }

            case KeyEvent.VK_RIGHT: {
                gamePanel.getPlayer().setPosX(gamePanel.getPlayer().getPosX()+5);
                break;
            }

            case KeyEvent.VK_SPACE: {
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println(e.getKeyCode());
    }

    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
    }
}
