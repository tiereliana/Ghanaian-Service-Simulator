public class CorrectionDeque {
    private Request[] data;
    private int front;
    private int rear;
    private int size;

    public CorrectionDeque(int capacity) {
        data = new Request[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        // TODO 13: Return true when size equals capacity.
        return size == data.length;
    }

    public boolean isEmpty() {
        // TODO 14: Return true when size is zero.
        return size == 0;
    }

    public boolean addRear(Request request) {
        // TODO 15: Add a normal correction request to the rear using modulo arithmetic.
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % data.length;
        data[rear] = request;
        size++;
        return true;
    }

    public boolean addFront(Request request) {
        // TODO 16: Add a corrected urgent request to the front using modulo arithmetic.
        // Hint: front = (front - 1 + data.length) % data.length
        if (isFull()) {
            return false;
        }
        front = (front - 1 + data.length) % data.length;
        data[front] = request;
        size++;
        return true;
    }

    public Request removeFront() {
        // TODO 17: Remove and return the front request.
        if (isEmpty()) {
            return null;
        }
        Request item = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return item;
    }

    public Request removeRear() {
        // TODO 18: Remove and return the rear request.
        if (isEmpty()) {
            return null;
        }
        Request item = data[rear];
        data[rear] = null;
        rear = (rear - 1 + data.length) % data.length;
        size--;
        return item;
    }

    public int size() {
        return size;
    }

    public int frontIndex() {
        return front;
    }

    public int rearIndex() {
        return rear;
    }
}
