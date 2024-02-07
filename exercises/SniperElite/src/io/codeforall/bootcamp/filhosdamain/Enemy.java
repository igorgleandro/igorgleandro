package io.codeforall.bootcamp.filhosdamain;

public class Enemy extends GameObject {

    private boolean isDead;

    public void isDead(){
        isDead = !isDead;
    }

    public int hit(int bulletDamage){
        return bulletDamage;
    }

    @Override
    public String getMessage(){
        String enemyMessage = "I'm the Enemy!!";
        return enemyMessage;
    }
    public boolean getIsDead() {
        return isDead;
    }
}

