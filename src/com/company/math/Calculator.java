package com.company.math;

import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {

    // вычисление выражения
    public static Integer calc(String inputDate){
        StringTokenizer tokenizer = new StringTokenizer(inputDate);
        String token;
        Integer result;
        Stack<String> stackTokens = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        while(tokenizer.countTokens() > 0){
            stackTokens.push(tokenizer.nextToken());
        }
        while (!stackTokens.isEmpty()){
            token = stackTokens.pop();
            if (token.equals("add")){
                result = 0; // если аргументов у add не будет, то сумма=0
                while (!numStack.isEmpty()){
                    result += numStack.pop();
                }
                numStack.push(result);
            } else if (token.equals("mul")){
                result = 1;
                if (numStack.isEmpty()) // у mul обязательно должны быть аргументы
                    throw new RuntimeException("Произведение путого множества");
                while (!numStack.isEmpty()){
                    result *= numStack.pop();
                }
                numStack.push(result);
            } else {
                numStack.push(Integer.parseInt(token));
            }
        }
        return numStack.pop();
    }

}
