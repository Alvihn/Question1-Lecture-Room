package com.mycompany.oopexam;

/**
 *
 * @author Alvihn-PC
 */
import java.util.Scanner;

public class LectureRoomController {
    private final LectureRoom room;
    private final EasyReader reader;

    public LectureRoomController() {
        room = new LectureRoom();
        reader = new EasyReader();
    }

    public void run() {
        while (true) {
            System.out.println("Main Menu:");
            System.out.println("W: Add students to the room");
            System.out.println("X: Remove students from the room");
            System.out.println("Y: Turn on a light");
            System.out.println("Z: Turn off a light");
            System.out.println("Q: Quit");
            System.out.println("S: Show room status");
            System.out.println("L: List lights");
            System.out.print("Enter your choice: ");
            char choice = reader.readChar();

            switch (choice) {
                case 'W' -> addStudents();
                case 'X' -> removeStudents();
                case 'Y' -> turnOnLight();
                case 'Z' -> turnOffLight();
                case 'Q' -> {
                    System.out.println("Goodbye!");
                    return;
                }
                case 'S' -> showRoomStatus();
                case 'L' -> listLights();
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addStudents() {
        System.out.print("Enter the number of students to add: ");
        int numStudents = reader.readInt();
        room.addStudents(numStudents);
        System.out.println("Added " + numStudents + " students to the room.");
    }

    private void removeStudents() {
        System.out.print("Enter the number of students to remove: ");
        int numStudents = reader.readInt();
        room.removeStudents(numStudents);
        System.out.println("Removed " + numStudents + " students from the room.");
    }

    private void turnOnLight() {
        System.out.print("Enter the light number to turn on (1, 2, or 3): ");
        int lightNumber = reader.readInt();
        if (lightNumber >= 1 && lightNumber <= 3) {
            room.turnOnLight(lightNumber);
            System.out.println("Light " + lightNumber + " is now on.");
        } else {
            System.out.println("Invalid light number. Please try again.");
        }
    }

    private void turnOffLight() {
        System.out.print("Enter the light number to turn off (1, 2, or 3): ");
        int lightNumber = reader.readInt();
        if (lightNumber >= 1 && lightNumber <= 3) {
            room.turnOffLight(lightNumber);
            System.out.println("Light " + lightNumber + " is now off.");
        } else {
            System.out.println("Invalid light number. Please try again.");
        }
    }

    private void showRoomStatus() {
        System.out.println("Room Status:");
        System.out.println("Number of students: " + room.getNumberOfStudents());
        System.out.println("Lights: " + room.getLightStatus());
    }

    private void listLights() {
        System.out.println("Lights:");
        for (int i = 1; i <= 3; i++) {
            System.out.println("Light " + i + ": " + (room.isLightOn(i) ? "on" : "off"));
        }
    }

    public static void main(String[] args) {
        LectureRoomController controller = new LectureRoomController();
        controller.run();
    }
}

class LectureRoom {
    private int numberOfStudents;
    private final boolean[] lights;

    public LectureRoom() {
        numberOfStudents = 0;
        lights = new boolean[3];
    }

    public void addStudents(int numStudents) {
        numberOfStudents += numStudents;
    }

    public void removeStudents(int numStudents) {
        numberOfStudents -= numStudents;
        if (numberOfStudents < 0) {
            numberOfStudents = 0;
        }
    }

    public void turnOnLight(int lightNumber) {
        lights[lightNumber - 1] = true;
    }

    public void turnOffLight(int lightNumber) {
        lights[lightNumber - 1] = false;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public String getLightStatus() {
        String status = "";
        for (int i = 1; i <= 3; i++) {
            status += "Light " + i + ": " + (lights[i - 1] ? "on" : "off") + " ";
        }
        return status;
    }

    public boolean isLightOn(int lightNumber) {
        return lights[lightNumber - 1];
    }
}

class EasyReader {
    private final Scanner scanner;

    public EasyReader() {
        scanner = new Scanner(System.in);
    }

        public char readChar() {
        return scanner.next().charAt(0);
    }

    public int readInt() {
        return scanner.nextInt();
    }

    public String readString() {
        return scanner.next();
    }
}
