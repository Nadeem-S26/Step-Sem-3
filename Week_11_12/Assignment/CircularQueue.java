package Week_11_12.Assignment;

public class CircularQueue {
    static final int SIZE = 5;
    int[] queue = new int[SIZE];
    int front = -1, rear = -1;
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % SIZE;
        }

        queue[rear] = value;
        System.out.println("Enqueued: " + value);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }

        System.out.println("Dequeued: " + queue[front]);

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % SIZE;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue: ");
        int i = front;
        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) break;
            i = (i + 1) % SIZE;
        }
        System.out.println();
    }

    public boolean isFull() {
        return (rear + 1) % SIZE == front;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue();
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);
        cq.display();
        cq.dequeue();
        cq.dequeue();
        cq.display();
        cq.enqueue(60);
        cq.enqueue(70);
        cq.display();
    }
}
