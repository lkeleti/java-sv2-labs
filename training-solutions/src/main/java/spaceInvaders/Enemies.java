package spaceInvaders;

import java.util.ArrayList;
import java.util.List;

public class Enemies {
    private int minX = 65536;
    private int maxX = 0;
    private int direction = 1;
    private int velocityX = 5;
    private int velocityY = 5;

    List<Spirit> enemies = new ArrayList<>();

    public List<Spirit> getEnemies() {
        return enemies;
    }

    public void addEnemy(Spirit enemy) {
        enemies.add(enemy);
    }

    private void findMinMaxX(){
        minX = 65536;
        maxX = 0;
        for (Spirit enemy: enemies) {
            if (enemy.getPosX() < minX) {
                minX = enemy.getPosX();
            }
            if (enemy.getPosX() + 50 > maxX) {
                maxX = enemy.getPosX() + 50 ;
            }
        }
    }

    public void changePosX(int panelWidth) {
        findMinMaxX();
        if (direction == 1 && maxX + (velocityX*direction) > panelWidth) {
            direction *= -1;
        }
        if (direction == -1 && minX + (velocityX*direction) < 0) {
            direction *= -1;
        }
        for (Spirit enemy: enemies) {
            enemy.setPosX(enemy.getPosX()+(velocityX*direction));
        }
    }
}
