package DesignUI;

import javax.swing.JFrame;
import java.awt.EventQueue;

public class PointsEx extends JFrame {

    public PointsEx() {
        
        initUI();
    }

    private void initUI() {
        
        var drawPanel = new DrawPanel();
        add(drawPanel);


        setSize(450, 450);
        setTitle("Points");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            
            var ex = new PointsEx();
            ex.setVisible(true);
        });
    }
}