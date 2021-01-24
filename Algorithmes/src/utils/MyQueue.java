package utils;

public class MyQueue {

    private int [] arr;
    private int size = 10;
    private int head; //
    private int tail; //
    private int count;

    public MyQueue() {
        arr = new int[size];
        head = 0;
        tail = -1;
        count = 0;
    }

    public void insert(int v){
        if (tail == size -1){
            tail = -1;
        }

        arr[++tail] = v;
        count++;
    }

    public int remove(){
        if(head == size){
            head = 0;
        }

        count --;
        return arr[head++];
    }

    public boolean isEmpty(){
        return count == 0;
    }
}
