package example.br.models;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private double balance;
    private final Lock lock = new ReentrantLock(); // Para o exemplo com ReentrantLock

    // Método para depósito com synchronized
    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited: " + amount);
    }

    // Método para saque com synchronized
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw but insufficient funds.");
        }
    }

    // Consulta de saldo
    public synchronized double getBalance() {
        return balance;
    }

    // Exemplo com ReentrantLock para um controle mais granular
    public void depositWithLock(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited (with lock): " + amount);
        } finally {
            lock.unlock();
        }
    }

    public void withdrawWithLock(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrew (with lock): " + amount);
            } else {
                System.out.println(Thread.currentThread().getName() + " tried to withdraw (with lock) but insufficient funds.");
            }
        } finally {
            lock.unlock();
        }
    }
}
