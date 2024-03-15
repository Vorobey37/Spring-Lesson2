package ru.gb.SpringHomeWork2;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ()

public class StudentController {

    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping ("student")
    public List<Student> getAll(){
        return studentRepository.getAllStudents();
    }

    @GetMapping ("student/{id}")
    public Student getById(@PathVariable long id){
        return studentRepository.getStudentById(id);
    }

    @GetMapping ("student/search")
    public Student getByName(@RequestParam String name){
        return studentRepository.getStudentByName(name);
    }

    @GetMapping("group/{groupName}/student")
    public List<Student> getByGroupName(@PathVariable String groupName){
        return studentRepository.getStudentsByGroupName(groupName);
    }
}
