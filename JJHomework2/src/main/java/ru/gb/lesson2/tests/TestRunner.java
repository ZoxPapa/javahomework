package ru.gb.lesson2.tests;

//import java.lang.reflect.AccessFlag;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;


public class TestRunner {

  public static void run(Class<?> testClass) throws InvocationTargetException, IllegalAccessException {
    final Object testObj = initTestObj(testClass);
    List<Method> beforeEachTestsList = new ArrayList<>();
    List<Method> afterEachTestsList = new ArrayList<>();
    for (Method testMethod : testClass.getDeclaredMethods()) {
      if (testMethod.getModifiers()== Modifier.PRIVATE) {
        continue;
      }

      if(testMethod.getAnnotation(BeforeAll.class) != null) testMethod.invoke(testObj);
      else if (testMethod.getAnnotation(BeforeEach.class) != null){
        beforeEachTestsList.add(testMethod);
      }
      else if (testMethod.getAnnotation(AfterEach.class) != null){
        afterEachTestsList.add(testMethod);
      }
      else if (testMethod.getAnnotation(Test.class) != null) {
        executeListOfMethods(beforeEachTestsList, testMethod);
        testMethod.invoke(testObj);
        executeListOfMethods(afterEachTestsList, testMethod);
      }
      else if(testMethod.getAnnotation(AfterAll.class) != null) testMethod.invoke(testObj);
    }
  }


  private static void executeListOfMethods(List<Method> methodList, Method testMethod){
    for(Method method: methodList){
      try {
        method.invoke(testMethod);
      } catch (IllegalAccessException | InvocationTargetException e2){
        e2.printStackTrace();
      }
    }
  }
  private static Object initTestObj(Class<?> testClass) {
    try {
      Constructor<?> noArgsConstructor = testClass.getConstructor();
      return noArgsConstructor.newInstance();
    } catch (NoSuchMethodException e) {
      throw new RuntimeException("Нет конструктора по умолчанию");
    } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
      throw new RuntimeException("Не удалось создать объект тест класса");
    }
  }

}
