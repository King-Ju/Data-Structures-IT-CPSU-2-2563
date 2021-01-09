
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
class Attraction {//คลาสสถานที่ท่องเที่ยวตามที่โจทย์กำหนด
/*
    ฟิดล์ควรเป็น private เพื่อเรียนรู้การใช้งานในเรื่องขอบเขตของตัวแปร
    ตัวสร้าง,get(),set() ตัวความเหมาะสม
    แต่ต้องมี toString() เพื่อ return ค่าฟิลด์ในคลาสและนำไปใช้งานต่อในส่วนอื่นๆ
     */
    private String code;
    private String name;
    private String type;
    private String country;

    public Attraction(String code, String name, String type, String country) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return code + "," + name + "," + type + "," + country;
    }

}

class Node {//คลาส Node ที่มีองค์ประกอบตาม ทฤษฎี 

    Attraction data;//เก็บข้อมูล
    Node next;//ข้อมูลต่อไป
    Node prev;//ข้อมูลก่อนหน้า

    Node(Attraction x) {//ใส่ข้อมูลโดยตัวสร้าง
        data = x;
    }

    /*
    get() และ set()
    ที่ใช้จัดการกับ Node ตามความจำเป็นและเหมาะสม
     */
    public void setNext(Node n) {
        next = n;
    }

    public Node getNext() {
        return next;
    }

    public void setPrev(Node n) {
        prev = n;
    }

    public Node getPrev() {
        return prev;
    }

    /*
    getData() เพื่อแสดงค่าที่เก็บไว้ใน Node นั้นๆ
     */
    public Attraction getData() {
        return data;
    }
}

class DoublyLinkedList {//คลาส DoublyLinkedList ตาม ทฤษฎี 

    Node head;//ข้อมูลหน้าสุดใน DoublyLinkedList
    Node tail;//ข้อมูลหลังสุดใน DoublyLinkedList
    int count;// size ของ DoublyLinkedList
/*
     addFirst(),addLast()
    ตามโจทย์มีการ return String ออกมาในรูปแบบ
    "add [First/Last] " + n.getData();
     */
    public String addFirst(Node n) {
        if (head == null) {
            head = n;
            tail = n;
        } else {
            head.setPrev(n);
            n.setNext(head);
            head = n;
        }
        count++;
        return "add First " + n.getData();
    }

    public String addLast(Node n) {
        if (head == null) {
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }
        count++;
        return "add Last " + n.getData();
    }

    public void print() {// print สิ่งที่อยู่ใน DoublyLinkedList ทั้งหมด
        System.out.println("Size = " + count);//ขนาดของ DoublyLinkedList
        Node p = head;//ข้อมูลหน้าสุดหรือ index แรก 
        while (p != null) {//จนกว่าจะไม่มีข้อมูลตัวต่อไป
            System.out.println(p.getData());// print ออกมาดูข้อมูลภายใน
            p = p.getNext();//ข้อมูลตัวต่อไป
        }
    }
}

public class Assignment_4 extends javax.swing.JFrame {

    /**
     * Creates new form Assignment_4
     */
    static DoublyLinkedList db;//DoublyLinkedList ประกาศแบบใจง่าย
    Random r = new Random();//เครื่องมือสุ่ม
    static String reGen = "";// String ที่เก็บไว้เพื่อทำตามจุดประสงค์ในข้อที่ 4.2
    static String[] header = {"Code", "Name", "type", "Country"};//ชื่อ column
    public static String[] name = {"Stonehenge", "Maldives", "Maldives", "Great Wall of China", "Vaccine", "Madagascar", "Taj Mahal"};
    //Array ชื่อสถานที่ท่องเที่ยวที่เตรียมไว้
    public static String[] type = {"Historical Attraction", "Natural Attraction", "Cultural Attraction"};
    //Array ชนิดที่เตรียมไว้
    public static String[] country = {"London", "Italy", "India", "China"};
    //Array ประดทศที่เตรียมไว้

    /*
    inTable();
    เป็น method ที่ทำไว้สำหรับขึ้นตารางใน GUI
     */
    public void inTable(DoublyLinkedList Doubly) {
        //>>>ขี้นตาราง แบบ Linked List จะไม่ค่อยปกติสักเท่าไร 
        Object[][] x = new Object[Doubly.count][];

        //===>วิธีที่ 1
        Node ptr = Doubly.head;//เอา Node แรกแยกออกมาเพื่อความง่าย
        x[0] = Doubly.head.getData().toString().split(",");
        //และจัดการแบ่งมันด้วย "," ก่อนยังเข้า array x หรือ row แบบหวานๆ ใน index[0]
        ptr = ptr.getNext();//เลื่อนมาที่ Node ต่อไป
        int c = 1;//ให้ค่า c เป็นตัวแทยของ row หรือ index ใน array x
        while (ptr.getNext() != null) {//วนหาไป Node ต่อๆไปจนกว่าจะไม่มีให้ไปต่อ

            x[c] = ptr.getData().toString().split(",");
            //และจัดการแบ่งมันด้วย "," ก่อนยังเข้า array x หรือ row แบบหวานๆ ใน index[c]
            ptr = ptr.getNext();//เลื่อนไป Node ต่อไปจร้า
            c++;//เพิ่มค่า index ด้วยนะ
        }
        x[c] = ptr.getData().toString().split(",");
        //<===วิธีที่ 1

        //===>วิธีที่ 2
//        Node ptr = Doubly.head;
//        for (int i = 0; i < Doubly.count; i++) {
//            x[i] = ptr.getData().toString().split(",");
//            ptr = ptr.getNext();
//        }
        //<===วิธีที่ 2
        javax.swing.table.DefaultTableModel model1 = new javax.swing.table.DefaultTableModel(x, header);
        //จัดแจงเตรียมขึ้นตาราง (row หรือ แถว,ชื่อ column)
        jTable1.setModel(model1);//แสดงขึ้นตารางใน GUI
    }

    public Assignment_4() {
        initComponents();
        this.setTitle("เจ้ากรรม นายเวร");
        String name = "DBL Operations: 0761XXXX เจ้ากรรม นายเวร";
        this.jLabel1.setText(name);

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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        Generate = new javax.swing.JButton();
        Operate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        Generate.setText("Generate");
        Generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateActionPerformed(evt);
            }
        });

        Operate.setText("Operate");
        Operate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OperateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Angsana New", 0, 24)); // NOI18N
        jLabel1.setText("DBL Operations: 0761XXXX เจ้ากรรม นายเวร");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Generate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Operate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Generate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Operate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateActionPerformed
        // TODO add your handling code here:
        db = new DoublyLinkedList();
        //ใน ปุ่ม Gen เราจะ new DoublyLinkedList เพราะจะเริ่มใช้การเก็บแบบ DoublyLinkedList แล้ว

        //==> จุดประสงค์ตามโจทย์ข้อที่ 4.1 addFirst() วัตถุ 5 วัตถุ
        for (int i = 0; i < 5; i++) {
            db.addFirst(new Node(new Attraction(genRandomInt(7),
                    name[r.nextInt(name.length)],
                    type[r.nextInt(type.length)],
                    country[r.nextInt(country.length)])));
            /*
            บรรทัดด้านบนมีการ สร้างวัตถุจากการสุ่ม index ของ Array ที่เตรียมไว้ ใส่ตามพารามิเตอร์มีเหมาะสม
            จากนั้นสร้าง Node เพื่อเก็บวัตถุที่สร้างไว้ ก่อนจะถูกเก็บเข้าไปใน DoublyLinkedList ด้วย 
            วิธีการ addFirst()
             */

        }
        //<==จบจุดประสงค์ตามโจทย์ข้อที่ 4.1

        //==> จุดประสงค์ตามโจทย์ข้อที่ 4.2 สุ่มคำสั่งที่ใช้จัดการ DoublyLinkedList
        //มี 2 คำสั่งคือ addFirst(),addLast()
        //สุ่มการเลือกใช้ระหว่าง 2 คำสั่งนี้
        //ในคำสั่งข้อ 4.2 มีการเก็บค่า String ที่ return ออกมาเมื่อมีการเรียกใช้คำสั่ง addFirst(),addLast()
        for (int i = 0; i < 5; i++) {
            int n = r.nextInt(2);//สุ่มเลขเพื่อเป็นตัวตัดสินใจว่าจะใช้คำสั่งใด
            if (n == 0) {
                //ถ้าได้ 0 จะทำการใช้คำสั่งจัดการ DoublyLinkedList ด้วย addFirst()
                reGen += db.addFirst(new Node(new Attraction(genRandomInt(7),
                        name[r.nextInt(name.length)],
                        type[r.nextInt(type.length)],
                        country[r.nextInt(country.length)])));
                /*
                บรรทัดด้านบนมีการ สร้างวัตถุจากการสุ่ม index ของ Array ที่เตรียมไว้ ใส่ตามพารามิเตอร์มีเหมาะสม
            จากนั้นสร้าง Node เพื่อเก็บวัตถุที่สร้างไว้ ก่อนจะถูกเก็บเข้าไปใน DoublyLinkedList ด้วย 
            วิธีการ addFirst()
                 */
                
                /*
                ในคำสั่งข้อ 4.2 มีการเก็บค่า String ที่ return ออกมาเมื่อมีการเรียกใช้คำสั่ง addFirst()
                จึงเรียกตัวแปร reGen ที่เป็น String มาเก็บค่าสะสมไว้ คั่นด้วย "\n" เพื่อใช้ในการขึ้นบรรทัดใหม่ในการแสดงผล
                */

            /*if(i!=4)*/
                reGen += "\n";
            } else {
                //ถ้าได้ 1 จะทำการใช้คำสั่งจัดการ DoublyLinkedList ด้วย addLast()
                reGen += db.addLast(new Node(new Attraction(genRandomInt(7),
                        name[r.nextInt(name.length)],
                        type[r.nextInt(type.length)],
                        country[r.nextInt(country.length)])));
                /*if(i!=4)*/
                reGen += "\n";
                /*
                บรรทัดด้านบนมีการ สร้างวัตถุจากการสุ่ม index ของ Array ที่เตรียมไว้ ใส่ตามพารามิเตอร์มีเหมาะสม
            จากนั้นสร้าง Node เพื่อเก็บวัตถุที่สร้างไว้ ก่อนจะถูกเก็บเข้าไปใน DoublyLinkedList ด้วย 
            วิธีการ addLast()
                 */
                
                /*
                ในคำสั่งข้อ 4.2 มีการเก็บค่า String ที่ return ออกมาเมื่อมีการเรียกใช้คำสั่ง addLast()
                จึงเรียกตัวแปร reGen ที่เป็น String มาเก็บค่าสะสมไว้ คั่นด้วย "\n" เพื่อใช้ในการขึ้นบรรทัดใหม่ในการแสดงผล
                */
            }
        }
        db.print();//print ดูขึ้นมูลทั้งหมดใน DoublyLinkedList
        inTable(db);//เรียกใช้ method inTable() เพื่อแสดงขึ้นตาราง
        System.out.println(reGen);//print String ที่เก็บสะสมคำสั่งไว้ออกมาดู
        jTextArea1.setText(reGen);//แสดง  String ที่เก็บสะสมคำสั่งไว้ ใน jTextArea1
         //<== จบจุดประสงค์ตามโจทย์ข้อที่ 4.2
    }//GEN-LAST:event_GenerateActionPerformed

    private void OperateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OperateActionPerformed
        // TODO add your handling code here:
        reGen = "";//รีเซ็ตค่าของการเก็บคำสั่ง
        //==>จุดประสงค์ตามโจทย์ปุ่ม  Operate
        //ประโยคสำคัญคือ "ตามมขั้นตอนที่ปรากฏใน jTextArea1" นั่นคือข้อ 4.2
        //จุดประสงค์ตามโจทย์ข้อที่ 4.2 สุ่มคำสั่งที่ใช้จัดการ DoublyLinkedList
        //มี 2 คำสั่งคือ addFirst(),addLast()
        //สุ่มการเลือกใช้ระหว่าง 2 คำสั่งนี้
        //ในคำสั่งข้อ 4.2 มีการเก็บค่า String ที่ return ออกมาเมื่อมีการเรียกใช้คำสั่ง addFirst(),addLast()
        for (int i = 0; i < 5; i++) {
            int n = r.nextInt(2);//สุ่มเลขเพื่อเป็นตัวตัดสินใจว่าจะใช้คำสั่งใด
            if (n == 0) {//ถ้าได้ 0 จะทำการใช้คำสั่งจัดการ DoublyLinkedList ด้วย addFirst()
                reGen += db.addFirst(new Node(new Attraction(genRandomInt(7),
                        name[r.nextInt(name.length)],
                        type[r.nextInt(type.length)],
                        country[r.nextInt(country.length)])));
                reGen += "\n";
               /*
                บรรทัดด้านบนมีการ สร้างวัตถุจากการสุ่ม index ของ Array ที่เตรียมไว้ ใส่ตามพารามิเตอร์มีเหมาะสม
            จากนั้นสร้าง Node เพื่อเก็บวัตถุที่สร้างไว้ ก่อนจะถูกเก็บเข้าไปใน DoublyLinkedList ด้วย 
            วิธีการ addFirst()
                 */
                
                /*
                ในคำสั่งข้อ 4.2 มีการเก็บค่า String ที่ return ออกมาเมื่อมีการเรียกใช้คำสั่ง addFirst()
                จึงเรียกตัวแปร reGen ที่เป็น String มาเก็บค่าสะสมไว้ คั่นด้วย "\n" เพื่อใช้ในการขึ้นบรรทัดใหม่ในการแสดงผล
                */
                
            } else {
                //ถ้าได้ 1 จะทำการใช้คำสั่งจัดการ DoublyLinkedList ด้วย addLast()
                reGen += db.addLast(new Node(new Attraction(genRandomInt(7),
                        name[r.nextInt(name.length)],
                        type[r.nextInt(type.length)],
                        country[r.nextInt(country.length)])));
                /*if(i!=4)*/
                reGen += "\n";
                /*
                บรรทัดด้านบนมีการ สร้างวัตถุจากการสุ่ม index ของ Array ที่เตรียมไว้ ใส่ตามพารามิเตอร์มีเหมาะสม
            จากนั้นสร้าง Node เพื่อเก็บวัตถุที่สร้างไว้ ก่อนจะถูกเก็บเข้าไปใน DoublyLinkedList ด้วย 
            วิธีการ addLast()
                 */
                
                /*
                ในคำสั่งข้อ 4.2 มีการเก็บค่า String ที่ return ออกมาเมื่อมีการเรียกใช้คำสั่ง addLast()
                จึงเรียกตัวแปร reGen ที่เป็น String มาเก็บค่าสะสมไว้ คั่นด้วย "\n" เพื่อใช้ในการขึ้นบรรทัดใหม่ในการแสดงผล
                */
            }
        }
        db.print();//print ดูขึ้นมูลทั้งหมดใน DoublyLinkedList
        inTable(db);//เรียกใช้ method inTable() เพื่อแสดงขึ้นตาราง
        System.out.println(reGen);//print String ที่เก็บสะสมคำสั่งไว้ออกมาดู
        jTextArea2.setText(reGen);//แสดง  String ที่เก็บสะสมคำสั่งไว้ ใน jTextArea2
        //<==จบจุดประสงค์ตามโจทย์ปุ่ม  Operate
    }//GEN-LAST:event_OperateActionPerformed

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
            java.util.logging.Logger.getLogger(Assignment_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Assignment_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Assignment_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Assignment_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Assignment_4().setVisible(true);
            }
        });
    }

    /*
    genRandomInt()
    method ที่สร้างไว้เพื่อสุ่มรหัสตัวเลขตามจำนวนที่กำหนดในพารามิเตอร์
     */
    public static String genRandomInt(int n) {
        Random random = new Random();
        String str = "";
        char[] letters = "0123456789".toCharArray();
        for (int i = 0; i < n; i++) {
            str += letters[random.nextInt(10)];
        }
        return str;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Generate;
    private javax.swing.JButton Operate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
