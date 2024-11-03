package com.github.zipcodewilmington;

//Gabrielle Damazio

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {

    private int numberOfTries;
    private String[] wordList;
    private char currentGuess;
    private char[] currentState;

    public Hangman() {
        this.numberOfTries = 0;
        this.wordList = new String[]{"birds", "eagles", "games", "sunday"};
    }

    public void StartGame() {
        String random = (wordList[new Random().nextInt(wordList.length)]);
        this.currentState = new char[random.length()];

//        System.out.println(random);
        int i = 0;
        for (char c : random.toCharArray()) {
            this.currentState[i] = '_';
            i++;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Hangman game");

        while (!String.valueOf(currentState).equals(random) && numberOfTries < 10) {
            i = 0;
            System.out.println(this.currentState);
            System.out.println("Guess a letter");
            this.numberOfTries++;
            this.currentGuess = scanner.nextLine().charAt(0);
            for (char d : random.toCharArray()) {
                if (d == this.currentGuess) {
                    this.currentState[i] = d;
                }
                i++;
            }
        }
    if (numberOfTries == 10){
        System.out.println("Sorry you lose, you have ran out of tries, the word was " + random);
    }else {
        System.out.println("Congratulations you win the word was " + random);
    }
    }
}


