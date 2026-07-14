public class CircularQueue {
    private Request[] data;
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int capacity) {
        data = new Request[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        // TODO 1: Return true when size equals the array capacity.
        return size == data.length;
    }

    public boolean isEmpty() {
        // TODO 2: Return true when the queue has no items.
        return size == 0;
    }

    public boolean enqueue(Request request) {
        // TODO 3: If full, return false.
        if (isFull()) {
            return false;
        }
        // TODO 4: Move rear using modulo arithmetic and insert the request.
        // Formula: rear = (rear + 1) % data.length
        rear = (rear + 1) % data.length;
        data[rear] = request;
        // TODO 5: Increase size and return true.
        size++;
        return true;
    }

    public Request dequeue() {
        // TODO 6: If empty, return null.
        if (isEmpty()) {
            return null;
        }
        // TODO 7: Save the front item, clear the old slot, move front using modulo, reduce size and return item.
        Request item = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return item;
    }

    public Request peek() {
        // TODO 8: Return the front request without removing it.
        if (isEmpty()) {
            return null;
        }
        return data[front];
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
