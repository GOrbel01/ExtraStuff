package com.george.concurrency.mockquestion;

/**
 * Created by Cloud on 08/06/2015.
 */
public class Queue {
    private QueueNode head, tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    public synchronized void enqueue(Object ob) {
        QueueNode n = new QueueNode(ob);
        if (tail == null) {
            head = n;
            tail = n;
        }
        else {
            QueueNode oldTail = tail;
            tail = n;
            oldTail.setLink(n);
        }
        notifyAll();
    }

    public synchronized Object dequeue() throws InterruptedException {
        while (head == null) {
            wait();
        }
        Object ob = head.Ob();
        head = head.getPrev();
        return ob;
    }
}

class QueueNode {
    private Object ob;
    private QueueNode prev;

    public QueueNode(Object o) {
        ob = o;
    }

    public QueueNode(Object o, QueueNode n) {
        ob = o;
        prev = n;
    }

    public Object Ob() {
        return ob;
    }

    public QueueNode getPrev() {
        return prev;
    }

    public void setLink(QueueNode n) {
        prev = n;
    }
}