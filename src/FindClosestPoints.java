import javax.swing.*;

public class FindClosestPoints {

    LinkedListOperations pointsList = new LinkedListOperations();//noktaları tutmak için

    public double minDistance = 1000;
    public int counter = 0;//kaç tane nokta eklediğimi tutmak için

    public FindClosestPoints() {

    }

    public void setPoints(int[] arrayX, int[] arrayY) {

        for (int i = 0; i < arrayX.length; i++) {//gelen noktaları point yapıp listPoints' e ekledim

            Points point = new Points(arrayX[i], arrayY[i]);
            pointsList.add(point);
            counter++;
        }

        System.out.println("Minimum distance: " + findClosestPair(pointsList, counter));
        draw(arrayX, arrayY);
    }

    private double findClosestPair(LinkedListOperations pointsList, int size) {

        int counter = 0;
        int mid;

        if (size % 2 != 0) {
            mid = size / 2 + 1;
        } else {
            mid = size / 2;
        }

        if (size <= 3) {//üç noktaya eşit ve az nokta varsa
            return calculate2(pointsList);
        }

        LinkedListNode walk = pointsList.getHead();

        LinkedListOperations newPointsListLeft = new LinkedListOperations();
        LinkedListOperations newPointsListRight = new LinkedListOperations();

        walk = pointsList.getHead();

        while (walk != null) {//noktaları tam ortadan böldüm ve iki farklı LinkedList'e attım

            if (counter < mid) {
                newPointsListLeft.add(walk.getPoint());
            } else {
                newPointsListRight.add(walk.getPoint());
            }
            counter++;
            walk = walk.getNext();
        }

        double distanceLeft = findClosestPair(newPointsListLeft, mid);
        double distanceRight = findClosestPair(newPointsListRight, (size - mid));

        //Math.min = iki sayıdan küçük olanı döndürür
        double minimumDistance = Math.min(distanceLeft, distanceRight);

        LinkedListNode walk2 = null;
        LinkedListOperations resultList = new LinkedListOperations();
        walk = pointsList.getHead();

        //Math.abs = sayıların mutlak değerlerini döndürür
        //tüm noktalara bakmak yerine x değerlerini karşılaştırıp küçük olanları ekledim
        while (walk != null) {

            walk2 = walk.getNext();
            while (walk2 != null) {
                if (Math.abs(walk.getPoint().getX() - walk2.getPoint().getX()) < minimumDistance) {
                    resultList.add(walk.getPoint());
                    resultList.add(walk2.getPoint());
                }
                walk2 = walk2.getNext();
            }

            walk = walk.getNext();
        }

        return Math.min(minimumDistance, calculate(resultList, minimumDistance));
    }

    //verilen iki nokta arasındaki mesafeyi pisagor(x^2 + y^2 = z^2) kullanarak bulmak için
    private double distance(Points point1, Points point2) {
        //Math.sqrt = sayının karesini almak için
        return Math.sqrt((point1.getX() - point2.getX()) * (point1.getX() - point2.getX()) + (point1.getY() - point2.getY()) * (point1.getY() - point2.getY()));
    }

    private double calculate(LinkedListOperations list, double minDistance) {

        LinkedListNode walk = list.getHead();
        LinkedListNode walk2 = list.getHead();

        while (walk != null) {
            walk2 = walk.getNext();

            while (walk2 != null) {

                double value = distance(walk.getPoint(), walk2.getPoint());
                if (minDistance > value) {
                    minDistance = value;

                    create(minDistance, list, walk, walk2);
                }
                walk2 = walk2.getNext();
            }
            walk = walk.getNext();
        }

        return minDistance;
    }

    //gelen noktalardan kendi içinde mesafesi en az olanı döndürüyor
    private double calculate2(LinkedListOperations list) {

        LinkedListNode walk = list.getHead();
        LinkedListNode walk2 = list.getHead();

        double minDistance = distance(walk.getPoint(), walk2.getNext().getPoint());
        create(minDistance, list, walk, walk2.getNext());

        while (walk != null) {
            walk2 = walk.getNext();
            while (walk2 != null) {

                double value = distance(walk.getPoint(), walk2.getPoint());
                if (minDistance > value) {
                    minDistance = value;

                    create(minDistance, list, walk, walk2);
                }
                walk2 = walk2.getNext();
            }
            walk = walk.getNext();
        }
        return minDistance;
    }

    private void create(double value, LinkedListOperations list, LinkedListNode walk, LinkedListNode walk2) {

        if (minDistance > value) {
            returnFalse(list);

            walk.getPoint().setCandidatePoint(true);
            walk2.getPoint().setCandidatePoint(true);

            minDistance = value;
        }
    }

    private void returnFalse(LinkedListOperations list) {

        LinkedListNode walk = list.getHead();

        while (walk != null) {

            if (walk.getPoint().isCandidatePoint()) {
                walk.getPoint().setCandidatePoint(false);
            }

            walk = walk.getNext();
        }
    }

    private void draw(int[] arrX, int[] arrY) {
        LinkedListNode walk = pointsList.getHead();
        LinkedListOperations box = new LinkedListOperations();

        while (walk != null) {

            if (walk.getPoint().isCandidatePoint()) {
                box.add(walk.getPoint());
            }

            walk = walk.getNext();
        }

        LinkedListNode newBox = box.getHead();
        int x1 = newBox.getPoint().getX();
        int y1 = newBox.getPoint().getY();
        int x2 = newBox.getNext().getPoint().getX();
        int y2 = newBox.getNext().getPoint().getY();


        SwingUtilities.invokeLater(new Runnable() {//grafiği çizmek için
            @Override
            public void run() {
                CartesianPanel cartesianPanel = new CartesianPanel();
                CartesianFrame frame = new CartesianFrame(arrX, arrY, x1, y1, x2, y2);
                frame.showUI();
            }
        });
    }
}