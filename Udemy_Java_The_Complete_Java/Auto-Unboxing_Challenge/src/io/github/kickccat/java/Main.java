package io.github.kickccat.java;

import io.github.kickccat.java.domain.Bank;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("Deutsche Bank");
        bank.addBranch("Berlin");
        bank.addCustomer("Berlin", "Tom", 90.2);
        bank.addCustomer("Berlin", "John", 45.2);
        bank.addCustomer("Berlin", "Alice", 12.5);

        bank.addBranch("München");
        bank.addCustomer("München", "Bob", 39.2);
        bank.addCustomer("München", "Xiaoming", 69.2);
        bank.addCustomer("München", "Xiaohong", 97.1);

        bank.listCustomers("Berlin", true);
        bank.listCustomers("München", true);

        if (!bank.addCustomer("Frankfurt", "Brian", 34.1)) {
            System.out.println("Error Frankfurt branch does not exist");
        }

        if (!bank.addBranch("Berlin")) {
            System.out.println("Berlin branch already exists");
        }

        if (!bank.addCustomerTransaction("Berlin", "Xiaogou", 11.1)) {
            System.out.println("Customer does not exists at branch");
        }

        if (!bank.addCustomer("München", "Bob", 39.2)) {
            System.out.println("Customer already exists");
        }
    }
}
