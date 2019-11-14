package com.company;

import com.company.math.Calculator;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        // если в параметрах указали '--' вместо '- -'
        // то разделим на 2 аргумента
        if (args.length == 1 && args[0].equals("--")){
            args = new String[]{"-", "-"};
        }
        if (args.length < 2){
            throw new RuntimeException("Недостаточно аргументов");
        }

        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        try {
            // определеям ввод-вывод
            bufferedReader = args[0].equals("-") ?
                    new BufferedReader(new InputStreamReader(System.in)) :
                    new BufferedReader(new FileReader(args[0]));
            printWriter = args[1].equals("-") ?
                    new PrintWriter(System.out) :
                    new PrintWriter(new FileWriter(args[1]));
            // вычисляем и выводим результат
            printWriter.println("Ответ: " + Calculator.calc(bufferedReader.readLine()));
        } finally {
            bufferedReader.close();
            printWriter.close();
        }
    }
}
