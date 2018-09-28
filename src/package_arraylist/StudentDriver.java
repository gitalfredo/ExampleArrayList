/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package_arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Alfredo
 */

// Model class 
class Student{
    int id;
    String name;
    String[] courses;

    // Constructor initializes Student fields
    public Student(int id, String name, String[] courses) {
        this.id = id;
        this.name = name;
        this.courses = courses;
    }
    
    // Student as a string representation -- id name courses
    @Override
    public String toString(){
        return String.format("%-3d %-10s %-8s  %-8s  %-8s", id, name, courses[0], courses[1], courses[2]);
    }
    
}


public class StudentDriver {
    
    private ArrayList<Student> customers;

    // Constructor
    public StudentDriver() {
        customers = new ArrayList<Student>();    //Initialize list
        
        // Prepare and shuffle ids
        Integer[] arrIds = new Integer[]{1,2,3,4,5,6,7,8,9,10}; // 10 integer objects to shuffle latter
        ArrayList<Integer> rIds = new ArrayList<>();         // Declare list of ids
        rIds.addAll(Arrays.asList(arrIds));                 // Add integers to the list of ids
        
        Collections.shuffle(rIds); // Shuffle list of id numbers
        
        // Prepare and shuffle names 
        String[] arrNames = new String[]{"Lela","Nana","Vicky","Susan","Sarah","Ken","John","Isaiah","Jen","Humbert"};
        ArrayList<String> rNames = new ArrayList<>();   // List of names to be randomized
        rNames.addAll(Arrays.asList(arrNames));         // Add names values in the string array to list of names
        
        Collections.shuffle(rNames); // Shuffle numbers
        
        // Prepare a courses 
        String[][] arrCourses = new String[][]{
            new String[]{"MATH101", "MATH122", "CAP101"},
            new String[]{"COP101", "MATH101", "COP370"},
            new String[]{"COP370", "MATH122", "MATH101"},
            new String[]{"COP101", "COP270", "COP370"},
            new String[]{"COP203", "MATH122", "COP203"},
            new String[]{"PH101", "COP101", "COP203"},
            new String[]{"COP101", "COP101", "COP203"},
            new String[]{"COP101", "PH101", "PH104"},
            new String[]{"ENG101", "MATH122", "COP203"},
            new String[]{"ENG223", "CAP101", "CAP350"}
        };
        
        for (int i = 0; i < 10; i++) {
            customers.add(new Student(rIds.get(i), rNames.get(i), arrCourses[i]));
        }
        
        
        // Sort the entire list by using a comparator for names
        Collections.sort(customers, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        });
    }
    
    public void display(){
        // Print to screen, sorted by name
        System.out.println("Displaying students, sorted by name");
        System.out.println(String.format("%-2s %-8s %s", "Id", "Name", "Courses"));
        for (Student student : customers) {
            System.out.println(student);    //Uses string representation of Student class (toString())
        }
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StudentDriver students = new StudentDriver(); // All initialization occurs in constructor 
        students.display();     // Print to screen
        
    }
    
}
