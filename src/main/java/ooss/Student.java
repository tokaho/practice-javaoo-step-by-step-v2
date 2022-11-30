package ooss;

public class Student extends Person{
    private Klass klass=null;
    public Student(int id, String name, int age){
        super(id,name,age);
    }

    public String introduce(){
        return super.introduce()+" I am a student."+
                    (this.klass!=null?
                            String.format(" I am in class %d.",this.klass.getNumber()): //true
                            "" //else
                    );
    }

    public void join(Klass klass){
        this.klass=klass;
    }

    public boolean isIn(Klass klass){
        return klass.equals(this.klass);
    }
}
