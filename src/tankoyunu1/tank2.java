/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankoyunu1;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static tankoyunu1.OyunAlani.TANK2;


/**
 *
 * @author Yusuf
 */
public class tank2 {
    static String yon;
    static int X=1287;//1287
    static int Y=0;
    static int width=33;
    static int can=100;
    static String tankRenk="";
    static String tankLeft= "";
    static String tankRight="";
    static String  tankUp="";
    static String tankDown="";
    
    public static void Tank2Olustur(String tankRenk2)
    {
          X=1287;//1287
          Y=0;
          can=100;
        tankRenk=tankRenk2;
        tankLeft="images\\"+tankRenk+"-tank-left.png";
        tankRight="images\\"+tankRenk+"-tank-right.png";
        tankUp="images\\"+tankRenk+"-tank-up.png";
        tankDown="images\\"+tankRenk+"-tank-down.png";     
       TANK2=new JLabel(new javax.swing.ImageIcon(tank2.tankDown));
       TANK2.setBounds(tank2.X,tank2.Y,tank2.width,tank2.width);
       TANK2.setName("tank2");
    }
     public static void Tank2Up()
    {
        TANK2.setIcon(new ImageIcon(tankUp));
         int indis=((X/33)*20)+((Y-33)/33);
         JLabel blockKontrol=(JLabel)OyunAlani.elements[indis][0];
          if(OyunAlani.health[indis][0]!=null)
           {
                    if((Integer)OyunAlani.health[indis][1]==X && (Integer)OyunAlani.health[indis][2]==Y-33)
                    {
                    JLabel silinenHealth=(JLabel)OyunAlani.health[indis][0];
                    can=100;
                    OyunAlani.tank2_can.setValue(can);
                    OyunAlani.health[indis][0]=null;
                    OyunAlani.PANEL.remove(silinenHealth);
                     Y-=33;
                    TANK2.setBounds(X,Y,width,width); 
                    }
                    
          }
          else if(Y-33>=0 && Y-33<=627 && OyunAlani.elements[indis][0]==null)
        {       
                Y-=33;
                TANK2.setBounds(X,Y,width,width);           
        }
        else if(OyunAlani.elements[indis][0]!=null)
        {
            if(blockKontrol.getName().indexOf("Burn")!=-1)
            {
                 Y-=33;
                TANK2.setBounds(X,Y,width,width);
                 can-=20;
                OyunAlani.tank2_can.setValue(can);
                if(can<=0)
                    OyunAlani.GameOver();
            }
        }
       
    }
    public static void Tank2Left()
    {
        TANK2.setIcon(new ImageIcon(tankLeft));
        int indis=(((X-33)/33)*20)+(Y/33);
         JLabel blockKontrol=(JLabel)OyunAlani.elements[indis][0];
          if(OyunAlani.health[indis][0]!=null)
           {
                    if((Integer)OyunAlani.health[indis][1]==X-33 && (Integer)OyunAlani.health[indis][2]==Y)
                    {
                    JLabel silinenHealth=(JLabel)OyunAlani.health[indis][0];
                    can=100;
                    OyunAlani.tank2_can.setValue(can);
                    OyunAlani.health[indis][0]=null;
                    OyunAlani.PANEL.remove(silinenHealth);
                     X-=33;
                    TANK2.setBounds(X,Y,width,width); 
                    }
                    
          }
          else if(X-33>=0 && X-33<=1287 && OyunAlani.elements[indis][0]==null)
        {
            X-=33;            
            TANK2.setBounds(X,Y,width,width);
        }
        else if(OyunAlani.elements[indis][0]!=null)
        {
            if(blockKontrol.getName().indexOf("Burn")!=-1)
            {
             X-=33;
             TANK2.setBounds(X,Y,width,width);
              can-=20;
                OyunAlani.tank2_can.setValue(can);
              if(can<=0)
                    OyunAlani.GameOver();
            }
        }
        
    }
    public static void Tank2Down()
    {
        TANK2.setIcon(new ImageIcon(tankDown));
        int indis=((X/33)*20)+((Y+33)/33);
         JLabel blockKontrol=(JLabel)OyunAlani.elements[indis][0];
          if(OyunAlani.health[indis][0]!=null)
           {
                    if((Integer)OyunAlani.health[indis][1]==X && (Integer)OyunAlani.health[indis][2]==Y+33)
                    {
                    JLabel silinenHealth=(JLabel)OyunAlani.health[indis][0];
                    can=100;
                    OyunAlani.tank2_can.setValue(can);
                    OyunAlani.health[indis][0]=null;
                    OyunAlani.PANEL.remove(silinenHealth);
                     Y+=33;
                    TANK2.setBounds(X,Y,width,width); 
                    }
                    
          }
          else if(Y+33>=0 && Y+33<=627 && OyunAlani.elements[indis][0]==null)
        {
            Y+=33;         
            TANK2.setBounds(X,Y,width,width);
        }
        else if(OyunAlani.elements[indis][0]!=null)
        {
            if(blockKontrol.getName().indexOf("Burn")!=-1)
            {
                Y+=33;
                TANK2.setBounds(X,Y,width,width);
                 can-=20;
                OyunAlani.tank2_can.setValue(can);
                if(can<=0)
                    OyunAlani.GameOver();
            }
        }
    }
    public static void Tank2Right()
    {
        
        TANK2.setIcon(new ImageIcon(tankRight));
        int indis=(((X+33)/33)*20)+(Y/33);
         JLabel blockKontrol=(JLabel)OyunAlani.elements[indis][0];
          if(OyunAlani.health[indis][0]!=null)
           {
                    if((Integer)OyunAlani.health[indis][1]==X+33 && (Integer)OyunAlani.health[indis][2]==Y)
                    {
                    JLabel silinenHealth=(JLabel)OyunAlani.health[indis][0];
                    can=100;
                    OyunAlani.tank2_can.setValue(can);
                    OyunAlani.health[indis][0]=null;
                    OyunAlani.PANEL.remove(silinenHealth);
                     X+=33;
                    TANK2.setBounds(X,Y,width,width); 
                    }
                    
          }
          else if(X+33>=0 && X+33<=1287 && OyunAlani.elements[indis][0]==null)
        {
            X+=33;            
            TANK2.setBounds(X,Y,width,width);
        }
        else if(OyunAlani.elements[indis][0]!=null)
        {
            if(blockKontrol.getName().indexOf("Burn")!=-1)
            {
                X+=33;
                TANK2.setBounds(X,Y,width,width);
                 can-=20;
                OyunAlani.tank2_can.setValue(can);
                if(can<=0)
                    OyunAlani.GameOver();
            }
        }
    }
    public static void AtesEt()
    {
       Kursun2.KursunBilgileri(X, Y, yon);
    }
     public static ImageIcon Tank2image()
    {
       ImageIcon imgTank1=new ImageIcon(tankUp);
       return imgTank1;
    }
   
}
