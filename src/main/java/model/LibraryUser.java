package model;

import model.abtractclass.Person;

// implementing an interface
public class LibraryUser extends Person implements Comparable<LibraryUser>{
    private String userCategory;
    private Integer rank;

    public LibraryUser(String name, int age, DateOfBirth dateOfBirth, String userType) {
        // a call to initialize the parent constructor
        super(name, age, dateOfBirth);
        this.userCategory = userType;
        this.rank =  getUserRank(userType);
    }

    // method to borrow a book from the library
    public boolean borrowBook(String bookName) throws Exception {
        // validate the user input
        if (bookName == null ||  bookName.isEmpty() || bookName.isBlank() ){
            throw new IllegalArgumentException("Invalid Book Name");
        }
        // submit the book request to the librarian
        boolean submitRequest = Librarian.acceptUserRequest(bookName, this);
        if (submitRequest){
            System.out.println("Your Request Has Been Submitted Successfully");
            // join the queue
            Library.addUserToQueue(this);
            return true;
        } else {
            System.out.println("Unable to Process Your Request");
            return false;
        }
    }

    // method to return a borrowed Book
    public boolean returnBook(String bookName){
        // will implement latter if there is time
        return false;
    }


    // method to get UserRank
    private  int getUserRank(String userCategory){
        userCategory =  userCategory.toLowerCase();
        Integer rank = 0;
        switch (userCategory){
            case "teacher":
                rank = 5;
                break;
            case "junior student":
                rank = 1;
                break;
            case "senior student":
                rank = 3;
                break;
            default:
                rank = 0;

        }
        return rank;
    }
    public void talk() {
        System.out.println("Hello Librarian, i want to borrow a book");
    }

    public void move() {
        System.out.println("user is moving to the catalog");
    }

    public void eat() {
        System.out.println("User is eating");
    }

    public String getUserCategory() {
        return userCategory;
    }

    public int getRank() {
        return rank;
    }

    // arrange the library users on the queue accord to their rank;
    @Override
    public int compareTo(LibraryUser libraryUser) {

        return  Integer.compare(libraryUser.getRank(), this.getRank());
    }

    @Override
    public String toString() {
        return this.getName() + " " +  this.getRank();
    }
}
