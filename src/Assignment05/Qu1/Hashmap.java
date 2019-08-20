package Assignment05.Qu1;
/*
    Author: Adam Fahrer
    Date: August 20, 2019
    Purpose: To create a hashmap that can be implemented using three methods
             mode = 0: Linear Probing
             mode = 1: Quadratic Probing
             mode = 2: Double Hashing
*/
public class Hashmap {
    private Employee[] list = new Employee[401];
    private final int mode;

    public Hashmap(int mode) {
        if (mode > 2 || mode < 0)
            this.mode = 0;
        else this.mode = mode;
    }

    public void insert(Employee employee) {
        switch (mode) {
            case 0:
                linearInsert(employee);
                break;
            case 1:
                quadraticInsert(employee);
                break;
            case 2:
                doubleHashInsert(employee);
                break;
        }
    }

    private void linearInsert(Employee employee) {
        int key = hashKey(employee.getEmpID());
        for (int i = key; i < list.length; i++) {
            if (list[i] == null || list[i].getEmpID() == Integer.MIN_VALUE) {
                list[i] = employee;
                break;
            }
        }
    }

    private void quadraticInsert(Employee employee) {
        int key = hashKey(employee.getEmpID());
        for (int i = 0; i <= Math.sqrt(list.length); i++) {
            key = key + i * i;
            if (list[key] == null || list[key].getEmpID() == Integer.MIN_VALUE) {
                list[key] = employee;
                break;
            }
        }
    }

    private void doubleHashInsert(Employee employee) {
        int id = employee.getEmpID();
        int key = hashKey(id);
        for (int i = 1; i < list.length; i++) {
            if (list[key] == null || list[key].getEmpID() == Integer.MIN_VALUE) {
                list[key] = employee;
                break;
            }
            key = (hashKey(id) + i * hashKeyDouble(id)) % list.length;
        }
    }

    public Employee retrieve(int id) {
        switch (mode) {
            case 0:
                return linearRetrieve(id);
            case 1:
                return quadraticRetrieve(id);
            case 2:
                return doubleHashRetrieve(id);
        }
        return null;
    }

    private Employee linearRetrieve(int id) {
        int key = hashKey(id);
        for (int i = key; i < list.length; i++) {
            if (list[i] == null) return null;
            if (list[i].getEmpID() == id) return list[i];
        }
        return null;
    }

    private Employee quadraticRetrieve(int id) {
        int key = hashKey(id);
        for (int i = 0; i <= Math.sqrt(list.length); i++) {
            key = key + i * i;
            if (key > list.length || list[key] == null) return null;
            if (list[key].getEmpID() == id) return list[key];
        }
        return null;
    }

    private Employee doubleHashRetrieve(int id) {
        int key = hashKey(id);
        for (int i = 0; i <= Math.sqrt(list.length); i++) {
            if (key > list.length || list[key] == null) return null;
            if (list[key].getEmpID() == id) return list[key];
            key = (hashKey(id) + i * hashKeyDouble(id)) % list.length;
        }
        return null;
    }

    public void delete(int id) {
        switch (mode) {
            case 0:
                linearDelete(id);
                break;
            case 1:
                quadraticDelete(id);
                break;
            case 2:
                doubleHashDelete(id);
                break;
        }
    }

    private void linearDelete(int id) {
        int key = hashKey(id);
        for (int i = key; i < list.length; i++) {
            if (list[i] == null) return;
            if (list[i].getEmpID() == id)
                list[i] = new Employee(Integer.MIN_VALUE);
        }
    }

    private void quadraticDelete(int id) {
        int key = hashKey(id);
        for (int i = 0; i <= Math.sqrt(list.length); i++) {
            key = key + i * i;
            if (key > list.length || list[key] == null) return;
            if (list[key].getEmpID() == id)
                list[key] = new Employee(Integer.MIN_VALUE);
        }
    }

    private void doubleHashDelete(int id) {
        int key = hashKey(id);
        for (int i = 0; i <= Math.sqrt(list.length); i++) {
            if (key > list.length || list[key] == null) return;
            if (list[key].getEmpID() == id)
                list[key] = new Employee(Integer.MIN_VALUE);
            key = (hashKey(id) + i * hashKeyDouble(id)) % list.length;
        }
    }

    private int hashKey(int id) {
        return id % list.length;
    }

    private int hashKeyDouble(int id) {
        return id % 97;
    }

    public void printHash() {
        for (int i = 0; i < list.length; i++) {
            if(list[i] == null) continue;
            if(list[i].getEmpID() == Integer.MIN_VALUE) {
                System.out.println("#" + i + ": 999: {Deleted}");
                continue;
            }
            System.out.println("#" + i + ": " + list[i]);
        }
    }
}
