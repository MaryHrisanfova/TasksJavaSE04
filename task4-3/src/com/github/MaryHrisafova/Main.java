package com.github.MaryHrisafova;

import java.io.*;

/**
 * Created by hrisanfovamm on 19.10.2015.
 */

public class Main {

    public static void main(String[] aArgs) throws IOException {
        try{
            FileReader fileUTF8=new FileReader("fileUTF8");
            BufferedReader bufread=new BufferedReader(new InputStreamReader(new FileInputStream("fileUTF8"),"UTF8"));
            String s;

            //FileWriter fileUTF16=new FileWriter("fileUTF16");
            BufferedWriter bufwrite=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fileUTF16"),"UTF16"));
            while ((s=bufread.readLine())!=null){
                bufwrite.write(s);//readLine отбрасывает перевод строк
                System.out.print(s);
            }
            fileUTF8.close();
            bufread.close();
            bufwrite.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
