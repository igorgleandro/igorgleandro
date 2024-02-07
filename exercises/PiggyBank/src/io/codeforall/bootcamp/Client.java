package io.codeforall.bootcamp;

public class Client {
        private String client;
        private int wallet = 0;

        public Client (String client) {
            this.client = client ;
        }
        public String getClient() {
            return client;
        }

    public void bankOperations() {
        System.out.println("\n Hello, " + client + ": \n Welcome to Balthazar's Bank 🏪\n \n 📟Please choose your operation type: ");
        Bank.GetOperationType();
    }
    public void doDeposit(int amount) {
        if (amount > 0) {
            System.out.println("\n You're doing a 📥" + Bank.OperationType.DEPOSIT + " of $" + amount);
            this.wallet = wallet + amount;
            System.out.println("You have $" + this.wallet + " in your wallet💰");
        } else {
            System.out.println("\n ⛔️**** ERROR**** ⛔️  \nSet a Positive value please.");
        }
    }
    public void doDebit(int amount) {
        if (amount >= 0){
            System.out.println("\n You're doing a 📤" + Bank.OperationType.PAYMENT + " of $" + amount );
            this.wallet = wallet - amount;
            System.out.println("You have $ " + this.wallet + " in your wallet💰");
        }else{
            System.out.println("\n ⛔️**** ERROR**** ⛔️ \nSet a Positive value please."); }
    }
}



