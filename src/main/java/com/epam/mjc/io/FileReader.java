package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileReader {



    public static Profile getDataFromFile(File file) {

        String line;
        Map<String, String> profile = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] keyValue = line.split(": ");
                profile.put(keyValue[0], keyValue[1]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profile(profile.get("Name"), Integer.parseInt(profile.get("Age")), profile.get("Email"), Long.parseLong(profile.get("Phone")));
    }
}
