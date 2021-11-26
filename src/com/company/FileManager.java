package com.company;

import rzp.oop.filesystem.FileSystem;
import rzp.oop.filesystem.FileSystemExtra;

import java.io.*;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager implements FileSystem{



    @Override
    public void createFile(String fileName, String text) {

        File file = new File(fileName);

        if (!file.exists()) {

            try {
                FileWriter fileWriter = new FileWriter(file, false);
                fileWriter.write(text);
                fileWriter.flush();
                fileWriter.close();
                System.out.println("File created...");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File exists!!!");
        }

    }

    @Override
    public String readFile(String fileName) {

        StringBuilder stringBuilder = new StringBuilder();

            try {
                int sym;
                FileReader fileReader = new FileReader(fileName);
                while ((sym = fileReader.read()) != -1) {
                    stringBuilder.append((char) sym);
                }

                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }



        return stringBuilder.toString();
    }

    @Override
    public void deleteFile(String fileName) {

            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            } else System.out.println("File exists!");


    }

    @Override
    public void moveFile(String oldFileName, String newFileName) {

            createFile(newFileName, readFile(oldFileName));
            deleteFile(oldFileName);


    }

    @Override
    public List<String> searchFiles(String fileNamePart) {

        File folder = new File(".");
        List<String> result = new ArrayList<>();

        for (String f : Objects.requireNonNull(folder.list())) {
            if (Pattern.matches(".*" + fileNamePart + ".*", f)) {
                result.add(f);
            }

        }
        return result;
    }

    @Override
    public void changeFile(String fileName, String newText) {

            writeInFile(fileName, newText, false);
    }

    @Override
    public void appendFile(String fileName, String appendText) {


            writeInFile(fileName, appendText, true);

    }


    private void writeInFile(String filename, String text, Boolean appendMode) {
        File file = new File(filename);

        if (!file.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(file, appendMode);
                fileWriter.write(text);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

