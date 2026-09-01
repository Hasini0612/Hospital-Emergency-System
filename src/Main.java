import java.util.Scanner;

public class Main {
    static PatientBST bst = new PatientBST();
    static EmergencyQueue queue = new EmergencyQueue();
    static TreatmentStack stack = new TreatmentStack();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Mini Hospital Emergency Management System ===");
            System.out.println("1. Register new patient (BST insert)");
            System.out.println("2. Search patient by ID");
            System.out.println("3. Delete patient");
            System.out.println("4. Display all patients (in-order)");
            System.out.println("5. Add patient to emergency queue");
            System.out.println("6. Treat next patient (dequeue + push to treatment history)");
            System.out.println("7. Display waiting queue");
            System.out.println("8. Display treatment history (stack)");
            System.out.println("9. Add visit to patient history");
            System.out.println("10. Display patient visit history");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Patient ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt(); sc.nextLine();
                    System.out.print("Contact Number: ");
                    String contact = sc.nextLine();
                    System.out.print("Medical Condition: ");
                    String condition = sc.nextLine();
                    Patient p = new Patient(id, name, age, contact, condition);
                    bst.insert(p);
                    System.out.println("Patient registered successfully.");
                    break;
                }
                case 2: {
                    System.out.print("Enter Patient ID to search: ");
                    int id = sc.nextInt();
                    Patient p = bst.search(id);
                    System.out.println(p != null ? p : "Patient not found.");
                    break;
                }
                case 3: {
                    System.out.print("Enter Patient ID to delete: ");
                    int id = sc.nextInt();
                    bst.delete(id);
                    System.out.println("Patient deleted (if existed).");
                    break;
                }
                case 4:
                    bst.inOrderDisplay();
                    break;
                case 5: {
                    System.out.print("Enter Patient ID to add to queue: ");
                    int id = sc.nextInt();
                    Patient p = bst.search(id);
                    if (p != null) queue.enqueue(p);
                    else System.out.println("Patient not found — register them first.");
                    break;
                }
                case 6: {
                    Patient treated = queue.dequeue();
                    if (treated != null) {
                        System.out.println("Now treating: " + treated);
                        stack.push("Patient " + treated.patientId + " (" + treated.name + ") treated for: " + treated.medicalCondition);
                    }
                    break;
                }
                case 7:
                    queue.displayQueue();
                    break;
                case 8:
                    stack.displayStack();
                    break;
                case 9: {
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    Patient p = bst.search(id);
                    if (p == null) { System.out.println("Patient not found."); break; }
                    System.out.print("Visit ID: ");
                    int vid = sc.nextInt(); sc.nextLine();
                    System.out.print("Visit Date: ");
                    String date = sc.nextLine();
                    System.out.print("Doctor Name: ");
                    String doctor = sc.nextLine();
                    System.out.print("Diagnosis: ");
                    String diagnosis = sc.nextLine();
                    System.out.print("Treatment: ");
                    String treatment = sc.nextLine();
                    p.visitHistory.addVisit(new Visit(vid, date, doctor, diagnosis, treatment));
                    break;
                }
                case 10: {
                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    Patient p = bst.search(id);
                    if (p != null) p.visitHistory.displayVisits();
                    else System.out.println("Patient not found.");
                    break;
                }
                case 0:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 0);
    }
}