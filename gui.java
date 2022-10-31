import javax.swing.*;

import java.awt.*;

// import java.awt.Image;
// import java.awt.Toolkit;

class gui extends JPanel implements Runnable
{

    final int orginalTileSize = 16;
    final int scale = 3;

    final int tileSize = orginalTileSize * scale;
    final int maxScreenCol = 11;
    final int maxScreenRow = 11;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    //Image img1 = Toolkit.getDefaultToolkit().getImage("images/board.png");
    
    
    MouseListenerDemo mouseH = new MouseListenerDemo();
    Thread gameThread;

    public gui()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addMouseListener(mouseH);
    }

    public void startGaneThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run()
    {
        while(gameThread != null)
        {
            update();
            repaint();
        }

    }

    public void update()
    {

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        // g2.drawChars(chartab, 0, 1, tileSize-2, tileSize-2);



        // g2.drawImage(img1, 0, 0, this);
        
        for(int i=0; i<11; i++)
        {
            for(int j=0; j<11; j++)
            {
                if(i==0 || j== 0)
                {
                    
                }
                else
                {
                    g2.setColor(Color.black);
                    g2.fillRect(tileSize*i, tileSize*j, tileSize, tileSize);   
                    g2.setColor(Color.white);
                    g2.fillRect(tileSize*i-1, tileSize*j-1, tileSize-1, tileSize-1);
                }
            }
        }
        //g2.fillRect(100, 100, tileSize, tileSize);

        g2.dispose();

    }
}
