package main;

import AllTents.Tents;

public class GridSnap {

    ClickHandler mouseH;

    public GridSnap(ClickHandler mouseH, GamePanel panel){
        this.mouseH = mouseH;
    }

    public void checkForCloseEdges(Tents currentTent, Tents otherTent){

        int currentTentXCentre = 0;
        int currentTentYCentre = 0;


       System.out.println("X Left: " + otherTent.xLeft);
        System.out.println("X Right: " + otherTent.xRight);
        System.out.println("y top: " + otherTent.yTop);
        System.out.println("y bottom: " + otherTent.yBottom);
        System.out.println("x centre: " + otherTent.xCentre);
        System.out.println("y centre: " + otherTent.yCentre);
        System.out.println("-----------------------------");
        System.out.println("X Left: " + currentTent.xLeft);
        System.out.println("X Right: " + currentTent.xRight);
        System.out.println("y top: " + currentTent.yTop);
        System.out.println("y bottom: " + currentTent.yBottom);
        System.out.println("x centre: " + currentTent.xCentre);
        System.out.println("y centre: " + currentTent.yCentre);





        if(currentTent.xCentre >= otherTent.xLeft && currentTent.xCentre <= otherTent.xRight){

            System.out.println("first if");

            if(currentTent.yTop >= otherTent.yBottom - 10 && currentTent.yTop <= otherTent.yBottom + 10){

                System.out.println("second if");
                if(!mouseH.mPressed) {
                    currentTent.xLeft = otherTent.xLeft;
                    currentTent.xRight = currentTent.xLeft + currentTent.width;
                    currentTent.yTop = otherTent.yBottom;
                    currentTent.yBottom = currentTent.yTop + currentTent.height;
                }

            }
            else if(currentTent.yBottom >= otherTent.yTop - 10 && currentTent.yBottom <= otherTent.yTop + 10){

                if(!mouseH.mPressed) {
                    currentTent.xLeft = otherTent.xLeft;
                    currentTent.xRight = currentTent.xLeft + currentTent.width;
                    currentTent.yBottom = otherTent.yTop;
                    currentTent.yTop = currentTent.yBottom - currentTent.height;
                }

            }
        }
        else if(currentTent.yCentre >= otherTent.yTop && currentTent.yCentre <= otherTent.yBottom){



            if(currentTent.xRight >= otherTent.xLeft - 10 && currentTent.xRight <= otherTent.xLeft + 10){


                if(!mouseH.mPressed) {

                    currentTent.yTop = otherTent.yTop;
                    currentTent.yBottom = currentTent.yTop + currentTent.height;
                    currentTent.xRight = otherTent.xLeft;
                    currentTent.xLeft = currentTent.xRight - currentTent.width;
                }

            }
            else if(currentTent.xLeft >= otherTent.xRight - 10 && currentTent.xLeft <= otherTent.xRight + 10){

                if(!mouseH.mPressed) {

                    currentTent.yTop = otherTent.yTop;
                    currentTent.yBottom = currentTent.yTop + currentTent.height;
                    currentTent.xLeft = otherTent.xRight;
                    currentTent.xRight = currentTent.xLeft + currentTent.width;
                }

            }
        }

        System.out.println("================================");


    }
}
