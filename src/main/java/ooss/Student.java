package ooss;

public class Student extends Person{
    private Klass klass=null;
    public Student(int id, String name, int age){
        super(id,name,age,"student");
    }

    public String introduce(){
        return super.introduce()+" I am a student."+
                    (this.klass!=null?
                            (this.klass.isLeader(this)?
                                    //in class, and is a leader
                                    String.format(" I am the leader of class %d.",this.klass.getNumber()):
                                    //in class, but not a leader
                                    String.format(" I am in class %d.",this.klass.getNumber())):
                            //not in class
                            ""
                    );
    }
    public void join(Klass klass){
        this.klass=klass;
    }

    public boolean isIn(Klass klass){
        return klass.equals(this.klass);
    }


}
