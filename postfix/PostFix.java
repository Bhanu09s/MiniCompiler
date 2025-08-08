package postfix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class PostFix {

    private static final Set<String> firstPriority  = new HashSet<>(List.of("*", "/"));
    private static final Set<String> secondPriority = new HashSet<>(List.of("+", "-"));
    private static final Set<String> operators      = new HashSet<>(List.of("*", "/", "+", "-", "%", "^"));

    private boolean checkPrecidence(String op1, String op2) {
        // op1 is the incoming operator, op2 is the one on stack
        if (firstPriority.contains(op1) && firstPriority.contains(op2)) {
            return true;
        } else if (firstPriority.contains(op1) && secondPriority.contains(op2)) {
            return true;
        } else if (secondPriority.contains(op1) && secondPriority.contains(op2)) {
            return true;
        }
        return false;
    }

    private boolean isOperator(String token) {
        return operators.contains(token);
    }

    private boolean isBrackets(String token) {
        return "(".equals(token) || ")".equals(token);
    }

    public ArrayList<String> infixTopostfix(ArrayList<String> tokens) {
        ArrayList<String> output = new ArrayList<>();
        Stack<String>      stack  = new Stack<>();

        for (String token : tokens) {
            if (!isOperator(token) && !isBrackets(token)) {
                // operand
                output.add(token);

            } else if (isOperator(token)) {
                // pop higher-or-equal precedence operators
                while (!stack.isEmpty()
                       && isOperator(stack.peek())
                       && checkPrecidence(token, stack.peek())) {
                    output.add(stack.pop());
                }
                stack.push(token);

            } else if ("(".equals(token)) {
                stack.push(token);

            } else if (")".equals(token)) {
                // unwind until matching "("
                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    output.add(stack.pop());
                }
                if (!stack.isEmpty() && "(".equals(stack.peek())) {
                    stack.pop();  // discard "("
                }
            }
        }

        // flush any remaining operators
        while (!stack.isEmpty()) {
            output.add(stack.pop());
        }

        return output;
    }
}



// package postfix;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.HashSet;
// import java.util.Stack;
// public class PostFix {

//     //private static final HashSet<Character> ZeroPriority = new HashSet<>(List.of('^'));
//     private static final HashSet<Character> firstPriority = new HashSet<>(List.of('*','/'));
//     private static final HashSet<Character> secondPriority = new HashSet<>(List.of('+','-'));
//     private static final HashSet<Character> operators = new HashSet<>(List.of('*','/','+','-','%','^'));

//     private boolean checkPrecidence(Character ch1, Character ch2){
//         if(firstPriority.contains(ch1) && firstPriority.contains(ch2)){
//             return true;
//         }else if(firstPriority.contains(ch1) && secondPriority.contains(ch2)){
//             return true;
//         }else if(secondPriority.contains(ch1) && secondPriority.contains(ch2)){
//             return true;
//         }
//         return false;
//     }

//     private boolean isOperator(Character ch){
//         return operators.contains(ch);
//     }

//     private boolean isBrackets(Character ch){
//         return ch=='(' || ch==')';
//     }

//     public ArrayList<Character> infixTopostfix(ArrayList<Character> tokens){
//         ArrayList<Character> ans = new ArrayList<>();
//         Stack<Character> s = new Stack<>();
//         for(Character ch:tokens){
//             if(!isOperator(ch) && !isBrackets(ch)){
//                 ans.add(ch);
//             }else if(isOperator(ch)){
//                 while(!s.isEmpty() && isOperator(s.peek()) && checkPrecidence(ch, s.peek())){
//                     ans.add(s.pop());
//                 }
//                 s.add(ch);
//             }
//             else if(ch=='('){
//                 s.add(ch);
//             }else if(ch==')'){
//                 while(!s.isEmpty() && s.peek()!='('){
//                     ans.add(s.pop());
//                 }
//                 if(!s.isEmpty() && s.peek()!='('){
//                     s.pop();
//                 }
//             }
//         }
//         while(!s.empty()){
//             ans.add(s.pop());
//         }
//         return ans;
//     }
// }
