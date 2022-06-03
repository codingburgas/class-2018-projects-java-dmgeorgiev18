package controllers;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import repositories.UserRepository;

/*
    Layer #1: Data Presentation
*/
public class UserController {

	public void optionMenu() throws SQLException {
		UserRepository dataBase = new UserRepository();

		Scanner x = new Scanner(System.in);

		while (true) {
			System.out.println("\r\nWelcome!");
			System.out.println("1. Customers");
			System.out.println("9. Exit");
			System.out.print("Enter your choice: ");

			try {
				int choice = Integer.parseInt(x.nextLine());
				switch (choice) {
				case 1:
					subMenu(dataBase, x);
					break;
				case 9:
					System.exit(0);
					break;
				default:
					System.out.println("Wrong input! Please enter valid value\r\n");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Enter a numerical value!");
				x.nextLine();
			}
		}
	}

	void subMenu(UserRepository database, Scanner x) throws SQLException {

		while (true) {
			System.out.println("\r\nShow info menu");
			System.out.println("1. Show user's details");
			System.out.println("2. Update user's details");
			System.out.println("9. Return to main menu");
			System.out.print("Enter your choice: ");

			try {
				int choice = Integer.parseInt(x.nextLine());
				switch (choice) {
			
				case 1:
					database.GetUser();

					System.out.print("First Name -> ");
					String firstName = x.nextLine();
					System.out.print("Last Name -> ");
					String lastName = x.nextLine();
					System.out.print("Email -> ");
					String email = x.nextLine();
					System.out.print("Username -> ");
					String username = x.nextLine();
					System.out.print("Password -> ");
					String password = x.nextLine();
					System.out.print("Parking ID -> ");
					int parkingId = Integer.parseInt(x.nextLine());
					database.updateUser(firstName, lastName,email,username,password,parkingId);
				case 2:
					System.out.print("First Name -> ");
					String firstName1 = x.nextLine();
					System.out.print("Last Name -> ");
					String lastName1 = x.nextLine();
					System.out.print("Email -> ");
					String email1 = x.nextLine();
					System.out.print("Username -> ");
					String username1 = x.nextLine();
					System.out.print("Password -> ");
					String password1 = x.nextLine();
					System.out.print("Parking ID -> ");
					int parkingId1 = Integer.parseInt(x.nextLine());
					 database.InsertUser( firstName1 ,lastName1, email1, username1, password1, parkingId1);
					break;
				case 9:
					return;

				default:
					System.out.println("Wrong input! Please enter valid value\r\n");
					break;
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Enter a numerical value!");
				x.nextLine();
			}
		}
	}

}