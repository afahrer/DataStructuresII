package Lab02;

import java.util.StringTokenizer;

public class Lab02 {
    private static class Node {
        Object item;
        Node left, right;
        Node(Object item) {
            this.item = item;
            this.left = null;
            this.right = null;
        }
    }
    private static String[] operators = {"+", "-", "*", "/"};
    public static void main(String[] args) {
        Node tree;
        StringTokenizer str;
        str = new StringTokenizer("+ - * 6 8 + 4 2 7");
        tree = buildTree(str);
        System.out.println("Prefix");
        printPrefix(tree);
        System.out.println("\nInfix");
        printInfix(tree);
        System.out.println("\nPostfix");
        printPostfix(tree);
        System.out.println("\nAnswer " + eval(tree));
        str = new StringTokenizer("+ - * 4 8 6 2");
        tree = buildTree(str);
        System.out.println("\nPrefix");
        printPrefix(tree);
        System.out.println("\nInfix");
        printInfix(tree);
        System.out.println("\nPostfix");
        printPostfix(tree);
        System.out.println("\nAnswer " + eval(tree));
    }

    private static void printPrefix(Node tree) {
        if(tree == null) return;
        System.out.print(tree.item);
        printPrefix(tree.left);
        printPrefix(tree.right);
    }

    private static void printInfix(Node tree) {
        if(tree == null) return;
        printInfix(tree.left);
        System.out.print(tree.item);
        printInfix(tree.right);
    }

    private static void printPostfix(Node tree) {
        if(tree == null) return;
        printPostfix(tree.left);
        printPostfix(tree.right);
        System.out.print(tree.item);
    }

    public static int eval(Node tree) {
        if(tree == null) return 0;
        Object val = tree.item;
        int result = 0;
        if(val instanceof Integer) return (Integer)val;
        int valLeft = eval(tree.left);
        int valRight = eval(tree.right);
        if(isOperator((String)val))
        switch ((String)val) {
            case "+":
                result = valLeft + valRight;
                break;
            case "-":
                result = valLeft - valRight;
                break;
            case "*":
                result = valLeft * valRight;
                break;
            case "/":
                result = valLeft / valRight;
                break;
        }
        return result;
    }
    public static Node buildTree(StringTokenizer str) {
          if(!str.hasMoreElements()) return null;
          String item = str.nextToken();
          Node newNode;
          try {
              int num = Integer.parseInt(item);
              newNode = new Node(num);
          }
          catch (Exception e) {
              newNode = new Node(item);
          }
          if(!isOperator(item)) return newNode;
          else {
              newNode.left = buildTree(str);
              newNode.right = buildTree(str);
              return newNode;
          }
    }
    public static boolean isOperator(String item) {
        for (String operator : operators) {
            if (item.equals(operator)) return true;
        }
        return false;
    }
}
