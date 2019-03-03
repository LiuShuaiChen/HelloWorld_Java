package com.alice.HelloWord;

public class StudentB {

    private StudentC studentC;

    public StudentB(StudentC studentC) {
        System.out.println("com.alice.HelloWord.StudentB.StudentB(com.alice.HelloWord.StudentC)");
        this.studentC = studentC;
    }

    public StudentB() {
        this(new StudentC());
    }
}
