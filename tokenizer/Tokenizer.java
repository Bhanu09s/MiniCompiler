package tokenizer;

import java.util.ArrayList;
import postfix.PostFix;

public class Tokenizer {

    private ArrayList<String> tokens = new ArrayList<>();

    /**
     * Breaks the input string into tokens: multi-digit numbers (and decimals) plus single-char operators/brackets.
     */
    public ArrayList<String> tokenize(String str) {
        tokens.clear();
        StringBuilder numberBuf = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch) || ch == '.') {
                // build up a number (integer or decimal)
                numberBuf.append(ch);
            } else {
                // flush any number we were building
                if (numberBuf.length() > 0) {
                    tokens.add(numberBuf.toString());
                    numberBuf.setLength(0);
                }
                // skip whitespace
                if (Character.isWhitespace(ch)) {
                    continue;
                }
                // single-char token: operator or parenthesis
                tokens.add(String.valueOf(ch));
            }
        }

        // flush trailing number, if any
        if (numberBuf.length() > 0) {
            tokens.add(numberBuf.toString());
        }

        return tokens;
    }

    /**
     * Converts the most recently tokenized list into postfix notation.
     */
    public ArrayList<String> postfix() {
        PostFix p = new PostFix();
        return p.infixTopostfix(tokens);
    }
}




// package tokenizer;
// import java.util.ArrayList;
// import postfix.PostFix;
// public class Tokenizer {

//     ArrayList<Character> token = new ArrayList<>();
//     public ArrayList<Character> tokenize(String str){
//         for(Character ch: str.toCharArray()){
//             token.add(ch);
//         }
//         return token;
//     }

//     public ArrayList<Character> postfix(){
//         PostFix p = new PostFix();
//         ArrayList<Character> postFixArray = p.infixTopostfix(token);
//         return postFixArray;
//     }
// }
