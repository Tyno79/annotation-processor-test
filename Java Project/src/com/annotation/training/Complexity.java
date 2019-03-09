package com.annotation.training;

public @interface Complexity {
    ComplexityLevel value() default ComplexityLevel.MEDIUM;

    public enum ComplexityLevel {
        VERY_SIMPLE, SIMPLE, MEDIUM, COMPLEX, VERY_COMPLEX;
    }
}
