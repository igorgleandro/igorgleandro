package io.codeforall.bootcamp.filhosdamain;

public class ArmouredEnemy extends Enemy {


    int armouredHealth = 6;
    int armour = 6;


    public int hit(int bulletDamage) {

        System.out.println("_____________________________ \n 🪖ArmouredEnemy Target: " + armour + " armour 🛡️, " + armouredHealth + " health.❤️");
        System.out.println(" 🔫ArmouredEnemy received : " + bulletDamage + " damage.");
        for (int i = bulletDamage; i > 0; i--) {
            if (armour > 0) {
                armour = armour - 1;
            }
            if (armouredHealth > 0 && armour == 0) {
                armouredHealth = armouredHealth - 1;
            }
            if (armour == 0 && armouredHealth == 0) {
                System.out.println(" ☠️Armoured Enemy is dead!");
                isDead();
                break;
            }

        }
        return bulletDamage;
    }

    @Override
    public String toString() {
        return "ArmouredEnemy";
    }
}



