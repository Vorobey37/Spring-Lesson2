package ru.gb.SpringHomeWork2;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class StudentRepository {
    private final List<Group> list;


    public StudentRepository() {
        list = new ArrayList<>();
        Group group1 = new Group("Програмисты");
        Group group2 = new Group("Тестировщики");
        group1.addStudent(new Student("Алексей"));
        group1.addStudent(new Student("Татьяна"));
        group2.addStudent(new Student("Евгения"));
        group2.addStudent(new Student("Артем"));
        group2.addStudent(new Student("Наташа"));
        list.add(group1);
        list.add(group2);

    }

    public Student getStudentById(long id) {
        for (Group group : list) {
            for (Student student : group.getStudents()) {
                if (student.getId() == id){
                    return student;
                }
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        for (Group group : list) {
            students = Stream.concat(group.getStudents().stream(), students.stream())
                    .toList();
        }
        return students;
    }

    public Student getStudentByName(String name){
        for (Group group : list) {
            for (Student student : group.getStudents()) {
                if (student.getName().equals(name)){
                    return student;
                }
            }
        }
        return null;
    }

    public List<Student> getStudentsByGroupName(String nameGroup){
        List<Student> students = new ArrayList<>();
        students = getAllStudents().stream()
                .filter(e -> e.getGroupName().equals(nameGroup))
                .toList();
        return students;
    }
}
