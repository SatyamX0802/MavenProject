package com.example.HibernateProject;

import com.example.HibernateProject.entities.Students;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Services s = new Services();
        
        Students st = new Students();
        st.setName("Mohan");
        st.setAge(20);
        st.setAddress("Chandigarh University, Mohali, Punjab");
        
        s.saveData(st);
        s.getStudents(1);
    }
}
