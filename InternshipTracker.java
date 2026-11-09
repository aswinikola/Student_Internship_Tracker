
import java.util.ArrayList;
import java.util.Scanner;

class Internship {
    int id;
    String company;
    String role;
    String date;
    String status;
    String duration;
    String learning;

    Internship(int id, String company, String role, String date) {
        this.id = id;
        this.company = company;
        this.role = role;
        this.date = date;
        this.status = "Applied";
    }

    void display() {
        System.out.println("\nID: " + id);
        System.out.println("Company: " + company);
        System.out.println("Role: " + role);
        System.out.println("Application Date: " + date);
        System.out.println("Status: " + status);

        if (status.equals("Internship Completed")) {
            System.out.println("Duration: " + duration);
            System.out.println("Learning: " + learning);
        }
    }
}

public class InternshipTracker {

    static ArrayList<Internship> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextId = 1;

    static Internship find(int id) {
        for (Internship i : list) {
            if (i.id == id)
                return i;
        }
        return null;
    }

    static void addApplication() {
        System.out.print("Company Name: ");
        String company = sc.nextLine();

        System.out.print("Internship Role: ");
        String role = sc.nextLine();

        System.out.print("Application Date: ");
        String date = sc.nextLine();

        list.add(new Internship(nextId++, company, role, date));

        System.out.println("Application added successfully!");
    }

    static void viewApplications() {
        if (list.isEmpty()) {
            System.out.println("No applications found.");
            return;
        }

        for (Internship i : list) {
            i.display();
        }
    }

    static void editApplication() {
        System.out.print("Enter Application ID: ");
        int id = Integer.parseInt(sc.nextLine());

        Internship i = find(id);

        if (i == null) {
            System.out.println("Application not found.");
            return;
        }

        System.out.print("New Company Name: ");
        i.company = sc.nextLine();

        System.out.print("New Role: ");
        i.role = sc.nextLine();

        System.out.print("New Application Date: ");
        i.date = sc.nextLine();

        System.out.println("Application updated!");
    }

    static void deleteApplication() {
        System.out.print("Enter Application ID: ");
        int id = Integer.parseInt(sc.nextLine());

        Internship i = find(id);

        if (i != null) {
            list.remove(i);
            System.out.println("Application deleted!");
        } else {
            System.out.println("Application not found.");
        }
    }

    static void updateStatus() {
        System.out.print("Enter Application ID: ");
        int id = Integer.parseInt(sc.nextLine());

        Internship i = find(id);

        if (i == null) {
            System.out.println("Application not found.");
            return;
        }

        System.out.println("1. Applied");
        System.out.println("2. Selected");
        System.out.println("3. Rejected");
        System.out.println("4. Internship Completed");

        System.out.print("Choose Status: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                i.status = "Applied";
                break;
            case 2:
                i.status = "Selected";
                break;
            case 3:
                i.status = "Rejected";
                break;
            case 4:
                System.out.print("Enter Internship Duration: ");
                i.duration = sc.nextLine();

                System.out.print("What did you learn? ");
                i.learning = sc.nextLine();

                if (i.duration.trim().isEmpty() ||
                    i.learning.trim().isEmpty()) {
                    System.out.println("Both fields are required!");
                    return;
                }

                i.status = "Internship Completed";
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("Status updated successfully!");
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== INTERNSHIP TRACKER =====");
            System.out.println("1. Add Application");
            System.out.println("2. View Applications");
            System.out.println("3. Edit Application");
            System.out.println("4. Delete Application");
            System.out.println("5. Update Status");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addApplication();
                    break;
                case 2:
                    viewApplications();
                    break;
                case 3:
                    editApplication();
                    break;
                case 4:
                    deleteApplication();
                    break;
                case 5:
                    updateStatus();
                    break;
                case 6:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
