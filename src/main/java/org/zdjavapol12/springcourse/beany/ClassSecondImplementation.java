package org.zdjavapol12.springcourse.beany;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component
//@Primary
public class ClassSecondImplementation implements ClassInterface {

    @Override
    public void stuff() {
        System.out.println("Jestem druga implementacja");
    }
}
