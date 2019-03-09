package com.annotation.training;

@Immutable
public class AnnotationTest {

    private int nb;

    @ClassCreator()
    public AnnotationTest() {
        super();
    }

    @ClassCreator("Professeur")
    public void Method() {
    }

}
