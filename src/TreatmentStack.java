public class TreatmentStack {
    private class SNode {
        String record;
        SNode next;
        SNode(String record) { this.record = record; }
    }

    private SNode top;

    public void push(String record) {
        SNode newNode = new SNode(record);
        newNode.next = top;
        top = newNode;
        System.out.println("Treatment record added: " + record);
    }

    public String pop() {
        if (top == null) {
            System.out.println("No treatment records to remove.");
            return null;
        }
        String record = top.record;
        top = top.next;
        return record;
    }

    public void displayStack() {
        if (top == null) {
            System.out.println("No treatment records yet.");
            return;
        }
        SNode current = top;
        while (current != null) {
            System.out.println(current.record);
            current = current.next;
        }
    }

    public boolean isEmpty() { return top == null; }
}