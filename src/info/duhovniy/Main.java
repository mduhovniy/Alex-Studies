package info.duhovniy;

import info.duhovniy.data.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Введите количество студентов в группе: ");
        Scanner sc = new Scanner(System.in);
        int numberOfStudents = sc.nextInt();
        List<Student> group = new ArrayList<>(numberOfStudents);

        for (int i = 0; i < numberOfStudents; i++) {

            int numberForConsole = i + 1;
            String firstName;
            String lastName;
            int rating;
            System.out.print("Введите имя студента № " + numberForConsole);

            firstName = sc.next();

            sc.nextLine();
            System.out.print("Введите фамилию студента № " + numberForConsole);

            lastName = sc.nextLine();
            System.out.print("Введите рейтинг (от 1 до 10 в целых числах) студента № " + numberForConsole);

            rating = sc.nextInt();
            group.add(new Student(numberForConsole, firstName, lastName, rating, false));
        }

        System.out.println("Группа студентов: " + group);

        int maxRating = 0;
        int leaderIndex = 0;
        for(int i = 0; i < numberOfStudents; i++) {
            if(maxRating < group.get(i).getRating()) {
                maxRating = group.get(i).getRating();
                leaderIndex = i;
            }
        }
        group.get(leaderIndex).setLeader(true);
        System.out.println("Староста группы: " + group.get(leaderIndex));

        Random rnd = new Random();
        for(Student student : group) {
            student.setPresent(rnd.nextBoolean());
        }

        printPresents(group);
    }

    private static void printPresents(List<Student> group) {

        System.out.println("Сегодня присутствуют:");
        for(Student student : group) {
            if(student.isPresent()) {
                System.out.println(student);
            }
        }
    }
}
