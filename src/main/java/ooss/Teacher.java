package ooss;

import java.util.HashSet;
import java.util.stream.Collectors;

public class Teacher extends Person{
    private HashSet<Klass> teachingKlasses =new HashSet<Klass>();
    public Teacher(int id, String name, int age){
        super(id,name,age);
    }

    public String introduce(){
        return super.introduce()+
                " I am a teacher."+
                (!this.teachingKlasses.isEmpty()?
                        //true
                        String.format(" I teach Class %s.",
                                this.teachingKlasses.stream()
                                        .map(k->String.valueOf(k.getNumber()))
                                        .collect(Collectors.joining(", "))
                        ):
                        //else
                        ""
                );
    }
    public void assignTo(Klass klass){
        this.teachingKlasses.add(klass);
    }
    public boolean belongsTo(Klass klass){
        return this.teachingKlasses.contains(klass);
    }

    public boolean isTeaching(Student student){
        return this.teachingKlasses.stream()
                .map(klass-> student.isIn(klass))
                .collect(Collectors.reducing(Boolean.FALSE, Boolean::logicalOr));
    }
}
