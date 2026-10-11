// TODO 1: Change the HashMap import into a tree map import
import com.sun.source.tree.Tree;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ListManager {

    // TODO 2: Change studentsMap from HashMap to TreeMap
    TreeMap studentsMap = new TreeMap();

    public ListManager(Student [] students){

        for (Student student : students) {
            studentsMap.put(student.lastName, student);
        }
    }
    
    public void listStudents( ) {
        if(studentsMap.isEmpty()){
            System.out.println("The system has no students in the waiting list");
        } else {
            System.out.println("Listing all Students\n");
            Set entries = studentsMap.entrySet();
            for (Object entry : entries) {
                Map.Entry mapEntry = (Map.Entry) entry;
                Student student = (Student)mapEntry.getValue();
                System.out.println(student);
            }
        }

    }

    public void findStudent(String lastName) {
        if(studentsMap.containsKey(lastName)){
            System.out.println("Student Found\n");
            Student student = (Student)studentsMap.get(lastName);
            System.out.println(student);
        }else{
            System.out.println("\nStudent with name '" + lastName + "' Does not exist.");
        }

    }

    public void updateStudentStatus(String lastName, String newStatus){
        Student student = (Student)studentsMap.get(lastName);
        if(student != null){
            String oldStatus = student.status;
            student.status = newStatus;
            studentsMap.put(lastName,student);
            System.out.println();
            System.out.println("Student ("+ lastName +") status was changed from '" + oldStatus + "'' to '" + newStatus + "'");
            System.out.println(student);
        }else {
            System.out.println();
            System.out.println("Student does not exist. Status was not updated.");
        }
    }

    public void removeStudent(String lastName) {
        Student studentRemoved = (Student)studentsMap.remove(lastName);
        if(studentRemoved != null){
            System.out.println();
            System.out.println("Student removed.");
            System.out.println(studentRemoved);
            System.out.println();
        }else{
            System.out.println("Student was not removed.");
        }
    }


public void findFirstStudent(){

    // TODO 3: Get the first Entry in studentsMap
    Map.Entry<String,Student> first = studentsMap.firstEntry();
    Student student = null;
    if(first != null){
        student = (Student)first.getValue();
    }
    /* TODO 4: If the first entry exists, get the Student object
        from the entry */
    if(student!=null){
        System.out.println(student.toString());
        return;
    }
    System.out.println("Student does not exist.");
    // TODO 5: If the Student is not null, print the Student object

    // TODO 6: If the Student is not null, return from the method.

    /* TODO 7: If the first Entry doesn't exist or the Student is
        null, print an error message. */

}

    public void findLastStudent(){

        // TODO 9: Get the last Entry in studentsMap
        Map.Entry<String,Student> last = studentsMap.lastEntry();
        /* TODO 10: If the last entry exists, get the Student object
            from the entry */
        Student student = null;
        if(last != null){
            student = (Student)last.getValue();
        }
    /* TODO 4: If the first entry exists, get the Student object
        from the entry */
        if(student!=null){
            System.out.println(student.toString());
            return;
        }
        System.out.println("Student does not exist.");
        // TODO 11: If the Student is not null, print the Student object

        // TODO 12: If the Student is not null, return from the method.

        /* TODO 13: If the last Entry doesn't exist or the Student is
            null, print an error message. */
    }

    public void findNextStudent(String searchString){
        Map.Entry<String,Student> entry = studentsMap.higherEntry(searchString);
        // TODO 15: Find the higher entry after the searchString
        Student student = null;
        if(entry != null){
            student = (Student)entry.getValue();
        }
        if(student!=null){
            System.out.println(student.toString());
            return;
        }
        System.out.println("Student does not exist.");
        /* TODO 16: If an entry is found, get the Student object
            from the entry */

        // TODO 17: If the student is not null, print the student

        // TODO 18: If the Student is not null, return from the method

        /* TODO 19: If the higher entry is not found or the
            student is null, print "Student not found." */

    }


    public void findPreviousStudent(String searchString) {
        Map.Entry<String,Student> entry = studentsMap.lowerEntry(searchString);
        Student student = null;
        if(entry != null){
            student = (Student)entry.getValue();
        }
        if(student!=null){
            System.out.println(student.toString());
            return;
        }
        System.out.println("Student does not exist.");
        // TODO 22: Find the lower entry before the searchString

        // TODO 23: If an entry is found, get the Student object

        /* TODO 24: If the student is not null, print the student

        /* TODO 25: If the Student is not null, return from the
             method.*/

        /* TODO 26: If the lower entry is not found or the student is
            null, print "Student not found." */
    }
}