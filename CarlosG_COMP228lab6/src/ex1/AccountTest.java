package ex1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(100.0); 
        ArrayList<Transaction> transactions = new ArrayList<>();

        
        transactions.add(new Transaction(account, true, 200.0)); 
        transactions.add(new Transaction(account, false, 150.0)); 
        transactions.add(new Transaction(account, true, 300.0)); 
        transactions.add(new Transaction(account, false, 500.0)); 
        transactions.add(new Transaction(account, false, 100.0)); 
        transactions.add(new Transaction(account, false, 500.0)); 

        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (Transaction transaction : transactions) {
            executor.execute(transaction);
        }

        
        executor.shutdown();
        while (!executor.isTerminated()) {
            
        }

        
        System.out.printf("Final Balance: %s%n", account.getBalance());
    }
}
