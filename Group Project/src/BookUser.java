/*
 * 
 * BookUser
-	Book1: Book
+ getBasicData(): List
+ printBookData()
+ main()

 */

import java.util.List;
import java.util.Scanner;

public class BookUser {

	public static void main(String args[])
	{
		Book book1 = new Book("Coding for Dummies", "George Lucas");
		Scanner in = new Scanner(System.in);
		int action = 0;
		while (action != 6)
		{
			System.out.println("What would you like to do? "
					+ "\r\n[1] change book information, [2] Print specific book information, [3] Print all book information, [4] Change stock, [5] Get/set Price, [6] Exit");
			action = in.nextInt();
			if (action == 1)
			{
				int actionChange = 0;
				while (actionChange != 6)
				{
					System.out.println("What would you like to change? "
							+ "\r\n[1] Title, [2] ISBN, [3] Year, [4] Author, [5] Publisher, [6] Go Back");
					actionChange = in.nextInt();
					{
						if (actionChange == 1)
						{
							System.out.println("The current title is: " + book1.getTitle()
							+ "\r\nPlease enter the new title: ");
							String newTitle = in.nextLine();
							book1.setTitle(newTitle);
							System.out.println("The new title is: " + book1.getTitle());
						}
						else if (actionChange == 2)
						{
							System.out.println("The current ISBN is:" + book1.getISBN()
							+ "\r\nPlease enter the new ISBN: ");
							book1.setISBN(in.next());
							System.out.println("The new ISBN is:" + book1.getISBN());
						}
						else if (actionChange == 3)
						{
							System.out.println("The current pubication year is " + book1.getYear()
							+ "\r\nPlease enter the new publication year");
							book1.setPublicationYear(in.nextInt());
							System.out.println("The new publication year is " + book1.getYear());
						}
						else if (actionChange == 4)
						{
							int actionAuthor = 0;
							while (actionAuthor != 4)
							{
								System.out.println("What would you like to change?" 
										+ "\r\n[1] Add author, [2] Remove Author, [3] Clear authors, [4] Go back");
								if (actionAuthor == 1)
								{
									System.out.println("The current author[s] are " + book1.getAuthor()
									+ "\r\nPlease enter the new author: ");
									book1.modifyAuthors("Add", in.next());
									System.out.println("The new list of author[s] are: " + book1.getAuthor());
								}
								else if (actionAuthor == 2)
								{
									System.out.println("The current author[s] are " + book1.getAuthor()
									+ "\r\nPlease enter the location (1,2,...) of the author to remove.");
									book1.modifyAuthors("remove", in.next());
									System.out.println("The new list of author[s] is: " + book1.getAuthor());
									
								}
								else if (actionAuthor == 3)
								{
									book1.modifyAuthors("clear", null);
									System.out.println("Authors have been cleared");
				
								}
							}
						}
						else if (actionChange == 5)
						{
							System.out.println("The current publisher is " + book1.getPublisher() + ". " 
									+ " \r\nWhat would you like the new publisher to be?");
							book1.setPublisher(in.next());
							System.out.println("The new publisher is " + book1.getPublisher());
						}
					}
				}
			}
			else if (action == 2)
			{
				int actionPrint = 0;
				while (actionPrint != 6)
				{
					System.out.println("What information would you like to print?"
							+ "\r\n[1] Title, [2] ISBN, [3] Publication Year, [4], Author(s), [5] Publisher, [6] Go back");
					actionPrint = in.nextInt();
					if (actionPrint == 1)
					{
						System.out.println("The title is " + book1.getTitle());
					}
					else if (actionPrint == 2)
					{
						System.out.println("The ISBN is " + book1.getISBN());
					}
					else if (actionPrint == 3)
					{
						System.out.println("The publication year is " + book1.getYear());	
					}
					else if (actionPrint == 4)
					{
						System.out.println("The author(s) is/are: " + book1.getAuthor());
					}
					else 
					{
						System.out.println("The publisher is " + book1.getPublisher());
					}
				}
			}
			else if (action == 3)
			{
				System.out.println("Title: " + book1.getTitle() + "         ISBN: " + book1.getISBN()
				+ "\r\nAuthor(s): " + book1.getAuthor() 
				+ "\r\nPublisher: " + book1.getPublisher() + "          Year: " + book1.getYear()
				+ "\r\nPrice (USD): " + book1.getPrice(1)
				+ "\r\nStock: " + book1.getStock());
			}
			else if (action == 4)
			{
				
				int actionStock = 0;
				while (actionStock < 4)
				{
					System.out.println("The current stock is " + book1.getStock() + " of " + book1.getTitle() +". "
							+ "\r\nWhat would you like to change?"
							+ "\r\n[1] add, [2] remove, [3] clear, [4] go back");
					actionStock = in.nextInt();
					if (actionStock == 1)
					{
						System.out.println("The current stock of " + book1.getTitle() + " is " + book1.getStock()
						+ "\r\nHow many would you like to add? ");
						book1.changeStock("add", in.nextInt());
						System.out.println("The new stock is " + book1.getStock() + ". ");
						
					}
					else if (actionStock == 2)
					{
						System.out.println("The current stock of " + book1.getTitle() + " is " + book1.getStock()
						+ "\r\nHow many would you like to remove? ");
						book1.changeStock("remove", in.nextInt());
						System.out.println("The new stock is "+ book1.getStock() + ". ");
					}
					else 
					{
						book1.changeStock("clear", 1);
						System.out.println("Stock successfully cleared. ");
					}
				}
			}
			else if (action == 5)
			{
				int actionPrice = 0;
				while (actionPrice < 3)
				{
					System.out.println("What would you like to do? "
							+ "[1] Get price, [2] set price, [3] go back");
					actionPrice = in.nextInt();
					if (actionPrice == 1)
					{
						int ActionGetPrice = 0;
						while (ActionGetPrice < book1.getCurrencyList().size() + 1);
						{
							System.out.println("What currency would you like the price in?");
							for (int i = 1; i < book1.getCurrencyList().size(); i++)
							{
								System.out.print("[" + i + "] " +  book1.getCurrencyList().get(i-1) + ", ");
							}
							int actionWhatCurrency = in.nextInt();
							System.out.println("Price ("+ book1.getCurrencyList().get(actionWhatCurrency-1) + ") =" + book1.getPrice(actionWhatCurrency));
						}
					}
					else if (actionPrice == 2)
					{
						int actionSetPrice = 0;
						while (actionSetPrice < book1.getCurrencyList().size() + 1)
						{
							System.out.print("Please enter the currency you will enter the price in: ");
							String currencyGet = in.next().toUpperCase();
							if (book1.getCurrencyList().contains(currencyGet))
							{
								int setCurrencyNum = book1.getCurrencyList().indexOf(currencyGet);
								System.out.println("Please enter the new price in " + currencyGet + ". ");
								book1.setPrice(setCurrencyNum, in.nextDouble());
								System.out.println("The new price is " + book1.getPrice(setCurrencyNum));
							}
							else System.out.println("The currency you entered is not supported by this program. Please enter a supported currency from the list below."
									+ "\r\n" + book1.getCurrencyList().toString() + "[" + (book1.getCurrencyList().size() + 1) +"] go back. ");
						}
					}
				}
			}
		}
		System.out.println("Exited");
	}
	
}
