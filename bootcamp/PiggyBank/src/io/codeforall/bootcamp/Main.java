package io.codeforall.bootcamp;

public class Main {

    public static void main(String[] args) {

        Client client = new Client("🙎️Igor"); //inicilizar com uma wallet e um banco
        client.bankOperations();
        client.doDeposit(0);
        client.doDeposit(200);
        client.doDebit(200);
        client.doDeposit(10);

        Client client2 = new Client("🙍️Edward");
        client2.bankOperations();
        client2.doDeposit(1000);
        client2.doDeposit(200);
        client2.doDebit(200);
        client2.doDeposit(0);

        Client client1 = new Client("🙎️Maria");
        client1.bankOperations();
        client1.doDeposit(1000);
        client1.doDeposit(200);
        client1.doDebit(200);
        client1.doDeposit(0);

    }
}

