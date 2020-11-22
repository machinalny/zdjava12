package org.zdjavapol12.springcourse.exception;

public class WrongPageException extends RuntimeException {
    public WrongPageException(String message){
        super(message);
    }
}
