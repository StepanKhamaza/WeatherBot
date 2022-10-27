package com;

import com.input.Input;
import com.output.Output;

import java.util.Scanner;

public class Bot implements Input, Output {
    private String message = null;
    public Bot() {}

    public boolean input() {
        Scanner scanner = new Scanner(System.in);
        this.message = scanner.nextLine();
        return !this.message.equals("exit");
    }

    public void output() {
        System.out.println(this.message);
    }
}
