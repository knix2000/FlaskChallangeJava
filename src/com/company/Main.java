package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main
{
    public static void main(String[] args)
    {
        Node startNode=new Node(null, 0, 0);

        Queue<Node> Q=new LinkedList<>();
        Q.add(startNode);

        var lkjsdf=getChildNodes(Q, false);

        if(lkjsdf==true)
        {
            System.out.println("Success!!!!!111!!!");
        }
    }

    public static boolean getChildNodes(Queue<Node> Q, boolean success)
    {
        if(success)
        {
            return success;
        }
        if(Q.size()<=0)
        {
            return success;
        }
        Node parent=Q.remove();

        System.out.println();
        System.out.println(parent.getBig() + ", " + parent.getSmall());

        int goal=4;
        if(parent.getSmall()==goal || parent.getBig()==goal)
        {
            success=true;
            return success;
        }

        if(parent.getBig()==5)
        {
            //var emptyBig=
            Q.add(new Node(parent, 0, parent.getSmall()));
            System.out.print("0,"+ parent.getSmall()+"  ");
        }
        if(parent.getBig()==0)
        {
            var fillBig =new Node(parent, 5, parent.getSmall());
            Q.add(fillBig);
            System.out.print("5,"+ parent.getSmall() +"  ");
        }
        if(parent.getSmall()==3)
        {
            // emptySmall=
            Q.add(new Node(parent, parent.getBig(), 0));
            System.out.print(parent.getBig() +",0  ");
        }
        if(parent.getSmall()==0)
        {
            // fillSmall =
            Q.add(new Node(parent, parent.getBig(), 3));
            System.out.print(parent.getBig() +",3  ");
        }
        //pour small to big
        int totalContent=parent.getBig()+parent.getSmall();
        if(totalContent>5)
        {
            // pourS2b=
            Q.add(new Node(parent, 5, totalContent-5));
            System.out.print("5," + (totalContent-5) +"  ");
        }
        else if(totalContent>0)
        {
            // pourS2b=
            Q.add(new Node(parent, totalContent, 0));
            System.out.print(totalContent+ ",0  ");
        }

        //pour big to small
        if(totalContent>3)
        {
            // pourS2b=
            Q.add(new Node(parent, totalContent-3, 3));
            System.out.print((totalContent-3) +",3  ");
        }
        else if(totalContent>0)
        {
            // pourS2b=
            Q.add(new Node(parent, 0, totalContent));
            System.out.print("0," + totalContent +"  ");
        }

        getChildNodes(Q, success);

        return success;
    }
}

class Node
{
    private Node _parentNode;
    private int _contentBig;
    private int _contentSmall;

    public int getBig()
    {
        return _contentBig;
    }
    public int getSmall()
    {
        return _contentSmall;
    }

    public Node(Node parentNode, int contentBig, int contentSmall)
    {
        _contentBig=contentBig;
        _contentSmall=contentSmall;
        _parentNode=parentNode;
    }
}

