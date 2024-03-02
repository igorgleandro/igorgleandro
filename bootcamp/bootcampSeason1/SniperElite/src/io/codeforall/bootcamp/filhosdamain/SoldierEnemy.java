package io.codeforall.bootcamp.filhosdamain;

public class SoldierEnemy extends Enemy {

    int soldierHealth = 6;

    public int hit(int bulletDamage) {

        System.out.println("_____________________________ \n 🪖SoldierEnemy Target: " + soldierHealth + " health ❤️.");
        System.out.println(" 🔫SoldierEnemy received : " + bulletDamage + " damage.");

        for (int i = bulletDamage; i > 0; i--) {
            if (soldierHealth > 0) {
                soldierHealth = soldierHealth - 1;
            }
            if (soldierHealth == 0){
                System.out.println(" ☠️Soldier Enemy is dead! ");
                isDead();
                break;

            }
        } return bulletDamage;
    }

    @Override
    public String toString() {
        return "SoldierEnemy";
    }
}

