package model;

import model.abtractclass.Person;

public class Main {

    public static void main(String[] args) throws  Exception {

            // Initializing the  Librarian Object
            Person.DateOfBirth librarianDOB = new Person.DateOfBirth("1855", "01", "18");
            Librarian librarian = new Librarian("Anthony", 25, librarianDOB, "08106515740");

            // Initialize  the author object
            Person.DateOfBirth authorDob = new Person.DateOfBirth("1955", "05", "22");
            Book.Author author = new Book.Author("Mary Jane", 25, authorDob, "Very Hard Working");

            // Initialize the Librarian Object
            librarian.addNewBook("book1", author, "YHSZ01/22", "2020", 9);
            librarian.addNewBook("book2", author, "YHSZ01/22", "2020", 2);
            librarian.addNewBook("book3", author, "YHSZ01/22", "2020", 9);
            librarian.addNewBook("book3", author, "YHSZ01/22", "2020", 2);

            // create a library user
            LibraryUser libraryUser = new LibraryUser("Mondris", 25, authorDob, "junior student");
            LibraryUser libraryUser2 = new LibraryUser("Andrew", 25, authorDob, "Teacher");
            LibraryUser libraryUser3 = new LibraryUser("John", 25, authorDob, "senior student");
            LibraryUser libraryUser4 = new LibraryUser("Thomas", 25, authorDob, "Teacher");
            libraryUser.borrowBook("Hacking++dddddd");
            libraryUser2.borrowBook("book2");
            libraryUser3.borrowBook("book1");
            libraryUser3.borrowBook("book3");
            libraryUser4.borrowBook("Hackinddg++ddddddddcccdd");
            System.out.println(librarian.processQueue(false));


    }
}