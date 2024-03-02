package io.codeforall.bootcamp.filhosdamain;

public class ObjectFactory {

    public static GameObject getNewObject() {
        int randomNum = (int) Math.floor(Math.random() * 3);

        if (randomNum == 0) {
            GameObject enemy = new SoldierEnemy();
            return enemy;
        } else if (randomNum == 1) {
            GameObject enemy = new ArmouredEnemy();
            return enemy;
        } else {
            GameObject object = new Tree();
            return object;
        }
    }
}
