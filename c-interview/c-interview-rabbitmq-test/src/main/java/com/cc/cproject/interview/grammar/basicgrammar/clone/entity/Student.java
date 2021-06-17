package com.cc.cproject.interview.grammar.basicgrammar.clone.entity;

import lombok.Data;

import java.io.*;

/**
 * @author changcheng
 * @since 2021-04-29 10:37
 */
@Data
public class Student implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private Integer age;

    private String name;

    private Teacher teacher;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Student deepClone() throws IOException, ClassNotFoundException {
        Student student = null;
        //将对象序列化成流，因为写在流里的是对象的一个拷贝，而源对象仍然存在于JVM中
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);
        //将流序列化成对象
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        student = (Student) ois.readObject();
        return student;
    }
}
