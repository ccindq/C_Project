package com.cc.cproject.interview.grammar.basicgrammar.enums;

public class TestEnum {

    public static void main(String[] args) {
        System.out.println(TypeEnumA.Type.name());
        System.out.println(TypeEnumA.TypeA);
        System.out.println(TypeEnumA.values());
        System.out.println(TypeEnumA.valueOf("TypeA"));
    }
}
