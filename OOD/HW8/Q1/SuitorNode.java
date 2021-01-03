package com.company;

public class SuitorNode {
    private int num = 0;
    private SuitorNode next = null;

    public SuitorNode(int num){
        this.num = num;
    }
    public int getNum(){
        return num;
    }
    public SuitorNode getNext(){
        return next;
    }
    public void setNext(SuitorNode nextN) {
        this.next = nextN;
    }
    
}

