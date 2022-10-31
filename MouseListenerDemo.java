import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;

public class MouseListenerDemo extends JPanel implements MouseInputListener 
{

    int mouseX = -2;
    int mouseY = -2;
    int mouseXSh = -2;
    int mouseYSh = -2;
    boolean pressed = false;


    @Override
    public void mouseClicked(MouseEvent e) {
        // System.out.println("Mouse Clicked: ("+(int)Math.nextDown((double)e.getX()/48)+", "+ (int)Math.nextDown((double)e.getY()/48) +")");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = (int)Math.nextDown((double)e.getX()/48)-1;
        mouseY = (int)Math.nextDown((double)e.getY()/48)-1;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (mouseX == (int)Math.nextDown((double)e.getX()/48)-1 && mouseY == (int)Math.nextDown((double)e.getY()/48)-1)
        {
            // System.out.println("Klikniete");
            pressed = true;
            mouseXSh = mouseX;
            mouseYSh = mouseY;            
        }
        mouseX = -2;
        mouseY = -2;  

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // System.out.println("Mouse Clicked: ("+(int)Math.nextDown((double)e.getX()/48)+", "+ (int)Math.nextDown((double)e.getY()/48) +")");

        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // System.out.println("Mouse Clicked: ("+(int)Math.nextDown((double)e.getX()/48)+", "+ (int)Math.nextDown((double)e.getY()/48) +")");
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // System.out.println("Mouse Clicked: ("+(int)Math.nextDown((double)e.getX()/48)+", "+ (int)Math.nextDown((double)e.getY()/48) +")");
        
    }
    
    
}
