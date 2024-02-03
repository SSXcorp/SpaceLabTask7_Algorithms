package Task6;

import java.util.Map;

public class Id {
    public String fname;
    public String lname;
    public Address address;
    public String[] numbers;

    public Map<String, Integer> details;

    Id(String fname, String lname, Address address,String[] numbers, Map<String, Integer> details){
        this.fname  = fname;
        this.lname = lname;
        this.address = address;
        this.numbers = numbers;
        this.details = details;
    }

    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public String[] getNumbers() {
        return numbers;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setNumbers(String[] numbers) {
        this.numbers = numbers;
    }

}
