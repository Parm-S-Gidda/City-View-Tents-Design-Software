package main;

import AllTents.Tent10x10;
import AllTents.Tent10x20;
import AllTents.Tent20x20;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16; //16 x 16 tile
    final int scale = 3;

    final int tileSize = originalTileSize * scale;


    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;
    KeyHandler keyH = new KeyHandler();
    ClickHandler mouseH = new ClickHandler();
    Thread gameThread;

    GridSnap gridCollisions = new GridSnap(mouseH, this);

    Tent20x20 tent1 = new Tent20x20(this, keyH, mouseH);
    Tent10x20 tent2 = new Tent10x20(this, keyH, mouseH);
    Tent10x10 tent3 = new Tent10x10(this, keyH, mouseH);

    int whoseTurn = 1;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);
        this.addMouseMotionListener(mouseH);
        this.setFocusable(true);
    }

    public void startGameThread(){

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){

            long currentTime = System.nanoTime();

            whoDraws();
            update(); //update values

            repaint(); //paint screen

            gridCollisions.checkForCloseEdges(tent1, tent2);


            /*
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
             */

        }

    }

    public void update(){

            if(whoseTurn == 1){

                tent1.update();
            }
            else if(whoseTurn == 2){
                tent2.update();
            }
            else if(whoseTurn == 3){
                tent3.update();
            }


    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;


        tent1.draw(g2);
        tent2.draw(g2);
        tent3.draw(g2);

        g2.dispose();

    }

    public void whoDraws(){

        if(keyH.onePressed == true ){

            whoseTurn = 1;
        }
        else if(keyH.twoPressed == true){
           whoseTurn = 2;
        }
        else if(keyH.threePressed == true){

            whoseTurn = 3;
        }

    }
}
