package graph;

import utils.MyQueue;
import utils.MyStack;

public class Graph {

    private int maxN = 10; //Макс. кол-во вершин в графе
    private int[][] arr; //Матрица смежности ("1" - есть переход, "0" - нету)
    Vertex[] vertexList; //Список вершин
    public int count; //Счетчик вершин
    private int countN;

    MyStack stack = new MyStack();
    MyQueue queue = new MyQueue();

    public Graph() {
        vertexList = new Vertex[maxN];
        arr = new int[maxN][maxN];
        countN = 0;
    }

    //Добавление вершины
    public void addVertex(char name) {
        vertexList[countN++] = new Vertex(name);
    }

    //Добавление ребра
    public void addEdge(int first, int end) {
        arr[first][end] = 1;
        //arr[end][first] = have;
    }

    //Проверка на непосещенную вершину
    public int check(int v) {
        for (int i = 0; i < countN; i++) {
            if (arr[v][i] == 1 && !vertexList[i].isVisited) {
                return i;
            }
        }
        return -1;
    }

    //Обход в глубину
    public void passInDeep(int index) {
        System.out.println(vertexList[index].name); //Выводим в консоль
        vertexList[index].isVisited = true; //Помечаем, как посещенную
        stack.push(index); //Заносим вершину в стек

        //Пока стек не пустой, то работает
        while (!stack.isEmpty()) {
            int neighbour = check(stack.peek()); // Поиск смежных

            if (neighbour == -1) { // Если не нашел, идем обратно
                count++;
                stack.pop();
            } else { // Если нашел
                count++;
                System.out.println(vertexList[neighbour].name);
                vertexList[neighbour].isVisited = true;
                stack.push(neighbour);
            }
        }

        for (int i = 0; i < countN; i++) {
            vertexList[i].isVisited = false;
        }

    }

    //Обход в ширину
    public void passInWidth(int index) {
        count = 0;
        System.out.println(vertexList[index].name);
        vertexList[index].isVisited = true;
        queue.insert(index);

        int vertex;

        while (!queue.isEmpty()) {
            int temp = queue.remove(); // извлекли помещённую в очередь вершину
            count++;
            while ((vertex = check(temp)) != -1) {
                count++;
                System.out.println(vertexList[vertex].name);
                vertexList[vertex].isVisited = true;
                queue.insert(vertex);
            }

        }
        for (int i = 0; i < countN; i++) {
            vertexList[i].isVisited = false;
        }
    }

    public int getCount() {
        return count;
    }

}
