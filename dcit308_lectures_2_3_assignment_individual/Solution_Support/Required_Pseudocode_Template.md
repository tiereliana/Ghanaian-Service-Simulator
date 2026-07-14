# Required Pseudocode Template

Students must include these algorithms in their report and adapt them to their own implementation.

## enqueueCircular(request)
IF circularQueue is full THEN
    record overflow
    RETURN false
END IF
rear = (rear + 1) MOD capacity
data[rear] = request
size = size + 1
RETURN true

## dequeueCircular()
IF circularQueue is empty THEN
    RETURN null
END IF
request = data[front]
data[front] = null
front = (front + 1) MOD capacity
size = size - 1
RETURN request

## admitRequest(request)
IF request.needsCorrection THEN
    add request to correctionDeque
ELSE IF request.urgencyLevel >= 4 THEN
    add request to urgentPriorityQueue
ELSE
    add request to normalCircularQueue
END IF
record successful admission on action stack

## serveNextRequest()
IF urgentPriorityQueue is not empty THEN
    serve highest priority request
ELSE IF correctionDeque is not empty THEN
    serve from front of correctionDeque
ELSE IF normalCircularQueue is not empty THEN
    serve from normalCircularQueue
ELSE
    return null
END IF
record service action on action stack
update report counters

## undoLastAction()
lastAction = actionStack.pop()
IF lastAction is null THEN return
IF lastAction.type is SERVE THEN
    re-admit the served request
ELSE
    reverse the admission if your implementation supports exact removal
END IF
