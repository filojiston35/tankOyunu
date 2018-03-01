/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankoyunu1;

/**
 *
 * @author Yusuf
 */
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static tankoyunu1.OyunAlani.KURSUN1;
import static tankoyunu1.OyunAlani.elements;
public class Kursun1 {
    
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
        Kursun1.X=X;
        Kursun1.Y=Y;
        Kursun1.yon=yon;
        KursunOlustur();
        KursunHareket();
        kursunhareket.start();
    }
    private static void KursunOlustur()
    {
       if(yon=="up")
       {
        KURSUN1=new JLabel(new javax.swing.ImageIcon(kursunUp));
       }
       else if(yon=="down")
       {
        KURSUN1=new JLabel(new javax.swing.ImageIcon(kursunDown));
       }
       else if(yon=="left")
       {
        KURSUN1=new JLabel(new javax.swing.ImageIcon(kursunLeft));
       }
       else if(yon=="right")
       {
        KURSUN1=new JLabel(new javax.swing.ImageIcon(kursunRight));
       }
       
       KURSUN1.setBounds(tank1.X,tank1.Y,tank1.width,tank1.width);
       KURSUN1.setName("tank1");
    }
    public static void BlockKaldir(JLabel silinecekBlock)
    {
        pat=new Patlama(KURSUN1.getX(),KURSUN1.getY());
        JLabel silinenBlock=silinecekBlock;
        OyunAlani.PANEL.remove(silinenBlock);
        OyunAlani.PANEL.remove(KURSUN1);
        OyunAlani.PANEL.validate();
        OyunAlani.PANEL.repaint();
        
    }
    public static void KursunKaldir()
    { 
        pat=new Patlama(KURSUN1.getX(),KURSUN1.getY());
        OyunAlani.PANEL.validate();
        OyunAlani.PANEL.repaint();
         OyunAlani.PANEL.remove(KURSUN1);

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
                            KURSUN1.setBounds(X,Y,width,width);
                          }
                           if(yon=="down")
                          {
                            Y+=33;
                            KURSUN1.setBounds(X,Y,width,width);
                          }
                          if(yon=="left")
                          {
                            X-=33;
                            KURSUN1.setBounds(X,Y,width,width);
                          }
                          if(yon=="right")
                          {
                            X+=33;
                            KURSUN1.setBounds(X,Y,width,width);
                          }
                          if(X<0 || X>1287 || Y<0 || Y>627 || KURSUN1==null)
                          {
                            KursunKaldir();
                            KURSUN1=null;
                            break;                      
                          }    
                           int indis=((X/33)*20)+(Y/33);
                              if(X==(Integer)elements[indis][1] && Y==(Integer)elements[indis][2] && elements[indis][0]!=null)
                              {   
                                  JLabel blockKontrol=(JLabel)elements[indis][0];
                                  if(blockKontrol.getName().indexOf("label")!=-1)
                                  {
                                    BlockKaldir((JLabel)elements[indis][0]);
                                    KURSUN1=null;
                                    elements[indis][0]=null;
                                    i=1;
                                    break;
                                  }
                                  
                              }
                              if(X==tank2.X &&Y==tank2.Y)
                              { 
                               KursunKaldir();
                                tank2.can-=20;
                                if(tank2.can>0)
                                {

                                    OyunAlani.tank2_can.setValue(tank2.can);
                                }
                                    
                                else if(tank2.can<=0)
                                {
                                  OyunAlani.tank2_can.setValue(tank2.can);
                                  OyunAlani.GameOver();
                                }
                                 
                                    KURSUN1=null;
                                    //elements[indis][0]=null;
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
