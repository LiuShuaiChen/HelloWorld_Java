package com.alice.HelloWord;

public class StudentC {

    private StudentA studentA;

    public StudentC(StudentA studentA) {
        System.out.println("com.alice.HelloWord.StudentC.StudentC(com.alice.HelloWord.StudentA)");
        this.studentA = studentA;
    }

    public StudentC() {
        this(new StudentA());
    }
}
