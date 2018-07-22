package info.duhovniy;

import info.duhovniy.data.Student;
import info.duhovniy.service.Group;
import info.duhovniy.utils.Utils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Введите количество студентов в группе: ");
        int numberOfStudents = sc.nextInt();

        System.out.print("Введите название группы: ");
        String groupName = sc.next();

        Group group = Utils.createGroup(numberOfStudents, groupName);
        System.out.println("\nСоздана новая группа студентов: \n" + group);

        System.out.println("Проводим выборы стартосты группы " + group.getName());
        long leaderId = Utils.leaderElection(group);
        group.setLeader(leaderId);
        System.out.println("Выбран новый староста группы: " + group.get(leaderId).orElse(new Student(-1, "N/A", "N/A", 0, true)));

        System.out.println("\nПроводим перекличку группы: " + group.getName());
        int attendeesNumber = group.startNextClass();
        System.out.println("В перекличке участвовало " + attendeesNumber + " человек");
        group.printPresents();
    }


}
