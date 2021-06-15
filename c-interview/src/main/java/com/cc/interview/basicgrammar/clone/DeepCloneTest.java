package com.cc.interview.basicgrammar.clone;


import com.cc.interview.basicgrammar.clone.entity.Student;
import com.cc.interview.basicgrammar.clone.entity.Teacher;

import java.io.IOException;

/**
 * @author changcheng
 * @since 2021-04-29 10:46
 */
public class DeepCloneTest {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Teacher teacher=new Teacher();
        teacher.setAge(88);
        teacher.setName("changcheng");


        Student student=new Student();
        student.setAge(18);
        student.setName("sunyimeng");
        student.setTeacher(teacher);

        Student student1=student.deepClone();

        System.out.println(student1);

        student.setName("我还是那个学生");
        teacher.setName("我还是那个老师");
        System.out.println(student1);
        System.out.println(student);
    }

}
