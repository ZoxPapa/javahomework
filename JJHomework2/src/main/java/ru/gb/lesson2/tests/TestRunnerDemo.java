package ru.gb.lesson2.tests;

import java.lang.reflect.InvocationTargetException;

public class TestRunnerDemo {

  // private никому не видно
  // default (package-private) внутри пакета
  // protected внутри пакета + наследники
  // public всем

  public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
    TestRunner.run(TestRunnerDemo.class);
  }

  @BeforeAll
  void test10(){
    System.out.println("BeforeAll1");
  }
  @BeforeAll
  void test11(){
    System.out.println("BeforeAll2");
  }
  @BeforeAll
  void test12(){
    System.out.println("BeforeAll3");
  }
  @BeforeEach
  void test21(){
    System.out.println("BeforeEach1");
  }
  @BeforeEach
  void test22(){
    System.out.println("BeforeEach2");
  }
  @BeforeEach
  void test23(){
    System.out.println("BeforeEach3");
  }
  @AfterEach
  void test31(){
    System.out.println("AfterEach1");
  }
  @AfterEach
  void test32(){
    System.out.println("AfterEach2");
  }
  @AfterEach
  void test33(){
    System.out.println("AfterEach3");
  }
  @AfterAll
  void test41(){
    System.out.println("AfterAll1");
  }
  @AfterAll
  void test42(){
    System.out.println("AfterAll2");
  }
  @AfterAll
  void test43(){
    System.out.println("AfterAll3");
  }
  @Test
  void test1() {
    System.out.println("test1");
  }

  @Test
  void test2() {
    System.out.println("test2");
  }

  @Test
  void test3() {
    System.out.println("test3");
  }

}
