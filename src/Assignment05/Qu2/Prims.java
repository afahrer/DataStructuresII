package Assignment05.Qu2;

import java.util.Arrays;
/*
    Author: Adam Fahrer
    Date: August 20, 2019
    Purpose: To demonstrate Prim's algorithm on a weighted graph using an
             Adjacency Matrix and Adjacency List
*/
public class Prims {

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this(val, null);
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 2145, 3520, 1540, 2475, 2420, 3355, 2585},
                {2145, 0, 1980, 3795, 1815, 2585, 1375, 2530},
                {3520, 1980, 0, 2475, 3795, 3960, 3410, 2255},
                {1540, 3795, 2475, 0, 3575, 2695, 2475, 2035},
                {2475, 1815, 3795, 3575, 0, 3025, 2035, 1210},
                {2420, 2585, 3960, 2695, 3025, 0, 3685, 2585},
                {3355, 1375, 3410, 2475, 2035, 3685, 0, 3080},
                {2585, 2530, 2255, 2035, 1210, 2585, 3080, 0}
        };
        System.out.println("Cost when represented as an Adjacency Matrix\n$" + costMatrix(matrix));
        System.out.println();
        Node[] list = buildAdjacencyList(matrix);
        System.out.println("Cost when represented as an Adjacency List\n$" + costList(list));
    }

    private static Node[] buildAdjacencyList(int[][] matrix) {
        Node[] list = new Node[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Node curr = list[i];
                if (curr == null) list[i] = new Node(matrix[i][j]);
                else {
                    while (curr.next != null) {
                        curr = curr.next;
                    }
                    curr.next = new Node(matrix[i][j]);
                }
            }
        }
        return list;
    }

    private static int costMatrix(int[][] matrix) {
        int cost = 0;
        int start = 0;
        boolean[] visited = new boolean[matrix.length];
        int[] minValues = new int[matrix.length];
        Arrays.fill(minValues, Integer.MAX_VALUE);
        minValues[start] = 0;
        visited[start] = true;
        while (!allVisited(visited)) {
            //build a list of shortest paths available
            for (int i = 0; i < matrix.length; i++) {
                if (minValues[i] > matrix[start][i] && !visited[i]) {
                    minValues[i] = matrix[start][i];
                }
            }
            //choose the smallest path and visit the new start value
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < minValues.length; i++) {
                if (min > minValues[i] && !visited[i]) {
                    start = i;
                    min = minValues[i];
                }
            }
            if (min != Integer.MAX_VALUE) cost += min;
            visited[start] = true;
        }
        return cost;
    }

    private static int costList(Node[] list) {
        int cost = 0;
        int start = 0;
        boolean[] visited = new boolean[list.length];
        int[] minValues = new int[list.length];
        Arrays.fill(minValues, Integer.MAX_VALUE);
        minValues[start] = 0;
        visited[start] = true;
        while (!allVisited(visited)) {
            //build a list of shortest paths available
            Node curr = list[start];
            int node = 0;
            while (curr != null) {
                if (minValues[node] > curr.val && !visited[node]) {
                    minValues[node] = curr.val;
                }
                curr = curr.next;
                node++;
            }
            //choose the smallest path and visit the new start value
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < minValues.length; i++) {
                if (min > minValues[i] && !visited[i]) {
                    start = i;
                    min = minValues[i];
                }
            }
            if (min != Integer.MAX_VALUE) cost += min;
            visited[start] = true;
        }
        return cost;
    }

    private static boolean allVisited(boolean[] visited) {
        for (boolean wasVisited : visited) {
            if (!wasVisited) return false;
        }
        return true;
    }

}
