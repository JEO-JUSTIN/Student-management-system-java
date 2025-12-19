import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean ctl=true;
        Services.get();
        while (ctl) {
            System.out.println();System.out.println();
            System.out.println("Enter 1 to create\nEnter 2 to update\nEnter 3 to display\nEnter 4 to delete\nEnter 5 to Commit");
            Scanner sc = new Scanner(System.in);
            int value=sc.nextInt();
            sc.nextLine();
            switch (value) {
                case 1:
                    Student student =new Student();
                    System.out.print("Enter the Roll no:");
                    student.RollNo=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the name:");
                    student.Name=sc.nextLine();
                    System.out.print("Enter the Age:");
                    student.Age=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the phone:");
                    student.PhoneNo=sc.nextLine();
                    Services.create(student);
                    break;
                case 2:
                    System.out.print("Enter the roll number:");
                    String roll = sc.nextLine();
                    Services.update(roll);   
                    break;
                case 3:    
                    Services.display(); 
                    break;
                case 4:
                    System.out.print("Enter the roll number:");
                    String roll1 = sc.nextLine();
                    Services.delete(roll1);
                    break;
                case 5:
                    System.out.print("Enter y/n to commit");
                    String commitctl = sc.nextLine();
                    if (commitctl.equals("y")){
                        Services.commit();
                    }
                    else if (commitctl.equals("n")){
                        System.out.println("Commit not done");
                    }
                    else{
                        System.out.println("Unknown input");
                    }
                    break;
                default:
                    
                    ctl=false;
                    break;
            }
        }
    }
}
