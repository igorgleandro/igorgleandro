public class Player {
    public String name;
    private int currentGuess;


    public Player(String name) {
        this.name = name;
    }

    public int getCurrentGuess(){
        return this.currentGuess;

    }


    public int generateCurrentGuess(){

       currentGuess = Rng.randomNumberGenerator();

       return currentGuess;
    };











}
