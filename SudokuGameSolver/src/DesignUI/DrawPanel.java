package DesignUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

class DrawPanel extends JPanel {

    private void doDrawing(Graphics g) {

        var g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
		
		g2d.fillRect(0, 0,this.getWidth(),this.getHeight());
		
		g2d.setColor(Color.BLACK);
		for(int x = 0;x <= this.getWidth();x+=this.getWidth()/9) {
			if((x/(this.getWidth()/9)) % 3 == 0) {
				g2d.setStroke(new BasicStroke(2));
				g2d.drawLine(x, 0, x, (this.getHeight() / 9) * 9);
			}
			else {
				g2d.setStroke(new BasicStroke(1));
				g2d.drawLine(x, 0, x, (this.getHeight() / 9) * 9);
			}
		}
		
		for(int y = 0;y <= this.getHeight();y+=this.getHeight()/9) {
			if((y/(this.getHeight()/9)) % 3 == 0) {
				g2d.setStroke(new BasicStroke(2));
				g2d.drawLine(0, y, (this.getWidth() / 9) * 9, y);
			}
			else {
				g2d.setStroke(new BasicStroke(1));
				g2d.drawLine(0, y, (this.getWidth() / 9) * 9, y);
			}
		}
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }
}
