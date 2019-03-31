import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class random_tile_generator extends PApplet {

//contributed Libraries
//GUI classes
ControlP5 gui;
PFont labelfont;
int[] colorList = new int[10000];

//9 colors,
int red = 0xffFF0000;
int pink = 0xffFF05C9;
int orange = 0xffFF8400;
int blue = 0xff032DFA;
int lightblue = 0xffADBBFF;
int aqua = 0xff05FFD3;
int darkgreen = 0xff0A9301;
int yellow = 0xffF6FF00;
int darkblue = 0xff011B93;
int purple = 0xffC208FC;


int rowCount;
int colCount;


public void setup() {
  //Setup Canvas
  
  background(0);
  
  gui = new ControlP5(this);

  labelfont = createFont("Arial", 13);
  textFont(createFont("Yu Gothic UI Bold", 12));
  textSize(18);
  textAlign(CENTER, CENTER);


  gui.addButton("Generate")
    .setLabel("Generate Random Tiles")
    .setValue(0)
    .setPosition(800, 20)
    .setSize(200, 50)
    .plugTo(this, "test")
    .setFont(labelfont)
    ;
  gui.addSlider("Rows")
    .setLabel("Number of Rows")
    .setValue(10)
    .setPosition(10, 20)
    .setSize(150, 50)
    .setRange(1, 20)
    .setFont(labelfont)
    .setNumberOfTickMarks(20)
    ;
  gui.addSlider("Columns")
    .setLabel("Number of Columns")
    .setValue(10)
    .setPosition(400, 20)
    .setSize(150, 50)
    .setRange(1, 20)
    .setNumberOfTickMarks(20)
    .setFont(labelfont)
    ;
}//end setup


public void draw() {
  fill(0);
  rect(0, 0, 1200, 1000);
  pushStyle();
  noFill();
  stroke(255);
  rect(0, 100, 1200, 900);
  popStyle();

  rectangleDraw(colorList);
}//end draw


public void Rows(float value) {
  rowCount = PApplet.parseInt(value);
}
public void Columns(float value) {
  colCount = PApplet.parseInt(value);
}
public void rectangleDraw(int[] temp_list) {
  int w = 1200/rowCount;
  int h = 900/colCount;
  int k = 0;
  for (int i = 0; i< rowCount; i=i+1) {
    for (int j = 0; j< colCount; j=j+1) {
      pushStyle();
      stroke(255);

      switch(temp_list[k]) {
      case 0:
        fill(red);
        rect(w*i, 100+h*j, w, h);
        break;

      case 1:
        fill(pink);
        rect(w*i, 100+h*j, w, h);
        break;

      case 2:
        fill(orange);
        rect(w*i, 100+h*j, w, h);
        break;

      case 3:
        fill(blue);
        rect(w*i, 100+h*j, w, h);
        break;

      case 4:
        fill(lightblue);
        rect(w*i, 100+h*j, w, h);
        break;

      case 5:
        fill(aqua);
        rect(w*i, 100+h*j, w, h);
        break;

      case 6:
        fill(darkgreen);
        rect(w*i, 100+h*j, w, h);
        break;

      case 7:
        fill(yellow);
        rect(w*i, 100+h*j, w, h);
        break;

      case 8:
        fill(darkblue);
        rect(w*i, 100+h*j, w, h);
        break;

      case 9:
        fill(purple);
        rect(w*i, 100+h*j, w, h);
        break;
        

      }//end switch

      popStyle();
      k = k+1;
    }//end column count
  }//end row for loop
}//end rectangleDraw


public void test() {
  for (int i = 0; i<(rowCount*colCount); i = i+1) {
    colorList[i] = PApplet.parseInt(random(0, 9));
    if (i>2) {
      while (colorList[i] == colorList[i-1]) {
        colorList[i] = PApplet.parseInt(random(0, 9));
      }
    }//end if
    if (i>rowCount){
           while (colorList[i] == colorList[i-rowCount]) {   
             colorList[i] = PApplet.parseInt(random(0, 9));
         }//end while
 
    }//end if
  }//end for loop
}//end generate
  public void settings() {  size(1200, 1000);  smooth(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "random_tile_generator" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
