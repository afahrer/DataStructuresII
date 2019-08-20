package Assignment05.Qu1;
/*
    Author: Adam Fahrer
    Date: August 20, 2019
    Purpose: To test the Hashmap class methods
*/
public class HashTest {

    public static void main(String[] args) {
        System.out.println("Linear\n");
        buildHash(0);
        System.out.println("Quadratic\n");
        buildHash(1);
        System.out.println("Double Hash\n");
        buildHash(2);
    }

    private static void buildHash(int mode) {
        Hashmap hash = new Hashmap(mode);
        Employee[] list = {
                new Employee(1,"Adam","Fahrer", "Computer Science", 3),
                new Employee(2,"Phil","Smith", "Computer Science", 3),
                new Employee(402,"Amy","Smith", "Science", 7),
                new Employee(802,"Bill","Walker", "Math", 1),
                new Employee(3,"Jill","Doe", "English", 12),
                new Employee(66,"Mike","Smith", "Math", 6),
                new Employee(55,"John","Doe", "Music", 6),
                new Employee(456,"Bob","Smith", "Art", 4),
                new Employee(88,"Andy","Doe", "English", 22),
                new Employee(1023,"Sarah","Smith", "English", 14),
        };
        for (Employee employee: list) {
            hash.insert(employee);
        }
        hash.delete(402);
        hash.delete(88);
        System.out.println("retrieve(3)\n" + hash.retrieve(3));
        System.out.println();
        hash.printHash();
        System.out.println();
    }
}
