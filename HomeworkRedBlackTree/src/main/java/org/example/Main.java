package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RedBlackTree myTree = new RedBlackTree();
        Scanner sc = new Scanner(System.in);
        while (true) {
            myTree.add(sc.nextInt());
            System.out.println(myTree);
        }
    }
}