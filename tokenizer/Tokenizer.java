// File: src/tokenizer/Tokenizer.java
package tokenizer;

import java.util.ArrayList;
import postfix.PostFix;

public class Tokenizer {

    private ArrayList<String> tokens = new ArrayList<>();

    /**
     * Breaks the input string into single-character String tokens.
     */
    public ArrayList<String> tokenize(String str) {
        tokens.clear();
        for (char ch : str.toCharArray()) {
            tokens.add(String.valueOf(ch));
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
