package io.zipcoder.casino;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Console {

    private Scanner scanner = new Scanner(System.in);


//    public Console(String input) {
//        this.scanner = new Scanner(input);
//    }

public void print(String str){
    System.out.println(str);
}





//    public  void print(String str, Object... args) {
//        output.println(String.format(str, args));
//    }
//
    public  String getStringInput(String prompt) {
        print(prompt);
        String input = scanner.nextLine();
        return input;
    }

    public  Double getDoubleInput(String prompt) {
        return Double.parseDouble(getStringInput(prompt));
    }

    public Integer getIntegerInput(String prompt) {
        return getDoubleInput(prompt).intValue();
    }
}
