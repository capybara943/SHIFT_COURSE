package org.example;

@FunctionalInterface
public interface ParserCommandLine {

    public Config parse(String[] args);
}
