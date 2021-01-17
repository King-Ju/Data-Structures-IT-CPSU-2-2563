package MidtermLAB; //บอกชื่อแพ็คเกตที่ใช้งาน
//เปิดเอกสารคำสั่งประกอบด้วยนะ
import java.util.Random; //เพื่อใช้งานสุ่ม
import java.util.Deque;  //เพื่อใช้ การเก็บข้อมูลแบบ Deque
import java.util.LinkedList; //เพื่อใช้งาน LinkedList ในการสร้าง Deque

class Process{ //ตั้งแต่บรรทัดที่ 7-20 เป็น( 2 คะแนน )
	//ตัวอย่าง ZZ-10
    private String name; //ชื่อโพรเซส (ZZ คือ ชื่อโพรเซส)
    private int numInstruction; // จำนวนคำสั่ง ( 10 คือ จำนวนคำสั่ง )
    public Process(String n, int i){ //บรรทัดที่ 10-13 กระบวนการของตัวสร้างในการกำหนดค่าเริ่มต้นของวัตถุที่สร้าง
        name = n;
        numInstruction = i;
    }
    public String toString(){ //เขียนเพิ่มเพื่อสะดวกในการแสดงผลข้อความในวัตถุ
        return name+"-"+numInstruction; //กำหนดลักษณะการแสดงผลในรูปแบบข้อความของฟิลด์ในวัตถุ
    }
    public int getNumInstruction(){//ใช้ประโยชน์ในการนับจำนวนคำสั่งในกระบวนการต่อไป ( จำเป็นต้องมีเมื่อฟิลด์เป็น private)
        return numInstruction; //จำนวนคำสั่งที่จะประมวลผล เช่น  ZZ-10 ดังนั้น 10 คือจำนวนคำสั่ง
    }
}

public class MidtermLAB extends javax.swing.JFrame {
    static Deque<Process> programQueue = new LinkedList<>(); //มีไว้เพื่อเก็บข้อมูลในการสร้างข้อมูลชุดแรก จำนวน 10 โพรเซส
    static Deque<Process> cpu1Queue = new LinkedList<>(); //เก็บข้อมูล 5 โพรเซส แรก
    static Deque<Process> cpu2Queue = new LinkedList<>(); //เก็บข้อมูล 5 โพรเซส ที่เหลือ
    
    static int queue1Count = 0; //นับจำนวนคำสั่งของ cpu1Queue
    static int queue2Count = 0; //นับจำนวนคำสั่งของ cpu2Queue
    
    public MidtermLAB() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.jLabel1.setText("A-Steal Job Scheduling: 07xxxxxx - Ms.Grim ");
        this.setTitle("Midterm LAB [เจ้ากรรม นายเวร]"); //ชื่อของหน้าต่าง GUI ด้านบนขวามือหลังโลโก้ JAVA
        //jTextField1.setHorizontalAlignment(JTextField.CENTER);
        jButton4.setEnabled(false); //กำหนดให้ปุ่มA-Steal Job Scheduling ปิดเพื่อรอการประมวลผล
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        jLabel4.setText("Program-Queue");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("A-Steal Job Scheduling: 07xxxxxx - name");

        jButton1.setText("Gen-processes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 0, 0));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField1.setToolTipText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setText("Create-Process-Queue");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Create-CPUs-Queue");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField2.setToolTipText("");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 0, 204));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField3.setToolTipText("");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(204, 0, 204));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField4.setToolTipText("");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Processes");

        jLabel3.setText("Process-Queue");

        jLabel5.setText("CPU1-Queue");

        jLabel6.setText("CPU2-Queue");

        jButton5.setText("Close");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 255));
        jButton4.setText("A-Steal Job Scheduling");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 51, 51));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setToolTipText("");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 51, 51));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setToolTipText("");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel8.setText("#instructions");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton5))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField5))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(17, 17, 17)
                                                        .addComponent(jLabel8))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jTextField6))))))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField5))
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6))
                .addGap(45, 45, 45)
                .addComponent(jButton5)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Gen-Program button
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton4.setEnabled(false); //กำหนดให้ปุ่มA-Steal Job Scheduling ปิดเพื่อรอการประมวลผล
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        
        
        String program = ""; //สร้างไว้เก็บข้อความที่เป็นโพรเซสพร้อมจำนวนคำสั่งททั้งหมด
		//ตัวอย่าง  EA-6, TV-6, RP-5, OI-6, QW-6, ZB-4, WG-2, ZB-4, UI-8, GA-3
        String sep = ", "; //สร้างไว้เพื่อคั่นระหว่างโพรเซส ( ตัวอย่าง EA-6, TV-6 )
        for(int i=0; i<10; i++){ //วนเพื่อสร้างโพรเซส 10 โพรเซส
            program += genProgram(2)+sep; //สร้างโพรเซสที่คั่นด้วย ", "
			//genProgram เป็นเมธอดที่สร้างมาเพื่อสร้าง โพรเซส 1 โพรเซส อยู่บรรทัดที่ 404
            if(i==8) // ( บรรทัดที่ 286-287 )  สร้างไว้เพื่อไม่ให้ตัวสุดท้ายมี , ติดมาด้วย
                sep = "";
        }//ตัวอย่างในบรรทัดที่ 282 จะเกิดขึ้นเมื่อวนลูปครบตามเงื่อนไข
        jTextField1.setText(program); // แสดงออกมาตามข้อกำหนดในข้อที่ 3 (ตั้งแต่บรรทัดที่ 269- 289 รับเพิ่ม 2 คะแนน )
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed
    // Create-Program-Queue button
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if(jTextField1.getText()!=""){ //เช็คว่ามีข้อความที่สุ่มมาอยู่ในกล่องข้อความ( TextField )หรือเปล่า 
            //ตัวอย่าง  EA-6, TV-6, RP-5, OI-6, QW-6, ZB-4, WG-2, ZB-4, UI-8, GA-3
            programQueue.clear(); //ทำให้ Deque ว่าง
            String[] x = jTextField1.getText().split(", "); //รับข้อความใส่ในอาเรย์โดยให้ ", " เป็นตัวตัดข้อความ
            //ตัวอย่าง  x[0] = EA-6 ,x[1] = TV-6 เป็นต้นไป
            for(String i: x){ // วนลูปเท่าจำนวนข้อความที่เก็บไว้
                String[] y = i.split("-"); // แยกข้อความใส่ลงในอาเรย์โดยให้  "-" เป็นตัวตัดข้อความ ตัวอย่าง ZZ-10 (y[0]= ZZ,y[0]= 10)
                String name = y[0]; //ให้เก็บชื่อโพรเซส
                int instruction = Integer.parseInt(y[1]); //ให้เก็บจำนวนคำสั่งที่แปลงจากข้อความเป็นจำนวนเต็มแล้วด้วย Integer.parseInt()
                programQueue.add(new Process(name, instruction)); //สร้างวัตถุใน Deque ชื่อ programQueue ถ้าไม่สร้างก็ null วนไป
            }
            jTextField2.setText(programQueue.toString()); //ถ้าสร้างวัถตุอย่างถูกต้อง จะเป็นข้อความตามภาพในโจทย์หน้าที่ 2 วงกลมหมายเลข2
        }
        else{
            System.out.println("No program"); //จะทำเมื่อไม่อะไรในกล่องข้อความ ( TextField)
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    //Create-CPUs-Queue ( code ในปุ่มตามข้อที่ 5 )
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       cpu1Queue.clear(); //ทำให้ Deque ว่าง
        cpu2Queue.clear(); //ทำให้ Deque ว่าง
        queue1Count = 0; //ให้ค่าเริ่มต้นตัวนับจำนวนคำสั่งของ cpu1Queue เป็น 0
        queue2Count = 0; //ให้ค่าเริ่มต้นตัวนับจำนวนคำสั่งของ cpu2Queue เป็น 0
        while(!programQueue.isEmpty()){ //วนลูปจนกว่า Deque จะว่าง
            try{
                Process p1 = programQueue.removeFirst(); //สร้างไว้เพื่อเก็บข้อมูล โพรเซสที่ถูกนำค่าออกมาลำดับแรก
                
                cpu1Queue.add(p1); //นำไปเก็บไว้ใน Deque ใหม่คือ cpu1Queue 
                queue1Count+=p1.getNumInstruction(); //นับจำนวนคำสั่งของข้อมูลที่นำไปเก็บไว้ใน cpu1Queue เพิ่มจากเดิม
                
                Process p2 = programQueue.removeFirst();//สร้างไว้เพื่อเก็บข้อมูล โพรเซสที่ถูกนำค่าออกมาลำดับแรก เพราะข้อมูลจากบรรทัดก่อนหน้าถูกลบไปแล้วนะ
                cpu2Queue.add(p2); //นำไปเก็บไว้ใน Deque ใหม่คือ cpu2Queue
                queue2Count+=p2.getNumInstruction(); //นับจำนวนคำสั่งของข้อมูลที่นำไปเก็บไว้ใน cpu2Queue เพิ่มจากเดิม
            }
            catch(Exception e){continue;} //ถ้าเกิดข้อผิดพลาดก็ทำต่อไป...
        }
        //jTextField2.setText(programQueue.toString());
        jTextField3.setText(cpu1Queue.toString()); // แสดงโพรเซสที่รอประมวลผลเครื่องที่ 1ในกล่องข้อความ ( TextField) ด้านล่างข้อความ cpu1Queue ใน GUI
        jTextField4.setText(cpu2Queue.toString()); // แสดงโพรเซสที่รอประมวลผลเครื่องที่ 2ในกล่องข้อความ ( TextField) ด้านล่างข้อความ cpu2Queue ใน GUI
        jTextField5.setText(Integer.toString(queue1Count)); //แสดงจำนวนเต็มของคำสั่งทั้งหมดของเครื่องที่ 1 ที่ถูกเปลี่ยนเป็นข้อความ จากกระบวนการของ Integer.toString ในกล่องข้อความแรก ( TextField) ด้านล่างข้อความ #instructions ใน GUI
        jTextField6.setText(Integer.toString(queue2Count)); //แสดงจำนวนเต็มของคำสั่งทั้งหมดของเครื่องที่ 2 ที่ถูกเปลี่ยนเป็นข้อความ จากกระบวนการของ Integer.toString ในกล่องข้อความที่สอง ( TextField) ด้านล่างข้อความ #instructions ใน GUI
        //รับคะแนนเพิ่ม 4 คะแนนจากบรรทัดที่ 335-336และ337-338 โดยต้องทำตั้งแต่ 316 จนถึง 338 นะ
        jButton4.setEnabled(false); //กำหนดให้ปุ่มA-Steal Job Scheduling ปิดเพื่อรอการประมวลผล
        
        if(queue1Count+cpu2Queue.getLast().getNumInstruction() < queue2Count ){
            System.out.println("cpu1 can steal from cpu2");
            jButton4.setEnabled(true);
        }
        if(queue2Count+cpu2Queue.getLast().getNumInstruction() < queue1Count ){
           System.out.println("cpu2 can steal from cpu1");
           jButton4.setEnabled(true);
        }
        //บรรทัดที่ 342-349 ขั้นตอนการเปิดปุ่มในโจทย์หน้าที่ 2 วงกลมหมายเลขที่ 4 ตามเงื่อนไขของโจทย์ข้อที่ 5.3  ถ้าทำได้รับเพิ่ม 5 คะแนน
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    
    // A-Steal-Job-Scheduling button ( code ในปุ่มตามข้อที่ 7 อาจารย์ไม่มีข้อที่ 6 นะ )
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(queue1Count<queue2Count){ //ถ้าเครื่องที่ 2 (cpu2Queue) มีจำนวนคำสั่งรวมมากกว่า เครื่องที่ 1 (cpu1Queue)
            // Move from queue2 to queue1
            Process p = cpu2Queue.removeLast(); //นำโพรเซสสุดท้ายของเครื่องที่ 2 ออกมาใส่ใน p
            cpu1Queue.addLast(p); //เพิ่ม p ต่อท้ายในเครื่องที่ 1
            queue1Count+=p.getNumInstruction(); // เพิ่มจำนวนคำสั่งของ cpu1Queue ตามจำนวนคำสั่งของ โพรเซส p
            queue2Count-=p.getNumInstruction(); // ลดจำนวนคำสั่งของ cpu2Queue ตามจำนวนคำสั่งของ โพรเซส p
        }
        else{ //ถ้าเครื่องที่ 1 มีจำนวนคำสั่งรวมมากกว่า เครื่องที่ 2
            // Move from queue1 to queue2
            Process p = cpu1Queue.removeLast(); //นำโพรเซสสุดท้ายของเครื่องที่ 1 ออกมาใส่ใน p
            cpu2Queue.addLast(p); //เพิ่ม p ต่อท้ายในเครื่องที่ 2
            queue2Count+=p.getNumInstruction(); // เพิ่มจำนวนคำสั่งของ cpu2Queue ตามจำนวนคำสั่งของ โพรเซส p
            queue1Count-=p.getNumInstruction(); // ลดจำนวนคำสั่งของ cpu1Queue ตามจำนวนคำสั่งของ โพรเซส p
        }
        jTextField3.setText(cpu1Queue.toString()); // แสดงโพรเซสที่รอประมวลผลเครื่องที่ 1ล่าสุดในกล่องข้อความ ( TextField) ด้านล่างข้อความ cpu1Queue ใน GUI
        jTextField4.setText(cpu2Queue.toString()); // แสดงโพรเซสที่รอประมวลผลเครื่องที่ 2ล่าสุดในกล่องข้อความ ( TextField) ด้านล่างข้อความ cpu2Queue ใน GUI
        jTextField5.setText(Integer.toString(queue1Count)); //แสดงจำนวนเต็มของคำสั่งทั้งหมดของเครื่องที่ 1 ที่ถูกเปลี่ยนเป็นข้อความ จากกระบวนการของ Integer.toString ในกล่องข้อความแรก ( TextField) ด้านล่างข้อความ #instructions ใน GUI
        jTextField6.setText(Integer.toString(queue2Count)); //แสดงจำนวนเต็มของคำสั่งทั้งหมดของเครื่องที่ 2 ที่ถูกเปลี่ยนเป็นข้อความ จากกระบวนการของ Integer.toString ในกล่องข้อความที่สอง ( TextField) ด้านล่างข้อความ #instructions ใน GUI
        //ถ้าทำได้รับเพิ่ม 5 คะแนน
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    public static String genProgram(int n) { //เมธอดสร้างโพรเซสพร้อมจำนวนคำสั่งตามข้อกำหนดที่ 3 ในโจทย์
        Random random = new Random(); //เรียกมาใช้สุ่ม
        String str = ""; //สร้างไว้เก็บข้อความ
        char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray(); //นำอักษร A-Z ใส่ไว้เป็นอา้รย์
        for (int i = 0; i < n; i++) {
            str += letters[random.nextInt(26)]; //สร้าง index ของอาเรย์ที่เก็บ A-Z
            if (i == 0) {
                str = str.toUpperCase(); //ทำให้เป็นตัวพิมพ์ใหญ่
            }
        }
        str += "-" + (random.nextInt(10)+1); //นำข้อความที่มีชื่อโพรเซสมาต่อกับ - ก่อนจะสุ่มเลข 1-10 ต่อท้าย
        return str; //ส่งข้อความที่เป็นโพรเซสพร้อมจำนวนคำสั่ง  ตัวอย่าง ZZ-10
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MidtermLAB().setVisible(true);
                
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
