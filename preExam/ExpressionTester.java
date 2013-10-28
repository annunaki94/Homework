package preExam;

import java.util.Stack;

public class ExpressionTester {

    private static Stack<Integer> unpaired;

    public static boolean checkBalance(String expression) {
        unpaired = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            Integer top = -1;
            if (!unpaired.isEmpty()) {
                top = unpaired.peek();
            }
            switch (expression.charAt(i)) {
                case '[':
                    unpaired.push(0);
                    break;
                case '(':
                    unpaired.push(1);
                    break;
                case '{':
                    unpaired.push(2);
                    break;
                case '/':
                    if (expression.charAt(i + 1) == '*') {
                        unpaired.push(3);
                        i++;
                    }
                    break;
                case ']':
                    if (top != 0) {
                        return false;
                    } else {
                        unpaired.pop();
                    }
                    break;
                case ')':
                    if (top != 1) {
                        return false;
                    } else {
                        unpaired.pop();
                    }
                    break;
                case '}':
                    if (top != 2) {
                        return false;
                    } else {
                        unpaired.pop();
                    }
                    break;
                case '*':
                    if (expression.charAt(i + 1) == '/') {
                        i++;
                        if (top != 3) {
                            return false;
                        } else {
                            unpaired.pop();
                        }
                    }
                    break;
            }
        }
        if (unpaired.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String exp = "/*[(){}]*//**/";
        System.out.println(checkBalance(exp));
    }
}
