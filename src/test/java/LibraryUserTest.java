import model.Book;
import model.LibraryUser;
import model.abtractclass.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Junit 5 tests for LibraryUser class
public class LibraryUserTest {
    private static Person.DateOfBirth authorDob;
    private static Book.Author author;
    private static LibraryUser libraryUser;
    @BeforeEach
    public  void setup(){
//        / Initialize  the author object
        authorDob =  new Person.DateOfBirth("1955", "05", "22");
        author = new Book.Author("Mary Jane", 25,authorDob,"Very Hard Working");
        // initialize the library user object
        libraryUser = new LibraryUser("Mondris", 25, authorDob, "junior student");
    }

   @Test
   // passing an invalid  bookName to borrowBookMethod() should throw an error;
    void invalidBookNameShouldThrowAnError(){
        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            libraryUser.borrowBook(null);
        });
   }

   @Test
   // should submit user request to the librarian;
    void shouldSubmitUserRequestAndAddUserToTheQueue() throws Exception {
        boolean returnedResult = libraryUser.borrowBook("Hacking IOT");
        Assertions.assertEquals(true, returnedResult);
   }


}
