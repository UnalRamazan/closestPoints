import javax.swing.*;
import java.awt.*;

class CartesianPanel extends JPanel {

    private static int[] arrX;
    private static int[] arrY;
    public static int midPoint;
    public int x1, y1, x2, y2;

    public CartesianPanel() {

    }

    public CartesianPanel(int[] arrX, int[] arrY, int x1, int y1, int x2, int y2) {
        this.arrX = arrX;
        this.arrY = arrY;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    //x-axis coord constants
    public static final int X_AXIS_FIRST_X_COORD = 50;
    public static final int X_AXIS_SECOND_X_COORD = 600;//x ekseninde bulunan değerlerin arasındaki mesafe
    public static final int X_AXIS_Y_COORD = 600;//x ekseninin yukarıdan uzaklığı

    //y-axis coord constants
    public static final int Y_AXIS_FIRST_Y_COORD = 50;
    public static final int Y_AXIS_SECOND_Y_COORD = 600;//y ekseninde bulunan değerlerin arasındaki mesafe
    public static final int Y_AXIS_X_COORD = 50;//y ekseninin başlangıçtaki uzaklığı

    public static final int FIRST_LENGHT = 10;//okların boyutu
    public static final int SECOND_LENGHT = 5;//grafik üstünde bulunan çizgilerin uzunluğu

    //size of start coordinate lenght
    public static final int ORIGIN_COORDINATE_LENGHT = 6;//nokta boyutları

    //distance of coordinate strings from axis
    public static final int AXIS_STRING_DISTANCE = 20;//grafiğin yanında bulunan değerlerin cizgiden uzaklığı

    public Graphics2D g2d;//grafik oluşturduk

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //x-axis oluşturmak için
        g2d.drawLine(X_AXIS_FIRST_X_COORD, X_AXIS_Y_COORD, X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);

        //y-axis
        g2d.drawLine(Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD, Y_AXIS_X_COORD, Y_AXIS_SECOND_Y_COORD);//?????????????????

        //x-axis arrow(ok)
        g2d.drawLine(X_AXIS_SECOND_X_COORD - FIRST_LENGHT, X_AXIS_Y_COORD - SECOND_LENGHT, X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);
        g2d.drawLine(X_AXIS_SECOND_X_COORD - FIRST_LENGHT, X_AXIS_Y_COORD + SECOND_LENGHT, X_AXIS_SECOND_X_COORD, X_AXIS_Y_COORD);

        //y-axis arrow(ok)
        g2d.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT, Y_AXIS_FIRST_Y_COORD + FIRST_LENGHT, Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD);
        g2d.drawLine(Y_AXIS_X_COORD + SECOND_LENGHT, Y_AXIS_FIRST_Y_COORD + FIRST_LENGHT, Y_AXIS_X_COORD, Y_AXIS_FIRST_Y_COORD);

        //draw origin point
        g2d.fillOval(X_AXIS_FIRST_X_COORD - (ORIGIN_COORDINATE_LENGHT / 2), Y_AXIS_SECOND_Y_COORD - (ORIGIN_COORDINATE_LENGHT / 2), ORIGIN_COORDINATE_LENGHT, ORIGIN_COORDINATE_LENGHT);

        //draw text "X" and draw text "Y"
        g2d.drawString("X", X_AXIS_SECOND_X_COORD - AXIS_STRING_DISTANCE / 2, X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
        g2d.drawString("Y", Y_AXIS_X_COORD - AXIS_STRING_DISTANCE, Y_AXIS_FIRST_Y_COORD + AXIS_STRING_DISTANCE / 2);
        g2d.drawString("(0, 0)", X_AXIS_FIRST_X_COORD - AXIS_STRING_DISTANCE, Y_AXIS_SECOND_Y_COORD + AXIS_STRING_DISTANCE);

        //numerate axis/sayı ekseni boyutu
        int xCoordNumbers = 20;
        int yCoordNumbers = 20;
        int xLength = (X_AXIS_SECOND_X_COORD - X_AXIS_FIRST_X_COORD) / xCoordNumbers;
        int yLength = (Y_AXIS_SECOND_Y_COORD - Y_AXIS_FIRST_Y_COORD) / yCoordNumbers;

        g2d.drawLine(X_AXIS_FIRST_X_COORD + (midPoint * xLength), 50, X_AXIS_FIRST_X_COORD + (midPoint * xLength), 50);//????????

        g2d.drawLine(Y_AXIS_X_COORD + (midPoint * xLength), Y_AXIS_FIRST_Y_COORD, Y_AXIS_X_COORD + (midPoint * xLength), Y_AXIS_SECOND_Y_COORD);//????????????

        for (int i = 1; i < xCoordNumbers; i++) {//x ekseni çizgileri oluşturduk
            g2d.drawLine(X_AXIS_FIRST_X_COORD + (i * xLength), X_AXIS_Y_COORD - SECOND_LENGHT, X_AXIS_FIRST_X_COORD + (i * xLength), X_AXIS_Y_COORD + SECOND_LENGHT);

            g2d.drawString(Integer.toString(i), X_AXIS_FIRST_X_COORD + (i * xLength) - 3, X_AXIS_Y_COORD + AXIS_STRING_DISTANCE);
        }

        for (int i = 0; i < arrX.length; i++) {//noktaları oluşturduk

            if (arrX[i] == x1 && arrY[i] == y1) {
                g2d.setColor(Color.RED);
                g2d.fillOval(X_AXIS_FIRST_X_COORD + (arrX[i] * xLength), X_AXIS_Y_COORD + (-arrY[i] * yLength), ORIGIN_COORDINATE_LENGHT, ORIGIN_COORDINATE_LENGHT);
            } else if (arrX[i] == x2 && arrY[i] == y2) {
                g2d.setColor(Color.RED);
                g2d.fillOval(X_AXIS_FIRST_X_COORD + (arrX[i] * xLength), X_AXIS_Y_COORD + (-arrY[i] * yLength), ORIGIN_COORDINATE_LENGHT, ORIGIN_COORDINATE_LENGHT);
            } else {
                g2d.fillOval(X_AXIS_FIRST_X_COORD + (arrX[i] * xLength), X_AXIS_Y_COORD + (-arrY[i] * yLength), ORIGIN_COORDINATE_LENGHT, ORIGIN_COORDINATE_LENGHT);
            }
            g2d.setColor(Color.black);
        }

        for (int i = 1; i < yCoordNumbers; i++) {//y ekseni çizgileri oluşturduk

            g2d.drawLine(Y_AXIS_X_COORD - SECOND_LENGHT, Y_AXIS_SECOND_Y_COORD - (i * yLength), Y_AXIS_X_COORD + SECOND_LENGHT, Y_AXIS_SECOND_Y_COORD - (i * yLength));

            g2d.drawString(Integer.toString(i), Y_AXIS_X_COORD - AXIS_STRING_DISTANCE, Y_AXIS_SECOND_Y_COORD - (i * yLength));
        }

        //iki nokta arası çizgi çizmek için
        Stroke stroke = new BasicStroke(2f);
        g2d.setStroke(stroke);
        g2d.setColor(Color.red);
        g2d.drawLine(X_AXIS_FIRST_X_COORD + (x1 * xLength), X_AXIS_Y_COORD + (-y1 * yLength), X_AXIS_FIRST_X_COORD + (x2 * xLength), X_AXIS_Y_COORD + (-y2 * yLength));
    }
}