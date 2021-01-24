package utils;

public class MyStack {
    private int size = 10; //Размер
    private int up; //То, что первым
    private int[] arr;

    public MyStack() {
        arr = new int[size];
        up = -1;
    }

    //Положить в стек вершину
    public void push(int v) {
        arr[++up] = v;
    }

    //Извдечение, но не удаление вершины (трогает)
    public int peek() {
        return arr[up];
    }

    //Удаление вершины из стека
    public int pop() {
        return arr[up--];
    }

    //Проверка на пустоту
    public boolean isEmpty() {
        return up == -1;
    }

}
