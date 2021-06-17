package com.cc.cproject.interview.grammar.basicgrammar.clone;


import com.cc.cproject.interview.grammar.basicgrammar.clone.entity.Student;
import com.cc.cproject.interview.grammar.basicgrammar.clone.entity.Teacher;

/**
 * @author changcheng
 * @since 2021-04-29 10:46
 */
public class ShallownCloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher=new Teacher();
        teacher.setAge(88);
        teacher.setName("changcheng");


        Student student=new Student();
        student.setAge(18);
        student.setName("sunyimeng");
        student.setTeacher(teacher);

        Student student1=(Student) student.clone();

        System.out.println(student1);

        student.setName("我还是那个学生");
        teacher.setName("我还是那个老师");
        System.out.println(student1);
        System.out.println(student);
    }
}
