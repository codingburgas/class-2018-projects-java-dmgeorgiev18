package controllers;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import repositories.UserRepository;

/*
    Layer #1: Data Presentation
*/
public class UserController {
	private UserRepository userRepository;
	public UserController() throws SQLException {
		this.setUserRepository(new UserRepository());
		}
	
	public void optionMenu() throws SQLException {


		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\r\nWelcome!");
			System.out.println("1. Users");
			System.out.println("9. Exit");
			System.out.print("Enter your choice: ");

			try {
				int choice = Integer.parseInt(scanner.nextLine());
				switch (choice) {
				case 1:
					subMenu(userRepository, scanner);
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
				scanner.nextLine();
			}
		}
	}

	void subMenu(UserRepository database, Scanner scanner) throws SQLException {
		UserData user=new UserData();
	
		while (true) {
			System.out.println("\r\nShow info menu");
			System.out.println("1. Show user's details");
			System.out.println("2. Register user");
			System.out.println("3. Update user's user");
			System.out.println("9. Return to main menu");
			System.out.print("Enter your choice: ");

			try {
				int choice = Integer.parseInt(scanner.nextLine());
				switch (choice) {
			
				case 1:
					database.ShowUsers();
					break;
				case 2:
					user.insertUser();
					break;
				case 3:
					//user.updateUserInfo();
				case 9:
					return;
				default:
					System.out.println("Wrong input! Please enter valid value\r\n");
					break;
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Enter a numerical value!");
				scanner.nextLine();
			}
		}
	}
	public UserRepository getUserRepository() {
		return userRepository;
	}
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}