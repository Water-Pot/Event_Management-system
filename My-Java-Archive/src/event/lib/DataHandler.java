//package event.lib;
//
//import java.io.*;
//
//public class DataHandler {
//
//    //public static File dir = new File("C:\\EventPlanner");
//    //public static File fName = new File("C:\\EventPlanner\\EventData.txt");
////    public static File dir = new File("EventPlanner");
////    public static File fName = new File("EventPlanner\\EventData.txt");
//      public static String fName = "EventData.txt";
//    public static void saveData(EventPlanner planner) {
//        try {
////            if (!dir.exists()) {
////                dir.mkdir();
////                System.out.println(dir.getAbsolutePath());
////            }
////            if (!fName.exists()) {
////                fName.createNewFile();
////                System.out.println(fName.getAbsolutePath());
////            }
//            System.out.println("Ok");
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fName));
//            oos.writeObject(planner);
//            oos.close();
//        } catch (Exception e) {
//            System.out.println("Error saving data");
//        }
//    }
//
//    public static EventPlanner loadData() {
//        try {
////            if (!dir.exists()) {
////                dir.mkdir();
////                System.out.println(dir.getAbsolutePath());
////            }
////            if (!fName.exists()) {
////                fName.createNewFile();
////                System.out.println(fName.getAbsolutePath());
////            }
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fName));
//            return (EventPlanner) ois.readObject();
//        } catch (Exception e) {
//            System.out.println("Error loading data");
//        }
//        return null;
//    }
//}


package event.lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataHandler {
    public static String fName = "EventData.txt";

    public DataHandler() {
    }

    public static void saveData(EventPlanner planner) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fName));
        oos.writeObject(planner);
        oos.close();
    }

    public static EventPlanner loadData() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fName));
        return (EventPlanner)ois.readObject();
    }
}
