
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//class Virus ที่มีส่วนประกอบตามที่โจทย์กำหนด
/*Comparable<Integer> กำหนดตัวที่จะใช้เพื่อเรียงลำดับใส่ค่าใน <> 
ที่เป็น Integer เพราะมันเรียงง่ายกว่าด้วยความที่ danger เป็นตัวอักษรที่ไม่ได้เรียงกัน
บอกมากไปน้อยนั่นหมายถึง "High","Moderate","Low" 
ก็เลยดัดแปลงให้ง่ายนิดหน่อยใน method typeDanger()
*/
class Virus implements Comparable<Integer> {

    private String id;
    private String name;
    private String spreading;
    private String danger;
    private String vaccine;

    public Virus(String id, String name, String spreading, String danger, String vaccine) {
        this.id = id;
        this.name = name;
        this.spreading = spreading;
        this.danger = danger;
        this.vaccine = vaccine;
    }

    public String getDanger() {
        return danger;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpreading() {
        return spreading;
    }

    public String getVaccine() {
        return vaccine;
    }
    //โจทย์บอกว่าต้องมีการเรียง danger ตรงนี้เพื่อความง่ายเลยเปลี่ยนเป็นตัวเลขสะเลย
    public Integer typeDanger() {
        String d = this.danger;

        if (d.equals("Low")) {//low แทนด้วย 0
            return 0;
        } else if (d.equals("Moderate")) {//Moderate แทนด้วย 1
            return 1;
        } else if (d.equals("High")) {//High แทนด้วย 2
            return 2;
        }
        return 0;
    }

    public static Virus getAll() { //ใช้สร้างวัตถุที่ผ่านการสุ่มทุกๆฟิลว์ตามที่โจทย์กำหนด
        Random r = new Random();
        Virus test;
        String id = "";
        String name[] = {"Adeno", "Barmah", "Corona", "Hendra"};
        String spreading[] = {"Slow", "Fast", "Very Fast"};
        String danger[] = {"Low", "Moderate", "High"};
        String vaccine[] = {"Yes", "No"};
        //-->อันนี้คือส่วนที่สุ่มสร้างส่วนของ id
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();//สร้างอาเรย์ของตัวอักษรแบบถึกๆ
        String testid = "";
        testid += letters[r.nextInt(letters.length)]+""+ r.nextInt(10)+""+ letters[r.nextInt(letters.length)]+""+ r.nextInt(10); 
        //สร้าง id ตามรูปแบบของโจทย์ใน 1 บรรทัดแอบคิดว่าต้องมีคนวนลูปแน่เลยแต่แบบนี้ง่ายกว่า
        testid = testid.toUpperCase();
        //ถ้าสังเกตจะเห็นว่า ตัวอักษรมีแต่พิมพ์เล็กนิหน่า toUpperCase() จะเปลี่ยนให้เป็นพิมพ์ใหญ่เองจร้าไม่ต้องกังวลไป
        //<--
        
        //ขั้นตอนนี้เราจะสร้างวัตถุขึ้นมาเพื่อ return ออกไปใช้งานเพราะอย่างลืมว่านี้คือใน method นะไม่ใช่ main มันจะง่ายๆมากๆถ้าเราต้องสุ่มหลายๆครั้งโดยการเรียก method นี้
        test = new Virus(testid, name[r.nextInt(name.length)], spreading[r.nextInt(spreading.length)], danger[r.nextInt(danger.length)], vaccine[r.nextInt(vaccine.length)]);

        return test;
    }

    @Override
    public String toString() {//return ค่าเป็น String ตามรูปแบบที่กำหนดโดยคั่นด้วย ","
        return id + "," + name + "," + spreading + "," + danger + "," + vaccine;
    }

    @Override
    public int compareTo(Integer o) {// ตรงนี้พูดง่ายๆคือเลือกตัวที่จะทำการเรียงลำดับนั้นเอง ซึ่งเราทำ method ที่เข้าใจง่ายๆไว้แล้วคือ typeDanger()
        return this.typeDanger().compareTo(o);//To change body of generated methods, choose Tools | Templates.
    }

}

class Myarray {// class ที่เก็บข้อมูลตามที่โจทย์กำหนด

    private ArrayList<Virus> data = new ArrayList<>();
    //สร้าง ArrayList มาเก็บเพราะง่ายต่อการเรียกใช้ดีและอาจารย์ก็ไม่ได้ห้ามด้วย อีกอย่างเราไม่ต้องกังวลว่ามันจะเต็มด้วยเนี่ยดีตรงนี้
    //เป็น private นะเพราะเราไม่อยากให้ใครมายุ่งกับ data ของเราง่ายๆต้องผ่าน method ที่เราสร้างเท่านั้น

    public ArrayList<Virus> getData() {//เรียกใช้  Array
        return data;
    }

    public void addFirst(Virus v) {//เพื่อไว้ข้างหน้าสุดของ  Array
        data.add(0, v);//ใน ArrayList มี method add(ตำแหน่ง, ค่าที่จะเพิ่มใน Array) เลยทำให้ง่ายในการใช้
    }

    public void addLast(Virus v) {//เพื่อไว้ข้างท้ายสุดของ  Array
        data.add(data.size(), v);//จริงอันนี้ไม่ต้องใส่ตำแหน่งก็ได้นะใช้เป็น add(ค่าที่จะเพิ่มใน Array) เลยมันก็จะต่อท้ายให้อยู่แล้ว
    }

    public void inSert(int index, Virus v) {//เพื่อไว้แทรงตำแหน่งใดๆก็ได้ของ  Array ซึ่งอาจารย์ไม่ได้สั่งก็เขียนเผื่อไว้เอง
        data.add(index - 1, v);
    }

    public void printMe() { //เอาไว้ปริ้นต์เช็คค่าใน Array เฉยว่าค่าที่เก็บเข้ามาถูกต้องมั้ย
        for (Virus x : data) {
            System.out.println(x.toString());
        }
        System.out.println("END PRINT");
    }

    public void sort() {//อันนี้เอาไว้เรียงตามที่โจทย์กำหนดคือจากมากไปน้อย
        Collections.sort(data, new VirusComparator());//ใส่  VirusComparator() ที่ช่วยในการเรียง
    }

}

class VirusComparator implements Comparator<Virus> {
//พระเอกของเราในการเรียงจากมากไปน้อยมาแล้ว
    @Override
    public int compare(Virus o1, Virus o2) {
        return o2.typeDanger().compareTo(o1.typeDanger()); //ถ้าเขียนแบบนี้จะเป็นการเรียงค่าที่มากไปน้อย ถ้าอยากเข้าใจแบบละเอียดมากไปอ่าน java doc เพราะมันมีการทำงานที่อาจจะบอกแล้วมึนกันไปเลย.
    }
}

/**
 *
 * @author User
 */
public class JFrame extends javax.swing.JFrame {
    
    
    Myarray my = new Myarray();//สร้างวัตถุที่ไว้เก็บข้อมูล

    public void dataTable(Myarray v) {
    /*อันนี้เอาไว้ขึ้นตาราง jTable1 อีกหนึ่งแบบที่อาจารย์ไม่ได้แปะให้ดูนะ สำหรับเราคิดว่าง่ายกว่านิดหน่อย
    โดยเราต้องสร้าง column เองก่อนนะจึงเขียนแบบนี้ได้
    */
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (Virus x : v.getData()) {
            System.out.println(x);
        }
        //--> การใส่ข้อมูลลงไปในแต่ละแถม แต่ละ column  สังเกตุจาก method ท้ายสุดก็ได้
        Object row[] = new Object[5];
        for (int i = 0; i < v.getData().size(); i++) {
            row[0] = v.getData().get(i).getId();
            row[1] = v.getData().get(i).getName();
            row[2] = v.getData().get(i).getSpreading();
            row[3] = v.getData().get(i).getDanger();
            row[4] = v.getData().get(i).getVaccine();

            model.addRow(row);
        }
        //<--
    }
      
    /**
     * Creates new form JFrame
     */
    public JFrame() {
        
        initComponents();
        this.setTitle( "เจ้ากรรม นายเวร" );
        this.jTextField1.setText("MyArray: 07610XXX เจ้ากรรม นายเวร");
        this.jTextField1.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButtonGen = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jButtonSort = new javax.swing.JButton();
        jButtonGen1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Spreading", "Danger", "Vaccine "
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setText("jTextField1");

        jButtonGen.setText("Generate");
        jButtonGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenActionPerformed(evt);
            }
        });

        jButtonAdd.setText("Add First");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonSort.setText("Sort");
        jButtonSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSortActionPerformed(evt);
            }
        });

        jButtonGen1.setText("Add Last");
        jButtonGen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGen1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonGen, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSort, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGen1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonGen, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jButtonGen1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButtonSort, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenActionPerformed
        // TODO add your handling code here:
        //ทุกครั้งที่กด Gen จะสร้างวัตถุมา 2 วัตถุ
        for(int i=0; i<2; i++){
            my.addFirst(Virus.getAll());
        }
//        my.printMe();
        dataTable(my); //แสดงขึ้นตาราง
    }//GEN-LAST:event_jButtonGenActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        my.addFirst(Virus.getAll());//สร้างวัตถุจาก Virus.getAll() แล้วเพิ่มหน้าสุด [index 0] ใน วัตถุที่เก็บข้อมูลคือ my 
        dataTable(my);//แสดงขึ้นตาราง
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonGen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGen1ActionPerformed
        // TODO add your handling code here:
         my.addLast(Virus.getAll());//สร้างวัตถุจาก Virus.getAll() แล้วเพิ่มท้ายสุด [index Array.size()]ใน วัตถุที่เก็บข้อมูลคือ my 
         dataTable(my);//แสดงขึ้นตาราง
    }//GEN-LAST:event_jButtonGen1ActionPerformed

    private void jButtonSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSortActionPerformed
        // TODO add your handling code here:
        my.sort();//ให้ข้อมูลในวัตถุ my เรียงจากมากไปน้อยคือ "High","Moderate","Low" 
        dataTable(my);//แสดงขึ้นตาราง
    }//GEN-LAST:event_jButtonSortActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

//        Myarray data = new Myarray();
//        for (int i = 0; i < 5; i++) {
//            data.addFirst(Virus.getAll());
//        }
//        data.printMe();
//        data.sort();
//        data.printMe();

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
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonGen;
    private javax.swing.JButton jButtonGen1;
    private javax.swing.JButton jButtonSort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
