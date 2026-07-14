public class ActionStack {
    private ActionRecord[] data;
    private int top;

    public ActionStack(int capacity) {
        data = new ActionRecord[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        // TODO 9: Return true when top is -1.
        return top == -1;
    }

    public boolean push(ActionRecord action) {
        // TODO 10: Push action if there is space; return false if stack is full.
        if (top + 1 >= data.length) {
            return false;
        }
        top++;
        data[top] = action;
        return true;
    }

    public ActionRecord pop() {
        // TODO 11: Remove and return the most recent action; return null if empty.
        if (isEmpty()) {
            return null;
        }
        ActionRecord item = data[top];
        data[top] = null;
        top--;
        return item;
    }

    public ActionRecord peek() {
        // TODO 12: Return the top action without removing it.
        if (isEmpty()) {
            return null;
        }
        return data[top];
    }

    public int size() {
        return top + 1;
    }
}
