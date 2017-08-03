/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5192.ass.gui;

import fit5192.ass.repository.entities.Book;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author zx
 */
public class TableGUIImpl extends JFrame implements LibraryCatalogueSystemGUI{
    private static final String[] TABLE_COLUMNS = {"Title","Authors","Call_Number"};
    private static final String TAG_SEPARATOR = ",";
    
    private final JButton closeButton;
    //private final JButton addButton;
    //private final JButton viewButton;
    private final JButton searchButton;
    //private final JButton updateButton;
    //private final JButton deleteButton;
    
    private final JPanel inputPanel;
    private final JPanel buttonPanel;
    private final JPanel detailsPanel;

    //private final JLabel bidLabel;
    //private final JLabel isbnLabel;
    private final JLabel titleLabel;
    private final JLabel authorsLabel;
    private final JLabel callnumberLabel;
    //private final JLabel publisherLabel;
    private final JLabel typeLabel;
    //private final JLabel thumbnailLabel;
    //private final JLabel descriptionLabel;
    //private final JLabel previewurlLabel;
    
    //private final JTextField bidTextField;
    //private final JTextField isbnTextField;
    private final JTextField titleTextField;
    private final JTextField authorsTextField;
    private final JTextField callnumberTextField;
    private final JTextField detailsTextField;
    //private final JTextField typeTextField;
    //private final JTextField publisherTextField;
    //private final JTextField thumbnailTextField;
    //private final JTextField descriptionTextField;
    //private final JTextField previewurlTextField;
    
    private final JTable bookTable;
    
    private final JComboBox typeComboBox;

    Book book;
    
    public TableGUIImpl(ActionListener actionListener, ListSelectionListener listSelectionListener){
         super("Library Catalogue System");
    
         // create buttons
        this.closeButton = new JButton("Close");
        this.searchButton = new JButton("Search");
        

        // create container
        Container container = this.getContentPane();
        
         // create labels
        this.titleLabel = new JLabel("Book Title:");
        this.authorsLabel = new JLabel("Book Author(s):");
        this.callnumberLabel = new JLabel("Book Call Number:");
        this.typeLabel = new JLabel("Book Type:");
        
        // create text fields
        this.titleTextField = new JTextField();
        this.authorsTextField = new JTextField();
        this.callnumberTextField = new JTextField();
        this.detailsTextField = new JTextField(10);
       // this.typeTextField = new JTextField();
        
        // create table
        this.bookTable = new JTable(new DefaultTableModel(TABLE_COLUMNS, 0));
        this.bookTable.getSelectionModel().addListSelectionListener(listSelectionListener);       
        this.bookTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        TableColumnModel bookTableColumnModel = this.bookTable.getColumnModel();
        bookTableColumnModel.getColumn(0).setPreferredWidth(200);
        bookTableColumnModel.getColumn(1).setPreferredWidth(270);
        bookTableColumnModel.getColumn(2).setPreferredWidth(250);
        
        //create combobox
        
        this.typeComboBox = new JComboBox(new String[]{" ","General", "Reserve","a","bb"});
        
        // create panels
        this.inputPanel = new JPanel();
        this.buttonPanel = new JPanel();
        this.detailsPanel = new JPanel();
        
        // set layout manager
        container.setLayout(new BorderLayout());
        this.inputPanel.setLayout(new GridLayout(4,2));
        this.buttonPanel.setLayout(new GridLayout(1,2));
        this.detailsPanel.setLayout(new GridLayout(5,1));
        
        // add action listeners
        this.closeButton.addActionListener(actionListener);
        this.searchButton.addActionListener(actionListener);
        
        // add components
        this.inputPanel.add(titleLabel);
        this.inputPanel.add(titleTextField);
        this.inputPanel.add(authorsLabel);
        this.inputPanel.add(authorsTextField);
        this.inputPanel.add(callnumberLabel);
        this.inputPanel.add(callnumberTextField);
        this.inputPanel.add(typeLabel);
        this.inputPanel.add(typeComboBox);
       // this.inputPanel.add(typeTextField);
        
        // add buttons to panel
        this.buttonPanel.add(this.searchButton);
        this.buttonPanel.add(this.closeButton);
        
        //detailstextField to detailsPanel
        this.detailsPanel.add(detailsTextField);
        
        
        
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        // add panels to content pane
        container.add(this.inputPanel);
        container.add(new JScrollPane(this.bookTable));
        container.add(this.detailsPanel);
        container.add(this.buttonPanel);
        
        
        
        
        // change the default behaviour of the close button
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setSize(750, 570);       
        this.setVisible(true);
    }
    
    @Override
    public void clearInput() {
        this.clearTextFields();
        this.clearComboBoxes();
    }

    @Override
    public void clearTextFields() {
        this.titleTextField.setText("");
        this.authorsTextField.setText("");
        this.callnumberTextField.setText("");
        
       // this.typeTextField.setText("");
    }

    @Override
    public void clearComboBoxes() {
         if (this.typeComboBox.getItemCount() > 0) {
            this.typeComboBox.setSelectedIndex(0);
        } 
    }

    @Override
    public void clearBookTable() {
        int numberOfRow = this.bookTable.getModel().getRowCount();
        
        if (numberOfRow > 0) {
            DefaultTableModel tableModel = (DefaultTableModel) this.bookTable.getModel();
            for (int index = (numberOfRow - 1); index >= 0; index --) {
                tableModel.removeRow(index);
            }            
        }
    }

    @Override
    public void displayMessageInDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void displayBookDetails(Book book) {
        this.clearBookTable();
        this.clearInput();
        
        ((DefaultTableModel)this.bookTable.getModel()).addRow(new Object[]{book.getAuthors(),
                                                                               book.getTitle(),
                                                                               book.getCallnumber(),
                                                                               });
    }

    @Override
    public void displaySelectedBookDetails(Book book) {
        this.titleTextField.setText(String.valueOf(book.getTitle()));           
        this.authorsTextField.setText(String.valueOf(book.getAuthors())); 
        this.callnumberTextField.setText(String.valueOf(book.getCallnumber()));
        this.typeComboBox.getSelectedItem(); 
        //this.typeTextField.setText(String.valueOf(book.getType())); 
    }

    @Override
    public void displayBookDetails(List<Book> books) {
        this.clearBookTable();
        this.clearInput();
        
        for (Book book : books) {
            ((DefaultTableModel)this.bookTable.getModel()).addRow(new Object[]{book.getAuthors(),
                                                                               book.getTitle(),
                                                                               book.getCallnumber(),
                                                                               });
        }
    }

    @Override
    public void displayBookDetails(Set<Book> books) {
        this.clearBookTable();
        this.clearInput();
        
        for (Book book : books) {
            ((DefaultTableModel)this.bookTable.getModel()).addRow(new Object[]{book.getAuthors(),
                                                                               book.getTitle(),
                                                                               book.getCallnumber(),
                                                                               });
        }
    }

   

    

    @Override
    public JButton getCloseButton() {
        return closeButton;
    }

    @Override
    public JButton getSearchButton() {
        return searchButton;
    }

    @Override
    public JTable getBookTable() {
        return bookTable;
    }

    @Override
    public Book getBookDetails() {
        return new Book(this.titleTextField.getText(), 
                        this.authorsTextField.getText(), 
                        this.callnumberTextField.getText(), (String) this.typeComboBox.getSelectedItem());
    }

    @Override
    public String getBookTitle(){
    String title = this.titleTextField.getText();
    return title == null || title.isEmpty()? null:title;
    }

    @Override
    public String getBookAuthors(){
    String authors = this.authorsTextField.getText();
    return authors == null || authors.isEmpty()? null:authors;
    }
    
    @Override
    public String getBookCallnumber(){
    String callnumber = this.callnumberTextField.getText();
    return callnumber == null || callnumber.isEmpty()? null:callnumber;
    }
    
    @Override
    public String getBookType(){
    String type =this.typeComboBox.getSelectedItem().toString();
    return type == null || type.isEmpty()? null:type;
    }
    
    
    @Override
    public boolean isBookSelected() {
        return (this.bookTable.getSelectedRow() >= 0);
    }
   /*
       public static void main(String args[]) {

       // Create and display the form 
      java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               NewClass n = new NewClass();
                new TableGUIImpl(n,n).setVisible(true);
            }
        });
    } 
*/

}
