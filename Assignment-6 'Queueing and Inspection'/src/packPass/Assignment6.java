package packPass;


import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
class Passenger implements Comparable<String> {

    /*
    คลาส Passenger ฟิลด์ตามที่โจทย์กำหนด
    implements Comparable<String> เพื่อใช้ในการเรียงลำดับของวัตถุจากฟิลด์ที่เลือก
     */

    private String passportID;
    private String name;
    private String arrivalTime;
    private int queueNo;
    private int waitingTime;

    //>> method SET ฟิลด์ต่างๆ
    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setQueueNo(int queueNo) {
        this.queueNo = queueNo;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
    //<< method SET ฟิลด์ต่างๆ

    //>> method GET ฟิลด์ต่างๆ
    public String getPassportID() {
        return passportID;
    }

    public String getName() {
        return name;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getQueueNo() {
        return queueNo;
    }

    public int getWaitingTime() {
        return waitingTime;
    }
    //method GET ฟิลด์ต่างๆ

    public Passenger(String name) {
        this.passportID = genId();//เรียก genId() เพื่อสร้าง ID
        this.name = name;//ชื่อที่รับเข้ามาจากไฟล์ .txt
        this.arrivalTime = arrivalTime();//เรียก arrivalTime() เพื่อสร้างวัน-เวลาที่มาถึง (ไม่ซ้ำกัน)
        this.queueNo = 1;//ตั้งค่าตามโจทย์กำหนด
        this.waitingTime = 0;//ตั้งค่าตามโจทย์กำหนด

    }

    private static String arrivalTime() {//สร้าง Timestamp ไม่ซ้ำกัน
        long offset = Timestamp.valueOf("2021-01-01 00:00:00").getTime();
        long end = Timestamp.valueOf("2021-01-31 00:00:00").getTime();
        long diff = end - offset + 1;
        Timestamp rand = new Timestamp(offset + (long) (Math.random() * diff));
        System.out.println(rand.toString());
        return rand.toString();
    }

    private static String genId() {//สร้าง ID ด้วยรูปแบบที่โจทย์กำหนด
        char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();//Array ของตัวอักษร
        String temp = (letters[new Random().nextInt(letters.length)] + "" + letters[new Random().nextInt(letters.length)]);
        //สร้างตัวอักษร 2 ตัวติดกันตามโจทย์กำหนด
        for (int i = 0; i < 4; i++) {
            temp += new Random().nextInt(10);//ตัวเลขอีก 4 ตัวติดกันกับอักษรเมื่อสักครู่
        }
        return temp;

    }

    @Override
    public String toString() {//เรียกดูค่าใน วัตถุตามรูปแบบที่กำหนด คั่นด้วย ","
        return passportID + "," + name + "," + arrivalTime + "," + queueNo + "," + waitingTime;
    }

    @Override
    public int compareTo(String o) {//ใช้ในการเปรียบเทียบ
        return this.getArrivalTime().compareTo(o);//ระบุฟิลด์ที่นำมาเปรียบเทียบ
    }

}

class PassengerComparator implements Comparator<Passenger> {

    //สร้างเพื่อการจัดเรียงวัตถุตามฟิลด์ที่เลือกจากน้อยไปมาก
    @Override
    public int compare(Passenger p1, Passenger p2) {
        return p1.getArrivalTime().compareTo(p2.getArrivalTime());
    }
}

class Inspector {

    /*
    คลาส Inspector ฟิลด์ตามที่โจทย์กำหนด
    และฟิลด์ตามที่โจทย์กำหนด
     */

    private String id;
    private String name;
    private int totalInspectionTime;

    public Inspector(String id, String name) {
        this.id = id;
        this.name = name;
        this.totalInspectionTime = 0;//ค่าเริ่มต้นตามที่โจทย์กำหนด
    }

    ////method GET ฟิลด์ totalInspectionTime
    public int getTotalInspectionTime() {
        return totalInspectionTime;
    }

    /*ทำหน้าที่ set WaitingTime ในกับวัตถุ และเพิ่มค่า totalInspectionTime ทุกครั้งที่ถูกเรียก
    ค่าที่เพิ่มจะอยู่ในช่วง 5-30 เท่านั้น
     */
    public void inspect(Passenger p) {
        p.setWaitingTime(totalInspectionTime);
        totalInspectionTime += new Random().nextInt(26) + 5;
    }

    @Override
    public String toString() {//เรียกดูค่าใน วัตถุตามรูปแบบที่กำหนด 
        return "Inspector[ " + "ID = " + id + ", Name = " + name + " ]";
    }

}

public class Assignment6 extends javax.swing.JFrame {

    public static String[] namePass;//สร้างไว้เพื่อเก็บชื่อที่อ่านมาจากไฟล์ 
    String[] header = {"passportID", "name", "arrivalTime", "queueNo", "waitingTime"};
    //หัวตารางชื่อคอลัมน์ต่างๆ
    ArrayList<Passenger> passTemp = new ArrayList<>();//สร้างไว้เพื่อ sort โดยเฉพาะ

    public static Queue<Passenger> passengerQueue;//เก็บค่าเริ่มต้นของวัตถุ Passenger

    public static void readFile() {//อ่านไฟล์ .txt
        String name = "";//เก็บชื่อที่อ่านจากไฟล์ .txt
        try {
            File myObj = new File("passengerNames.txt");//ชื่อไฟล์และตำแหน่งต้องถูกต้องนะ
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                name += data + "#";//คั่นแต่ละชื่อที่อ่านด้วย "#"

            }
            namePass = name.split("#");//จากนั้น ทำให้มันอยกในรูปของ Array ด้วยการ split("#")
            System.out.println(Arrays.toString(namePass));//print เช็คดูว่าค่าเข้ามาหรือไม่
            myReader.close();
        } catch (FileNotFoundException e) {
            //ข้อความแจ้งเมื่อเกิดข้อผิดพลาด
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    private void toTable(Queue<Passenger> p) {//นำขึ้นตารางที่เตรียมไว้
        jTable1.setEditingRow(0);//set ตารางให้ว่าง
        int n = p.size();//ขนาดของ Queue 
        System.out.println("Table " + n);//print ตรวจสอบ

        //>>ขึ้นตาราง 
        Object[][] x = new Object[n][];

        for (int i = 0; i < n; i++) {
            x[i] = p.remove().toString().split(",");
            //ข้อมูลในแต่ละแถวจากการ นำออกมาจาก Queue ด้วย remove()
        }

        javax.swing.table.DefaultTableModel model1 = new javax.swing.table.DefaultTableModel(x, header);
        //เตรียมพร้อมขึ้นตารางด้วยการใช้ข้อมูลในตาราง,ชื่อแต่ละคอลัมน์
        jTable1.setModel(model1);//ขึ้นตารางที่เตรียมไว้
        //<<ขึ้นตาราง
    }

    /**
     * Creates new form Assignment6
     */
    public Assignment6() {
        initComponents();
        this.setTitle("เจ้ากรรม นายเวร");
        this.jTextField1.setText("Operations on Expressions: 07610XXX Ms.Grim Reaper");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton1Queue1Inspector = new javax.swing.JButton();
        jButton1Queue2Inspectors = new javax.swing.JButton();
        jButton2Queues2Inspectors = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("jTextField1");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton1Queue1Inspector.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1Queue1Inspector.setText("1 Queue 1 Inspector");
        jButton1Queue1Inspector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1Queue1InspectorActionPerformed(evt);
            }
        });

        jButton1Queue2Inspectors.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1Queue2Inspectors.setText("1 Queue 2 Inspectors");
        jButton1Queue2Inspectors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1Queue2InspectorsActionPerformed(evt);
            }
        });

        jButton2Queues2Inspectors.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2Queues2Inspectors.setText("2 Queues 2 Inspectors");
        jButton2Queues2Inspectors.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2Queues2InspectorsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Angsana New", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel2.setFont(new java.awt.Font("Angsana New", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1Queue1Inspector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1Queue2Inspectors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2Queues2Inspectors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1Queue1Inspector, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton1Queue2Inspectors, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton2Queues2Inspectors, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        passengerQueue = new LinkedList<>();//สร้าง Queue ที่เก็บข้อมูล
        Queue<Passenger> passenger = new LinkedList<>();//Queue สำหรับข้อมูลใส่ตาราง
        for (int i = 0; i < 50; i++) {
            passengerQueue.add(new Passenger(namePass[i]));
            //สร้างวัตถุ 50 ตัว
        }
        for (int i = 0; i < 50; i++) {//copy to Queue passenger
            Passenger humen = passengerQueue.remove();
            passenger.add(humen);//add ใส่ Queue passenger
            passengerQueue.add(humen);//add กลับเข้า Queue เดิมเพื่อให้สามารถนำไปใช้ในปุ่มต่อๆไปได้
            System.out.println(i + 1 + " " + humen.toString());
            //เช็คว่ามีวัตถุครบทั้ง 50 ตัวมั้ย
        }
        toTable(passenger);//นำข้อมูลใน Queue passenger ขึ้นตาราง
        System.out.println(passengerQueue.size());//เช็คขนาด Queue passengerQueue
        System.out.println(passengerQueue.peek());//เช็คข้อมูลตัวแรกของ passengerQueue


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1Queue1InspectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1Queue1InspectorActionPerformed
        // TODO add your handling code here:
        int c = 0;
        int tn=0;
        Inspector Nick = new Inspector("S.H.I.E.L.D.", "Nicholas Joseph Fury");
        //สร้าง Inspector มาเช็คคนเข้าเมือง 1 คนใส่ ID และ ชื่อ ให้เรียบร้อย
        passTemp.clear();//ลบค่าทุกอย่างใน ArrayList
        Queue<Passenger> passenger = new LinkedList<>();//เก็บข้อมูลที่เรียงลำดับแล้ว
        for (int i = 0; i < passengerQueue.size(); i++) {//วนลูปตามจำนวน passengerQueue 
            Passenger humen = passengerQueue.remove();//สร้างตัวแปรมารองรับวัตถุที่ออกจาก Queue
            passTemp.add(humen);//ใส่เข้า ArrayList ที่เตรียมไว้เพื่อทำการ sort
            passengerQueue.add(humen);//add กลับเข้า Queue เดิมเพื่อให้สามารถนำไปใช้ในปุ่มต่อๆไปได้
        }
        Collections.sort(passTemp, new PassengerComparator());
        //เรียงลำดับข้อมูลใน ArrayList จากน้อยไปมาก ใช้ค่าฟิลด์ arrivaltime ในการเรียง
        for (Passenger x : passTemp) {//copy ข้อมูลไปใส่ Queue Passenger
            passenger.add(x);//add เข้า Queue Passenger
            System.out.println(x.getArrivalTime());//print ค่า arrivaltime มาดูว่าเรียงตามที่ต้องการหรือไม่
        }
        passTemp.clear();//ลบค่าทุกอย่างใน ArrayList
        System.out.println("Q " + passengerQueue.size());//print ขนาดของ passengerQueue ตรวจสอบว่าข้อมูลเดิมครบถ้วนมั้ย

        for (int i = 0; i < passengerQueue.size(); i++) {//วนลูปตามจำนวน passengerQueue 
            Passenger humen = passenger.remove();//สร้างตัวแปรมารองรับวัตถุที่ออกจาก Queue
             tn = Nick.getTotalInspectionTime();
             Nick.inspect(humen);//ให้ Inspector Nick ตรวจเช็คเอกสารและ เพิ่มค่าเวลาที่รอ
            passenger.add(humen);//add เข้า Queue Passenger เตรียมขึ้นตาราง
            c++;
           
        }
        toTable(passenger);//ขึ้นตาราง
        System.out.println(passengerQueue.size());//เช็คขนาด Queue passengerQueue
        System.out.println(passengerQueue.peek());//เช็คข้อมูลตัวแรกของ passengerQueue
        jLabel1.setText(Nick.toString() + " จำนวน " + c + " เวลา " + tn);
    }//GEN-LAST:event_jButton1Queue1InspectorActionPerformed

    private void jButton1Queue2InspectorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1Queue2InspectorsActionPerformed
        // TODO add your handling code here:
        int s = 0, p = 0,ts=0,tp=0;
        Inspector Stark = new Inspector("Iron Man", "Tony Stark");
        Inspector Parker = new Inspector("Spider-Man", "Peter Parker");
        //สร้าง Inspector มาเช็คคนเข้าเมือง 2 คนใส่ ID และ ชื่อ ให้เรียบร้อย
        passTemp.clear();//ลบค่าทุกอย่างใน ArrayList
        Queue<Passenger> passenger = new LinkedList<>();//เก็บข้อมูลที่เรียงลำดับแล้ว
        for (int i = 0; i < passengerQueue.size(); i++) {//วนลูปตามจำนวน passengerQueue 
            Passenger humen = passengerQueue.remove();//สร้างตัวแปรมารองรับวัตถุที่ออกจาก Queue
            passTemp.add(humen);//ใส่เข้า ArrayList ที่เตรียมไว้เพื่อทำการ sort
            passengerQueue.add(humen);//add กลับเข้า Queue เดิมเพื่อให้สามารถนำไปใช้ในปุ่มต่อๆไปได้
        }
        Collections.sort(passTemp, new PassengerComparator());
        //เรียงลำดับข้อมูลใน ArrayList จากน้อยไปมาก ใช้ค่าฟิลด์ arrivaltime ในการเรียง
        for (Passenger x : passTemp) {//copy ข้อมูลไปใส่ Queue Passenger
            passenger.add(x);//add เข้า Queue Passenger
            System.out.println(x.getArrivalTime());//print ค่า arrivaltime มาดูว่าเรียงตามที่ต้องการหรือไม่
        }
        passTemp.clear();//ลบค่าทุกอย่างใน ArrayList
        System.out.println("Q " + passengerQueue.size());//print ขนาดของ passengerQueue ตรวจสอบว่าข้อมูลเดิมครบถ้วนมั้ย
        for (int i = 0; i < passengerQueue.size(); i++) {//วนลูปตามจำนวน passengerQueue 
            Passenger humen = passenger.remove();//สร้างตัวแปรมารองรับวัตถุที่ออกจาก Queue
            int timeStark = Stark.getTotalInspectionTime();//เวลาของ Inspector Stark 
            int timeParker = Parker.getTotalInspectionTime();//เวลาของ Inspector Parker
            if (timeParker > timeStark) {//ถ้าเวลาของ Parker มากกว่า
                Stark.inspect(humen);//ให้ Stark เป็นคนตรวจสอบ
                humen.setQueueNo(1);//ให้ใส่ค่าช่องตรวจเป็น 1
                s++;
                ts = timeStark;
            } else if (timeStark > timeParker) {//ถ้าเวลาของ Stark มากกว่า
                Parker.inspect(humen);//ให้ Parker เป็นคนตรวจสอบ
                humen.setQueueNo(2);//ให้ใส่ค่าช่องตรวจเป็น 2
                p++;
                tp = timeParker;
            } else {//ถ้าเท่ากัน
                Parker.inspect(humen);//ให้ Parker เป็นคนตรวจสอบ
                humen.setQueueNo(2);//ให้ใส่ค่าช่องตรวจเป็น 2
                p++;
                tp = timeParker;
            }
            
            
            passenger.add(humen);//add เข้า Queue Passenger เตรียมขึ้นตาราง

        }
        toTable(passenger);//ขึ้นตาราง
        jLabel1.setText(Stark.toString() + " จำนวน " + s + " เวลา " + ts);
        jLabel2.setText(Parker.toString() + " จำนวน " + p + " เวลา " + tp);
    }//GEN-LAST:event_jButton1Queue2InspectorsActionPerformed

    private void jButton2Queues2InspectorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2Queues2InspectorsActionPerformed
        // TODO add your handling code here:
        int l = 0, t = 0,tt=0,tl=0;
        Inspector Loki = new Inspector("Loki", "Loki Laufeyson");
        Inspector Thor = new Inspector("Thor", "Thor Odinson");
        //สร้าง Inspector มาเช็คคนเข้าเมือง 2 คนใส่ ID และ ชื่อ ให้เรียบร้อย
        passTemp.clear();//ลบค่าทุกอย่างใน ArrayList
        Deque<Passenger> passenger2deque = new LinkedBlockingDeque<>(50);
        //Deque สำหรับข้อมูลที่จะนำมาใช้
        Queue<Passenger> passenger2queue = new LinkedList<>();
        //สร้าง Queue เก็บวัตถุครึ่งหนึ่งจาก Deque 
        Stack<Passenger> passenger2stack = new Stack<>();
        //สร้าง Stack เพื่อประยุกต์ใช้ในการทำให้คนที่แบ่งครึ่งมาจาก Deque ยังคงเรียงลำดับต่อไป
        Queue<Passenger> passenger = new LinkedList<>();//เก็บข้อมูลที่เรียงลำดับแล้ว
        for (int i = 0; i < passengerQueue.size(); i++) {//วนลูปตามจำนวน passengerQueue 
            Passenger humen = passengerQueue.remove();//สร้างตัวแปรมารองรับวัตถุที่ออกจาก Queue
            passTemp.add(humen);//ใส่เข้า ArrayList ที่เตรียมไว้เพื่อทำการ sort
            passengerQueue.add(humen);//add กลับเข้า Queue เดิมเพื่อให้สามารถนำไปใช้ในปุ่มต่อๆไปได้
        }
        System.out.println("oLd Pass " + passengerQueue.size());//print ขนาดของ passengerQueue ตรวจสอบว่าข้อมูลเดิมครบถ้วนมั้ย
        Collections.sort(passTemp, new PassengerComparator());
        //เรียงลำดับข้อมูลใน ArrayList จากน้อยไปมาก ใช้ค่าฟิลด์ arrivaltime ในการเรียง
        for (Passenger x : passTemp) {//copy ข้อมูลไปใส่ passenger2deque
            passenger2deque.add(x);//add เข้า Deque passenger2deque
            System.out.println(x.getArrivalTime());
            //print ค่า arrivaltime มาดูว่าเรียงตามที่ต้องการหรือไม่
        }
        passTemp.clear();//ลบค่าทุกอย่างใน ArrayList
        for (int i = 0; i < passengerQueue.size() / 2; i++) {//วนลูปครึ่งหนึ่งของจำนวน passengerQueue 
            passenger2stack.push(passenger2deque.removeLast());
            //นำมาใส่ Stack ตามลำดับที่ removeLast() ออกมาจาก Deque passenger2deque
        }
        System.out.println("Stack " + passenger2stack.size());//print เช็คจำนวนของข้อมูลใน Stack
        System.out.println("Deque " + passenger2deque.size());//print เช็คจำนวนของข้อมูลใน Deque
        for (int i = 0; i < passengerQueue.size() / 2; i++) {//วนลูปครึ่งหนึ่งของจำนวน passengerQueue 
            passenger2queue.add(passenger2stack.pop());
            //นำวัตถุใน stack ออกมาด้วยการ pop() และเพิ่มเข้าไปใน Queue passenger2queue
        }
        System.out.println("Qeque " + passenger2queue.size());//print เช็คจำนวนของข้อมูลใน Queue
        for (int i = 0; i < passengerQueue.size(); i++) {//วนลูปตามจำนวน passengerQueue 
            Passenger humen;//สร้างตัวแปรมารองรับ
            if (passenger2deque.size() > passenger2queue.size()) {
                //ถ้าขนาดของ passenger2deque มากกว่า passenger2queue
                humen = passenger2deque.removeFirst();//นำวัตถุออกจาก passenger2deque
            } else if (passenger2queue.size() > passenger2deque.size()) {
                //ถ้าขนาดของ passenger2queue มากกว่า passenger2deque
                humen = passenger2queue.remove();//นำวัตถุออกจาก passenger2queue
            } else {//ถ้าเท่ากัน 
                humen = passenger2queue.remove();//นำวัตถุออกจาก passenger2queue
            }
            int timeLoki = Loki.getTotalInspectionTime();//เวลาของ Inspector Loki
            int timeThor = Thor.getTotalInspectionTime();//เวลาของ Inspector Thor
            
            if (timeLoki > timeThor) {//ถ้าเวลาของ Loki มากกว่า
                Thor.inspect(humen);//ให้ Thor เป็นคนตรวจสอบ
                humen.setQueueNo(3);//ให้ใส่ค่าช่องตรวจเป็น 3
                t++;
                tt=timeThor;
            } else if (timeThor > timeLoki) {//ถ้าเวลาของ Thor มากกว่า
                Loki.inspect(humen);//ให้ Loki เป็นคนตรวจสอบ
                humen.setQueueNo(4);//ให้ใส่ค่าช่องตรวจเป็น 4
                l++;
                tl=timeLoki;
            } else {//ถ้าเท่ากัน
                Thor.inspect(humen);//ให้ Thor เป็นคนตรวจสอบ
                humen.setQueueNo(3);//ให้ใส่ค่าช่องตรวจเป็น 3
                t++;
                tt=timeThor;
            }

            passenger.add(humen);//add เข้า Queue Passenger เตรียมขึ้นตาราง

        }
        //เช็คดู Deque Qeque Stack ว่าอยู่ในสถานะว่างหรือไม่
        System.out.println("Deque " + passenger2deque.isEmpty());
        System.out.println("Qeque " + passenger2queue.isEmpty());
        System.out.println("Stack " + passenger2stack.isEmpty());
        toTable(passenger);//ขึ้นตาราง
        jLabel1.setText(Thor.toString() + " จำนวน " + t + " เวลา " + tt);
        jLabel2.setText(Loki.toString() + " จำนวน " + l + " เวลา " + tl);
    }//GEN-LAST:event_jButton2Queues2InspectorsActionPerformed

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
            java.util.logging.Logger.getLogger(Assignment6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Assignment6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Assignment6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Assignment6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        readFile();//อ่านไฟล์ .txt

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Assignment6().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton1Queue1Inspector;
    private javax.swing.JButton jButton1Queue2Inspectors;
    private javax.swing.JButton jButton2Queues2Inspectors;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
