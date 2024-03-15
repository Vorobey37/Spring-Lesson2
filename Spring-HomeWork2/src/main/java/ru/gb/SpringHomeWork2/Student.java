package ru.gb.SpringHomeWork2;

import lombok.Data;

@Data
public class Student {
    private static long currentID = 0;
    private final long id;
    private final String name;
    private String groupName;

    public Student(String name) {
        this.id = currentID++;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
