/*
 * Class name: Book
 * Author: Jakob Yearous & Christopher Hopper
 * Date: 1/29/2024
 * Problem: Create  bookstore management system
 * Goals:
 *      - Store data on various book-related things: ISBN, book title, author(s), year, price, publisher, etc. 
 *      - Allow the user to retrieve said data
 *      - Allow the user to change and add data
 *      - Allow the user to convert price to other currencies
 * Inputs:
 *      - book data
 *      - 
 * Outputs:
 *      - data
 *      - price
 * Required packages: java.ArrayList
 * Test cases:
 *      - 
 *      - 
 * Pseudo code:
 *     Step 1: ...
 *     Step 2: ...
 *     Step 3: ... 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier; 

public class Book {
	List<String> authorsList = new ArrayList<String>();
	public List<String> currencyList = new ArrayList<String>();
	public List conversionList = new ArrayList();
	private String ISBN;
	private String title;
	private int numOfAuthors;
	private List<String> authors;
//	private String author1;
//	private String author2;
//	private String author3;
	private int yearPublished;
	private double priceUSD;
	private String publisher;
	private int stock;
	private float usdJnyConversion;
	private float usdEurConversion;
	
//	public Book(int isbnA, String titleA, int nAuthors, List authorsA, int yearA, String publisherA, double priceA, String currencyA, int stockA) 
//	{
//		ISBN = isbnA;
//		title = titleA;
//		numOfAuthors = nAuthors;
//		authors = authorsA;
//		yearPublished = yearA;
//		publisher = publisherA;
//		String currencyClean = currencyA.toUpperCase();
//		if (currencyClean.equals("USD"))
//		{
//			priceUSD = priceA;
//		}
//		else if (currencyClean.equals("JNY"))
//		{
//			priceUSD = priceA*usdJnyConversion;
//		}
//		else if (currencyClean.equals("EUR"))
//		{
//			priceUSD = priceUSD*usdEurConversion;
//		}
//		else
//		{
//			System.out.println("The currency you selected is not valid, please input a supported currency (USD, JNY, EUR");
//		}
//		stock = stockA;
//		
	//}
	public Book(String isbnA, String titleA)
	{
		ISBN = isbnA;
		title = titleA;
	}
	public void setISBN(String isbnA)
	{
		ISBN = isbnA;
	}
	public void setTitle(String titleA)
	{
		title = titleA;
	}
	public void setAuthors(List<String> authorsA)
	{
		authors = authorsA;
	}
	public void modifyAuthors(String action, String name)
	{
		String actionClean = action.toUpperCase();
		if (actionClean.equals("ADD"))
		{
			authors.add(name.toString());
		}
		else if (actionClean.equals("REMOVE"))
		{
			authors.remove(authors.indexOf(name));
		}
		else if (actionClean.equals("CLEAR"))
		{
			authors.clear();
		}
		else {} // return error message
	}
	public void setPublicationYear(int yearA)
	{
		yearPublished = yearA;
	}
	public void setPublisher(String publisherA)
	{
		publisher = publisherA;
	}
	public void setStock(int stockA)
	{
		stock = stockA;
	}
	public void changeStock(String action, int num)
	{
		String actionClean = action.toUpperCase();
		if (actionClean.equals("ADD"))
		{
			stock = stock + num;
		}
		else if (actionClean.equals("SUBTRACT") || actionClean.equals("REMOVE"))
		{
			stock = stock - num;
		}
		else if (actionClean.equals("CLEAR"))
		{
			stock = 0;
		}
		else {} // return error
	}
	public String getISBN()
	{
		return ISBN;
	}
	public String getTitle()
	{
		return title;
	}
	public String getAuthor()
	{
		return authors.toString();
	}
	public int getYear()
	{
		return yearPublished;
	}
	public String getPublisher()
	{
		return publisher;
	}
	public double getPrice(int index)
	{
		return priceUSD*(double)conversionList.get(index);
	}
	public int getStock()
	{
		return stock;
	}
	public List<String> getCurrencyList()
	{
		return currencyList;
	}
	public void setPrice(int index, double xPrice)
	{
		priceUSD = xPrice*(double)conversionList.get(index);
	}
	public String getData()
	{
		
		String toReturn = "Title: " + title
				+ "\r\nISBN: " + ISBN
				+ "\r\nAuthor[s]: " + authors.toString()
				+ "\r\nPublication Year: " + yearPublished
				+ "\r\nPublisher: " + publisher
				+ "\r\nStock: " + stock
				+ "\r\nPrice(USD): " + priceUSD
				+ "\r\nPrice(JNY): " + priceUSD/usdJnyConversion
				+ "\r\nPrice(EUR): " + priceUSD/usdEurConversion;
		return toReturn;
	}
}
