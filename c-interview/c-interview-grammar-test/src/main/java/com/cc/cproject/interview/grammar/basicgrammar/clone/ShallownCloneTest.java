package com.cc.cproject.interview.grammar.basicgrammar.clone;


import com.cc.cproject.interview.grammar.basicgrammar.clone.entity.Student;
import com.cc.cproject.interview.grammar.basicgrammar.clone.entity.Teacher;

/**
 * @author changcheng
 * @since 2021-04-29 10:46
 */
public class ShallownCloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher();
        teacher.setAge(88);
        teacher.setName("老师");


        Student student1 = new Student();
        student1.setAge(18);
        student1.setName("学生");
        student1.setTeacher(teacher);

        System.out.println("student1:" + student1);

        Student student2 = (Student) student1.clone();

        System.out.println("student2:" + student2);

        student1.setName("我还是那个学生");
        teacher.setName("我还是那个老师");

        System.out.println("student1:" + student1);
        System.out.println("student2:" + student2);
    }
}
