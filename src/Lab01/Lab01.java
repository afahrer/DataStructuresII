package Lab01;

import java.util.Arrays;

public class Lab01 {
    public static void main(String[] args) {
        int[] list1 = {4, 7, 3, 2, 8, 1, 6};
        int[] list2 = {1, 2, 3, 1, 2, 3, 3, 3};
        int[] list3 = {1, 2, 3, 1, 2, 3, 6, 3, 6, 5, 4, 3};
        int[] list4 = {6, 5, 4, 2};
        int[] answer;
        System.out.println(partitionable2to1(list1, answer = new int[list1.length], 0));
        System.out.println(Arrays.toString(list1));
        System.out.println(Arrays.toString(answer));
        System.out.println(partitionable(list2, answer = new int[list2.length], 0));
        System.out.println(Arrays.toString(list2));
        System.out.println(Arrays.toString(answer));
        System.out.println(partitionable(list3, answer = new int[list3.length], 0));
        System.out.println(Arrays.toString(list3));
        System.out.println(Arrays.toString(answer));
        System.out.println(partitionable(list4, answer = new int[list4.length], 0));
        System.out.println(Arrays.toString(list4));
        System.out.println(Arrays.toString(answer));
    }

    public static boolean partitionable(int[] list1, int[] list2, int dropIndex) {
        if (sum(list1) == sum(list2)) return true;
        if (dropIndex == list1.length - 1) return false;
        list2[dropIndex] = list1[dropIndex];
        list1[dropIndex] = 0;
        if (partitionable(list1, list2, dropIndex + 1)) return true;
        list1[dropIndex] = list2[dropIndex];
        list2[dropIndex] = 0;
        return partitionable(list1, list2, dropIndex + 1);
    }

    public static boolean partitionable2to1(int[] list1, int[] list2, int dropIndex) {
        if (sum(list1) == sum(list2) * 2) return true;
        if (dropIndex == list1.length - 1) return false;
        list2[dropIndex] = list1[dropIndex];
        list1[dropIndex] = 0;
        if (partitionable2to1(list1, list2, dropIndex + 1)) return true;
        list1[dropIndex] = list2[dropIndex];
        list2[dropIndex] = 0;
        return partitionable2to1(list1, list2, dropIndex + 1);
    }

    public static int sum(int[] list) {
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }
}
