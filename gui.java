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

    int FPS = 60;

    int mouseX = 0, mouseY = 0;

    //Image img1 = Toolkit.getDefaultToolkit().getImage("images/board.png");
    
    
    MouseListenerDemo mouseH = new MouseListenerDemo();
    Thread gameThread;

    BattleShips battleShips = new BattleShips();
    

    boolean gra = true;


    public gui()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addMouseListener(mouseH);
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run()
    {
        double drawInterval = 1000000000/FPS;
        double drawNextTime = System.nanoTime() + drawInterval;

        battleShips.macierz_s.SetStatki();

        while(gameThread != null)
        {



            update();
            repaint();

            try 
            {
                double remainingTime = drawNextTime - System.nanoTime();
                remainingTime /= 1000000;

                if(remainingTime < 0 )
                {
                    remainingTime = 0;
                }

                Thread.sleep((long)remainingTime);

                drawNextTime +=drawInterval;
            } catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }

        

    }

    public void update()
    {

        if(mouseH.pressed)
        {
            if(mouseH.mouseXSh >=0 &&  mouseH.mouseXSh <10 && mouseH.mouseYSh >=0 && mouseH.mouseYSh <10)
            gra = battleShips.macierz_s.Shoot(mouseH.mouseXSh, mouseH.mouseYSh);
            mouseH.pressed = false;  
        }

        if(battleShips.macierz_s.statki.equals(0))
        gameThread = null;
        
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        // g2.drawChars(chartab, 0, 1, tileSize-2, tileSize-2);



        // g2.drawImage(img1, 0, 0, this);
        if(gra)
        {
            g2.setColor(Color.white);
            g2.drawString("Pozostalo " + battleShips.macierz_s.statki, 10, 10);
        }
        else
        {
            g2.setColor(Color.white);
            g2.drawString("Wygrales", 10, 10);
        }

        
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
                    switch(battleShips.macierz_s.macierz[i-1][j-1])
                    {
                        case 1:
                        g2.setColor(Color.blue);
                        break;
                        case 2:
                        g2.setColor(Color.red);
                        break;
                        default:
                        g2.setColor(Color.white);
                        break;
                    }  
                    g2.fillRect(tileSize*i-1, tileSize*j-1, tileSize-1, tileSize-1);
                }

                if(i == mouseH.mouseX+1 && mouseH.mouseY+1 == j)
                {
                    g2.setColor(Color.gray);
                    g2.fillRect(tileSize*i+5, tileSize*j+5, tileSize-13, tileSize-13);
                }
            }
        }
        //g2.fillRect(100, 100, tileSize, tileSize);

        g2.dispose();

    }
}
