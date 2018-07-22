package info.duhovniy.data;

public class Student {

    private final long id;
    private final String firstName, lastName;
    private final int rating;
    private boolean leader;

    public Student(long id, String firstName, String lastName, int rating, boolean leader) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.leader = leader;
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
