// Students Result Management System
import java.util.Scanner;
public class SRMS{
    
        static String[] name = new String[100];
        static int[] marks = new int[100];
        static int count = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Sort by Marks");
            System.out.println("4. Show Topper");
            System.out.println("5. Show Average Marks");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch(choice){
                case 1 -> addStudent(sc);
                case 2 -> displayStudents();
                case 3 -> sortByMarks();
                case 4 -> showTopper();
                case 5 -> showAverageMarks();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }while(choice != 6);
        sc.close();
    }
    public static void addStudent(Scanner sc){
        if(count >= 100){
            System.out.println("Cannot add more students. Maximum limit reached.");
            return;
        }
        System.out.println("Enter Student Name: ");
        name[count] = sc.nextLine();
        System.out.println(" Enter Students Marks:");
        marks[count] = sc.nextInt();
        count++;
        System.out.println("Student added successfully.");
    }
    public static void displayStudents(){
        if(count ==0){
            System.out.println("No students is Added. ");
            return;
        }
        System.out.println("Students List: ");
        for(int i=0; i< count; i++){
            System.out.println((i+1) + "." + name[i] + "-" + marks[i]+ " Marks"); ;
        }
    }
    public static void sortByMarks(){   // Bubble Sort
        for(int i = 0; i< count -1;i++){
            for(int j =0; j<= count -i-1; j++){
                if(marks[j] < marks[j+1]){
                    int temp = marks[j];
                    marks[j] = marks[j+1];
                    marks[j+1] = temp;

                    String tempName = name[j];
                    name[j] = name[j+1];
                    name[j+1] = tempName;
                }
            }
        }
        System.out.println("Students sorted by marks in descending order.");
    }
    public static void showTopper(){
        int topIndex = 0;
        for(int i=1; i<count; i++){
            if(marks[i] > marks[topIndex]){
                topIndex = i;
            }
        }
        System.out.println("Topper: " + name[topIndex] + " with " + marks[topIndex] + " Marks");
    }
    public static void showAverageMarks(){
        if(count == 0){
            System.out.println("No students added.");
            return;
        }
        int sum = 0;
        for(int i=0; i<count; i++){
            sum += marks[i];
        }
        double avg = (double) sum / count;
        System.out.println("Average Marks: " + avg);
    }
    
 

}