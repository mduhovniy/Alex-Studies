package info.duhovniy.data;

public class Student {

    private final long id;
    private final String firstName, lastName;
    private final int rating;
    private boolean leader;
    private boolean present;

    public Student(long id, String firstName, String lastName, int rating, boolean leader) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.leader = leader;
        this.present = false;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getRating() {
        return rating;
    }

    public boolean isLeader() {
        return leader;
    }

    public void setLeader(boolean leader) {
        this.leader = leader;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    @Override
    public String toString() {
        return "Студент:{" +
                " №" + id + " " +
                ", Имя=" + firstName + " " +
                ", Фамилия=" + lastName + " " +
                ", Рейтинг=" + rating + " " +
                ", Староста=" + leader +
                '}';
    }
}
