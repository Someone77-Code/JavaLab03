package Data.TestObjects;

public class Student {
    String Name;
    int age;
    float ProgrammingMark;
    float Average;

    public Student(String name, int age, float programmingMark, float average) {
        Name = name;
        this.age = age;
        ProgrammingMark = programmingMark;
        Average = average;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

    public float getProgrammingMark() {
        return ProgrammingMark;
    }

    public float getAverage() {
        return Average;
    }
}
