// File: src/usersRequest/UsersRequest.java
package usersRequest;

import tokenizer.Tokenizer;
import java.util.ArrayList;
import java.util.Scanner;

public class UsersRequest {

    static Tokenizer token = new Tokenizer();

    public static void TypeHi() {
        System.out.println("Hi!");
        System.out.println("Enter the expression you want to evaluate :- ");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        ArrayList<String> c1 = ConvertToToken(str);
        ArrayList<String> c2 = ConvertToPostFix(c1);

        System.out.println("Do you want to see the tokenized form of your entered expression? Y/N");
        char ch = in.next().charAt(0);
        if (ch == 'Y') {
            System.out.println(c1);
        }
        System.out.println();
        System.out.println("Do you want to see the postfix order of your expression? Y/N");
        char ch2 = in.next().charAt(0);
        if (ch2 == 'Y') {
            for(int i=0;i<c2.size();i++){
                System.out.print(c2.get(i)+" ");
            }
        }
        System.out.println();
    }

    private static ArrayList<String> ConvertToToken(String str) {
        return token.tokenize(str);
    }

    private static ArrayList<String> ConvertToPostFix(ArrayList<String> ignored) {
        return token.postfix();
    }
}


// package usersRequest;

// import postfix.PostFix;
// import tokenizer.Tokenizer;
// import java.util.ArrayList;
// import java.util.Scanner;
// public class UsersRequest {

//     static Tokenizer token = new Tokenizer();

//     public static void TypeHi(){
//         System.out.println("Hi!");
//         System.out.println("Enter the expression you want to evaluate :- ");
//         Scanner in = new Scanner(System.in);
//         String str = in.nextLine();
//         ArrayList<Character> c1 = ConvertToToken(str);
//         ArrayList<Character> c2 = ConvertToPostFix(c1);
//         System.out.println("Do you want to see the tokenized form of your entered Expression? Y/N");
//         Character ch = in.next().charAt(0);
//         if(ch=='Y'){
//             System.out.println(ConvertToToken(str));
//         }
//         System.out.println("Do you want to see the post fix order of your expression ? Y/N");
//         if(ch=='Y'){
//             System.out.println(ConvertToPostFix(c2));
//         }

//     }
//     private static ArrayList<Character> ConvertToToken(String str){
//         ArrayList<Character> tokenCharacters = token.tokenize(str);
//         return tokenCharacters;
//     }
//     private static ArrayList<Character> ConvertToPostFix(ArrayList<Character> ch){
//         ArrayList<Character> postfixarray = token.postfix();
//         return postfixarray;
//     }
// }
