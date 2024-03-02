package io.codeforall.bootcamp.filhosdamain;

public class Game {


    private GameObject[] gameObjects;
    private SniperRifle sniperRifle;
    private static int shotsFired;

    public void start() {
        createObject(10);
        sniperRifle = new SniperRifle();
        sniperRifle.shoot(gameObjects);

    }

    public void createObject(int objectNumbers) {

        this.gameObjects = new GameObject[objectNumbers];
        for (int i = 0; i < objectNumbers; i++) {
            this.gameObjects[i] = ObjectFactory.getNewObject();
        }

    }
}
