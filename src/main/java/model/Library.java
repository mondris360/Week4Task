package model;
import util.HelperClass;

import javax.xml.catalog.Catalog;
import java.util.*;

public class Library {
    private String libraryName;
    // Association relationship
    private Address libraryAddress;
    //generic
    private static  Map<String, Book> books = new HashMap<>();
    private static Queue <LibraryUser> usersQueue =  new LinkedList();

    public Library(String libraryName, Address libraryAddress) {
        this.libraryName = libraryName;
        this.libraryAddress = libraryAddress;
    }


    // method to add a library user to the queue
     public static void addUserToQueue(LibraryUser user){
        usersQueue.add(user);
        System.out.println("User Added To The Queue");
    }

    // return all the books in the library
    public static Map<String, Book> getBooks() {
        return books;
    }

    // method to add a new book to the library
    public static  boolean setBooks(Book newBook) throws Exception{
        if (newBook == null){
            throw new IllegalArgumentException("Invalid Input");
        }
        // check if a book with that same name already exists
        Book findBook = bookAlreadyExists(books, newBook.getName());
        // if book already exist
        if (findBook != null){
            // increase the quantity by one
            findBook.incrementBookQtyByOne();
        } else {
            // add the book to the book collection of the library
            books.put(newBook.getName(), newBook);
            System.out.println("Book Added");
        }
        return true;
    }

    // check if the book already exists
    private  static Book bookAlreadyExists(Map<String, Book> books, String newBookTitle){
        for(Book book: books.values()){
            if (book.getName().equalsIgnoreCase(newBookTitle)){
                return book;
            }
        }
        return null;
    }

    // returns the entire queue


    public static Queue<LibraryUser> getUsersQueue() {

        return usersQueue;
    }
}
