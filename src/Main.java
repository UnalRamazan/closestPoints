import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        start();
    }

    public static void start() {

        Scanner scanner = new Scanner(System.in);
        int size, xPoints, yPoints;

        System.out.println("Welcome to system...");
        System.out.println("1- To read file for points");
        System.out.println("2- To enter values for points");
        System.out.print("Choice: ");
        String choice = scanner.next();

        switch (choice) {
            case "1":
                System.out.print("How many points do you want to create a graph: ");
                size = scanner.nextInt();

                int[] arrayX = new int[size];
                int[] arrayY = new int[size];

                System.out.println("Please enter the values one by one in x and y format(X-Y)!!!");
                for (int i = 0; i < size; i++) {
                    System.out.print(i + 1 + ". point(X-Y): ");
                    xPoints = scanner.nextInt();
                    yPoints = scanner.nextInt();

                    arrayX[i] = xPoints;
                    arrayY[i] = yPoints;
                }

                FindClosestPoints findClosestPoints = new FindClosestPoints();
                findClosestPoints.setPoints(arrayX, arrayY);
                break;
            case "2":
                int[] arrX = {1, 3, 8, 4, 3, 6, 9, 2};
                int[] arrY = {5, 4, 9, 4, 9, 9, 7, 13};

                FindClosestPoints findClosestPoints2 = new FindClosestPoints();
                findClosestPoints2.setPoints(arrX, arrY);
                break;
            default:
                System.out.println("You entered the wrong value, try again.");
                break;
        }
    }
}