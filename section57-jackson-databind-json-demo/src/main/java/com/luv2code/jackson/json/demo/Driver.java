package com.luv2code.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {

        try{

            // create object mapper
            ObjectMapper mapper = new ObjectMapper();

            // read JSON file and map/convert to Java POJO:
            // data/sample-lite.json
            Student student = mapper.readValue(
                    new File("/home/ann/IdeaProjects/Spring-Hibernate-udemy/section57-jackson-databind-json-demo/data/sample-full.json"),Student.class);

            // print first name and last name;
            System.out.println("First name = " + student.getFirstName());
            System.out.println("Last name = " + student.getLastName());

            // print out address
            Address address = student.getAddress();

            System.out.println("Street = " + address.getStreet());
            System.out.println("City = " + address.getCity());

            // print out languages
            for (String langauge:student.getLanguages()){
                System.out.println(langauge);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
