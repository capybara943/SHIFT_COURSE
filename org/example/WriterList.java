package org.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterList {

    public static <T> void write(List<T> list, String fileName, boolean isAppend){

        if(list.isEmpty()){
            if(!isAppend){
                File file = new File(fileName);
                if(file.exists()) file.delete();
            }
            return;
        }
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,isAppend))){
            for(T line : list){
                bufferedWriter.write(line.toString());
                bufferedWriter.newLine();
            }
        }
        catch (IOException e) {
            System.err.println("Ошибка записи в файл "+fileName+" err: "+e.getMessage());
        }
    }
}
