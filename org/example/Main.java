package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ParserCommandLine parserCommandLine = new ParserCommandLineSortDataType();
        Config config = parserCommandLine.parse(args);

        Statistic statistic = new Statistic();

        List<Integer> integerList = new ArrayList<>();
        List<Float> floatList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();

        for(String filename : config.getInputFileNameList()){
            File file = new File(filename);

            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = bufferedReader.readLine())!=null){
                    if(line.isEmpty()) continue;

                    if(line.matches("[-+]?[0-9]*")){
                        int num = Integer.parseInt(line);
                        integerList.add(num);
                        statistic.setMaxInt(Integer.max(num, statistic.getMaxInt()));
                        statistic.setMinInt(Integer.min(num, statistic.getMinInt()));
                        statistic.setSumInt(num+statistic.getSumInt());
                        continue;
                    }
                    if(line.matches("[-+]?[0-9]*\\.?[0-9]+")){
                        float num = Float.parseFloat(line);
                        floatList.add(Float.parseFloat(line));
                        statistic.setMaxFloat(Float.max(num, statistic.getMaxFloat()));
                        statistic.setMinFloat(Float.min(num, statistic.getMinFloat()));
                        statistic.setSumFloat(num+statistic.getSumFloat());
                        continue;
                    }
                    stringList.add(line);
                    statistic.setLenMaxString(Integer.max(line.length(),statistic.getLenMaxString()));
                    statistic.setLenMinString(Integer.min(line.length(),statistic.getLenMinString()));
                }
            } catch (IOException e) {
                System.err.println("Ошибка чтения файла "+filename+" err: "+e.getMessage());
            }
        }

        statistic.setCountInt(integerList.size());
        statistic.setCountFloat(floatList.size());
        statistic.setCountString(stringList.size());

        WriterList.write(integerList,
                config.getPathOutputDir()+config.getPrefixOutputFiles()+config.getIntegerOutputFile(),
                config.isAddingFile());

        WriterList.write(floatList,
                config.getPathOutputDir()+config.getPrefixOutputFiles()+config.getFloatOutputFile(),
                config.isAddingFile());

        WriterList.write(stringList,
                config.getPathOutputDir()+config.getPrefixOutputFiles()+config.getStringOutputFile(),
                config.isAddingFile());

        if(config.isFullStatistic()) System.out.println(statistic.getFullStatistic());
        else System.out.println(statistic.getSmallStatistic());
    }


}