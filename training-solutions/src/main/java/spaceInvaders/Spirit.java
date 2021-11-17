package spaceInvaders;

import javax.swing.*;
import java.awt.*;

public class Spirit {
    private int posX;
    private int posY;
    private int typeOfSpirit;
    private Image image;

    public Spirit(int posX, int posY, int typeOfSpirit) {
        this.posX = posX;
        this.posY = posY;
        this.typeOfSpirit = typeOfSpirit;
        switch (typeOfSpirit) {
            case 0: {
                image = new ImageIcon("src/main/resources/spaceinvaders/spaceship.png").getImage();
                break;
            }
            case 1: {
                image = new ImageIcon("src/main/resources/spaceinvaders/enemy01.png").getImage();
                break;
            }
            case 2: {
                image = new ImageIcon("src/main/resources/spaceinvaders/enemy02.png").getImage();
                break;
            }
            case 3: {
                image = new ImageIcon("src/main/resources/spaceinvaders/enemy03.png").getImage();
                break;
            }
            case 4: {
                image = new ImageIcon("src/main/resources/spaceinvaders/enemy04.png").getImage();
                break;
            }
            case 5: {
                image = new ImageIcon("src/main/resources/spaceinvaders/enemy05.png").getImage();
                break;
            }
            case 6: {
                image = new ImageIcon("src/main/resources/spaceinvaders/enemy06.png").getImage();
                break;
            }
            case 7: {
                image = new ImageIcon("src/main/resources/spaceinvaders/enemy07.png").getImage();
                break;
            }
            case 8: {
                image = new ImageIcon("src/main/resources/spaceinvaders/enemy08.png").getImage();
                break;
            }
        }
    }

    public Image getImage() {
        return image;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
