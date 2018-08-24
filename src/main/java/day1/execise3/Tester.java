/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1.execise3;

import java.nio.file.AccessMode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Tiba
 */
public class Tester {

    static int MaxCount = 10000;
    static int maxThreads = 100;

    public static void main(String[] args) {

        Even e = new Even();

        for (int i = 0; i <= maxThreads; i++) {
            new Thread(() -> {
                for (int j = 0; j <= MaxCount; j++) {
                    System.out.println(e.next());

                }
            }).start();

        }

    }

}
