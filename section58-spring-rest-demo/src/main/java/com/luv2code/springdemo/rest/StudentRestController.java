package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Student;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima","Patel"));
        theStudents.add(new Student("Mario","Rossi"));
        theStudents.add(new Student("Mary","Smith"));
    }


    // define endpoint for "/students" - return list of students

    @GetMapping("/students")
    public List<Student> StudentRestController(){

        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")//path variable and method param should matchup
    public Student getStudent(@PathVariable int studentId){

        // check theStudentId against list size
        if((studentId >= theStudents.size()) || (studentId<0) ) {
            throw new StudentNotFoundException("Student id is not found - " + studentId);
        }

        return theStudents.get(studentId);
    }
}
