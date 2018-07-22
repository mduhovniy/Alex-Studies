package info.duhovniy.service;

import info.duhovniy.data.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Group {

    private final int studentCount;
    private final List<Student> students;
    private final String name;

    public Group(int studentCount, String name) {
        this.studentCount = studentCount;
        this.students = new ArrayList<>(studentCount);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int size() {
        return this.studentCount;
    }

    public void add(Student student) {
        this.students.add(student);
    }

    public Optional<Student> get(long id) {
        return this.students.stream().filter(s -> s.getId() == id).findFirst();
    }

    public void setLeader(long id) {
        for(Student student : this.students) {
            if(student.getId() == id) {
                student.setLeader(true);
            } else {
                student.setLeader(false);
            }
        }
    }

    public int startNextClass() {
        int attendeesNumber = 0;
        Random rnd = new Random();
        for(Student student : this.students) {
            boolean isAttend = rnd.nextBoolean();
            student.setPresent(isAttend);
            if(isAttend) attendeesNumber++;
        }
        return attendeesNumber;
    }

    public void printPresents() {

        System.out.println("Сегодня в группе " + this.name + " присутствуют:");
        int count = 0;
        for(Student student : this.students) {
            if(student.isPresent()) {
                System.out.println(student);
                count++;
            }
        }
        System.out.println("Итого " + count + " человек из " + size() + " в группе " + this.name + " присутствуют");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Группа " + name + " из " + size() + " человек:\n");
        for(Student student : this.students) {
            sb.append(student).append("\n");
        }
        return sb.toString();
    }
}
