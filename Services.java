import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Services {
    static ArrayList<String> table = new ArrayList<String>();
    static HashSet<String> set= new HashSet<String>();
    public static void get(){
        try{
            BufferedReader buffer = new BufferedReader(new FileReader("Student.txt"));
            String line;
            while ((line=buffer.readLine())!=null) {
                String[] t=line.split(",");
                set.add(t[0]);
                table.add(line);
            }
            buffer.close();
        }
        catch(Exception e){

        }
    }
    public static void create(Student student){
        if (set.contains((String.valueOf(student.RollNo)))){
            System.out.println("Cannot be create Dupicate found");
            return;
        }
        table.add(student.RollNo+","+student.Name+","+student.Age+","+student.PhoneNo);

    }
    public static void display(){
        
        for (String line:table){
            System.out.println(line.replace(",", "\t"));
        }
    }

    public static void update(String roll){
        for (int i=0;i<table.size();i++){
            String line=table.get(i);
            String splited[] = line.split(",");
            if (splited[0].equals(roll)){
                
                System.out.println("Found the List \nEnter 1 to change Name\nEnter 2 to change Age\nEnter 3 to change Phone Number\nEnter:");
                int val;
                Scanner sc =new Scanner(System.in);
                val=sc.nextInt();
                sc.nextLine();
                String[] temp =line.split(",");
                switch (val) {
                    case 1:
                        System.out.println("Enter Name :");
                        temp[1]=sc.nextLine();
                        break;
                    case 2:
                        System.out.println("Enter Age :");
                        temp[2]=sc.nextLine();
                        break;
                    case 3:
                        System.out.println("Enter Phone :");
                        temp[3]=sc.nextLine();
                        break;
                    default:
                        break;
                }
                String t="";
                t = t + temp[0]+",";
                t = t + temp[1]+",";
                t = t + temp[2]+",";
                t = t + temp[3];

                table.set(i,t);
                return;
            }
        }
    }
    public static void delete(String roll){
        for (int i=0;i<table.size();i++){
            String line=table.get(i);
            String t[] = line.split(",");

            if (t[0].equals(roll)){
                table.remove(i);
                System.out.println("Deleted the list");
                return;
            }
        }
    }
    public static void commit(){
        try{
            BufferedWriter buffer =new BufferedWriter(new FileWriter("Student.txt"));
            for (String line: table) {
                buffer.write(line);
                buffer.newLine();
            }
            buffer.close();
        }
        catch (Exception e){
            System.err.println(e);
        }
    }
}