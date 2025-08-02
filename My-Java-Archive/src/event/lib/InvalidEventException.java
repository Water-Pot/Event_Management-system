package event.lib;

public class InvalidEventException
        extends Exception {
 public InvalidEventException(String id) {
           super(String.format("Event with id:{%s} is not a valid Event.", new Object[] { id }));
         }
    }

