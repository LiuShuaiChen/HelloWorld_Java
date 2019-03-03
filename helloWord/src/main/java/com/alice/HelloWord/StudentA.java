package com.alice.HelloWord;

public class StudentA {

    private StudentB studentB;

    public StudentA(StudentB studentB) {
        System.out.println("com.alice.HelloWord.StudentA.StudentA(com.alice.HelloWord.StudentB)");
        this.studentB = studentB;
    }

    public StudentA() {
        this(new StudentB());
    }
}
