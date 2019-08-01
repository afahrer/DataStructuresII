package Assignment01;

public class Gremmar {

    public static void main(String[] args) {
        String expression = "a/b*c";
        findExpression(new StringBuilder(expression));

    }

    private static void findExpression(StringBuilder stringBuilder) {
        findTerm(stringBuilder);
        if(stringBuilder.length() == 0) return ;
        if(stringBuilder.charAt(0) == '+' || stringBuilder.charAt(0) == '-') {
            stringBuilder.deleteCharAt(0);
            findTerm(stringBuilder);
        }

    }

    private static void findTerm(StringBuilder stringBuilder) {
        findFactor(stringBuilder);
        if(stringBuilder.length() == 0) return;
        if(stringBuilder.charAt(0) == '*' || stringBuilder.charAt(0) == '/') {
            stringBuilder.deleteCharAt(0);
            findFactor(stringBuilder);
        }
    }

    private static void findFactor(StringBuilder stringBuilder) {
        if(stringBuilder.length() == 0) return;
        if(Character.toString(stringBuilder.charAt(0)).matches("[a-z]")) {
            stringBuilder.deleteCharAt(0);
        }
        else if(stringBuilder.charAt(0) == '(') {
            stringBuilder.deleteCharAt(0);
            findExpression(stringBuilder);
            if(stringBuilder.charAt(0) == ')'){
                stringBuilder.deleteCharAt(0);
            }
        }
        else{
            throw new ExpressionInvalidExceptionn("Expression is invalid");
        }
    }
}
