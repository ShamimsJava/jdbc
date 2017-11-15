package test;

import com.shamim.jdbc.domain.Student;
import com.shamim.jdbc.service.StudentService;
import java.util.List;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        StudentService studentService = new StudentService();
//        Student std1 = new Student(1001, "shamim");
//        Student std2 = new Student(1002, "shohan");
//        Student std3 = new Student(1003, "urmi");
//        Student std4 = new Student(1004, "ruhul");
//        Student std5 = new Student(1005, "atik");
//        
//        studentService.save(std1);
//        studentService.save(std2);
//        studentService.save(std3);
//        studentService.save(std4);
//        studentService.save(std5);

        //Student std1 = new Student(1001, "Upoma");
        //studentService.update(std1);
        //studentService.delete(1001);
//        studentService.save(new Student(1001, "Upoma"));
//        studentService.save(new Student(1006, "Tripti"));
//        studentService.save(new Student(1007, "Puja"));
//        studentService.save(new Student(1008, "Kotha"));
//        studentService.save(new Student(1009, "Khadija"));
//        studentService.save(new Student(1010, "Shihab"));
//        studentService.save(new Student(1011, "Megha"));
//        studentService.save(new Student(1012, "Samia"));
        List<Student> list = studentService.getStudents();
        System.out.println("Id        Name");
        System.out.println("------------------");
        for(Student s : list){
            System.out.println(s.getId()+"      "+s.getStudentName());   
        }
//        while (true) {
//            Scanner sc = new Scanner(System.in);
//            System.out.print("Please insert student id: ");
//            int x = sc.nextInt();
//            if(x != 0){
//            Student s = studentService.getStudent(x);
//            System.out.println("Student Name: " + s.getStudentName());   
//            }else{
//                break;
//            }
//        }
        

    }
}
