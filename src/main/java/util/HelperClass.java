package util;

import java.util.Random;

public class HelperClass {
    // help method to generate a random digit

    // method to generate a new bookID(bookCallNumber)
    public static int  generateRandomNumber (){
        Random randomNo =  new Random();
        int generatedNo =  randomNo.nextInt(54854201);

        return  generatedNo;
    }

}
