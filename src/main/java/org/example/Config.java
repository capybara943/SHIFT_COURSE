package org.example;

import java.util.ArrayList;
import java.util.List;

public class Config {

    private final String integerOutputFile = "integers.txt";
    private final String floatOutputFile = "floats.txt";
    private final String stringOutputFile = "strings.txt";

    private List<String> inputFileNameList = new ArrayList<>();

    private String pathOutputDir = "";

    private String prefixOutputFiles = "";

    private boolean isAddingFile = false;

    private boolean isFullStatistic = false;

    public Config(List<String> inputFileNameList,
                  String pathOutputFiles,
                  String prefixOutputFiles,
                  boolean isAddingFile,
                  boolean isFullStatistic) {
        this.inputFileNameList = inputFileNameList;
        this.pathOutputDir = pathOutputFiles;
        this.prefixOutputFiles = prefixOutputFiles;
        this.isAddingFile = isAddingFile;
        this.isFullStatistic = isFullStatistic;
    }
    public Config(){

    }
    public List<String> getInputFileNameList() {
        return inputFileNameList;
    }

    public void setInputFileNameList(List<String> inputFileNameList) {
        this.inputFileNameList = inputFileNameList;
    }

    public String getPathOutputDir() {
        return pathOutputDir;
    }

    public void setPathOutputDir(String pathOutputDir) {
        this.pathOutputDir = pathOutputDir;
    }

    public String getPrefixOutputFiles() {
        return prefixOutputFiles;
    }

    public void setPrefixOutputFiles(String prefixOutputFiles) {
        this.prefixOutputFiles = prefixOutputFiles;
    }

    public boolean isAddingFile() {
        return isAddingFile;
    }

    public void setAddingFile(boolean addingFile) {
        isAddingFile = addingFile;
    }

    public boolean isFullStatistic() {
        return isFullStatistic;
    }

    public void setFullStatistic(boolean fullStatistic) {
        isFullStatistic = fullStatistic;
    }

    public String getIntegerOutputFile() {
        return integerOutputFile;
    }

    public String getFloatOutputFile() {
        return floatOutputFile;
    }

    public String getStringOutputFile() {
        return stringOutputFile;
    }


    public String toString(){
        return "pathOutputDir = "+ pathOutputDir+
                ", prefixOutputFiles = "+ prefixOutputFiles+
                ", isAddingFile = "+ isAddingFile+
                ", isFullStatistic = "+ isFullStatistic+
                ", inputFileNameList = "+inputFileNameList;

    }
}
