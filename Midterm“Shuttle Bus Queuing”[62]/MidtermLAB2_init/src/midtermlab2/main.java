package midtermlab2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

class Passenger {
    /*
    คลาส Passenger ที่ประกอบด้วยฟิลด์: name และ hotel โดยที่ทั้ง 2 ฟิลด์เป็นแบบ private
    มี  constructor และ เมธอดที่จำเป็นตามข้อที่ 1
    */
    

    private String name;
    private String hotel;

    public Passenger(String name, String hotel) {
        this.name = name;
        this.hotel = hotel;
    }

    public String getName() {
        return name;
    }

    public String getHotel() {
        return hotel;
    }

    @Override
    public String toString() {//สร้าง toString ตามแบบที่โจทย์กำหนด
        return name + "-" + hotel;
    }
}

public class main extends javax.swing.JFrame {

    public static Queue<Passenger> passengerQueue = new LinkedList<>();
    //เก็บผู้โดยสารทั้งหมด
    public static Queue<Passenger> busAQueue = new LinkedBlockingQueue<>(9);
    //เก็บผู้โดยสารรถบัส A
    public static Queue<Passenger> busBQueue = new LinkedBlockingQueue<>(9);
    //เก็บผู้โดยสารรถบัส B
    public static Queue<Passenger> busCQueue = new LinkedBlockingQueue<>(9);
    //เก็บผู้โดยสารรถบัส C
    public static Queue<Passenger> waitQueue = new LinkedList<>();
    //เก็บผู้โดยสารที่ต้องรอรถบัส

    public static int countA = 0;
    public static int countB = 0;
    public static int countC = 0;

    Random r = new Random();
    public static int a = 0, b = 0, c = 0;
    //นับจำนวนผู้โดยสารที่จะไปโรงแรม A,B,C ตามลำดับ

    public main() {
        initComponents();
        this.setTitle("เจ้ากรรม นายเวร");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Shuttle Buses Queuing");

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("jTextField1");

        jButton1.setText("Gen-number");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Gen-passengers");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        jTextField6.setText("jTextField6");

        jButton3.setText("Get-in");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField7.setText("jTextField7");

        jLabel2.setText("BusA");

        jLabel3.setText("BusB");

        jLabel4.setText("BusC");

        jLabel5.setText("WaitQueue");

        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("jTextField8");

        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("jTextField9");

        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText("jTextField10");

        jTextField11.setText("jTextField11");

        jButton4.setText("Count");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3)
                            .addComponent(jButton3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton4)
                                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Gen-number
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        passengerQueue.clear();
        busAQueue.clear();
        busBQueue.clear();
        busCQueue.clear();
        waitQueue.clear();
        //เคลียร์ Queue เพื่อรอรับผู้โดยสาร
        jTextField1.setText(Integer.toString(10 + r.nextInt(41)));
        //สุ่มจำนวนผู้โดยสารที่มีค่าระหว่าง 10-50 แปลงเป็น String และ set แสดงใน jTextField1
        //ตามจุดประสงค์ข้อที่ 2
        
        //print ดูค่า ascii code
        System.out.println(((int) 'A') + " " + ((int) 'a'));
        System.out.println(((int) 'Z') + " " + ((int) 'z'));
        System.out.println(((int) '_') + "");
        
    }//GEN-LAST:event_jButton1ActionPerformed
    // Gen-passengers
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int n = Integer.parseInt(jTextField1.getText());
        //นำค่าจาก jTextField1 แปลงเป็น ตัวเลข
        String[] h = {"A", "B", "C"};
        //Array ชื่อโรงแรมเพื่อใช้สุ่ม
        a = 0;
        b = 0;
        c = 0;
        //เซตค่าตัวนับให้เป็น 0
        for (int i = 0; i < n; i++) {//วนลูปตามจำนวนค่าที่รับมาจาก jTextField1
            String name = "";
            name += (char) (65 + r.nextInt(24));//สร้างตัวอักษรพิมพ์ใหญ่จาก ascii code
            name += (char) (32+(65 + r.nextInt(24)));//สร้างตัวอักษรพิมพ์เล็กจาก ascii code
            String num = h[r.nextInt(3)];//สุ่มเลือกโรงแรม
            //>>นับจำนวนผู้โดยสารแต่ละโรงแรม
            if (num.equals("A")) {
                a++;
            }
            if (num.equals("B")) {
                b++;
            }
            if (num.equals("C")) {
                c++;
            }
            //<<นับจำนวนผู้โดยสารแต่ละโรงแรม
            passengerQueue.add(new Passenger(name, num));
            //สร้างวัตถุจากคลาส Passenger แล้วใส่เข้าไปใน passengerQueue Queue ของผู้โดยสารทั้งหมด
        }
        jTextField2.setText("Hotel-A= " + Integer.toString(a) + " Hotel-B= " + Integer.toString(b) + " Hotel-C= " + Integer.toString(c));
        //แสดงจำนวนผู้โดยสารที่จะเข้าพักโรงแรม A,B,C ตามลำดับใน jTextField2
        jTextField3.setText(passengerQueue.toString());
        //แสดงชื่อและโรงแรมทั้งหมดตามรูปแบบบที่โจทย์กำหนดใน  jTextField3
        //จบจุดประสงค์ข้อที่ 3

    }//GEN-LAST:event_jButton2ActionPerformed

    // Get-in
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        while (!passengerQueue.isEmpty()) {
        /*วนลูปจนกว่า Queue ของผู้โดยสารทั้งหมดจะว่าง นั่นคือวนจนกว่าจะครบทุกคน
        
        รถบัสแต่ละคันจะมีผู้โดยสารขึ้นได้เพียง 9 คนเท่านั้น
        */
            //เงื่อนไขเช็คว่าผู้โดยสารพักโรงแรมใดให้ขึ้นรถประจำโรงแรมนั้น และ ย้ำว่ารถบัสนั่งได้เพียง 9 คน
            if (passengerQueue.peek().getHotel().equals("A") && busAQueue.size() <9) {
                busAQueue.add(passengerQueue.remove());
            } 
            else if (passengerQueue.peek().getHotel().equals("B") && busBQueue.size() < 9) {
                busBQueue.add(passengerQueue.remove());
            }
            else if (passengerQueue.peek().getHotel().equals("C") && busCQueue.size() < 9) {
                busCQueue.add(passengerQueue.remove());
            } else {//ถ้ารถบัสเต็มจะต้องมาเข้า Queue สำหรับรอ
                waitQueue.add(passengerQueue.remove());
            }
        }
        jTextField4.setText(busAQueue.toString());
        //แสดงผู้โดยสารที่ขึ้นรถบัสประจำโรงแรม A ใน jTextField4
        jTextField5.setText(busBQueue.toString());
        //แสดงผู้โดยสารที่ขึ้นรถบัสประจำโรงแรม B ใน jTextField5
        jTextField6.setText(busCQueue.toString());
        //แสดงผู้โดยสารที่ขึ้นรถบัสประจำโรงแรม C ใน jTextField6
        jTextField7.setText(waitQueue.toString());
        //แสดงผู้โดยสารที่รอขึ้นรถบัสประจำโรงแรม ใน jTextField7
        //จบจุดประสงค์ข้อที่ 4

    }//GEN-LAST:event_jButton3ActionPerformed

    // Count
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int numa=0, numb=0,numc=0;//จำนวนผู้โดยสารที่นั่งรถบัสประจำโรงแรมแต่ละโรงแรม A,B,C ตามลำดับ
        int wa=0,wb=0,wc=0;//จำนวนผู้โดยสารที่รอรถบัสประจำโรงแรมแต่ละโรงแรม A,B,C ตามลำดับ
        //<<นับจำนวนผู้โดยสารว่าขึ้นรถกี่คน และรอกี่คนในแต่ละโรงแรม A,B,C ตามลำดับ
        if(a<=9){numa=a;}else{numa=9;wa = a-9;}
        if(b<=9){numb=b;}else{numb=9;wb = b-9;}
        if(c<=9){numc=c;}else{numc=9;wc = c-9;}
        //>>นับจำนวนผู้โดยสารว่าขึ้นรถกี่คน และรอกี่คนในแต่ละโรงแรม A,B,C ตามลำดับ
        jTextField8.setText(Integer.toString(numa));
        //แสดงจำนวนผู้โดยสารที่นั่งรถบัสประจำโรงแรม A ใน jTextField8
         jTextField9.setText(Integer.toString(numb));
         //แสดงจำนวนผู้โดยสารที่นั่งรถบัสประจำโรงแรม B ใน jTextField9
         jTextField10.setText(Integer.toString(numc));
         //แสดงจำนวนผู้โดยสารที่นั่งรถบัสประจำโรงแรม C ใน jTextField10
         jTextField11.setText("Hotel-A= " + Integer.toString(wa) + " Hotel-B= " + Integer.toString(wb) + " Hotel-C= " + Integer.toString(wc));
         //แสดงจำนวนคนที่กำลังรอรถประจำโรงแรม A,B,C ตามลำดับ ใน jTextField11
         //จบจุดประสงค์ข้อที่ 5
        
    }//GEN-LAST:event_jButton4ActionPerformed

    // close
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        System.exit(0);//ปิดโปรแกรม
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
