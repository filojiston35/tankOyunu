/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankoyunu1;


import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

/**
 *
 * @author Yusuf
 */
public class Patlama {
    static int sayac;
    static int X;
    static int Y;
    static int width=66;
    static Timer myTimer;
    public Patlama(int X,int Y)
    {
        Patlama.X=X;
        Patlama.Y=Y;
        Goster();
        sayac=0;
    }
    public static void Goster()
    {
        OyunAlani.PATLAMA=new JLabel(new javax.swing.ImageIcon("images\\fire2.gif"));
        OyunAlani.PATLAMA.setBounds(X, Y, width, width);
        OyunAlani.PANEL.add(OyunAlani.PATLAMA);
        
         myTimer=new Timer();
             TimerTask gorev =new TimerTask() {
 
                    @Override
                    public void run() {
                                
                           sayac++;
                           if(sayac==2)
                           {
                                OyunAlani.PANEL.remove(OyunAlani.PATLAMA);
                                  OyunAlani.PANEL.validate();
                                  OyunAlani.PANEL.repaint();
                                 myTimer.cancel();
                           }
                                 
                    }
             };
 
             myTimer.schedule(gorev,0,250);
            
    }
}
