import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class Main {
    

    public static void main(String[] args)
    {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("BattleShips");

        window.setIconImage(new ImageIcon("images/battleship-38191369.png").getImage());

        gui gui = new gui();
        window.add(gui);
        
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gui.startGameThread();
    }
}
