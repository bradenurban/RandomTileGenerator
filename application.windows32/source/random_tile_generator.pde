//contributed Libraries
import controlP5.*;//GUI classes
ControlP5 gui;
PFont labelfont;
int[] colorList = new int[10000];

//9 colors,
color red = #FF0000;
color pink = #FF05C9;
color orange = #FF8400;
color blue = #032DFA;
color lightblue = #ADBBFF;
color aqua = #05FFD3;
color darkgreen = #0A9301;
color yellow = #F6FF00;
color darkblue = #011B93;
color purple = #C208FC;


int rowCount;
int colCount;


void setup() {
  //Setup Canvas
  size(1200, 1000);
  background(0);
  smooth();
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


void draw() {
  fill(0);
  rect(0, 0, 1200, 1000);
  pushStyle();
  noFill();
  stroke(255);
  rect(0, 100, 1200, 900);
  popStyle();

  rectangleDraw(colorList);
}//end draw


void Rows(float value) {
  rowCount = int(value);
}
void Columns(float value) {
  colCount = int(value);
}
void rectangleDraw(int[] temp_list) {
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


void test() {
  for (int i = 0; i<(rowCount*colCount); i = i+1) {
    colorList[i] = int(random(0, 9));
    if (i>2) {
      while (colorList[i] == colorList[i-1]) {
        colorList[i] = int(random(0, 9));
      }
    }//end if
    if (i>rowCount){
           while (colorList[i] == colorList[i-rowCount]) {   
             colorList[i] = int(random(0, 9));
         }//end while
 
    }//end if
  }//end for loop
}//end generate
