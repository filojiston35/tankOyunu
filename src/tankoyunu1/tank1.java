/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankoyunu1;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static tankoyunu1.OyunAlani.TANK1;

/**
 *
 * @author Yusuf
 */
public class tank1 {
    static String yon;
    static int X=0;
    static int Y=627;
    static int width=33;
    static int can=100;
    static String tankRenk="";
    static String tankLeft="";
    static String tankRight="";
    static String  tankUp="";
    static String tankDown="";
    
    public static void Tank1Olustur(String tank1Renk)
    {
        X=0;
        Y=627;
        can=100;
        tankRenk=tank1Renk;
        tankLeft="images\\"+tankRenk+"-tank-left.png";
        tankRight="images\\"+tankRenk+"-tank-right.png";
        tankUp="images\\"+tankRenk+"-tank-up.png";
        tankDown="images\\"+tankRenk+"-tank-down.png";
       TANK1=new JLabel(new javax.swing.ImageIcon(tankUp));
       TANK1.setBounds(X,Y,width,width);
       TANK1.setName("tank1");
    }
    public static void Tank1Up()
    {
      TANK1.setIcon(new ImageIcon(tankUp));
         int indis=((X/33)*20)+((Y-33)/33);
         JLabel blockKontrol=(JLabel)OyunAlani.elements[indis][0];
          if(OyunAlani.health[indis][0]!=null)
           {
                    if((Integer)OyunAlani.health[indis][1]==X && (Integer)OyunAlani.health[indis][2]==Y-33)
                    {
                    JLabel silinenHealth=(JLabel)OyunAlani.health[indis][0];
                    can=100;
                    OyunAlani.tank1_can.setValue(can);
                    OyunAlani.health[indis][0]=null;
                    OyunAlani.PANEL.remove(silinenHealth);
                     Y-=33;
                    TANK1.setBounds(X,Y,width,width); 
                    }
                    
          }
          else if(Y-33>=0 && Y-33<=627 && OyunAlani.elements[indis][0]==null)
        {  
                Y-=33;
                TANK1.setBounds(X,Y,width,width); 
               
        }
        else if(OyunAlani.elements[indis][0]!=null)
        {
            if(blockKontrol.getName().indexOf("Burn")!=-1)
            {
                 Y-=33;
                TANK1.setBounds(X,Y,width,width);
                can-=20;
                OyunAlani.tank1_can.setValue(can);
                if(can<=0)
                    OyunAlani.GameOver();
            }
            
        }
       
    }
    public static void Tank1Left()
    {
        TANK1.setIcon(new ImageIcon(tankLeft));
        int indis=(((X-33)/33)*20)+(Y/33);
         JLabel blockKontrol=(JLabel)OyunAlani.elements[indis][0];
         if(OyunAlani.health[indis][0]!=null)
           {
                    if((Integer)OyunAlani.health[indis][1]==X-33 && (Integer)OyunAlani.health[indis][2]==Y)
                    {
                    JLabel silinenHealth=(JLabel)OyunAlani.health[indis][0];
                    can=100;
                    OyunAlani.tank1_can.setValue(can);
                    OyunAlani.health[indis][0]=null;
                    OyunAlani.PANEL.remove(silinenHealth);
                     X-=33;
                    TANK1.setBounds(X,Y,width,width); 
                    }
                    
          }
         else if(X-33>=0 && X-33<=1287 && OyunAlani.elements[indis][0]==null)
        {
            X-=33;           
            TANK1.setBounds(X,Y,width,width);
        }
        else if(OyunAlani.elements[indis][0]!=null)
        {
            if(blockKontrol.getName().indexOf("Burn")!=-1)
            {
             X-=33;
             TANK1.setBounds(X,Y,width,width);
              can-=20;
                OyunAlani.tank1_can.setValue(can);
                if(can<=0)
                    OyunAlani.GameOver();
            }
        }
        
    }
    public static void Tank1Down()
    {
        
        TANK1.setIcon(new ImageIcon(tankDown));
        int indis=((X/33)*20)+((Y+33)/33);
         JLabel blockKontrol=(JLabel)OyunAlani.elements[indis][0];
          if(OyunAlani.health[indis][0]!=null)
           {
                    if((Integer)OyunAlani.health[indis][1]==X && (Integer)OyunAlani.health[indis][2]==Y+33)
                    {
                    JLabel silinenHealth=(JLabel)OyunAlani.health[indis][0];
                    can=100;
                    OyunAlani.tank1_can.setValue(can);
                    OyunAlani.health[indis][0]=null;
                    OyunAlani.PANEL.remove(silinenHealth);
                     Y+=33;
                    TANK1.setBounds(X,Y,width,width); 
                    }
                    
          }
          else if(Y+33>=0 && Y+33<=627 && OyunAlani.elements[indis][0]==null)
        {
            Y+=33;
            TANK1.setBounds(X,Y,width,width);
            
        }
        else if(OyunAlani.elements[indis][0]!=null)
        {
            if(blockKontrol.getName().indexOf("Burn")!=-1)
            {
                Y+=33;
                TANK1.setBounds(X,Y,width,width);
                 can-=20;
                OyunAlani.tank1_can.setValue(can);
                if(can<=0)
                    OyunAlani.GameOver();
            }
        }
    }
    public static void Tank1Right()
    {
        
        TANK1.setIcon(new ImageIcon(tankRight));
        int indis=(((X+33)/33)*20)+(Y/33);
         JLabel blockKontrol=(JLabel)OyunAlani.elements[indis][0];
          if(OyunAlani.health[indis][0]!=null)
           {
                    if((Integer)OyunAlani.health[indis][1]==X+33 && (Integer)OyunAlani.health[indis][2]==Y)
                    {
                    JLabel silinenHealth=(JLabel)OyunAlani.health[indis][0];
                    can=100;
                    OyunAlani.tank1_can.setValue(can);
                    OyunAlani.health[indis][0]=null;
                    OyunAlani.PANEL.remove(silinenHealth);
                     X+=33;
                    TANK1.setBounds(X,Y,width,width); 
                    }
                    
          }
          else if(X+33>=0 && X+33<=1287 && OyunAlani.elements[indis][0]==null)
        {
            X+=33;
            TANK1.setBounds(X,Y,width,width);
        }
        else if(OyunAlani.elements[indis][0]!=null)
        {
            if(blockKontrol.getName().indexOf("Burn")!=-1)
            {
                X+=33;
                TANK1.setBounds(X,Y,width,width);
                 can-=20;
                OyunAlani.tank1_can.setValue(can);
                if(can<=0)
                    OyunAlani.GameOver();
            }
        }
    }
    public static void AtesEt()
    {
       Kursun1.KursunBilgileri(X, Y, yon);
    }
    public static ImageIcon Tank1image()
    {
       ImageIcon imgTank1=new ImageIcon(tankUp);
       return imgTank1;
    }
}
   
