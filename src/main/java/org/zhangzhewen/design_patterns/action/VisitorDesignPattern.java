package org.zhangzhewen.design_patterns.action;

import java.util.ArrayList;
import java.util.List;

public class VisitorDesignPattern {
    public static void main(String[] args) {
        VisitorDesignPattern v = new VisitorDesignPattern();
        List<Animal> list = new ArrayList();
        list.add(v.new Cat());
        list.add(v.new Dog());
        list.add(v.new Monkey());
        Visitor visitor = v.new Visitor();
        for(Animal a : list){
            a.accept(visitor);
        }
    }
    class Visitor{
        void visitCat(Cat c){
            System.out.println("Visiting "+c.getCatName());
        }
        void visitDog(Dog c){
            System.out.println("Visiting "+c.getDogName());
        }
        void visitMonkey(Monkey c){
            System.out.println("Visiting "+c.getMonkeyName());
        }
    }
    interface Animal{
        void accept(Visitor v);
    }
    class Cat implements Animal{
        public String getCatName() {
            return "Cat";
        }
        @Override
        public void accept(Visitor v) {
            v.visitCat(this);
        }
    }
    class Dog implements Animal{
        public String getDogName() {
            return "Dog";
        }
        @Override
        public void accept(Visitor v) {
            v.visitDog(this);
        }
    }
    class Monkey implements Animal{
        public String getMonkeyName() {
            return "Monkey";
        }
        @Override
        public void accept(Visitor v) {
            v.visitMonkey(this);
        }
    }
}

