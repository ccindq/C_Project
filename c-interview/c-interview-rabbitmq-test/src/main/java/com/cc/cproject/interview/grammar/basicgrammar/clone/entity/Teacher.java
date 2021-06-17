package com.cc.cproject.interview.grammar.basicgrammar.clone.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author changcheng
 * @since 2021-04-29 10:39
 */
@Data
public class Teacher implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private Integer age;

    private String name;
}
