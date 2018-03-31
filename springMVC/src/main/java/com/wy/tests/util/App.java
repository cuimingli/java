package com.wy.tests.util;

public class App {
    public static void main(String args[]){
     String a = Base64.getBase64("cuimingli123456");
     System.out.println(a);

     String b = Base64.getFromBase64(a);
     System.out.println(b);


    }
}
