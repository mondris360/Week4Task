package model;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

            // Initializing the  Librarian Object
        Person.DateOfBirth librarianDOB= new Person.DateOfBirth("1855", "01", "18");
        Librarian librarian = new Librarian("Anthony", 25,librarianDOB,"08106515740");

        // Initialize  the author object
        Person.DateOfBirth authorDob =  new Person.DateOfBirth("1955", "05", "22");
        Book.Author author = new Book.Author("Mary Jane", 25,authorDob,"Very Hard Working");

        // Initialize the Librarian Object
        librarian.addNewBook("book1", author, "YHSZ01/22", "2020",9);
        librarian.addNewBook("book2", author, "YHSZ01/22", "2020",2);
        librarian.addNewBook("book3", author, "YHSZ01/22", "2020",9);
        librarian.addNewBook("book3", author, "YHSZ01/22", "2020",2);

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


//        PriorityQueue<Integer> myQueue =  new PriorityQueue<Integer>();
////        List<Integer> array =  new ArrayList<>();
////        array.add(20);
////        array.add(0);
////        array.add(20);
//        myQueue.add(3);
//        myQueue.add(6);
//        myQueue.add(4);
//        myQueue.add(1);
//        myQueue.add(2);
//        myQueue.add(5);
//        Object[]  queue=  myQueue.toArray();
//        System.out.println("Displaying priority Queue ");
//        System.out.println("original priority queue");
//        System.out.println(myQueue);
//        Iterator iterator =  myQueue.iterator();
//        while (iterator.hasNext()) {
//            System.out.println("Priority Queue Element " + myQueue.poll());
//        }
//
//        System.out.println("======================================");
//
//        System.out.println("original  queue");
//        System.out.println(myQueue2);
//        Iterator iterator2 =  myQueue2.iterator();
//        while (iterator2.hasNext()) {
//            System.out.println("Queu Element  " + myQueue2.poll());
//        }
//        System.out.println(Arrays.toString(queue));
//
//        System.out.println(myQueue);

//        Collections.fill(myQueue2, queueToArr);



    }


}