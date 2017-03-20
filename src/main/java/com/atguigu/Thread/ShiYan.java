package com.atguigu.Thread;

public class ShiYan {
    public static void main(String[] args)
    {
            Methods m = new Methods();
            m.Out1(5);
            m.Out1("haha", 5);
            
    }

}

class Methods
{
    public final void Out1(int x )
    {
            System.out.println("Out1 number is "+x);
    }
    public void Out1(String s,int x )
    {
            System.out.println("Out2 number is "+x+";String is "+s);
    }
    
}