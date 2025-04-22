package org.example;

import java.awt.event.MouseEvent;

public abstract class MouseAdapter {
    public MouseAdapter(){}
    public abstract void mousePressed(MouseEvent e);
    public abstract void mouseReleased(MouseEvent e);
    public abstract void mouseClicked(MouseEvent e);
    public abstract void mouseEntered(MouseEvent e);
    public abstract void mouseExited(MouseEvent e);

}
