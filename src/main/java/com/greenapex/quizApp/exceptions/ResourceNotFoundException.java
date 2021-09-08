package com.greenapex.quizApp.exceptions;

public class ResourceNotFoundException extends RuntimeException {
   public ResourceNotFoundException() {
       super("ID doesn't exist. Input valid ID");
   }
   public ResourceNotFoundException(String message) {
       super(message);
   }


}
