//Create a Java program to serialize and deserialize a Student object. The program should                                                                         Serialize a Student object (containing id, name, and GPA) and save it to a file.                                                                               Deserialize the object from the file and display the student details.                                                                                               Handle FileNotFoundException, IOException, and ClassNotFoundException using exception handling.

//CODE:
import java.io.Serializable;
public class Student implements Serializable
{
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    float GPA;
    public Student(int id,String name, float GPA)
    {
        this.id= id;
        this.name = name;
        this.GPA= GPA;
    }
    public int getID() 
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public float getGPA()
    {
        return GPA;
    }
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", GPA=" + GPA + "]";
    }
}
import java.io.*;
public class Serialization {
    public static void main(String[] args) {
        Student s = new Student(17013,"Saurabh", 8.5f);
        String filename = "student.ser";
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(s);
            out.close();  
            fileOut.close(); 
            System.out.println("Student object has been serialized and saved to " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
                                                                    // Deserialization (read object from file)
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Student deserializedStudent = (Student) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Student object has been deserialized: " + deserializedStudent);
        } catch (FileNotFoundException e) {
            System.out.println("File not found during deserialization: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
