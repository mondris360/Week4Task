package model;

public  class Address {
    private String street;
    private String town;
    private String city;
    private String  state;

    // a constructor
    public Address(String street, String town, String city, String state) {
        this.street = street;
        this.town = town;
        this.city = city;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    // returns the full address as string
    public String getFullAddress(){

        return this.street + " " + this.town + " " + this.city + " " + this.state;
    }
}