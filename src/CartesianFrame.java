import javax.swing.*;

class CartesianFrame extends JFrame {
    CartesianPanel panel;

    public CartesianFrame(int[] arrX, int[] arrY, int x1, int y1, int x2, int y2) {
        panel = new CartesianPanel(arrX, arrY, x1, y1, x2, y2);
        add(panel);
    }

    public void showUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Graph");
        setSize(1000, 1000);
        setVisible(true);
    }
}