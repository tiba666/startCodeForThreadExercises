/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1.exercise2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Tiba
 */
public class Tester {

    ExecutorService es = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 100; j++) {
                    System.out.println(Thread.currentThread().getName() + ": " + j);
                }}).start();

        }
    }

}
