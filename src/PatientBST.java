public class PatientBST {
    private Node root;

    private class Node {
        Patient patient;
        Node left, right;
        Node(Patient patient) { this.patient = patient; }
    }

    // INSERT a new patient
    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }
    private Node insertRec(Node node, Patient patient) {
        if (node == null) return new Node(patient);
        if (patient.patientId < node.patient.patientId)
            node.left = insertRec(node.left, patient);
        else if (patient.patientId > node.patient.patientId)
            node.right = insertRec(node.right, patient);
        else
            System.out.println("Patient ID already exists!");
        return node;
    }

    // SEARCH for a patient by ID
    public Patient search(int id) {
        Node current = root;
        while (current != null) {
            if (id == current.patient.patientId) return current.patient;
            current = (id < current.patient.patientId) ? current.left : current.right;
        }
        return null;
    }

    // DELETE a patient by ID
    public void delete(int id) {
        root = deleteRec(root, id);
    }
    private Node deleteRec(Node node, int id) {
        if (node == null) return null;
        if (id < node.patient.patientId) {
            node.left = deleteRec(node.left, id);
        } else if (id > node.patient.patientId) {
            node.right = deleteRec(node.right, id);
        } else {
            // Case 1: no children, or Case 2: one child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            // Case 3: two children -> find smallest in right subtree (successor)
            Node successor = findMin(node.right);
            node.patient = successor.patient;
            node.right = deleteRec(node.right, successor.patient.patientId);
        }
        return node;
    }
    private Node findMin(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // IN-ORDER TRAVERSAL - displays patients in ascending order of ID
    public void inOrderDisplay() {
        if (root == null) {
            System.out.println("No patients registered yet.");
            return;
        }
        inOrderRec(root);
    }
    private void inOrderRec(Node node) {
        if (node == null) return;
        inOrderRec(node.left);
        System.out.println(node.patient);
        inOrderRec(node.right);
    }
}