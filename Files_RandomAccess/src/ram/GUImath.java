package ram;

import java.awt.*;                            // Contains the Classes for Controls

public class GUImath extends EasyApp          // EasyApp provides simplified commands
{                                             //  for creating controls and making
   public static void main(String[] args)     //  the actions method simpler
   {   new GUImath();   }
   
   //-------- creating CONTROLS -----------------------------------
   Button    APbutton   = addButton("AP",50,50,100,50,this);       // EasyApp will
   Button    TwoPlusTwo = addButton("2+2",150,50,100,50,this);     // create controls
   Button    giveUp     = addButton("Give up",250,50,100,50,this); // and place them
   TextField answerBox  = addTextField("",50,100,300,40,this);     // in the Window
   
   TextField number     = addTextField("",50,200,100,40,this);
   Button    squareIt   = addButton("Square",160,200,50,40,this);
   TextField squared    = addTextField("",220,200,100,40,this);
   

   public GUImath()                                  // Constructor
   {                                                 //  This runs at the beginning.
      setTitle("My First GUI App");                  //  You can do things like 
      setSize(400,300);                              //  changing the Window size
      answerBox.setFont(new Font("Arial",0,20) );    //  or appearance of Controls.
   }

   public void actions(Object source,String command) // When a Button is clicked,
   {                                                 //  this method decides how
      if (source == APbutton)                        //  to respond.  Normally this
      {                                              //  executes the corresponding
         AP();                                       //  method, but it could also
      }                                              //  do something like ending 
      if (source == TwoPlusTwo)                      //  the program.
      {
         Add2plus2();
      }
      if (source == giveUp)
      {  
         System.exit(0);         // this ends the program and kills the Window
      }   
      if (source == squareIt)
      {  squareIt(); }
   }
   
   public void squareIt()
   {
      String text = number.getText();               // Get text from input box
      double num = Double.parseDouble(text);        // Change text to a number
      double sq = num * num;                        // Calculate
      squared.setText(sq + "");          // put the answer in the other box
                                         // must add some text for .setText method
   }

   public void Add2plus2()
   {   
      double answer =  inputDouble("What is 2+2");  // Input their guess
      if (answer == 4)                              // Check whether it was right
      {  answerBox.setText("Right"); }              //  if right, display "right"
      else                                          // otherwise
      {  output("Wrong");                           //   annoy the living
         output("Try again");                       //   daylights out of
         output("If you dare!");                    //   the poor user
      }
   }

   public void AP()
   {
      double d = inputDouble("Common diff");        // common difference
      double a = inputDouble("First term");         // first term

      answerBox.setText(a + "   " + (a+d) + "   " + (a+2*d) + "   " + (a+3*d) );
      // When using .setText, you MUST put some text into the box.
      // You can also put numbers in, but not JUST numbers.
      // Put CALCULATIIONS in (parentheses).
      // Use + signs to CONCATENATE all the text and numbers together.
   }   
}