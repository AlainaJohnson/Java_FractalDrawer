import java.awt.Color;
import java.util.Scanner;

import static java.awt.Color.*;

public class FractalDrawer {
    private double totalArea = 0;  // member variable for tracking the total area

    public FractalDrawer() {
    }  // contructor

    //TODO:
    // drawFractal creates a new Canvas object
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {
        //create new canvas object called canvObj
        Canvas canvObj = new Canvas();
        //determine what shape to draw

        //if the shape input was triangle
        if(type.equals("triangle")){
            drawTriangleFractal(300, 300,400,400, red, canvObj, 0);

        }
        //if the shape input was rectangle
        else if(type.equals("rectangle")){
            drawRectangleFractal(200, 150, 400, 400, red, canvObj, 0);

        }
        //if the shape input was circle
        else if(type.equals("circle")){
            drawCircleFractal(150,400,400, red, canvObj, 0);

        }

        //return area of the fractal
        return totalArea;//???
    }

    //TODO:
    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        //creating new triangle object
        Triangle tri = new Triangle(x,y,width,height);
        tri.setColor(c);
        can.drawShape(tri);
        totalArea+=tri.calculateArea();

        //base case
        if(level==7){ //level starts at 0, and goes until it is at the level 7
            return;
        }

       //Recursive case
        else{// location is from the bottom left

            //color changing if statement
            if (c.equals(red)){
                c=blue;
            }
            else if(c.equals(blue)){
                c=green;
            }
            else if(c.equals(green)){
                c=red;
            }

            //to draw triangle at bottom right
            drawTriangleFractal(width/2, height/2, x+width ,y,c,can, level+1);

            //to draw triangle at the top
            drawTriangleFractal(width/2, height/2, x+((0.25)*width), y-height, c, can, level+1);

            //to draw triangle at bottom left
            drawTriangleFractal(width/2, height/2, x-(width/2),y,c,can, level+1);

        }

    }

    // TODO:
    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        Circle circ = new Circle(x,y,radius);//what should I set the default values to?
        circ.setColor(c);
        can.drawShape(circ);
        totalArea+=circ.calculateArea();
        //starts in the center
        //base case
        if (level==7){
           return;
        }
        //recursive case
        else{
            //color change if statement
            if (c.equals(red)){
                c=blue;
            }
            else if(c.equals(blue)){
                c=green;
            }
            else if(c.equals(green)){
                c=red;
            }
            //left
            drawCircleFractal(radius/2, x-radius-(radius/2), y, c, can, level+1);

            //right
            drawCircleFractal(radius/2, x+radius+(radius/2), y, c, can, level+1);

            //top
            drawCircleFractal(radius/2, x, y-radius-(radius/2), c, can, level+1);

            //bottom
            drawCircleFractal(radius/2, x, y+radius+(radius/2), c, can, level+1);







        }



    }

    //TODO:
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        Rectangle rect = new Rectangle(x,y,width,height);//what should I set the default value to?
        rect.setColor(c);
        can.drawShape(rect);
        totalArea+=rect.calculateArea();


        //base case
        if(level==7){
            return;
        }

        //recursive case
        else{
            //color change if statement
            if (c.equals(red)){
                c=blue;
            }
            else if(c.equals(blue)){
                c=green;
            }
            else if(c.equals(green)){
                c=red;
            }

            //bottom left
            drawRectangleFractal(width/2, height/2, x-(width/2), y, c, can, level+1);

            //bottom right
            drawRectangleFractal(width/2, height/2, x+width, y, c, can, level+1);

            //top left
            drawRectangleFractal(width/2, height/2, x-(width/2), y+height, c, can, level+1);

            //top right
            drawRectangleFractal(width/2, height/2, x+width, y+height, c, can, level+1);


        }





    }

    //TODO:
    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    public static void main(String[] args) {

        //use scanner
        System.out.println("Enter what shape you want to draw a fractal of(circle, rectangle or triangle): ");
        Scanner myScanner = new Scanner(System.in);
        String shapeInput = myScanner.nextLine(); //shape input is a string
        //creates new FractalDrawer with the shape input above
        FractalDrawer frac = new FractalDrawer();
        //printing out the area of the fractal (totalArea is returned from drawFractal)
        System.out.println(frac.drawFractal(shapeInput));




    }
}
