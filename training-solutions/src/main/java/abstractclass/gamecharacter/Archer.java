package abstractclass.gamecharacter;

import methodpass.Position;

import java.util.Random;

public class Archer extends Character{
    private int numberOfArrow = 100;

    public Archer(Point position, Random random) {
        super(position, random);
    }

    public int getNumberOfArrow() {
        return numberOfArrow;
    }

    public int getActualSecondaryDamage(){
        return getRandom().nextInt(1,5);
    }

    private void shootingAnArrow(Character enemy){
        numberOfArrow -= 1;
        hit(enemy, getActualSecondaryDamage());
    }


    @Override
    public void secondaryAttack(Character enemy) {
        shootingAnArrow(enemy);
    }
}
