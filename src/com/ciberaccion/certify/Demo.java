package com.ciberaccion.certify;

public class Demo implements Runnable{
    private Thread t;
    private String threadName;

    Demo(String threadName){
        this.threadName = threadName;
    }

    public static void main(String[] args) {
        Demo A = new Demo("A");
        Demo B = new Demo("B");
        B.start();
        A.start();

    }

    @Override
    public void run() {
        while (true)
            System.out.println(threadName);
    }

    public void start(){
        if (t==null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}
