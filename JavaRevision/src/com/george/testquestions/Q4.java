package com.george.testquestions;
import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the bottom end of range");
		int bottomEnd = sc.nextInt();
		System.out.println("Enter the Top End of Range");
		int topEnd = sc.nextInt();
		boolean done = false;
		int choice = -1;
		int inRange = 0;
		int outRange = 0;
		while (choice != 0) {
			System.out.println("Enter Number");
			choice = sc.nextInt();
			if (choice >= bottomEnd && choice <= topEnd) {
				inRange += choice;
			}
			else {
				outRange += choice;
			}
		}
		System.out.println("Sum of In Range Values: " + inRange);
		System.out.println("Sum of Out Range Values: " + outRange);
	}
}