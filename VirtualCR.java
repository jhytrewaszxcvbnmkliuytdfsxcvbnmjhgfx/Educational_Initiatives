import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VirtualClassroomManager {
    private static final Logger LOGGER = Logger.getLogger(VirtualClassroomManager.class.getName());

    private Map<String, Classroom> classrooms;

    public VirtualClassroomManager() {
        classrooms = new HashMap<>();
    }

    public void addClassroom(String name) {
        classrooms.put(name, new Classroom(name));
        LOGGER.log(Level.INFO, "Classroom {0} has been created.", name);
    }

    // ...

    public void submitAssignment(String studentId, String className, String assignmentDetails) {
        if (classrooms.containsKey(className)) {
            Classroom classroom = classrooms.get(className);
            try {
                boolean success = classroom.submitAssignment(studentId, assignmentDetails);
                if (success) {
                    LOGGER.log(Level.INFO, "Assignment submitted by Student {0} in {1}.", new Object[]{studentId, className});
                } else {
                    LOGGER.log(Level.WARNING, "Student {0} not found in {1}.", new Object[]{studentId, className});
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "An error occurred while submitting the assignment.", e);
            }
        } else {
            LOGGER.log(Level.WARNING, "Classroom {0} not found.", className);
        }
    }

    private class Classroom {
        // ...

        public boolean submitAssignment(String studentId, String assignmentDetails) throws Exception {
            if (students.contains(studentId)) {
                // Submit the assignment
                return true;
            } else {
                throw new Exception("Student not found.");
            }
        }
    }
}
