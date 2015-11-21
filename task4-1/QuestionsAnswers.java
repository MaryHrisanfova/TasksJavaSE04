package com.github.MaryHrisanfova;

/**
 * Created by hrisanfovamm on 12.10.2015.
 */
import java.io.*;
import java.text.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


import static java.util.ResourceBundle.*;

public class QuestionsAnswers {

    public static void main(String[] args) {
        ResourceBundle bundl;
        String language = new String();
        String country = new String();
        int button;

        String a1=new String();

        String cp = System.getProperty("console.encoding","Windows-1251");

       String encoding=System.setProperty("console.encoding", "utf-8");
        PrintStream ps=new PrintStream(System.out);
      //  Scanner sc=new Scanner(System.in,encoding);
        //System.setProperty("console.encoding","Windows-1251");
        //PrintStream ps=new PrintStream(System.out,true,encoding);
        a1="1-Английский 2 -Русский";
       // ps.println(a1);
        //russianText.println("1-Английский 2 -Русский");
        System.out.println("Choose the language: 1 - English; 2 - Russian" + "\n" +a1);
        Scanner scanner = new Scanner(System.in);
        button = scanner.nextInt();

        if (button == 1) {
            language = "en";
            country = "US";
        }

        if (button == 2) {
            language = "ru";
            country = "RU";
        }

        Locale chosenLocale = new Locale(language, country);
        bundl = getBundle("com/github/MaryHrisanfova/QuestionsAnswers", chosenLocale);

        System.out.println("1. " + bundl.getString("question1"));
        System.out.println("2. " + bundl.getString("question2"));
        System.out.println("3. " + bundl.getString("question3"));
        System.out.println("4. " + bundl.getString("question4"));
        System.out.println("5. " + bundl.getString("question5"));
        System.out.println("6. " + bundl.getString("question6"));
        System.out.println("7. " + bundl.getString("question7"));
        System.out.println("\n"+bundl.getString("choose"));

        button=scanner.nextInt();

            switch (button) {
                case 1:
                    System.out.println(bundl.getString("answer1"));
                    break;
                case 2:
                    System.out.println(bundl.getString("answer2"));
                    break;
                case 3:
                    System.out.println(bundl.getString("answer3"));
                    break;
                case 4:
                    System.out.println(bundl.getString("answer4"));
                    break;
                case 5:
                    System.out.println(bundl.getString("answer5"));
                    break;
                case 6:
                    System.out.println(bundl.getString("answer6"));
                    break;
                case 7:
                    System.out.println(bundl.getString("answer7"));
                    break;
            }

        }


    }
