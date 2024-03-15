package ru.gb.SpringHomeWork2;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
public class Group {
    private final String groupName;
    private List<Student> students;

    public Group(String groupName) {
        this.groupName = groupName;
        students = new ArrayList<>();

    }

    public void addStudent(Student student){
        student.setGroupName(groupName);
        students.add(student);
    }

    public Student getById(long id){
        return students.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Student> getStudents() {
        return students;
    }
}
