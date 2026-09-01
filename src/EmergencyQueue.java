public class EmergencyQueue {
    private class QNode {
        Patient patient;
        QNode next;
        QNode(Patient patient) { this.patient = patient; }
    }

    private QNode front, rear;
    private int size = 0;

    public void enqueue(Patient patient) {
        QNode newNode = new QNode(patient);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println(patient.name + " added to waiting queue.");
    }

    public Patient dequeue() {
        if (front == null) {
            System.out.println("Queue is empty — no patients waiting.");
            return null;
        }
        Patient p = front.patient;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return p;
    }

    public void displayQueue() {
        if (front == null) {
            System.out.println("No patients currently waiting.");
            return;
        }
        QNode current = front;
        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
    }

    public boolean isEmpty() { return front == null; }
    public int getSize() { return size; }
}