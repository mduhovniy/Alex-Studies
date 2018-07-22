package info.duhovniy.utils;

import info.duhovniy.data.Student;
import info.duhovniy.service.Group;

import java.util.Scanner;

public class Utils {


    public static Group createGroup(int numberOfStudents, String name) {

        Group group = new Group(numberOfStudents, name);
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < numberOfStudents; i++) {

            int numberForConsole = i + 1;
            String firstName;
            String lastName;
            int rating = 0;

            System.out.print("Введите имя студента №" + numberForConsole + ": ");
            firstName = checkName(sc.next());

            sc.nextLine();

            System.out.print("Введите фамилию студента № " + numberForConsole + ": ");
            lastName = checkName(sc.nextLine());

            while(!isRatingCorrect(rating)) {
                System.out.print("Введите рейтинг (от 1 до 10 в целых числах) студента № " + numberForConsole + ": ");
                rating = sc.nextInt();
            }

            group.add(new Student(numberForConsole, firstName, lastName, rating, false));
        }

        return group;
    }

    public static long leaderElection(Group group) {
        int maxRating = 0;
        int leaderIndex = 0;
        for(int i = 0; i < group.size(); i++) {
            if(maxRating < group.get(i).map(Student::getRating).orElse(0)) {
                maxRating = group.get(i).map(Student::getRating).orElse(0);
                leaderIndex = i;
            }
        }
        return leaderIndex;
    }

    private static String checkName(String name) {
        if(name.isEmpty()) return "N/A";
        return name;
    }

    private static boolean isRatingCorrect(int rating) {
        return rating > 0 && rating < 11;
    }
}
