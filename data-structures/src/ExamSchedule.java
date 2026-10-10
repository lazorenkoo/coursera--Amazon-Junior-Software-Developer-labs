public class ExamSchedule {
    private ExamNode head;
    private ExamNode current;

    public ExamSchedule() {
        this.head = null;
        this.current = null;
    }

    // TODO 2: Implement logic to add an exam to the end of the linked list
    public void addExam(String examDetails) {
        // YOUR CODE HERE
        ExamNode newExam = new ExamNode(examDetails);
        if(head==null)
        {
            head = newExam;
            current = newExam;
        }
        else {
            ExamNode temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = newExam;
            newExam.prev = temp;


        }
        System.out.println("Exam added" + examDetails);
    }


    // TODO 3: Implement the logic to move to the next exam in the list and displays it
    public void viewNextExam() {
        // YOUR CODE HERE
        if(current==null){
            return;
        }
        System.out.println(current.examDetails);

        if(current.next!=null) {
            current = current.next;
        }
        else System.out.println("Ended");


    }

    // TODO 4: Implement logic to move to the previous exam in the list and display it
    public void viewPreviousExam() {
        // YOUR CODE HERE
        if(current==null){
            return;
        }
        if(current.prev!=null) {
            current = current.prev;
        }
        else System.out.println("Ended");
        System.out.println(current.examDetails);


    }

    public void viewAllExamSchedule() {
        ExamNode temp = head;
        if (temp == null) {
            System.out.println("No exams scheduled.");
        } else {
            System.out.println("Exam Schedule:");
            while (temp != null) {
                System.out.println(temp.examDetails);
                temp = temp.next;
            }
        }
    }
}


