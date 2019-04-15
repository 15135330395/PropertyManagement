package com.spring.test;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: BeanTest
 */

import com.spring.entity.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
      //bean 注入 dog属性的<bean>放在Person<bean>的外部
      Person person1 = applicationContext.getBean("person1", Person.class);
        System.out.println(person1);
//内部bean，  配置dog 的bean放在 Person的属性<property >  中</property>
        Person person2 = applicationContext.getBean("person2", Person.class);
        System.out.println(person2);
//注入null   有什么作用
        Person person3 = applicationContext.getBean("person3", Person.class);
        System.out.println(person3);
//级联注入，必须先创建对象  在Person类中，属性Dog dog=new Dog();
// Exception in thread "main" org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'person4' defined in class path resource
// [bean.xml]: Error setting property values; nested exception is org.springframework.beans.NullValueInNestedPathException: Invalid property 'dog' of bean class [com.spring.entity.Person]: Value of nested property 'dog' is null
        Person person4 = applicationContext.getBean("person4", Person.class);
        System.out.println(person4);

       //集合注入  1.list集合注入   list 集合重复插入可以输出，允许重复，可以通过索引值取到指定元素
        Person person5 = applicationContext.getBean("person5", Person.class);
        System.out.println(person5.getAddr());

        //2.set 集合注入  无序，不重复，无法通过索引值取到指定元素
        Person person6 = applicationContext.getBean("person6", Person.class);
        System.out.println(person6.getLove());

        //3.map集合注入  键值对 方式存在， key值唯一，所以虽然设置了山东-青岛，山东-烟台，但是输出一个山东-烟台，
        Person person7 = applicationContext.getBean("person7", Person.class);
        System.out.println(person7.getAddress());

//properties 属性
        Person person8 = applicationContext.getBean("person8", Person.class);
        System.out.println(person8.getProperties());



    }
}
