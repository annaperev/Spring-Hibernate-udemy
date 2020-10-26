package com.luv2code.springdemo.javacodeconfiginjectvalues;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class RandomFromFileFortuneService implements FortuneService {

    private String fileName = "src/fortune-data.txt";
    private List<String> theFortunes;

    private Random random = new Random();

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">> RandomFromFileFortuneService: inside of doMyStartupStuff method ");

        File theFile = new File(fileName);

        System.out.println("Reading fortunes from file: " + theFile);
        System.out.println("File exists: " + theFile.exists());

        theFortunes = new ArrayList<String>();

        // read fortunes from file
        try (BufferedReader br = new BufferedReader(
                new FileReader(theFile))) {

            String tempLine;

            while ((tempLine = br.readLine()) != null) {
                theFortunes.add(tempLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFortune() {
        int index = random.nextInt(theFortunes.size());

        String fortune = theFortunes.get(index);
        return fortune;
    }
}
