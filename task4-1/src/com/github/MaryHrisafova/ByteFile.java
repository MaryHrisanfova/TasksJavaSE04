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

public abstract class ByteFile {

    public static ByteArrayOutputStream readFile(String fileNameToRead) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream(); //поток для записи прочитанных байтов
        File fileToRead = new File(fileNameToRead);
        int oneByte, countOfBytes = 0;

        try {
            System.out.println("Файл " + fileNameToRead + " в байтах: ");
            FileInputStream isRead = new FileInputStream(fileToRead);
            while ((oneByte = isRead.read()) != -1) {
                System.out.print(oneByte+" ");
                out.write(oneByte);
                countOfBytes++;
            }
            isRead.close();
            out.close();
            System.out.println();

        }
        catch (FileNotFoundException e){
            System.err.println("Файл не найден: " + e);
        }
        catch (IOException e) {
            System.err.println("Ошибка файла: " + e);
        }

        return out;
    }

    public static void writeJavaKeywords(ByteArrayOutputStream outputStream) throws IOException{
        String[] keywords={"boolean","case","do","else","for","if","import","new","package","return","while"};
        File fileToWrite = new File("QuestionsAnswers1.java");
        PrintStream printStream=null;
        try{
            FileOutputStream keywordsAreFinded=new FileOutputStream(fileToWrite);
            printStream=new PrintStream(keywordsAreFinded);
           // System.out.println("Файл открыт для записи");

            int i=0;
            for(String s:keywords){
                int countOfThisKeyword=0;
                Matcher keyword = Pattern.compile(keywords[i]).matcher(outputStream.toString());
                while(keyword.find()) {
                    for (Integer j=0;j<=keyword.groupCount();j++){
                        countOfThisKeyword++;
                        // System.out.println("[" + keyword.group(j) + "]");

                    }

                }
                printStream.print(keywords[i] + "\t" + "Count: "+countOfThisKeyword + "\n");

                i++;
            }

            printStream.close();
            keywordsAreFinded.close();
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
        ByteArrayOutputStream out=new ByteArrayOutputStream();

        out=readFile(javaFileToRead);
        writeJavaKeywords(out);
    }
}