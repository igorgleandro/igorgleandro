package io.codeforall.bootcamp.filhosdamain;

public class MagicLamp {

    private int geniesCount;
    private int numGenies;
    private int rechargeCount;

    public MagicLamp(int numGenies) {
        this.geniesCount = numGenies;
        this.numGenies = numGenies;
    }

    public int getNumber() {
        return (int) ((Math.random() * 4) + 1);
    }

    public Genie rubLamp() {
        int numOfWishes = getNumber();
        if (geniesCount == 0) {
            GenieDemon genie = new GenieDemon(numOfWishes);
            System.out.println("\n👹: I AM A RECYCLE DEMON.. BEWARE OF WHAT YOU ASK OF ME!!!");
            return genie;
        } else if (getNumber() % 2 == 0) {
            GenieFriendly genie = new GenieFriendly(numOfWishes);
            System.out.println("\n🦄: Hello dear..  I am a friendly genie and you have " + numOfWishes + " wishes that you can ask of me :)");
            geniesCount--;
            return genie;
        } else {
            GenieGrumpy genie = new GenieGrumpy(numOfWishes);
            System.out.println("\n😾: WHAT DO YOU WANT? I'LL JUST GIVE YOU ONE WISH AND YOU CAN GO AWAY!!");
            geniesCount--;
            return genie;
        }
    }

    public void recycle(Genie genie) {
        if (genie instanceof GenieDemon) {
            ((GenieDemon) genie).recycle();
            this.geniesCount = numGenies;
            rechargeCount++;
            return;
        }
        System.out.println("\n⛔️: I'm not a Recycable Demon!!");
    }

    public boolean compareLamps(MagicLamp lamp1, MagicLamp lamp2) {
        System.out.println("\n🖇️: The Lamp 1 have: " + lamp1.numGenies + " capacity, " + lamp1.geniesCount + " genies remaining, and has been recharged " + lamp1.rechargeCount + " times. 🖇️️");
        System.out.println("🖇️: The Lamp 1 have: " + lamp2.numGenies + " capacity, " + lamp2.geniesCount + " genies remaining, and has been recharged " + lamp2.rechargeCount + " times. 🖇️");

        if (lamp1.numGenies == lamp2.numGenies && lamp1.geniesCount == lamp2.geniesCount && lamp1.rechargeCount == lamp2.rechargeCount) {
            System.out.println("\n✅: They have the same values");
            return true;
        }
        System.out.println("\n❌: They have different values");
        return false;
    }
}
