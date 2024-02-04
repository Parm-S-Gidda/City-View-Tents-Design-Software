package AllTents;

import main.ClickHandler;
import main.GamePanel;
import main.KeyHandler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Tent10x20  extends Tents{

    GamePanel gp;
    KeyHandler keyH;
    ClickHandler mouseH;



    public Tent10x20(GamePanel gp, KeyHandler keyH, ClickHandler mouseH){

        this.gp = gp;
        this.keyH = keyH;
        this.mouseH = mouseH;

        width = 24;
        height = 48;
    }

    public void setDefaultValues(){

        xLeft = 0;
        yTop = 0;

        xRight = 0;
        yBottom = 0;


    }

    public void update(){

        /*
        if(keyH.upPressed == true ){
            y -= 24;

        }
        else if(keyH.downPressed == true ){
            y += 24;

        }
        else if(keyH.leftPressed == true ){
            x -= 24;

        }
        else if(keyH.rightPressed == true ){
            x += 24;

        }
        else if(keyH.RPressed == true) {

            if (width == 24) {
                width = 48;
                height = 24;
            } else {
                width = 24;
                height = 48;

            }

        }

         */

        if(mouseH.mPressed){

            System.out.println("x: " + mouseH.mouseX);
            System.out.println("y: " +  mouseH.mouseY);


            if(mouseH.mouseX >= xLeft && mouseH.mouseX <= xRight && mouseH.mouseY >= yTop && mouseH.mouseY <= yBottom){

                xCentre = mouseH.mouseX;
                yCentre = mouseH.mouseY;

                System.out.println("X Centre: " + xCentre);
                System.out.println("y Centre: " + yCentre);

                xLeft = xCentre - width / 2;
                xRight = xCentre + width / 2;

                yTop = yCentre - width / 2;
                yBottom = yCentre + width / 2;

                // System.out.println("X Left: " + xLeft);
                //System.out.println("X Right: " + xRight);
                //System.out.println("y top: " + yTop);
                //System.out.println("y bottom: " + yBottom);
            }

        }





    }

    public void draw(Graphics2D g2){

        g2.setColor(Color.white);

        g2.fillRect(xLeft, yTop, width, height);
    }
}