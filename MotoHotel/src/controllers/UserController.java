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
	 private boolean isAdmin = true;
	 UserData user=new UserData();
	public UserController() throws SQLException {
		this.setUserRepository(new UserRepository());
		}
	
	public void optionMenu() throws SQLException {


		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\r\nWelcome!");
			System.out.println("1. Users Register");
			System.out.println("2. Admin Login");
			System.out.println("9. Exit");
			System.out.print("Enter your choice: ");

			try {
				int choice = Integer.parseInt(scanner.nextLine());
				switch (choice) {
				case 1:
					user.insertUser();
					break;
				case 2:
					user.AdminMenuCheck();
					
					break;
				case 9:
					System.out.println("Goodbye!");
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


	void UserMenu(UserRepository userRepository, Scanner scanner) throws SQLException {
		UserData user=new UserData();
		while(true)
		{
			
		}
		
	}

	void AdminMenu(UserRepository database, Scanner scanner) throws SQLException {
		UserData user=new UserData();
	
		while (isAdmin == true) {
			System.out.println("\r\nShow info menu");
			System.out.println("1. Show all users and their details");
			System.out.println("2. Register user");
			System.out.println("3. Delete user");
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
					user.deleteUser();
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