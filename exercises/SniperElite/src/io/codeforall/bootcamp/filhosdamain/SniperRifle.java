package io.codeforall.bootcamp.filhosdamain;

import java.lang.annotation.Target;

public class SniperRifle {

    private Enemy target;
    //int bulletDamage = (int) Math.ceil(Math.random() * 3);

    public void shoot(GameObject[] target) {

        for (int i = 0; i < target.length; i++) {
            if (target[i] instanceof ArmouredEnemy enemy) {
                while (enemy.getIsDead() == false)
                enemy.hit((int) Math.ceil(Math.random() * 3));

            } else if (target[i] instanceof SoldierEnemy enemy) {
               while (enemy.getIsDead() == false)
                enemy.hit((int) Math.ceil(Math.random() * 3));
            } else {
                System.out.println("_________________________ \n 🌳Its a tree. Don't shoot.");
            }
        }

    }
}


//target.hit((int)Math.ceil(Math.random()* 3));
//int bulletDamage = (int)Math.ceil(Math.random()* 3);

