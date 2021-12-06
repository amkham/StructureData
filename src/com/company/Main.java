package com.company;

public class Main {

    public static void main(String[] args) {
	FileManager fileManager = new FileManager();
    fileManager.createFile("test", "sdsdgsgd");
    System.out.println(fileManager.readFile("test2"));
    }
}
