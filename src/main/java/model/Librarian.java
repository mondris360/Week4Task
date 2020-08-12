package model;

import model.abtractclass.Person;

import java.util.*;

// inheritance
public class Librarian extends Person {
    private String phoneNo;

    //pending requests
    private static Map<LibraryUser, String> pendingRequests =  new HashMap<>();

    // constructor
    public Librarian(String name, int age, DateOfBirth dateOfBirth, String phoneNo) {
        super(name, age, dateOfBirth);
        this.phoneNo = phoneNo;
    }


    // method to  add a new book to the library collection of books
    public boolean addNewBook(String name, Book.Author author, String ISBN, String yearOfPublication, int quantity) throws Exception{

        if(name == null || author == null || ISBN == null ||yearOfPublication == null || quantity <=0){
            throw new NullPointerException("You Passed an invalid Argument");
        }
        // create a new book object
        Book myBook = new Book(name, author, ISBN, yearOfPublication, quantity);
        // add the book to the library
        boolean addBook =  Library.setBooks(myBook);
        return  addBook;
    }

    // method to accept book requests from library users
    public static boolean acceptUserRequest(String bookName, LibraryUser user){
        if(bookName == null || user == null ){
            throw new NullPointerException("You Passed an invalid Argument");
        }
        pendingRequests.put(user, bookName);
        return true;
    }
    // method to process all users requests
    public boolean processQueue(boolean givePriority){
       if(givePriority){
           // attend to library users based on their priority
           implementation1();
       } else {
           // use first come first serve implementation
           implementation2();
       }
        return false;
    }

    // implementation 2 i.e on first come first server basis
    private  String implementation2(){
        System.out.println("attending to users based on FIFO");
       Queue<LibraryUser>  currentQueue = Library.getUsersQueue();

       // treat all our pending requests
       String treatRequests = treatRequests(currentQueue);

       return treatRequests;
    }

    // implementation 1: users are attended to based on their priority
    private  String implementation1() {
        System.out.println("attending to users based on priority");
            // convert the already existing queue to a priority queue
        // generic
        Queue myNewQueue =  convertQueueToPriorityQueue();
        String treatRequests = treatRequests(myNewQueue);

        return treatRequests;
    }

    // method to process all the pending users requests
    private String treatRequests(Queue<LibraryUser> currentQueue){

        Iterator iterator = currentQueue.iterator();
        while (iterator.hasNext()){
            //get the first user on the queue
            LibraryUser firstUserOnQueue =  currentQueue.peek();
            System.out.println("Attending to  " + firstUserOnQueue.getName() + " rank " + firstUserOnQueue.getRank());
            // get the title of the book he/she wants to borrow
            String bookName =  pendingRequests.get(firstUserOnQueue);
            // check if the book is available
            boolean bookIsAvailable =  Library.getBooks().containsKey(bookName);
            if (!bookIsAvailable){
                System.out.println("book taken");
            } else {
                // get the book
                Book getBook =  Library.getBooks().get(bookName);
                // reduce the total quantity of the book
                getBook.decrementBookByOne();
                // if this is the last copy of the book, remove it
                if (getBook.getQuantity() <= 0){
                    Library.getBooks().remove(getBook);
                }
                System.out.println( "Handing "  + bookName  + " to " + " "  + firstUserOnQueue.getName());
            }
            // remove the user from the queue and attend to the next user on the queue
            currentQueue.poll();
            // remove  the user request from our pending requests list
            pendingRequests.remove(firstUserOnQueue);
        }
        return "Request Treated";
    }


    // method to convert a queue to a priority queue
    private  Queue convertQueueToPriorityQueue() {
        Queue currentQueue =  Library.getUsersQueue();
        PriorityQueue<LibraryUser> myTempQueue =  new PriorityQueue<LibraryUser>();

        // loop through the old queue
        Iterator iterator =  currentQueue.iterator();
        // add each user on the queue to the new priority list queue;
        while (iterator.hasNext()){
            myTempQueue.add((LibraryUser) currentQueue.poll());
        }

        return myTempQueue;
    }


    public void talk() {
        System.out.println("Librarian is Talking To a library User");
    }
    public void move() {
        System.out.println("Librarian is moving towards the book shelf");
    }

    public void eat() {
        System.out.println("Librarian  is eating");
    }



}
