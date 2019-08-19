package Assignment05;

public class Test {
    public static void main(String[] args) {
        Hashmap hashmap = new Hashmap(0);
        hashmap.insert(new Employee(1));
        hashmap.insert(new Employee(2));
        hashmap.insert(new Employee(402));
        hashmap.delete(402);
        hashmap.printHash();
    }
}
