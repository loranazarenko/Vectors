
package com.netcracker.teachclub.vectors.example;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;


public class ExampleFrame extends JFrame{
    
     JButton drowButton;
     JRadioButton ovalRadioButton;
     JRadioButton rectRadioButton;
     JRadioButton lineRadioButton;
     ButtonGroup buttonGroup;
     
    
     public ExampleFrame(int width, int height) {
       this.setSize(width, height);
       this.setLayout(null);
       this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
     
       drowButton = new JButton("draw");
       drowButton.setLocation(710, 560);
       drowButton.setSize(80, 30);
       drowButton.addActionListener(new DrawButtonListener());
       this.add(drowButton);
       
       ovalRadioButton = new JRadioButton("oval");
       ovalRadioButton.setLocation(710, 0);
       ovalRadioButton.setSize(80, 30);
//       ovalRadioButton.addActionListener(new RadioButtonListener());
       this.add(ovalRadioButton);
       
       rectRadioButton = new JRadioButton("rect");
       rectRadioButton.setLocation(710, 40);
       rectRadioButton.setSize(80, 30);
//       rectRadioButton.addActionListener(new RadioButtonListener());
       this.add(rectRadioButton);
       
       lineRadioButton = new JRadioButton("line");
       lineRadioButton.setLocation(710, 80);
       lineRadioButton.setSize(80, 30);
//       lineRadioButton.addActionListener(new RadioButtonListener());
       this.add(lineRadioButton);
       
       buttonGroup = new ButtonGroup();
       buttonGroup.add(ovalRadioButton);
       buttonGroup.add(rectRadioButton);
       buttonGroup.add(lineRadioButton); 
       
       ovalRadioButton.setSelected(true);
       
       PenListener penListener = new PenListener();
       this.addMouseListener(penListener);
       this.addMouseMotionListener(penListener);
     }
     
     
     class DrawButtonListener implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (ovalRadioButton.isSelected()) {
                getGraphics().drawOval(0, 0, 100, 100);
            } else {
                if (rectRadioButton.isSelected()) {
                    getGraphics().drawRect(0, 0, 100, 100);
                } else {
                    if (lineRadioButton.isSelected()) {
                        getGraphics().drawLine(0, 0, 100, 100);
                    }
                }
            }              
        }
    }
     
class RadioButtonListener implements java.awt.event.ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(ovalRadioButton)) {
                getGraphics().drawOval(0, 0, 100, 100);
            } else {
                if (e.getSource().equals(rectRadioButton)) {
                    getGraphics().drawRect(0, 0, 100, 100);
                } else {
                    if (e.getSource().equals(lineRadioButton)) {
                        getGraphics().drawLine(0, 0, 100, 100);
                    }
                }
            }                       
        }
   }

    class PenListener implements java.awt.event.MouseMotionListener, java.awt.event.MouseListener {
        
        boolean drow = false;
        Point tempPoint = new Point(0, 0);

        @Override
        public void mouseDragged(MouseEvent e) {
            if (drow) {
                getGraphics().drawLine(tempPoint.x, tempPoint.y, e.getX(), e.getY());
                tempPoint.setLocation(e.getX(), e.getY());
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mousePressed(MouseEvent e) {
            drow = true;
            tempPoint.setLocation(e.getX(), e.getY());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            drow = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }

        






     
        
     public static void main(String[] args) {
        ExampleFrame exampleFrame = new ExampleFrame(815, 630);
        exampleFrame.setVisible(true);
    }
    
     
     
}
