

import java.awt.FlowLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class BookUserGUI extends JFrame implements ActionListener
{
	private String currencyList[] = {"USD", "JNY", "EUR"};
	// GUI Elements for search box
	private JLabel lblSearch;
	private JTextField txtSearch;
	private JButton btnExit;
	private JButton btnSearch;
	//GUI Elements for infoMain section 1
	private JLabel lblTitle;
	private JTextField txtTitle;
	private JLabel lblISBN;
	private JTextField txtISBN;
	private JLabel lblYear;
	private JTextField txtYear;
	private JLabel lblPublisher;
	private JTextField txtPublisher;
	private JButton btnEditInfo;
	private JSeparator sep1;
	// GUI Elements for infoMain section 2
	private JLabel lblAuthor;
	private JTextArea txtAuthor;
	private JLabel lblAuthorEdit;
	private JButton btnAddAuthor;
	private JButton btnRemoveAuthor;
	private JButton btnClearAuthor;
	private JSeparator sep2;
	// GUI Elements for infoMain section 3
	private JLabel lblPrice;
	private JTextField txtPrice;
	private JButton btnEditPrice;
	private JLabel lblConvert;
	private JComboBox<String> pnlCurrency;
	private JButton btnConvert;
	private JSeparator sep3;
	// GUI Elements for infoMain section 4
	private JLabel lblStock;
	private JTextField txtStock;
	private JTextField txtChangeStock;
	private JButton btnAddStock;
	private JButton btnRemoveStock;
	// GUI Elements for infoMain bottom section
	private JButton btnBack;
	private JButton btnSave;
	// GUI Elements for Add author screen
	private JLabel lblAuthorAdd;
	private JTextField txtAddAuthor;
	private JButton btnAuthorCancel;
	private JButton btnAuthorAdd;
	
	
	
	
	public void searchBox() {
		setTitle("H&Y Bookstore Management System");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200,150);
		setLayout(new FlowLayout());
		
		lblSearch = new JLabel("Search: ");
		txtSearch = new JTextField("Enter Title or ISBN             ");
		btnExit = new JButton("Exit");
		btnSearch = new JButton("Search");
		btnExit.addActionListener(this);
		btnSearch.addActionListener(this);
		txtSearch.setEditable(true);
		
		add(lblSearch);
		add(txtSearch);
		add(btnExit);
		add(btnSearch);
		
		setVisible(true);
	}
	public void infoMain(Book id)
	{
		new JFrame("infoMain");
		setTitle("H&Y Bookstore Management System");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000,1000);
		setLayout(new FlowLayout());
		// Section 1
		lblTitle = new JLabel("Title: ");
		txtTitle = new JTextField(30);
		txtTitle.setText(id.getTitle());
		txtTitle.setEditable(false);
		lblISBN = new JLabel("ISBN: ");
		txtISBN = new JTextField(14);
		txtISBN.setText(id.getISBN());
		txtISBN.setEditable(false);
		lblYear = new JLabel("Publication Year: ");
		txtYear = new JTextField(4);
		txtYear.setText(Integer.toString(id.getYear()));
		txtYear.setEditable(false);
		lblPublisher = new JLabel("Publisher: ");
		txtPublisher = new JTextField(20);
		txtPublisher.setText(id.getPublisher());
		txtPublisher.setEditable(false);
		btnEditInfo = new JButton("Edit");
		btnEditInfo.addActionListener(this);
		sep1 = new JSeparator();
		// section 2
		lblAuthor = new JLabel("Authors: ");
		txtAuthor = new JTextArea(10,4);
		txtAuthor.setText(id.getAuthor());
		txtAuthor.setEditable(false);
		lblAuthorEdit = new JLabel("Change Author[s]");
		btnAddAuthor = new JButton("Add");
		btnAddAuthor.addActionListener(this);
		btnRemoveAuthor = new JButton("Remove");
		btnRemoveAuthor.addActionListener(this);
		btnClearAuthor = new JButton("Clear");
		btnClearAuthor.addActionListener(this);
		sep2 = new JSeparator();
		// section 3
		lblPrice = new JLabel("Price: ");
		txtPrice = new JTextField(5);
		txtPrice.setText(Double.toString(id.getPrice("USD")));
		btnEditPrice = new JButton("Edit");
		btnEditPrice.addActionListener(this);
		lblConvert = new JLabel("Convert to: ");
		pnlCurrency = new JComboBox<String>(currencyList);
		btnConvert = new JButton("Convert");
		sep3 = new JSeparator();
		// section 4
		lblStock = new JLabel("Stock");
		txtStock = new JTextField(5);
		txtStock.setText(Integer.toString(id.getStock()));
		btnAddStock = new JButton("Add");
		btnRemoveStock = new JButton("Remove");
		// bottom section
		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		btnSave = new JButton("Save");
		btnSave.addActionListener(this);
		btnExit = new JButton("Exit");
		btnExit.addActionListener(this);
		
		// add all components
		add(lblTitle);
		add(txtTitle);
		add(lblISBN);
		add(txtISBN);
		add(lblYear);
		add(txtYear);
		add(lblPublisher);
		add(txtPublisher);
		add(btnEditInfo);
		add(sep1);
		add(lblAuthor);
		add(txtAuthor);
		add(btnAddAuthor);
		add(btnRemoveAuthor);
		add(btnClearAuthor);
		add(sep2);
		add(lblPrice);
		add(txtPrice);
		add(btnEditPrice);
		add(lblConvert);
		add(pnlCurrency);
		add(btnConvert);
		add(sep3);
		add(lblStock);
		add(txtStock);
		add(btnAddStock);
		add(btnRemoveStock);
		add(btnBack);
		add(btnSave);
		add(btnExit);
		
		
		setVisible(true);
		
	}
	public void addAuthorGUI()
	{
//		new JFrame("addAuthorGUI");
		setTitle("H&Y Bookstore Management System");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		setLayout(new FlowLayout());
		lblAuthorAdd = new JLabel("Add a new Author: ");
		txtAddAuthor = new JTextField("e.g. John Doe");
		txtAddAuthor.setEditable(true);
		btnAuthorCancel = new JButton("Cancel");
		btnAuthorCancel.addActionListener(this);
		btnAuthorAdd = new JButton("Add");
		btnAuthorAdd.addActionListener(this);
		
		add(lblAuthorAdd);
		add(txtAddAuthor);
		add(btnAuthorCancel);
		add(btnAuthorAdd);
		
		setVisible(true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		BookUserGUI app = new BookUserGUI();
		if (e.getSource() == btnExit) 
		{
			setVisible(false);
			dispose();
		}
		else if (e.getSource() == btnSearch) {
			/*
			 * Search file
			 * app.infoMain(bookID)
			 */
		}
		else if (e.getSource() == btnEditInfo) {
			txtTitle.setEditable(true);
			txtISBN.setEditable(true);
			txtPublisher.setEditable(true);
			txtYear.setEditable(true);
			
		}
		else if (e.getSource() == btnAddAuthor)
		{
			// open new window to enter name
		}
		else if (e.getSource() == btnRemoveAuthor)
		{
			// open new window to choose from dropdown
		}
		else if (e.getSource() == btnClearAuthor)
		{
			// id.clearAuthor();
		}
		else if (e.getSource() == btnEditPrice)
		{
			// open edit price screen w/ number and currency
		}
		else if (e.getSource() == btnConvert)
		{
			// convert the price using Book.convert() and currency from pnlCurrency
		}
		else if (e.getSource() == btnAddStock)
		{
			// open add stock window
		}
		else if (e.getSource() == btnAuthorCancel)
		{
			
		}
		
		
	}
	public static void main(String args[])
	{
		BookUserGUI app = new BookUserGUI();
		app.searchBox();
		app.setVisible(false);
		Book book1 = new Book("Title", "123232232");
		ArrayList<String> authorExample = new ArrayList<String>();
		authorExample.add("Author1");
		book1.setAuthors(authorExample);
		app.infoMain(book1);

	}
}
