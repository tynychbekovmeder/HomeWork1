package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("#  | Bus          |  Driver| State");
        System.out.println("---+--------------+--------+--------");
        JsonParser.read();
        JsonParser.parsing();
    }
}
