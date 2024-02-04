package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class ClickHandler implements  MouseListener, MouseMotionListener {

    public boolean mPressed;
    public int mouseX, mouseY;


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        mouseX = e.getX();
        mouseY = e.getY();
        mPressed = true;

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("unpressed");
        mPressed = false;

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
