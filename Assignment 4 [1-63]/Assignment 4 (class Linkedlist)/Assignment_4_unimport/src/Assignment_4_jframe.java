
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
ขอเรียกว่าการเขียนแบบ "หาทำ" 
เป็นการเขียนตาม ทฤษฎีที่เรียนในคาบ lec เป็นการเขียนแบบ "หาทำมากๆ" 
เพราะจริงๆแล้วคือมีให้ import มาใช้ไม่ต้องหาทำแบบนี้มันจะงงอยู่เด้อ~~~
ปล.ไม่ได้เขียนคลาส Doubly Linked List เองเพราะแบบไม่อยากหาทำ
Cr.https://gist.github.com/jpt1122/5ec634791f5dd8661234
กราบงามๆ
 */
class Person {//คลาสที่มีชื่อและฟิลด์ตามที่โจทย์กำหนด

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {//toString สร้างไว้เพื่อแล้ว print มาเช็คดูหรือดูฟิลด์ในคลาส
        return name + "," + age;
    }

}

class Node {//คลาส Node ตามที่อาจารย์สอนใน lec

    protected Person data;//ส่วนที่ใช้เก็บข้อมูลจริงๆ ซึ่งคือวัตถุจากคลาส Person 
    protected Node next, prev;//อันนี้อะไรเอ่ย ต่อไป,ก่อนหน้า 

    /* Constructor
        แบบที่ 1 คือให้ทุกอย่างเป็น null ซึ่งไม่ค่อยหาทำกันสักเท่าไหร่ 
     */
    public Node() {
        next = null;
        prev = null;
        data = null;
    }

    /* Constructor 
        แบบที่ 2 อันเนี้ยควรทำ จำเป็น รับพารามิเตอร์เป็น type Person ตามที่โจทย์ต้องการ
     */
    public Node(Person d, Node n, Node p) {
        data = d;
        next = n;
        prev = p;
    }

    /* Function to set link to next node 
        set Node ต่อไป
     */
    public void setLinkNext(Node n) {
        next = n;
    }

    /* Function to set link to previous node 
        set Node ก่อนหน้า
     */
    public void setLinkPrev(Node p) {
        prev = p;
    }

    /* Funtion to get link to next node 
        ดู Node ต่อไป
     */
    public Node getLinkNext() {
        return next;
    }

    /* Function to get link to previous node 
        ดู Node ก่อนหน้า
     */
    public Node getLinkPrev() {
        return prev;
    }

    /* Function to set data to node
        ใส่ข้อมูล type Person (เพื่อแก้ไขหรือใดๆก็แล้วแต่)
     */
    public void setData(Person d) {
        data = d;
    }

    /* Function to get data from node
        ดูข้อมูลใน Node
     */
    public Person getData() {
        return data;
    }
}

/* Class linkedList 
หัวใจสำคัญของแบบฝึกนี้เลย 
หรือเรียกว่าเป็นธาตุแท้ของ Doubly Linked List
อย่างแท้จริง คือคลาสนี้เลย
 */
class linkedList {

    protected Node start;//head
    protected Node end;//tail
    public int size;//count


    /* Constructor 
        ตัวสร้างที่เริ่มทำจากจาก 0/null
     */
    public linkedList() {
        start = null;
        end = null;
        size = 0;
    }

    /* Function to check if list is empty 
        เอาไว้ดูว่า list นี้ยังว่างๆอยู่มั้ยครับ จะได้เข้าไปในใจ เอ้ยบ้าบอ
     */
    public boolean isEmpty() {
        return start == null;
    }

    /* Function to get size of list 
        ขนาดของ list นี้ว่าใหญ่แค่ไหน ยาวต่อกันแค่ไหน
     */
    public int getSize() {
        return size;
    }

    /* Function to insert element at begining
        พูดง่ายๆเลยนะแบบไม่ต้องอะไรมา เพิ่มไว้หน้าสุด 
        "AddFirst"
     */
    public void insertAtStart(Person val) {
        Node nptr = new Node(val, null, null);
        if (start == null) {
            start = nptr;
            end = start;
        } else {//วิธีการสลับค่า x ไป y แบบใน com1/2
            start.setLinkPrev(nptr);
            nptr.setLinkNext(start);
            start = nptr;
        }
        size++;
    }

    /* Function to insert element at end 
        พูดง่ายๆเลยนะแบบไม่ต้องอะไรมา เพิ่มไว้ท้ายสุด 
        "AddLast"
     */
    public void insertAtEnd(Person val) {

        Node nptr = new Node(val, null, null);

        if (start == null) {
            start = nptr;
            end = start;
        } else {
            nptr.setLinkPrev(end);
            end.setLinkNext(nptr);
            end = nptr;
        }
        size++;
    }

    /* Function to insert element at position 
     พูดง่ายๆเลยนะแบบไม่ต้องอะไรมา เพิ่มไว้ในตำแหน่งที่ต้องการ 
        "Insert"
     */
    public void insertAtPos(Person val, int pos) {
        Node nptr = new Node(val, null, null);
        if (pos == 1) {//ตำแหน่งแรก
            insertAtStart(val);
            return;
        }

        Node ptr = start;
        for (int i = 2; i <= size; i++) {//ตำแหน่งที่ 2 ขึ้นไป
            if (i == pos) {
                Node tmp = ptr.getLinkNext();
                ptr.setLinkNext(nptr);
                nptr.setLinkPrev(ptr);
                nptr.setLinkNext(tmp);
                tmp.setLinkPrev(nptr);
            }
            ptr = ptr.getLinkNext();
        }
        size++;
    }

    /* Function to delete node at position
    ลบตำแหน่งที่เลือกออกไปตัว code อย่างวุ่นวายอ่ะ ซึ่งในแบบฝึกนี้ใช้มั้ย ไม่!
     */
    public void deleteAtPos(int pos) {
        if (pos == 1) {
            if (size == 1) {
                start = null;
                end = null;
                size = 0;
                return;
            }

            start = start.getLinkNext();
            start.setLinkPrev(null);
            size--;
            return;
        }

        if (pos == size) {
            end = end.getLinkPrev();
            end.setLinkNext(null);
            size--;
        }

        Node ptr = start.getLinkNext();

        for (int i = 2; i <= size; i++) {
            if (i == pos) {
                Node p = ptr.getLinkPrev();
                Node n = ptr.getLinkNext();
                p.setLinkNext(n);
                n.setLinkPrev(p);
                size--;
                return;
            }

            ptr = ptr.getLinkNext();
        }
    }

    /* Function to display status of list 
    print ทั้ง Doubly Linked List มาดูแบบหวานๆ
    ตัวอย่าง
    Doubly Linked List = Xlbgl,22 <-> Mwxqagia,33 <-> Welutlk,47 <-> Zfkzsuzt,54 <-> Nzqoexhh,16
     */
    public void display() {
        System.out.print("\nDoubly Linked List = ");

        if (size == 0) {//list ว่างเหมือนคนโสด
            System.out.print("empty\n");
            return;
        }

        if (start.getLinkNext() == null) {//มีข้อมูลแค่ 1 เดียวเหมือนคนในใจ
            System.out.println(start.getData());

            return;
        }

        //<---print ข้อมูลใน list ที่มีมากกว่า 1 
        Node ptr = start;
        System.out.print(start.getData() + " <-> ");
        ptr = start.getLinkNext();

        while (ptr.getLinkNext() != null) {
            System.out.print(ptr.getData() + " <-> ");
            ptr = ptr.getLinkNext();
        }
        System.out.print(ptr.getData() + "\n");
        //--->print ข้อมูลใน list ที่มีมากกว่า 1  END
    }
}

class DoublyLinkedList {//Doubly Linked List แบบแกล้งๆทำเพราะของจริงคืออยู่คลาสด้านบนละ ปลอมๆครอบไว้หลอกๆ

    private linkedList list = new linkedList();//Doubly Linked List ที่แท้ทรู

    public void addFirst(Person p) {//สร้าง method เพื่อให้ตัวเองเข้าใจง่ายๆ 
        //data.addFirst(p); เพิ่มข้อมูลหน้าสุด
        list.insertAtStart(p);//เพราะจริงๆใช้ method นี้แทนก็จบ
    }

    public void addLast(Person p) {//สร้าง method เพื่อให้ตัวเองเข้าใจง่ายๆ 
        //data.addLast(p);เพิ่มไว้ท้ายสุด
        list.insertAtEnd(p);//เพราะจริงๆใช้ method นี้แทนก็จบ
    }

    public void inSert(int index, Person p) {//สร้าง method เพื่อให้ตัวเองเข้าใจง่ายๆ 
        //data.add(index-1, p);เพิ่มตามตำแหน่งที่ต้องการ
        list.insertAtPos(p, index);//เพราะจริงๆใช้ method นี้แทนก็จบ
    }

    public linkedList data() {//เรียกใช้ list
        return list;
    }

    public void printMe() {//print ออกมาดูแบบหวานๆ
        list.display();
    }
}

/**
 *
 * @author User
 */
public class Assignment_4_jframe extends javax.swing.JFrame {

    public static DoublyLinkedList Doubly;//ประกาศ DoublyLinkedList แบบใจง่ายในชื่อ Doubly
    public static String[] header = {"Name", "Age"};//ชื่อ column

    /**
     * Creates new form Assignment_4_jframe
     */
    public Assignment_4_jframe() {
        initComponents();
        this.setTitle("เจ้ากรรม นายเวร");
        jTextField1.setText(null);
        jTextField2.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButtonGen = new javax.swing.JButton();
        jButtonAddFirst = new javax.swing.JButton();
        jButtonAddLast = new javax.swing.JButton();
        jButtonInsert = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("“Doubly LinkedList’s operations”");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTextField1.setText("New Data");

        jTextField2.setText("Number index");

        jButtonGen.setText("Generate");
        jButtonGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenActionPerformed(evt);
            }
        });

        jButtonAddFirst.setText("addFirst");
        jButtonAddFirst.setMaximumSize(new java.awt.Dimension(85, 25));
        jButtonAddFirst.setMinimumSize(new java.awt.Dimension(85, 25));
        jButtonAddFirst.setPreferredSize(new java.awt.Dimension(85, 25));
        jButtonAddFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddFirstActionPerformed(evt);
            }
        });

        jButtonAddLast.setText("addLast");
        jButtonAddLast.setActionCommand("");
        jButtonAddLast.setMaximumSize(new java.awt.Dimension(85, 25));
        jButtonAddLast.setMinimumSize(new java.awt.Dimension(85, 25));
        jButtonAddLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddLastActionPerformed(evt);
            }
        });

        jButtonInsert.setText("insert");
        jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAddLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAddFirst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(jButtonGen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jButtonGen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAddFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAddLast, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//Generate
    private void jButtonGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenActionPerformed
        // TODO add your handling code here:
        Doubly = new DoublyLinkedList();//สร้าง Doubly เพื่อเตรียมตัวเก็บข้อมูลแบบ Linked List
        int number = 5;
        for (int i = 0; i < number; i++) {//สร้างวัตถุ Person 5 Person เพิ่มลงใน Linked List
            String name = genRandomString(new Random().nextInt(5) + 5);//สุ่มข้อความที่ให้มีค่าเริ่มต้นที่ 5 ตัวอักษร
            int age = 15 + new Random().nextInt(50);//สุ่มเลขที่ให้มีค่าเริ่มต้นที่ 15
            Doubly.addLast(new Person(name, age));//สร้างวัตถุ Person และเพิ่มลงใน Linked List
        }
        Doubly.printMe();//print มาดูแบบหวานๆว่าเข้าไปใน Linked List หรือยัง

        //>>>ขี้นตาราง แบบ Linked List จะไม่ค่อยปกติสักเท่าไร 
        Object[][] x = new Object[Doubly.data().getSize()][];

        Node ptr = Doubly.data().start;//เอา Node แรกแยกออกมาเพื่อความง่าย
        //System.out.print(start.getData() + " <-> ");
        x[0] = Doubly.data().start.getData().toString().split(",");
        //และจัดการแบ่งมันด้วย "," ก่อนยังเข้า array x หรือ row แบบหวานๆ ใน index[0]
        ptr = Doubly.data().start.getLinkNext();//เลื่อนมาที่ Node ต่อไป
        int c = 1;//ให้ค่า c เป็นตัวแทยของ row หรือ index ใน array x
        while (ptr.getLinkNext() != null) {//วนหาไป Node ต่อๆไปจนกว่าจะไม่มีให้ไปต่อ
            //System.out.print(ptr.getData() + " <-> ");
            x[c] = ptr.getData().toString().split(",");
            //และจัดการแบ่งมันด้วย "," ก่อนยังเข้า array x หรือ row แบบหวานๆ ใน index[c]
            ptr = ptr.getLinkNext();//เลื่อนไป Node ต่อไปจร้า
            c++;//เพิ่มค่า index ด้วยนะ
        }
        //System.out.print(ptr.getData() + "\n");
        x[c] = ptr.getData().toString().split(",");// Node สุดท้ายที่ไม่มีทางให้ไปต่อแล้ว
        //เราก็จัดการแบ่งมันด้วย "," ก่อนยังเข้า array x หรือ row แบบหวานๆ ใน index[c]
        //ค่า c ในการวนลูปสุดท้ายจะพอดีกับค่าขนาดของ Linked List 

//            for (int i = 0; i < Doubly.data().getSize(); i++) {
//                x[i] = Doubly.data().start.getData();
//                        //.toString().split(",");
//            }
//
        javax.swing.table.DefaultTableModel model1 = new javax.swing.table.DefaultTableModel(x, header);
        //จัดแจงเตรียมขึ้นตาราง (row หรือ แถว,ชื่อ column)
        jTable1.setModel(model1); //set ขึ้นตารางใน GUI
        //<<<ขึ้นตาราง
    }//GEN-LAST:event_jButtonGenActionPerformed

//addFirst
    private void jButtonAddFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddFirstActionPerformed
        // TODO add your handling code here:
        if (jTextField1.getText().length() > 0) {
            //if ใส่ไว้กัน Error ในกรณีที่ jTextField1 มันว่าง
            String rowData[] = jTextField1.getText().split(",");
            //get String ออกมาแบ่งด้วย "," ใส่ array เตรียมสร้างวัตถุต่อไป
            Doubly.addFirst(new Person(rowData[0], Integer.parseInt(rowData[1])));
            //สร้างวัตถุ Person และเพิ่มไว้ข้างหน้า Linked List จาก rowData ที่เตรียมไว้

            Doubly.printMe();//print มาดูแบบหงานกรุบๆ
            //>>>ขี้นตาราง แบบ Linked List จะไม่ค่อยปกติสักเท่าไร 
            Object[][] x = new Object[Doubly.data().getSize()][];

            Node ptr = Doubly.data().start;//เอา Node แรกแยกออกมาเพื่อความง่าย
            //System.out.print(start.getData() + " <-> ");
            x[0] = Doubly.data().start.getData().toString().split(",");
            //และจัดการแบ่งมันด้วย "," ก่อนยังเข้า array x หรือ row แบบหวานๆ ใน index[0]
            ptr = Doubly.data().start.getLinkNext();//เลื่อนมาที่ Node ต่อไป
            int c = 1;//ให้ค่า c เป็นตัวแทยของ row หรือ index ใน array x
            while (ptr.getLinkNext() != null) {//วนหาไป Node ต่อๆไปจนกว่าจะไม่มีให้ไปต่อ
                //System.out.print(ptr.getData() + " <-> ");
                x[c] = ptr.getData().toString().split(",");
                //และจัดการแบ่งมันด้วย "," ก่อนยังเข้า array x หรือ row แบบหวานๆ ใน index[c]
                ptr = ptr.getLinkNext();//เลื่อนไป Node ต่อไปจร้า
                c++;//เพิ่มค่า index ด้วยนะ
            }
            //System.out.print(ptr.getData() + "\n");
            x[c] = ptr.getData().toString().split(",");// Node สุดท้ายที่ไม่มีทางให้ไปต่อแล้ว
            //เราก็จัดการแบ่งมันด้วย "," ก่อนยังเข้า array x หรือ row แบบหวานๆ ใน index[c]
            //ค่า c ในการวนลูปสุดท้ายจะพอดีกับค่าขนาดของ Linked List 

//            for (int i = 0; i < Doubly.data().getSize(); i++) {
//                x[i] = Doubly.data().start.getData();
//                        //.toString().split(",");
//            }
//
            javax.swing.table.DefaultTableModel model1 = new javax.swing.table.DefaultTableModel(x, header);
            //จัดแจงเตรียมขึ้นตาราง (row หรือ แถว,ชื่อ column)
            jTable1.setModel(model1); //set ขึ้นตารางใน GUI
            //<<<ขึ้นตาราง
            jTextField1.setText(null);//ทำให้ jTextField1 ว่างพร้อมรับข้อมูล
        }
    }//GEN-LAST:event_jButtonAddFirstActionPerformed

//addLast
    private void jButtonAddLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddLastActionPerformed
        // TODO add your handling code here:
        if (jTextField1.getText().length() > 0) {
            //if ใส่ไว้กัน Error ในกรณีที่ jTextField1 มันว่าง
            String rowData[] = jTextField1.getText().split(",");
            //get String ออกมาแบ่งด้วย "," ใส่ array เตรียมสร้างวัตถุต่อไป
            Doubly.addLast(new Person(rowData[0], Integer.parseInt(rowData[1])));
            //สร้างวัตถุ Person และเพิ่มไว้ท้ายสุด Linked List จาก rowData ที่เตรียมไว้

            Doubly.printMe();//print มาดูแบบหงานกรุบๆ
            //>>>ขี้นตาราง แบบ Linked List จะไม่ค่อยปกติสักเท่าไร 
            Object[][] x = new Object[Doubly.data().getSize()][];

            Node ptr = Doubly.data().start;//เอา Node แรกแยกออกมาเพื่อความง่าย
            //System.out.print(start.getData() + " <-> ");
            x[0] = Doubly.data().start.getData().toString().split(",");
            //และจัดการแบ่งมันด้วย "," ก่อนยังเข้า array x หรือ row แบบหวานๆ ใน index[0]
            ptr = Doubly.data().start.getLinkNext();//เลื่อนมาที่ Node ต่อไป
            int c = 1;//ให้ค่า c เป็นตัวแทยของ row หรือ index ใน array x
            while (ptr.getLinkNext() != null) {//วนหาไป Node ต่อๆไปจนกว่าจะไม่มีให้ไปต่อ
                //System.out.print(ptr.getData() + " <-> ");
                x[c] = ptr.getData().toString().split(",");
                //และจัดการแบ่งมันด้วย "," ก่อนยังเข้า array x หรือ row แบบหวานๆ ใน index[c]
                ptr = ptr.getLinkNext();//เลื่อนไป Node ต่อไปจร้า
                c++;//เพิ่มค่า index ด้วยนะ
            }
            //System.out.print(ptr.getData() + "\n");
            x[c] = ptr.getData().toString().split(",");// Node สุดท้ายที่ไม่มีทางให้ไปต่อแล้ว
            //เราก็จัดการแบ่งมันด้วย "," ก่อนยังเข้า array x หรือ row แบบหวานๆ ใน index[c]
            //ค่า c ในการวนลูปสุดท้ายจะพอดีกับค่าขนาดของ Linked List 

//            for (int i = 0; i < Doubly.data().getSize(); i++) {
//                x[i] = Doubly.data().start.getData();
//                        //.toString().split(",");
//            }
//
            javax.swing.table.DefaultTableModel model1 = new javax.swing.table.DefaultTableModel(x, header);
            //จัดแจงเตรียมขึ้นตาราง (row หรือ แถว,ชื่อ column)
            jTable1.setModel(model1); //set ขึ้นตารางใน GUI
            //<<<ขึ้นตาราง
            jTextField1.setText(null);//ทำให้ jTextField1 ว่างพร้อมรับข้อมูล
        }
    }//GEN-LAST:event_jButtonAddLastActionPerformed

//Insert
    private void jButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertActionPerformed
        // TODO add your handling code here:
        if (jTextField1.getText().length() > 0 && jTextField2.getText().length() > 0) {
            //if ใส่ไว้กัน Error ในกรณีที่ jTextField1และ2 มันว่าง
            String rowData[] = jTextField1.getText().split(",");
            //get String ออกมาแบ่งด้วย "," ใส่ array เตรียมสร้างวัตถุต่อไป
            int index = Integer.parseInt(jTextField2.getText());
            //get String ออกมาจาก jTextField2 
            //แต่มันเป็นค่าของตำแหน่งเลยต้องแปลงจาก String>>>int ด้วย Integer.parseInt
            Doubly.inSert(index, new Person(rowData[0], Integer.parseInt(rowData[1])));
            //สร้างวัตถุ Person และเพิ่มไว้ในตำแหน่งที่อยู่ในตัวแปร index ใน Linked List จาก rowData ที่เตรียมไว้
            Doubly.printMe();//print มาดูเพื่อความแน่ใจ
            //>>>ขี้นตาราง แบบ Linked List จะไม่ค่อยปกติสักเท่าไร 
            Object[][] x = new Object[Doubly.data().getSize()][];

            Node ptr = Doubly.data().start;//เอา Node แรกแยกออกมาเพื่อความง่าย
            //System.out.print(start.getData() + " <-> ");
            x[0] = Doubly.data().start.getData().toString().split(",");
            //และจัดการแบ่งมันด้วย "," ก่อนยังเข้า array x หรือ row แบบหวานๆ ใน index[0]
            ptr = Doubly.data().start.getLinkNext();//เลื่อนมาที่ Node ต่อไป
            int c = 1;//ให้ค่า c เป็นตัวแทยของ row หรือ index ใน array x
            while (ptr.getLinkNext() != null) {//วนหาไป Node ต่อๆไปจนกว่าจะไม่มีให้ไปต่อ
                //System.out.print(ptr.getData() + " <-> ");
                x[c] = ptr.getData().toString().split(",");
                //และจัดการแบ่งมันด้วย "," ก่อนยังเข้า array x หรือ row แบบหวานๆ ใน index[c]
                ptr = ptr.getLinkNext();//เลื่อนไป Node ต่อไปจร้า
                c++;//เพิ่มค่า index ด้วยนะ
            }
            //System.out.print(ptr.getData() + "\n");
            x[c] = ptr.getData().toString().split(",");// Node สุดท้ายที่ไม่มีทางให้ไปต่อแล้ว
            //เราก็จัดการแบ่งมันด้วย "," ก่อนยังเข้า array x หรือ row แบบหวานๆ ใน index[c]
            //ค่า c ในการวนลูปสุดท้ายจะพอดีกับค่าขนาดของ Linked List 

//            for (int i = 0; i < Doubly.data().getSize(); i++) {
//                x[i] = Doubly.data().start.getData();
//                        //.toString().split(",");
//            }
//
            javax.swing.table.DefaultTableModel model1 = new javax.swing.table.DefaultTableModel(x, header);
            //จัดแจงเตรียมขึ้นตาราง (row หรือ แถว,ชื่อ column)
            jTable1.setModel(model1); //set ขึ้นตารางใน GUI
            //<<<ขึ้นตาราง
            jTextField1.setText(null);//ทำให้ jTextField1 ว่างพร้อมรับข้อมูล
            jTextField2.setText(null);//ทำให้ jTextField2 ว่างพร้อมรับข้อมูล
        }
    }//GEN-LAST:event_jButtonInsertActionPerformed

    public static String genRandomString(int n) {//method สุ่มStringตามตวามยาวที่ใส่ใน( n ความยาว)
        Random random = new Random();
        String str = "";
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();//แปลง String a-z ยัดและแบ่งใส่ array charแบบถึกๆ
        for (int i = 0; i < n; i++) {//วนลูปตามความยาวที่ถูกใส่เข้ามา
            str += letters[random.nextInt(26)];//สุ่มว่าจะได้ตัวอักษรไหนจากการ สุ่มเลข index ของ array letters
            if (i == 0) {//ตัวแรกของ String
                str = str.toUpperCase();//ทำให้เป็นตัวพิมพ์ใหญ่ด้วย toUpperCase()
            }
        }
        return str; //คืนค่า String สุ่มตามความยาวที่ต้องการแล้ว
    }

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
            java.util.logging.Logger.getLogger(Assignment_4_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Assignment_4_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Assignment_4_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Assignment_4_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Assignment_4_jframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddFirst;
    private javax.swing.JButton jButtonAddLast;
    private javax.swing.JButton jButtonGen;
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
