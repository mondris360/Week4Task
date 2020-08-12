package model;

// helper class method
import static util.HelperClass.generateRandomNumber;

// this file contains both the Book and the Author class
public  class Book {
    private String name;
    private String ISBN;
    // Aggregation Relationship
    private Author author;
    private int bookCallNumber;
    private String yearOfPublication;
    private int quantity;

    public Book(String name, Author author, String ISBN, String yearOfPublication, int quantity) {
        this.name = name;
        this.author = author;
        this.ISBN = ISBN;
        this.yearOfPublication = yearOfPublication;
        this.quantity =  quantity;
        this.bookCallNumber = generateRandomNumber ();
    }


    public String getName() {
        return name;
    }

    public String getISBN() {
        return ISBN;
    }

    public Author getAuthor() {
        return author;
    }

    // method to return the current available  quantity of the book
    public int getQuantity(){
        return this.quantity;
    }

    public String  getYearOfPublication(){
        return this.yearOfPublication;
    }

    public int getBookCallNumber(){
        return this.bookCallNumber;
    }

    // method to increment the total quantities of a book by one
    public void incrementBookQtyByOne(){
        this.quantity++;
    }

    public void decrementBookByOne(){
        this.quantity--;
    }

    // an inner class for Author
    public static class Author extends  Person{

        private String biography;

        public Author(String name, int age, DateOfBirth dateOfBirth, String biography) {
            super(name, age, dateOfBirth);
            this.biography = biography;
        }


        public String getBiography() {
            return biography;
        }

        public void talk() {
            System.out.println("Author is talking to the press");
        }

        public void move() {
            System.out.println("Author is moving to his car");
        }

        public void eat() {
            System.out.println("Author is currently eating");
        }
    }
}


