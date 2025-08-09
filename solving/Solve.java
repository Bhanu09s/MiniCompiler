package solving;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solve {

    private static final Set<String> operators = new HashSet<>(List.of("*", "/", "+", "-", "%", "^"));

    private static int operation(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b != 0) {
                    return a / b; // integer division
                } else {
                    throw new ArithmeticException("Division by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }


    public static int finalValue(ArrayList<String> tokens){
        Stack<Integer> s = new Stack<>();
        s.add(Integer.valueOf(tokens.get(0)));
        for(int i=1;i<tokens.size();i++){
            if(operators.contains(tokens.get(i))){
                int a = Integer.valueOf(s.pop());
                int b = Integer.valueOf(s.pop());
                s.add(operation(b,a,tokens.get(i)));
            }else{
                s.add(Integer.valueOf(tokens.get(i)));
            }
        }
        return s.pop();
    }
}
