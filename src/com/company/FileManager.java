package com.company;

import rzp.oop.filesystem.FileSystem;
import rzp.oop.filesystem.FileSystemExtra;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class FileManager implements FileSystem, FileSystemExtra {

    private final HashMap<String, String> fileSystem = new HashMap<>();


    @Override
    public void createFile(String fileName, String text) {

        fileSystem.put(fileName, text);

    }

    @Override
    public String readFile(String fileName) {


        return fileSystem.getOrDefault(fileName, null);

    }

    @Override
    public void deleteFile(String fileName) {

        fileSystem.remove(fileName);

    }

    @Override
    public void moveFile(String oldFileName, String newFileName) {


        createFile(newFileName, fileSystem.get(oldFileName));
        deleteFile(oldFileName);

    }

    @Override
    public List<String> searchFiles(String fileNamePart) {

        List<String> result = new ArrayList<>();
        Set<String> keys = fileSystem.keySet();

        for (String k: keys)
        {
            if (k.contains(fileNamePart))
            {
                result.add(k);
            }
        }

        return result;

    }

    @Override
    public void changeFile(String fileName, String newText) {

       fileSystem.put(fileName, newText);
    }

    @Override
    public void appendFile(String fileName, String appendText) {

        String oldText = fileSystem.get(fileName);
        fileSystem.put(fileName, oldText + appendText);

    }


    @Override
    public void setWritable(String fileName, boolean writable) {

    }

    @Override
    public void setReadable(String fileName, boolean readable) {

    }
}

