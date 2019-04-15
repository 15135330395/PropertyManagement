package com.java;/*
 * @author :张
 * Date  : 2019/4/15
 * @Description: JavaWork
 */

public class JavaWork {
   private Tester tester;

   public void setTester(Tester tester){
       this.tester=tester;
   }

    public void doTest(){
      //业务操作时，对象之间的耦合性高。

//        ZhangSan zhangSan=new ZhangSan();
//        zhangSan.test();
       /*
       Tester tester=new Tester() {
            @Override
            public void test() {

            }
        }*/

       tester.test();

    }

}
