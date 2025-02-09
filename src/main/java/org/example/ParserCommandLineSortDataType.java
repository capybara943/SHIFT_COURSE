package org.example;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ParserCommandLineSortDataType implements ParserCommandLine{

    @Override
    public Config parse(String[] args) throws IllegalArgumentException{

        Config config = new Config();

        for (int i = 0; i < args.length; i++){

            switch (args[i]){
                case "-o":
                    if(i+1 >= args.length || args[i + 1].startsWith("-")){
                        System.err.println("Путь после фалага -o не указан.\n" +
                                "Будет использован путь по умолчанию(текущая папка)");
                    }
                    else {
                        String pathDir = args[++i];
                        try {
                            validatePathDir(pathDir);
                            if(!pathDir.endsWith(File.separator)){
                                pathDir += File.separator;
                            }
                            config.setPathOutputDir(pathDir);
                        }
                        catch (IllegalArgumentException e){
                            System.err.println(e.getMessage()+"\nБудет использован путь по умолчанию(текущая папка)");
                        }
                    }
                    break;
                case "-p":
                    if(i+1 >= args.length || args[i + 1].startsWith("-")){
                        System.err.println("Префекс после флага -p не указан." +
                                "\nБудет использовано название по умолчанию");
                    }
                    String prefix = args[++i];
                    try {
                        validatePrefix(prefix);
                        config.setPrefixOutputFiles(prefix);
                    }catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage()+"\nБудет использовано название по умолчанию");
                    }
                    break;
                case "-a":
                    config.setAddingFile(true);
                    break;
                case "-f":
                    config.setFullStatistic(true);
                    break;
                case "-s":
                    config.setFullStatistic(false);
                    break;
                default:
                    try {
                        validateFileName(args[i]);
                        config.getInputFileNameList().add(args[i]);
                    }
                    catch (IllegalArgumentException e){
                        System.err.println("Файл: "+args[i]+" задан неправильно. " + e.getMessage());
                    }
                    break;

            }
        }
        return config;
    }

    private void validatePathDir(String pathDir) throws IllegalArgumentException{
        Path path = Paths.get(pathDir);

        if(!Files.exists(path)){
            throw new IllegalArgumentException("Указанной директории не существует: " + pathDir);
        }

        if(!Files.isDirectory(path)){
            throw  new IllegalArgumentException("Путь не является директорией: "+pathDir);
        }

        if (!Files.isWritable(path)) {
            throw new IllegalArgumentException("В заданной директории нет прав на запись: " + pathDir);
        }
    }

    private void validatePrefix(String prefix) throws IllegalArgumentException{
        String PREFIX_PATTERN = "^[a-zA-Z0-9_-]+$";
        if(!prefix.matches(PREFIX_PATTERN)){
            throw new IllegalArgumentException("Невалидный префикс: "+prefix);
        }
    }

    private void validateFileName(String fileName)throws IllegalArgumentException{
        File file = new File(fileName);
        if(!fileName.toLowerCase().endsWith(".txt")){
            throw new IllegalArgumentException("Ожидается файл с разрешением .txt");
        }
        if(!file.exists()){
            throw new IllegalArgumentException("Такого файла не существует");
        }
        if(!file.isFile()){
            throw new IllegalArgumentException("Файл недоступен");
        }
    }
}
