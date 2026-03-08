package Week_11_12.Assignment;

public class ArrayQueue {
    static final int SIZE = 5;
    int[] queue = new int[SIZE];
    int front = -1, rear = -1;
    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        if (isEmpty()) front = 0;
        rear++;
        queue[rear] = value;
        System.out.println("Enqueued: " + value);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return;
        }
        System.out.println("Dequeued: " + queue[front]);
        front++;
        if (front > rear) {
            front = rear = -1;
        }
    }

    public void peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No front element.");
        } else {
            System.out.println("Front element: " + queue[front]);
        }
    }

    public boolean isFull() {
        return rear == SIZE - 1;
    }

    public boolean isEmpty() {
        return front == -1 || front > rear;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.peek();
        q.dequeue();
        q.display();
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }
}