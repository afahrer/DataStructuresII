package Assignment01;
/*
    Author: Adam Fahrer
    Date: Aug 1, 2019
    Purpose: To omit unnecessary brackets in an expression based the grammar
             in the textbook using a recursive algorithm
 */
public class Grammar {

    public static void main(String[] args) {
        String expression = "(a/b)*c";
        System.out.println(findExpression(new StringBuilder(expression)));
    }

    private static String findExpression(StringBuilder stringBuilder) {
        String exp = "";
        exp += findTerm(stringBuilder);
        if (stringBuilder.length() == 0) return exp;
        if (stringBuilder.charAt(0) == '+' || stringBuilder.charAt(0) == '-') {
            exp += stringBuilder.charAt(0);
            stringBuilder.deleteCharAt(0);
            exp += findTerm(stringBuilder);
        }
        if (stringBuilder.length() == 0 || stringBuilder.charAt(0) == ')') return exp;
        throw new ExpressionInvalidException("Expression is invalid");
    }

    private static String findTerm(StringBuilder stringBuilder) {
        String exp = "";
        exp += findFactor(stringBuilder);
        if (stringBuilder.length() == 0) return exp;
        if (stringBuilder.charAt(0) == '*' || stringBuilder.charAt(0) == '/') {
            exp += stringBuilder.charAt(0);
            stringBuilder.deleteCharAt(0);
            exp += findFactor(stringBuilder);
        }
        return exp;
    }

    private static String findFactor(StringBuilder stringBuilder) {
        String exp = "";
        if (stringBuilder.length() == 0) return exp;
        if (Character.toString(stringBuilder.charAt(0)).matches("[a-z]")) {
            exp += stringBuilder.charAt(0);
            stringBuilder.deleteCharAt(0);
            return exp;
        } else if (stringBuilder.charAt(0) == '(') {
            stringBuilder.deleteCharAt(0);
            exp += findExpression(stringBuilder);
            if (stringBuilder.charAt(0) == ')') {
                stringBuilder.deleteCharAt(0);
            }
            return exp;
        }
        throw new ExpressionInvalidException("Expression is invalid");
    }
}
