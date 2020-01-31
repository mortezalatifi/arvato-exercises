package com.arvato.exercise.latifi.exerciseOne;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h1>Working with files</h1>
 * The FileService is a service class to work with files.
 * Now it has only one method that converts a file to a list of lines
 */
@Service
public class FileService {

    /**
     * This method is used to convert a file to a list of file lines.
     * First it creates a list to store the lines of the file.
     * Then it simply opens and reads a file line by line using a scanner and adds ech line to
     * the list in a while loop. Finally it returns the list.
     * @param filePath
     * @return list
     * @throws FileNotFoundException
     */
    public List<String> convertToList(String filePath) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filePath));
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        scanner.close();
        return list;
    }

}
