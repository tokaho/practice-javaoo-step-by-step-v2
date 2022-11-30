package ooss;

public class Person {
    private final int id;
    private final String name;
    private final int age;
    private final String title;

    //for backward capability (Step 2 and before)
    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.title = null;
    }

    public Person(int id, String name, int age, String title) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.title = title;
    }

    public String introduce() {
        return String.format("My name is %s. I am %d years old.", this.name, this.age);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id == person.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public void replyToNewJoiner(Student leader, Klass klass) {
        System.out.println(String.format("I am %s, %s of Class %d. I know %s become Leader.",
                this.getName(),
                this.title,
                klass.getNumber(),
                leader.getName()
        ));
    }
}

