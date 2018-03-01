/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankoyunu1;

import javax.swing.JLabel;
import static tankoyunu1.OyunAlani.KURSUN2;
import static tankoyunu1.OyunAlani.elements;

/**
 *
 * @author Yusuf
 */
public class Kursun2 {
    static int X;
    static int Y;
    static int width=33;
    static String yon;
    static String kursunLeft="images\\bullet-left.png";
    static String kursunUp="images\\bullet-up.png";
    static String kursunRight="images\\bullet-right.png";
    static String kursunDown="images\\bullet-down.png";
    static Thread kursunhareket;
    static Patlama pat;
     public static void KursunBilgileri(int X,int Y,String yon)
    {
        Kursun2.X=X;
        Kursun2.Y=Y;
        Kursun2.yon=yon;
        KursunOlustur();
        KursunHareket();
        kursunhareket.start();
    }
     private static void KursunOlustur()
    {
       if(yon=="up")
       {
        KURSUN2=new JLabel(new javax.swing.ImageIcon(kursunUp));
       }
       else if(yon=="down")
       {
        KURSUN2=new JLabel(new javax.swing.ImageIcon(kursunDown));
       }
       else if(yon=="left")
       {
        KURSUN2=new JLabel(new javax.swing.ImageIcon(kursunLeft));
       }
       else if(yon=="right")
       {
        KURSUN2=new JLabel(new javax.swing.ImageIcon(kursunRight));
       }
       
       KURSUN2.setBounds(tank1.X,tank1.Y,tank1.width,tank1.width);
       KURSUN2.setName("tank1");
    }
   public static void BlockKaldir(JLabel silinecekBlock)
    {
        pat = new Patlama(KURSUN2.getX(),KURSUN2.getY());
        JLabel silinenBlock=silinecekBlock;
        OyunAlani.PANEL.remove(silinenBlock);
        OyunAlani.PANEL.remove(KURSUN2);
        OyunAlani.PANEL.validate();
        OyunAlani.PANEL.repaint();
    }
    public static void KursunKaldir()
    {
        pat=new Patlama(KURSUN2.getX(),KURSUN2.getY());
        OyunAlani.PANEL.validate();
        OyunAlani.PANEL.repaint();
        OyunAlani.PANEL.remove(KURSUN2);
    }
    private static void KursunHareket()
    {
     kursunhareket=new Thread(){
                 @Override               
                 public void run()
                 {
                     int i=0;
                     while(i==0)
                     {
                        
                          if(yon=="up")
                          {
                            Y-=33;
                            KURSUN2.setBounds(X,Y,width,width);
                          }
                           if(yon=="down")
                          {
                            Y+=33;
                            KURSUN2.setBounds(X,Y,width,width);
                          }
                          if(yon=="left")
                          {
                            X-=33;
                            KURSUN2.setBounds(X,Y,width,width);
                          }
                          if(yon=="right")
                          {
                            X+=33;
                            KURSUN2.setBounds(X,Y,width,width);
                          }
                          if(X<0 || X>1287 || Y<0 || Y>627 || KURSUN2==null)
                          {
                            KursunKaldir();
                            KURSUN2=null;
                            break;                      
                          }    
                           int indis=((X/33)*20)+(Y/33);
                              if(X==(Integer)elements[indis][1] && Y==(Integer)elements[indis][2] && elements[indis][0]!=null)
                              {   
                                  JLabel blockKontrol=(JLabel)elements[indis][0];
                                  if(blockKontrol.getName().indexOf("label")!=-1)
                                  {
                                    BlockKaldir((JLabel)elements[indis][0]);
                                    KURSUN2=null;
                                    elements[indis][0]=null;
                                    i=1;
                                    break;
                                  }
                                  
                              }
                               if(X==tank1.X &&Y==tank1.Y)
                              {
                                KursunKaldir();
                                tank1.can-=20;
                                if(tank1.can>0)
                                    OyunAlani.tank1_can.setValue(tank1.can);
                                else if(tank1.can<=0)
                                {
                                   OyunAlani.tank1_can.setValue(tank1.can);
                                  OyunAlani.GameOver();
                                }
                                
                              
                                 KURSUN2=null;
                                    elements[indis][0]=null;
                                    i=1;
                                    break;
                              }
                          
                             try {
                                 Thread.sleep(50);
                             } catch (Exception e) {}
                      }
                                        
                 }
             };
    }
    
}
