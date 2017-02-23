package util.converter;

//Easy GUI Apps, Components, IBIO
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

//=========================================================================
//====  EasyApp - standard GUI app with standard// IBIO routines ============
//=========================================================================

public class EasyApp extends Frame implements ActionListener, ItemListener, MouseListener, KeyListener
 {
   //--- Constructor -------

	private static final long serialVersionUID = -6336912381898967844L;

	MenuBar menubar = addMenuBar();

   public EasyApp()
   {
     setLayout(null);
     setSize(600,400);


     addWindowListener                    // enable [x] for closing app
     ( new WindowAdapter()
       { public void windowClosing(WindowEvent evt)
         { evt.getWindow().dispose(); }
       }
     );

     setVisible(true);
     toFront();
     requestFocus();
   }

   public MenuBar makeMenus(String[] menus)
   {
     for (int x=0;x<menus.length;x++)
     {  if (menus[x].length()>0)
        { int d = menus[x].indexOf("|");
          if (d<0) {d=menus[x].length();  }
          Menu newmenu = addMenu(menus[x].substring(0,d),menubar);

          while (d>=0 && d<menus[x].length())
          {
           int e = menus[x].indexOf("|",d+1);
            if (e<0) {e=menus[x].length();  }
            MenuItem newmi = addMenuItem(menus[x].substring(d+1,e),newmenu,this);
            newmi.setActionCommand(newmenu.getActionCommand()+"|"+newmi.getActionCommand());

            d = e;
          }
        }
      }
      return menubar;
   }

   //============================
   //--- Control Creators -------
   //============================

   public Button addButton(String text, int left, int top, int width, int height,
                           ActionListener listener)
   {
       Button newComp = new Button(text);
       add(newComp);
       newComp.setBounds(left,top,width,height);
       if (listener!=null)newComp.addActionListener(listener);
       return newComp;
   }

   public Checkbox addCheckbox(String text, int left, int top, int width, int height,
                               ItemListener listener)
   {
       Checkbox newComp = new Checkbox(text);
       add(newComp);
       newComp.setBounds(left,top,width,height);
       if (listener!=null)newComp.addItemListener(listener);
       return newComp;
   }

   public TextField addTextField(String text, int left, int top, int width, int height,
                                 ActionListener listener)
   {
       TextField newComp = new TextField(text);
       add(newComp);
       newComp.setBounds(left,top,width,height);
       if (listener!=null)newComp.addActionListener(listener);
       return newComp;
   }

   public TextArea addTextArea(String text, int left, int top, int width, int height,
                               KeyListener listener)
   {
       TextArea newComp = new TextArea(text);
       add(newComp);
       newComp.setBounds(left,top,width,height);
       if (listener!=null)newComp.addKeyListener(listener);
       return newComp;
   }

   public Label addLabel(String text, int left, int top, int width, int height,
                         MouseListener listener)
   {
       Label newComp = new Label(text);
       add(newComp);
       newComp.setBounds(left,top,width,height);
       if (listener!=null)newComp.addMouseListener(listener);
       return newComp;
   }

   public JLabel addJLabel(ImageIcon img, int left, int top, int width, int height,
                         MouseListener listener)
   {
       JLabel newComp = new JLabel(img);
       add(newComp);
       newComp.setBounds(left,top,width,height);
       if (listener!=null)newComp.addMouseListener(listener);
       return newComp;
   }

   public List addList(String words,int left, int top, int width, int height,
                       ItemListener listener)
   {
       List newComp = new List();
       while (words.length()>0)
       { int s = words.indexOf("|");
         if (s<0)
         { newComp.add(words);
           words = "";
         }
         else
         { newComp.add(words.substring(0,s));
           words = words.substring(s+1);
         }
       }
       add(newComp);
       newComp.setBounds(left,top,width,height);
       if (listener!=null)newComp.addItemListener(listener);
       return newComp;
   }

   public Choice addChoice(String words,int left, int top, int width, int height,
                           ItemListener listener)
   {
       Choice newComp = new Choice();
       while (words.length()>0)
       { int s = words.indexOf("|");
         if (s<0)
         { newComp.add(words);
           words = "";
         }
         else
         { newComp.add(words.substring(0,s));
           words = words.substring(s+1);
         }
       }
       add(newComp);
       newComp.setBounds(left,top,width,height);
       if (listener!=null)newComp.addItemListener(listener);
       return newComp;
   }
  
   public JTable addJTable(String[][] data, int left, int top, int width, int height,
                         ActionListener listener)
   {
       String[] heads = new String[data[0].length];
       for(int s=0; s<heads.length; s++){ heads[s] = ""; }
       JTable newComp = new JTable(data , heads);
       JScrollPane newComps = new JScrollPane(newComp);
       add(newComps);
       newComps.setBounds(left,top,width,height);
       // if (listener!=null)newComp.addActionListener(listener);
       return newComp;
   }
   
   public MenuItem addMenuItem(String mText,Menu mu,ActionListener listener)
   {  MenuItem c = new MenuItem(mText);
      mu.add(c);
      if (listener!=null)c.addActionListener(listener);
      return c;
   }

   public Menu addMenu(String mText,Menu mu)
   {
      Menu c = new Menu(mText);
      mu.add(c);
      return c;
   }

   public Menu addMenu(String mText,MenuBar mb)
   {
      Menu c = new Menu(mText);
      mb.add(c);
      return c;
   }

   public Menu addMenu(String mText)
   {
      int d = mText.indexOf("|");
      if (d<0){d=mText.length();}
      String id = mText.substring(0,d);
      Menu c = new Menu(id);
      menubar.add(c);
      while (d<mText.length())
      { int e = mText.indexOf("|",d+1);
        if (e<0){e = mText.length();}
        String cmd = mText.substring(d+1,e);
        MenuItem mi = addMenuItem(cmd,c,this);
        mi.setActionCommand(id+"|"+cmd);
        c.add(mi);
        d = e;
      }
      return c;
   }

   public MenuBar addMenuBar()
   {  MenuBar c = new MenuBar();
      setMenuBar(c);
      return c;
   }

  //==================================
  //=== Simplified Command Library ===
  //==================================

  public Process runProgram(String programName)
  {
      Process handle = null;
      try
      { handle = Runtime.getRuntime().exec(programName);
      }
      catch(IOException ex)
      { };
      return handle;
  }

  public String chooseFile()
  { FileDialog fd = new FileDialog(this);
    fd.setVisible(true);
    return fd.getDirectory() + fd.getFile();
  }

  public Image loadImage(String filename)
  {  ImageIcon im = new ImageIcon(filename);
     int c = 0;
     do
     { c++;
     } while (c<100000 && im.getImageLoadStatus()!=MediaTracker.COMPLETE);
     return im.getImage();
  }

  public boolean loadList(List list,String filename)
  {
   try
   { list.removeAll();
     BufferedReader infile = new BufferedReader(new FileReader(filename));
      while(infile.ready())
     { list.add(infile.readLine());
     }
     infile.close();
     return true;
   }
   catch(IOException e)
   { output(e.toString());
     return false;
   }
  }

  public boolean saveList(String filename,List list)
  {
   try
   { PrintWriter outfo = new PrintWriter(new FileWriter(filename));
     for (int c=0;c<list.getItemCount();c++)
     { outfo.println(list.getItem(c));
     }
     outfo.close();
     return true;
    }
    catch(IOException e)
    { output(e.toString());
      return false;
    }
  }

  public boolean loadArray(String[] array,String filename)
  {
   try
   {
     BufferedReader countFile = new BufferedReader(new FileReader(filename));
     int s = 0;
     while(countFile.ready())
     { array[s] = countFile.readLine();
       s++;
     }
     array[s] = null;
     countFile.close();
     return true;
   }
   catch(Exception e)
   { output(e.toString());
     return false;
   }
  }

  public boolean saveArray(String filename,String[] array)
  {
   try
   { PrintWriter outfo = new PrintWriter(new FileWriter(filename));
     int c = 0;
     while (array[c]!=null)
     { outfo.println(array[c]);
       c++;
     }
     outfo.close();
     return true;
    }
    catch(IOException e)
    { output(e.toString());
      return false;
    }
  }

  public void sortArray(String[] arr)
  {
   int swaps = 0 ;
    do
    { swaps = 0;
      int c = 0;
      while (arr[c+1]!=null)
      { if (arr[c].compareTo(arr[c+1])>0)
        { String temp = arr[c];
          arr[c] = arr[c+1];
          arr[c+1] = temp;
          swaps++;
        }
        c++;
      }
    } while (swaps != 0);
  }

  public String getType(Object ob)
  {
     String c = ob.getClass().toString();
     int p = c.lastIndexOf(".");
     if (p<0) {p=-1;}
     return c.substring(p+1);
  }

  //=== Stub versions of Listeners to satisfy interfaces ===
   public void actionPerformed(ActionEvent evt)
   { actions(evt.getSource(),evt.getActionCommand());
   }

   public void itemStateChanged(ItemEvent evt)
   { Object source = evt.getSource();
     String t = getType(source);
     String command = "";
     if (t.equals("List")) { command = ((List)source).getSelectedItem(); }
     else if (t.equals("Choice")){ command = ((Choice)source).getSelectedItem(); }
     else {command = evt.getItem().toString();}
     actions(source,command);
   }

   public void actions(Object source,String command)
   {
      output(source.toString()+":"+command);
   }

   public void mouseClicked(MouseEvent e)
   { Object source = e.getSource();
     actions(source,"");
   }
   public void mouseEntered(MouseEvent e){}
   public void mouseExited(MouseEvent e){}
   public void mousePressed(MouseEvent e){}
   public void mouseReleased(MouseEvent e){}

   public void keyTyped(KeyEvent e)
   { Object source = e.getSource();
     actions(source,e.getKeyChar()+"");
   }
   public void keyPressed(KeyEvent e){}
   public void keyReleased(KeyEvent e){}


 //===========================================================
 //=== IBIO simplified input/output commands - GUI version ===
 //===========================================================
   public void output(String message)
   {  JOptionPane.showMessageDialog(this,message);  }

   public void outputString(String message)
   {  output(message);  }

   public void output(char info)
   {  output(info + ""); }

   public void output(byte info)
   {  output(info + ""); }

   public void output(int info)
   {  output(info + ""); }

   public void output(long info)
   {  output(info + ""); }

   public void output(double info)
   {  output(info + ""); }

   public void output(boolean info)
   {  output(info + ""); }

   //----- Numerical input methods return 0 on error ------------
   public String input(String prompt)
   {  return JOptionPane.showInputDialog(this,prompt);  }

   public String inputString(String prompt)
   { return input(prompt);  }

   public String input()
   { return input("");     }

   public char inputChar(String prompt)
   { char result=(char)0;
     try{result=input(prompt).charAt(0);}
     catch (Exception e){result = (char)0;}
     return result;
   }

   public byte inputByte(String prompt)
   { byte result=0;
     try{result=Byte.valueOf(input(prompt).trim()).byteValue();}
     catch (Exception e){result = 0;}
     return result;
   }

   public int inputInt(String prompt)
   {  int result=0;
      try{result=Integer.valueOf(
                        input(prompt).trim()).intValue();}
      catch (Exception e){result = 0;}
      return result;
   }

   public long inputLong(String prompt)
   {  long result=0;
      try{result=Long.valueOf(input(prompt).trim()).longValue();}
      catch (Exception e){result = 0;}
      return result;
   }

   public double inputDouble(String prompt)
   {  double result=0;
      try{result=Double.valueOf(
                          input(prompt).trim()).doubleValue();}
      catch (Exception e){result = 0;}
      return result;
   }

   public boolean inputBoolean(String prompt)
   {  boolean result=false;
      try{result=Boolean.valueOf(
                         input(prompt).trim()).booleanValue();}
      catch (Exception e){result = false;}
      return result;
   }
  //============================================================
  //=========== end IBIO =======================================
  //============================================================

 }
