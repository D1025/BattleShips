import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MouseListenerDemo extends JPanel implements MouseListener 
{
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked: ("+(int)Math.nextDown((double)e.getX()/48)+", "+ (int)Math.nextDown((double)e.getY()/48) +")");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    
    
}
