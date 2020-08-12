package model.abtractclass;

// a Parent abstract class
public abstract  class Person {
    private String name;
    private int age;
    private DateOfBirth  dateOfBirth;

    public Person(String name, int age, DateOfBirth dateOfBirth) {
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    // abstract methods
    public abstract void talk();
    public abstract void move();
    public abstract void eat();



     // An inner class for Date Of Birth
    public static class DateOfBirth {

        private String year;
        private String month;
        private  String day;

        public DateOfBirth(String year, String month, String day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }


        public String getYear() {
            return year;
        }

        public String getMonth() {
            return month;
        }

        public String getDay() {
            return day;
        }

        // method to return the full date of birth
        public String getDateOfBirth(){

            return this.day + " / " + this.month + " / " + this.year + " /";
        }
    }
}
