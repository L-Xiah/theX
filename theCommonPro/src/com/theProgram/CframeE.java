package com.theProgram;

public class CframeE<E> implements IframeE<E> {

    @Override
    public void method1(E e) {
        System.out.println("---------------" + e.toString());
    }

    @Override
    public void method2(E e) {
        System.out.println("---------------" + e.getClass().getTypeName());
    }

    @Override
    public void method3(E e) {

    }
}
