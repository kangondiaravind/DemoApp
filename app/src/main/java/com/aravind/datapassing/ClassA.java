package com.aravind.datapassing;


//ClassA contains the functionality Logic
public class ClassA {

    private int a = 10;
    private int b = 20;
    private int res =a+b;
    private AddListener listener;

    public ClassA(AddListener listener) {
        this.listener = listener;
        returnValue(res);
    }
    //ClassA sends the result to the class(Activity or Fragment) where the Interface is implemented
    //Here Sending data to ActivityA
    public int returnValue(int res){
        listener.add(res);
        return res;
    }

}
