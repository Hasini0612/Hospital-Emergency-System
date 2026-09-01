public class Patient {
    int patientId;
    String name;
    int age;
    String contactNumber;
    String medicalCondition;
    VisitLinkedList visitHistory; // each patient has their own visit history list

    public Patient(int patientId, String name, int age, String contactNumber, String medicalCondition) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new VisitLinkedList();
    }

    public String toString() {
        return "ID: " + patientId + " | Name: " + name + " | Age: " + age
                + " | Contact: " + contactNumber + " | Condition: " + medicalCondition;
    }
}