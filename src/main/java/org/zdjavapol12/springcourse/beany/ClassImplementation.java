package org.zdjavapol12.springcourse.beany;

import org.springframework.stereotype.Component;

//@Component
public class ClassImplementation implements ClassInterface{
    @Override
    public void stuff() {
        System.out.println("Jestem pierwsza implementacja interfejsu");
    }
}
