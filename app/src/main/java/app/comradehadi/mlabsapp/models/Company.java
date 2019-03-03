package app.comradehadi.mlabsapp.models;

public class Company {
    private int id;
    private String name;
    private String color;


    private static Company singletonCompany;

    private Company(int id, String name, String color) {

        this.id  = id;
        this.name = name;
        this.color = color;

    }


    public static Company getSingletonCompany(int id, String name, String color) {
        if (singletonCompany == null) {
            singletonCompany = new Company(id, name, color);
        }

        return singletonCompany;
    }
}
