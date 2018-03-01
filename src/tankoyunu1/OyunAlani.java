package tankoyunu1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import static tankoyunu1.tank1.tankUp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Yusuf
 */
public class OyunAlani extends javax.swing.JFrame{
    static Object[][] elements=new Object[800][3];
    static Object[][] health=new Object[800][3];
    public static JLabel TANK1;
    public static JLabel TANK2;
    public static JLabel KURSUN1;
    public static JLabel KURSUN2;
    public static JPanel PANEL;
    public static JLabel PATLAMA;
    
    public static JProgressBar tank1_can;
    public static JProgressBar tank2_can;
    
    public static String player1_name;
    public static String player1_tankRenk;
    public static String player2_name;
    public static String player2_tankRenk;     

    @Override
    public void enable(boolean b) {
        super.enable(false); //To change body of generated methods, choose Tools | Templates.
    }
    public OyunAlani(String player1,String tank1Renk,String player2,String tank2Renk) {
        initComponents();
        blockOlustur();
        CenterScreen();
        PANEL=jPanel1;
        tank1_can=player1_can;
        tank2_can=player2_can;
        lbl_player1_name.setText(player1);
        player1_name=player1;
        player1_tankRenk=tank1Renk;

        lbl_player2_name.setText(player2);
        player2_name=player2;
        player2_tankRenk=tank2Renk;
        //OyunEkrani=JFrame;
        this.setVisible(true);
        TanklariOlustur(tank1Renk,tank2Renk);
    }
   
    public void blockOlustur()//RANDOM DUVAR OLUŞTURMA
    {
         
        int sayac=0;
        for(int i=0;i<40;i++)
        {
            for(int j=0;j<20;j++)
            {
                 //LABEL ÜRET
                JLabel label=new JLabel(new javax.swing.ImageIcon("images\\wall-orange.png"));
                label.setName("label"+Integer.toString(sayac));
                label.setBounds(i*33,j*33,33,33);
                //LABEL,X VE Y DEĞERLERİNİ DİZİYE KAYDET
                elements[sayac][0]=label;
                elements[sayac][1]=i*33;
                elements[sayac][2]=j*33;
                sayac++;
            }
        }
        randomBlockBoslukAta();
        
    }
    public void randomBlockBoslukAta()//HARİTALAR ÜZERİNDEKİ BOŞLUKLAR
    {
        elements[19][0]=null;
        elements[780][0]=null;
        Random r=new Random();      
       int i=0;
        while(i<=500)
       {
            int a =r.nextInt(800);
            if(elements[a][0]!=null)
            {
             elements[a][0]=null;
             i++;
            }
           
        }
        i=0;
        blockYazdir();
    }
    public void atesEkle()//HARİTAYA ATEŞLERİ EKLE
    {
     int sayac=0;
     Random r=new Random();      
        for (int i = 0; i < 25; i++) {
            int a =r.nextInt(800);
           // int sayac=0;
            if(elements[a][0]==null && a!=19 && a!=780)
            {
                JLabel label=new JLabel(new javax.swing.ImageIcon("images\\fire.gif"));
                label.setBounds((Integer)elements[a][1],(Integer)elements[a][2],33,33);
                 label.setName("Burn"+Integer.toString(sayac));
                elements[a][0]=label;
                jPanel1.add(label);
                sayac++;
            }
        }
    }
    public void healthEkle()//HARİTALARA RANDOM CAN EKLE
    {
     int sayac=0;
     Random r=new Random();      
        for (int i = 0; i < 25; i++) {
            int a =r.nextInt(800);
            
            if(elements[a][0]!=null && a!=19 && a!=780)
            {
                JLabel label=new JLabel(new javax.swing.ImageIcon("images\\health.png"));
                label.setBounds((Integer)elements[a][1],(Integer)elements[a][2],33,33);
                 label.setName("Health"+Integer.toString(sayac));
                 health[a][0]=label;
                 health[a][1]=(Integer)elements[a][1];
                 health[a][2]=(Integer)elements[a][2];
                jPanel1.add(label);
                ++sayac;
            }
        }
    }
    public void blockYazdir()//DUVARLARI ,ATEŞ VE CANLARI PANELE EKLE
    {
    //LABEL NULL DEĞİLSE EKRANA BAS.
        for(int i=0;i<elements.length;i++)
        {
           if(elements[i][0]!=null)
              jPanel1.add((JLabel)elements[i][0]);
            
        }
        atesEkle();
        healthEkle();
        
    }
      public void CenterScreen()//EKRANI ORTALA
    {
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
    }
    public void TanklariOlustur(String tank1Renk,String tank2Renk)//TANKLAR OLUŞTURULUYOR
    {
       tank1.Tank1Olustur(tank1Renk);
       tank2.Tank2Olustur(tank2Renk);
       jPanel1.add(TANK1);
       jPanel1.add(TANK2);
       player1_tank.setText("");
       player1_tank.setIcon(tank1.Tank1image());
       player1_can.setValue(tank1.can);
       player2_tank.setText("");
       player2_tank.setIcon(tank2.Tank2image());
       player2_can.setValue(tank2.can);
    }
    public static void GameOver()//OYUN BİTİNCE GAMEOVER FRAME ÇAĞIR
    { 
        AnaEkran.OyunAlaniDisabled();
        GameOver GO;
        if(tank1.can<20)
        {
            GO=new GameOver(player2_name,player2_tankRenk,player1_name,player1_tankRenk);
            GO.show();
        }
        if(tank2.can<20)
        {
            GO=new GameOver(player1_name,player1_tankRenk,player2_name,player2_tankRenk); 
            GO.show();
            
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        player1_can = new javax.swing.JProgressBar();
        lbl_player1_name = new javax.swing.JLabel();
        player1_tank = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        player2_can = new javax.swing.JProgressBar();
        lbl_player2_name = new javax.swing.JLabel();
        player2_tank = new javax.swing.JLabel();
        cikis = new javax.swing.JButton();
        anamenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setUndecorated(true);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        lbl_player1_name.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_player1_name.setText("PLAYER 1");

        player1_tank.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        player1_tank.setText("PLAYER 1");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player1_tank, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lbl_player1_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(player1_can, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_player1_name)
                    .addComponent(player1_can, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(player1_tank)
                .addGap(26, 26, 26))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lbl_player2_name.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_player2_name.setText("PLAYER 2");

        player2_tank.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        player2_tank.setText("PLAYER 1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_player2_name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(player2_can, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(player2_tank, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player2_can, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_player2_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(player2_tank)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        cikis.setBackground(new java.awt.Color(36, 47, 65));
        cikis.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        cikis.setForeground(new java.awt.Color(255, 255, 255));
        cikis.setText("ÇIKIŞ");
        cikis.setFocusable(false);
        cikis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cikisMouseClicked(evt);
            }
        });
        cikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cikisActionPerformed(evt);
            }
        });

        anamenu.setBackground(new java.awt.Color(36, 47, 65));
        anamenu.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        anamenu.setForeground(new java.awt.Color(255, 255, 255));
        anamenu.setText("ANA MENU");
        anamenu.setFocusable(false);
        anamenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                anamenuMouseClicked(evt);
            }
        });
        anamenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anamenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(447, Short.MAX_VALUE)
                .addComponent(anamenu, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cikis, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(453, 453, 453))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cikis, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anamenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        setBounds(0, 0, 1320, 837);
    }// </editor-fold>//GEN-END:initComponents
    //TUŞLAR
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_UP)
       {
          tank1.Tank1Up();
          tank1.yon="up";
       }
       if(evt.getKeyCode()==KeyEvent.VK_LEFT)
       {
          tank1.Tank1Left();
          tank1.yon="left";
       }
       if(evt.getKeyCode()==KeyEvent.VK_RIGHT)
       {
          tank1.Tank1Right();
          tank1.yon="right";
       }
       if(evt.getKeyCode()==KeyEvent.VK_DOWN)
       {
          tank1.Tank1Down();
          tank1.yon="down";
       }
       if(evt.getKeyCode()==KeyEvent.VK_NUMPAD5)
       {
           try 
           {
               if(KURSUN1==null)
                {
                 tank1.AtesEt();
                 jPanel1.add(KURSUN1);
                }
           } 
           catch (NullPointerException e)
           {
               
           }
         
       }
       if(evt.getKeyCode()==KeyEvent.VK_W)
       {
          tank2.Tank2Up();
          tank2.yon="up";
       }
       if(evt.getKeyCode()==KeyEvent.VK_S)
       {
          tank2.Tank2Down();
          tank2.yon="down";
       }
       if(evt.getKeyCode()==KeyEvent.VK_A)
       {
          tank2.Tank2Left();
          tank2.yon="left";
       }
       if(evt.getKeyCode()==KeyEvent.VK_D)
       {
          tank2.Tank2Right();
          tank2.yon="right";
       }
       if(evt.getKeyCode()==KeyEvent.VK_SPACE)
       {
           try 
           {
                if(KURSUN2==null)
                {
                 tank2.AtesEt();
                 jPanel1.add(KURSUN2);
                }
           }
           catch (NullPointerException e) 
           {
               
           }
        
       }
       
    }//GEN-LAST:event_formKeyPressed

    private void cikisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cikisMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cikisMouseClicked
    //ÇIKIŞ BUTONU
    private void cikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cikisActionPerformed
        System.exit(0);
    }//GEN-LAST:event_cikisActionPerformed

    private void anamenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anamenuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_anamenuMouseClicked

    private void anamenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anamenuActionPerformed
        jPanel1.remove(TANK1);
        jPanel1.remove(TANK2);
         OyunAlani.PANEL.validate();
        OyunAlani.PANEL.repaint();
        this.dispose();
        AnaEkran AE=new AnaEkran();
        AE.show();
    }//GEN-LAST:event_anamenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OyunAlani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OyunAlani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OyunAlani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OyunAlani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              //  new OyunAlani().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anamenu;
    private javax.swing.JButton cikis;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl_player1_name;
    private javax.swing.JLabel lbl_player2_name;
    private javax.swing.JProgressBar player1_can;
    private javax.swing.JLabel player1_tank;
    private javax.swing.JProgressBar player2_can;
    private javax.swing.JLabel player2_tank;
    // End of variables declaration//GEN-END:variables
}
