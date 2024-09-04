package example.br;

import example.br.models.BankAccount;
import example.br.models.Client;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        // Creating the clients
        Thread client1 = new Thread(new Client(account, 100), "Client 1");
        Thread client2 = new Thread(new Client(account, 150), "Client 2");
        Thread client3 = new Thread(new Client(account, 200), "Client 3");

        // Starting the clients
        client1.start();
        client2.start();
        client3.start();

        // Waiting for the clients to finish
        try {
            client1.join();
            client2.join();
            client3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Retrieving the final balance
        System.out.println("Final balance: " + account.getBalance());
    }
}