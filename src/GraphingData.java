import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class GraphingData extends JPanel {
    private static final int SIZE = 20;
    private int[] data;

    public GraphingData(int[] data){
        this.data = data;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        g2.draw(new Line2D.Double(SIZE, SIZE, SIZE, h- SIZE));
        g2.draw(new Line2D.Double(SIZE, h- SIZE, w- SIZE, h- SIZE));
        double xInc = (double)(w - 2* SIZE)/(data.length-1);
        double scale = (double)(h - 2* SIZE)/getMax();
        g2.setPaint(Color.red);
        for(int i = 0; i < data.length; i++) {
            double x = SIZE + i*xInc;
            double y = h - SIZE - scale*data[i];
            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
        }
    }

    private int getMax() {
        int max = -Integer.MAX_VALUE;
        for (int aData : data) {
            if (aData > max)
                max = aData;
        }
        return max;
    }

}