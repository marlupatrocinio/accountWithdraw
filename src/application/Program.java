package application;

import java.util.Locale;
import java.util.Scanner;

import model.account.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		try{
			System.out.println("Enter account data");
			System.out.println("Number:");
			int number = sc.nextInt();
			System.out.println("Holder:");
			String holder = sc.next();
			sc.next();
			System.out.println("Initial balance:");
			double balance = sc.nextDouble();
			System.out.println("Withdraw limit:");
			double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println();
			System.out.println("Enter the amount for withdraw:");
			double amount = sc.nextInt();
			account.withdraw(amount);
			System.out.println("New balance: " + account.getBalance());
		}
		catch(DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		sc.close();
	}

}
