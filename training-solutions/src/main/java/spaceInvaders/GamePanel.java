package spaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static spaceInvaders.GameDatas.PANEL_HEIGHT;
import static spaceInvaders.GameDatas.PANEL_WIDTH;

public class GamePanel extends JPanel implements ActionListener {
//public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private Enemies enemies;
    private final Spirit player;

    GamePanel(){
        this.setPreferredSize(new Dimension(PANEL_WIDTH, GameDatas.PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        //this.addKeyListener(this);
        enemies = new Enemies();
        player = new Spirit(PANEL_WIDTH/2,PANEL_HEIGHT-50,0);

        for (int i = 0; i < PANEL_WIDTH-150; i += 70) {
            for (int j = 0; j < 8; j++) {
                enemies.addEnemy(new Spirit(i, j*70, j+1));
            }
        }

        timer = new Timer(10,this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        for (Spirit enemy: enemies.getEnemies()) {
            g2d.drawImage(enemy.getImage(),enemy.getPosX(), enemy.getPosY(), null);
        }
        g2d.drawImage(player.getImage(),player.getPosX(), player.getPosY(), null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        enemies.changePosX(PANEL_WIDTH);
        repaint();
    }

    public Spirit getPlayer() {
        return player;
    }

    //    @Override
//    public void keyTyped(KeyEvent e) {
//        System.out.println(e.getKeyCode());
//    }
//
//    @Override
//    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyCode());
//        switch (e.getKeyCode()) {
//            case KeyEvent.VK_LEFT: {
//                player.setPosX(player.getPosX()-5);
//                break;
//            }
//
//            case KeyEvent.VK_RIGHT: {
//                player.setPosX(player.getPosX()+5);
//                break;
//            }
//
//            case KeyEvent.VK_SPACE: {
//                break;
//            }
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//        System.out.println(e.getKeyCode());
//    }
}
