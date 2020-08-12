import model.Librarian;
import model.LibraryUser;
import model.abtractclass.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibrarianTest {
    private static Person.DateOfBirth librarianDOB;
    private static Librarian librarian;
    // init set up
    @BeforeEach
    public  void setup(){
         // Initializing the  Librarian Object
        Person.DateOfBirth librarianDOB = new Person.DateOfBirth("1855", "01", "18");
        Librarian librarian = new Librarian("Anthony", 25, librarianDOB, "08106515740");
    }

    @Test
        // passing  invalid arguments to the addNewBook() should throw an error
    void invalidArgumentsShouldThrowAnError(){
        Assertions.assertThrows(NullPointerException.class, ()->{
            librarian.addNewBook(null,null,null,"250",2);
        });
    }


    @Test
    // should not accept user book requests when there is an invalid argument
    void invalidBookRequestArgumentsShouldThrowAnError(){
        Person.DateOfBirth userDob = new Person.DateOfBirth("1955", "05", "22");
        LibraryUser libraryUser = new LibraryUser("Mondris", 25, userDob, "junior student");
        Assertions.assertThrows(NullPointerException.class, ()->{
            Librarian.acceptUserRequest(null,libraryUser);
        });
    }

    @Test
    // should accept user's request to borrow a book from the library
    void shouldAcceptUserRequestToBorrowBook() throws Exception {
        Person.DateOfBirth userDob = new Person.DateOfBirth("1955", "05", "22");
        LibraryUser libraryUser = new LibraryUser("Mondris", 25, userDob, "junior student");
        boolean returnedResult = Librarian.acceptUserRequest("HACKING", libraryUser);

        Assertions.assertEquals(true, returnedResult);
    }
}

