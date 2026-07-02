package Oop.ChatGPT.Fundamentals;

class Bank {

    String accountHolder;
    double balance;

    public Bank () {}
    public Bank (String accountHolder) {this.accountHolder = accountHolder;}
    public Bank (String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double deposit(double amount) {
        return this.balance += amount;
    }

}

public class Main {

    public static void main(String[] args) {

        Bank holder1 = new Bank("MohanMad", 500);
        Bank holder2 = holder1;
        holder2.accountHolder = "Anil Jonathan";

        System.out.println("Account Holder Name: " + holder1.accountHolder);
        System.out.println("Balance: " + holder1.deposit(15000));

    }

}
