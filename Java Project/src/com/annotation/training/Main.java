package com.annotation.training;

@Immutable
public class Main {

    public static void main(String[] args) {

        @ClassCreator("Eleve")
        AnnotationTest ele = new AnnotationTest();
        //MutableClass m = new MutableClass("salut");
        //ele.Method();

    }

    public static void tester() {
        System.out.println("test");
    }

    public static void manger() { System.out.println("miam");}
}
