package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("#  | Bus          |  Driver| State");
        System.out.println("---+--------------+--------+--------");
        AutoBase1.read();
        AutoBase1.parsing();

        System.out.println("\n--------------ЭТАП ВТОРОЙ------------");
        System.out.println("#  | Bus          |  Driver| State");
        System.out.println("---+--------------+--------+--------");
        AutoBase2.read();
        AutoBase2.parsing();

    }
}
