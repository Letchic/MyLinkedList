package com.letchik.main;

import com.letchik.linkedlistinterface.ILinkedList;
import com.letchik.linlkedlist.MyLinkedList;
import com.letchik.testClasses.shapes.MyPoint;
import com.letchik.testClasses.shapes.MyTriangle;


import java.util.LinkedList;
import java.util.List;

public class MainClass {
    static int amountOfRepeat = 10000;
    static ILinkedList<MyTriangle> myLinkedList = new MyLinkedList<>();
    static List<MyTriangle> customLinkedList = new LinkedList<>();
    static long timeOfMyList;
    static long timeOfCustomList;
    static MyTriangle triangle = new MyTriangle(new MyPoint(0,0),new MyPoint(1,2),new MyPoint(2,0));
    static MyTriangle anotherTriangle = new MyTriangle(new MyPoint(0,1),new MyPoint(2,5),new MyPoint(4,1));
    public static void main(String[] args) {
        testAdd();
        testAddByIndex();
        testGetByIndex();
        testSet();
        testIndexOf();
        testToArray();
        testToArrayAnotherType();
        testClear();

        myLinkedList.add(triangle);
        myLinkedList.add(anotherTriangle);
        System.out.println(myLinkedList);
        customLinkedList.add(triangle);
        customLinkedList.add(anotherTriangle);
        System.out.println(customLinkedList);

    }

    public static void testAdd(){
        timeOfMyList = System.nanoTime();
        for (int i = 0; i < amountOfRepeat; i++) {
            myLinkedList.add(triangle);
        }
        timeOfMyList = System.nanoTime() - timeOfMyList;

        timeOfCustomList = System.nanoTime();
        for (int i = 0; i < amountOfRepeat; i++) {
            customLinkedList.add(triangle);
        }
        timeOfCustomList = System.nanoTime() - timeOfCustomList;
        System.out.println("Test add(E element)");
        System.out.println("timeOfMyList "+timeOfMyList/1000000+" ms");
        System.out.println("timeOfCustomList "+timeOfCustomList/1000000+" ms");
        System.out.println();
    }

    public static void testAddByIndex(){
        timeOfMyList = System.nanoTime();
        for (int i = 0; i < amountOfRepeat; i++) {
            myLinkedList.add(i/2,triangle);
        }
        timeOfMyList = System.nanoTime() - timeOfMyList;

        timeOfCustomList = System.nanoTime();
        for (int i = 0; i < amountOfRepeat; i++) {
            customLinkedList.add(i/2,triangle);
        }
        timeOfCustomList = System.nanoTime() - timeOfCustomList;
        System.out.println("Test add(int index, E element)");
        System.out.println("timeOfMyList "+timeOfMyList/1000000+" ms");
        System.out.println("timeOfCustomList "+timeOfCustomList/1000000+" ms");
        System.out.println();
    }

    public static void testClear(){
        timeOfMyList = System.nanoTime();
        myLinkedList.clear();
        timeOfMyList = System.nanoTime() - timeOfMyList;

        timeOfCustomList = System.nanoTime();
        customLinkedList.clear();
        timeOfCustomList = System.nanoTime() - timeOfCustomList;
        System.out.println("Test clear");
        System.out.println("timeOfMyList "+timeOfMyList+" ns");
        System.out.println("timeOfCustomList "+timeOfCustomList+" ns");
        System.out.println();
    }


    public static void testGetByIndex(){
        timeOfMyList = System.nanoTime();
        for (int i = 0; i < amountOfRepeat; i++) {
            myLinkedList.get((int)(Math.random()*amountOfRepeat));
        }
        timeOfMyList = System.nanoTime() - timeOfMyList;

        timeOfCustomList = System.nanoTime();
        for (int i = 0; i < amountOfRepeat; i++) {
            customLinkedList.get((int)(Math.random()*amountOfRepeat));
        }
        timeOfCustomList = System.nanoTime() - timeOfCustomList;
        System.out.println("Test get");
        System.out.println("timeOfMyList "+timeOfMyList/1000000+" ms");
        System.out.println("timeOfCustomList "+timeOfCustomList/1000000+" ms");
        System.out.println();
    }

    public static void testSet(){
        timeOfMyList = System.nanoTime();
        myLinkedList.set(10000,anotherTriangle);
        timeOfMyList = System.nanoTime() - timeOfMyList;

        timeOfCustomList = System.nanoTime();
        customLinkedList.set(10000,anotherTriangle);
        timeOfCustomList = System.nanoTime() - timeOfCustomList;

        System.out.println("Test set");
        System.out.println("timeOfMyList "+timeOfMyList+" ns");
        System.out.println("timeOfCustomList "+timeOfCustomList+" ns");
        System.out.println();
    }

    public static void testIndexOf(){
        timeOfMyList = System.nanoTime();
        myLinkedList.indexOf(anotherTriangle);
        timeOfMyList = System.nanoTime() - timeOfMyList;

        timeOfCustomList = System.nanoTime();
        customLinkedList.indexOf(anotherTriangle);
        timeOfCustomList = System.nanoTime() - timeOfCustomList;

        System.out.println("Test IndexOf");
        System.out.println("timeOfMyList "+timeOfMyList+" ns");
        System.out.println("timeOfCustomList "+timeOfCustomList+" ns");
        System.out.println();
    }

    public static void testToArray(){
        Object[] obj;
        timeOfMyList = System.nanoTime();
        obj= myLinkedList.toArray();
        timeOfMyList = System.nanoTime() - timeOfMyList;

        timeOfCustomList = System.nanoTime();
        obj=  customLinkedList.toArray();
        timeOfCustomList = System.nanoTime() - timeOfCustomList;

        System.out.println("Test ToArray");
        System.out.println("timeOfMyList "+timeOfMyList/1000+" microseconds");
        System.out.println("timeOfCustomList "+timeOfCustomList/1000+" microseconds");
        System.out.println();
    }

    public static void testToArrayAnotherType(){
        Object[] obj= new Object[myLinkedList.size()];
        timeOfMyList = System.nanoTime();
        myLinkedList.toArray(obj);
        timeOfMyList = System.nanoTime() - timeOfMyList;

        timeOfCustomList = System.nanoTime();
        obj=  customLinkedList.toArray(obj);
        timeOfCustomList = System.nanoTime() - timeOfCustomList;

        System.out.println("Test toArray(T[] a)");
        System.out.println("timeOfMyList "+timeOfMyList/1000+" microseconds");
        System.out.println("timeOfCustomList "+timeOfCustomList/1000+" microseconds");
        System.out.println();
    }


}
