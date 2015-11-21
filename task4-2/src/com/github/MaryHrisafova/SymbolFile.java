package com.github.MaryHrisafova;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Created by ���� on 18.10.2015.
 */

public abstract class SymbolFile {

    public static StringBuilder readFile(String fileNameToRead) throws IOException {
        String out=""; //строка для записи прочитанных байтов
        FileReader fileToRead = new FileReader(fileNameToRead);
        int oneByte, countOfBytes = 0;
        StringBuilder readedText=new StringBuilder();

        try {
            System.out.println("Файл " + fileNameToRead + " в байтах: ");
            BufferedReader isRead = new BufferedReader(fileToRead);
            while ((isRead.readLine()) != null) {
                readedText.append(isRead.readLine());
                System.out.print(out + "!");
                countOfBytes++;
            }
            isRead.close();
            System.out.println();

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
           // System.err.println("Файл не найден: " + e);
        }
        catch (IOException e) {
            System.err.println("Ошибка файла: " + e);
        }

        return readedText;
    }

    public static void writeJavaKeywords(StringBuilder outputStream) throws IOException{
        String[] keywords={"boolean","case","do","else","for","if","import","new","package","return","while"};
        FileWriter fileToWrite = new FileWriter("QuestionsAnswers1.java");

       // PrintStream printStream=null;
        try{
            BufferedWriter bw=new BufferedWriter(fileToWrite);
           // printStream=new PrintStream(keywordsAreFinded);
           // System.out.println("Файл открыт для записи");

            int i=0;
            for(String s:keywords){
                int countOfThisKeyword=0;
                Matcher keyword = Pattern.compile(keywords[i]).matcher(outputStream);
                while(keyword.find()) {
                    for (Integer j=0;j<=keyword.groupCount();j++){
                        countOfThisKeyword++;
                        // System.out.println("[" + keyword.group(j) + "]");

                    }

                }
                fileToWrite.write(keywords[i] + " "+countOfThisKeyword+"  ");

                i++;
            }

          //  printStream.close();
           // keywordsAreFinded.close();
            bw.close();
            System.out.print("Запись ключевых слов в файл " + fileToWrite + " произведена");
        }
        catch (FileNotFoundException e){
            System.err.println("Файл не найден: " + e);
        }

        catch (IOException e) {
            System.err.println("Ошибка файла: " + e);
        }
    }

    public static void main(String[] aArgs) throws IOException {
        String javaFileToRead = "QuestionsAnswers.java";
        StringBuilder readedText;

        readedText=readFile(javaFileToRead);
        writeJavaKeywords(readedText);
    }
}