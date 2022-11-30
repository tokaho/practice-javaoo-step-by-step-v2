package ooss;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Person> announceList;

    public Klass(int number) {
        this.number = number;
        this.announceList = new ArrayList<Person>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Klass klass = (Klass) o;

        return number == klass.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    public int getNumber() {
        return number;
    }

    public void assignLeader(Student leader) {
        if (!leader.isIn(this)) {
            System.out.println("It is not one of us.");
            return;
        }

        this.leader = leader;
        this.announceList.stream()
//               .filter(person->!(person.equals(leader)))
                .forEachOrdered(person -> person.replyToNewJoiner(leader, this));
    }

    public boolean isLeader(Student student) {
        return student.equals(this.leader);
    }

    public void attach(Person person) {
        this.announceList.add(person);
    }
}
