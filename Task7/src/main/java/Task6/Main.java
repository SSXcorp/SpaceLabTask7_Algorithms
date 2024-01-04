package Task6;

public class Main {
    public static void main(String[] args) {
        Address addressObj = new Address();
        addressObj.setCity("Chicago");
        addressObj.setStreet("Some Street");
        addressObj.setZip(12345);

        Id idObj = new Id();
        idObj.setAddress(addressObj);
        idObj.setFname("Test");
        idObj.setLname("Tester");

        ObjectConverterToJson.convert(idObj);
    }
}