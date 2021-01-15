
import java.util.Random;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
class Expression {//คลาสตามที่โจทย์กำหนดมีฟิลด์

    private String infix, postfix, result;//ฟิลด์ 3 ฟิลด์ตามที่โจทย์กำหนด
    /*
    มี constructor แบบรับพารามิเตอร์ 3 ตัวเป็นชนิด int 1 ตัว และชนิด boolean 2 ตัว 
    โดยจะสร้างนิพจน์ infixแบบอัตโนมัติ ที่มีความยาวเท่ากับค่าพารามิเตอร์ตัวแรก (มีค่าเป็นเลขคี่ในช่วงปิด 3 – 13) 
    พารามิเตอร์ตัวที่สองใช้กำาหนดว่าจะสร้างนิพจน์แบบตัวเลขหรือตัวอักษร (true = ตัวเลข, false = ตัวอักษร) 
    พารามิเตอร์ตัวที่สามใช้กำาหนดว่าจะสร้างนิพจน์ที่ประกอบด้วยวงเล็บ 1 คู่ หรือไม่ (true = มีวงเล็บ, false = ไม่มีวงเล็บ) 
    */
    public Expression(int n, boolean c, boolean v) {//
        if (c) {//สร้างเงื่อนไขการสร้างนิพจน์ infixแบบอัตโนมัติ
            infix = infixAuto(n + (n - 1), v, "Number");//เป็นตัวเลขเมื่อ พารามิเตอร์ตัวที่สอง true 
        } else {
            infix = infixAuto(n + (n - 1), v, "A-Z");//เป็นตัวอักษรเมื่อ พารามิเตอร์ตัวที่สอง false
        }

    }

    public String getInfix() {//เรียกดูค่า infix
        return infix;
    }

    public String getPostfix() {//เรียกดูค่า postfix
        return postfix;
    }

    public String getResult() {//เรียกดูค่า result
        return result;
    }

    public void infix2postfix() {//method ที่ตั้งชื่อตามโจทย์เพื่อทำการแปลงค่าจาก infix >> postfix

        postfix = toPostfix(infix);
        //ทำการเรียก method แปลงค่าจาก infix>>postfix ใส่ infix เป็นพารามิเตอร์ 

    }

    public void postfixEvaluation(boolean c) {//method ที่ตั้งชื่อตามโจทย์ เพื่อคำนวณค่าจาก postfix
        //รับ boolean มาเพื่อแยกว่าเป็น ตัวเลขหรือตัวอักษร 
        result = computation(postfix, c);
        //method computation ใช้เพื่อคำนวณค่าจากนิพจน์ postfix

    }

    private static String infixAuto(int n, boolean have, String type) {
        //method เพื่อใช้งานในการสร้าง infix 
        String str = "";
        char operator[] = "+-*/%".toCharArray();//array ของ เครื่องหมาย
        char[] letters;
        if (!type.equals("Number")) {//เงื่อนไขตัดสินว่าจะสร้างจาก
            letters = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();//ตัวอักษร
        } else {
            letters = "0123456789".toCharArray();//หรือตัวเลข
        }
        boolean no = true;//สร้าง boolean เพื่อให้มีวงเล็บเพียง 1 คู่
        boolean c = false;//สร้างขึ้นเพื่อกำหนดให้มีทั้งวงเล็บ เปิดและปิด
        for (int i = 0; i < n; i++) {//วนลูปเพื่อสร้าง  infix

            if (i % 2 == 0) {//สุ่มอีกทีว่าจะใส่วงเล็บมั้ย
                if (new Random().nextInt(2) == 0 && no && have && i + 2 < n) {
                    str += "(";
                    str += infixAuto(3, false, type);//เรียกตัวเองเพื่อสร้างนิพจน์ในวงเล็บ
                    c = true;
                    i += 2;//นับนิพจน์ที่สร้าง
                }
                if (!c) {
                    //สุ่มตัวเลขหรือตัวอักษร
                    str += letters[new Random().nextInt(letters.length)];
                }
                if (c) {//ใส่วงเล็บปิด
                    str += ")";
                    c = false;
                    no = false;
                }
            } else {//สุ่มเครืองหมายทางคณิตศาสตร์
                str += operator[new Random().nextInt(operator.length)];
            }
            c = false;
        }
        return str;//คืนค่าเป็น infix
    }

    //เช็คความสำคัญของเครื่องหมายด้วย isOperator
    private static int isOperator(char i) {
        if (i == '(' || i == ')') {
            return 1;
        } else if (i == '-' || i == '+') {
            return 2;
        } else if (i == '*' || i == '/' || i == '%') {
            return 3;
        } else {
            return 0;
        }
    }

    //คำนวณตามเครื่องหมายที่ใส่  (เลขตัวแรก,เครื่องหมาย,เลขตัวที่สอง)
    private static int toOperator(int a, char c, int b) {
        if (c == '+') {//เครื่องหมาย +
            return (a) + (b);//คำนวณด้วยการบวก
        } else if (c == '-') {//เครื่องหมาย -
            return (a) - (b);//คำนวณด้วยการลบ
        } else if (c == '*') {//เครื่องหมาย *
            return (a) * (b);//คำนวณด้วยการคูณ
        } else if (c == '/') {//เครื่องหมาย /
            return (a) / (b);//คำนวณด้วยการหาร
        } else if (c == '%') {//เครื่องหมาย %
            return (a) % (b);////คำนวณด้วยการมอด
        } else {
            return 0;
        }
    }

    //แปลงจาก infix >> postfix
    private static String toPostfix(String infix) {
        Stack<Character> test = new Stack<>();
        String ans = "";
        char top; //9+0*5-1/1
        //วนตามความยาวของ infix
        for (int i = 0; i < infix.length(); i++) {
            char one = infix.charAt(i);//เก็บค่ามาจาก infix ที่ละตัว
            if (isOperator(one) == 0) {//เช็คว่าใช้เครื่องหมายหรือไม่
                ans += one;//ถ้าไม่ใช้เครื่องหมายให้เก็บไว้ใน String
            } else if (one == ')') {//เช็คว่าเป็นวงเล็บปิดหรือไม่
                //ถ้าเป็นวงเล็บปิดเราจะต้อง pop() จนกว่าจะเจอวงเล็บเปิด
                while ((top = test.pop()) != '(') {
                    ans += top;//นำเครื่องหมายที่ pop()
                }
            } else {
                //เช็คว่าง stack ไม่ว่าง และ char ที่เข้ามาใหม่ไม่ใช่วงเล็บเปิด และ เครื่องหมายล่าสุดใน stack มีค่ามากกว่าหรือเท่ากับ เครื่องหมายใหม่
                while (!test.isEmpty() && one != '(' && isOperator(test.peek()) >= isOperator(one)) {
                    ans += test.pop();//ถ้าผ่านเงื่อนไขจะทำการ pop จนกว่าเงื่อนไขจะผิด
                }
                test.push(one);//ถ้าออกจากลูปแล้วจะใส่เครื่องหมายใหม่ลงไป
            }

        }
        //เมื่อสิ้นสุดความยาวของ infix แล้ว
        while (!test.isEmpty()) {
            ans += test.pop();//pop ทำอย่างใน stack ออกมา
        }

        return ans;//คำตอบที่เป็น postfix
    }

    //เปลี่ยน post >> infix แบบใส่วงเล็บ เพื่อช่วยลดความสับสน
    public static String toInfix(String postfix) {
        Stack<String> test = new Stack<>();
        //วนลูปด้วยความยาวของ postfix
        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);//อ่านค่า String postfix ที่ละตัว
            if (isOperator(c) != 0) {//เมื่อเจอเครื่องหมาย
                String b = test.pop();//pop Stack ครั้งที่ 1
                String a = test.pop();//pop Stack ครั้งที่ 2
                test.push("(" + a + c + b + ")");
                //"(" + Stack ที่ถูก pop() ครั้งที่ 2 + เครื่องหมาย + Stack ที่ถูก pop() ครั้งที่ 1 + ")"
                //แล้วนำไปใส่ไว้ใน stack แบบที่ใส่วงเล็บเรียบร้อย
            } else {
                test.push("" + c);//ไม่ใช่เครื่องหมาย นำไปใส่ stack
            }
        }

        return test.pop();//infix ที่ใส่วงเล็บแล้วเรียบร้อย

    }

    //method ใช้ในการคำนวณจาก postfix
    private static String computation(String postfix, boolean t) {

        Stack<Integer> test = new Stack<>();
        if (t) {//ถ้าเป็นตัวเลข
            try {

                for (int i = 0; i < postfix.length(); i++) {
                    char c = postfix.charAt(i);
                    if (isOperator(c) != 0) {
                        int b = test.pop();
                        //System.out.println(b);
                        int a = test.pop();
                        //System.out.println(a);
                        int num = toOperator(a, c, b);
                        //System.out.println(num);
                        test.push(num);
                    } else {
                        //System.out.println("push"+c+"="+Integer.parseInt(String.valueOf(c)));
                        test.push(Integer.parseInt(String.valueOf(c)));
                    }
                }
                return Integer.toString(test.pop());
            } catch (Exception e) {
                return "Error / by zero";
            }
        } else {//ถ้าเป็นตัวอักษร
            return "cannot process";
        }

    }

    @Override//ดูฟิดล์ทั้งหมดในวัตถุ
    public String toString() {
        return "Expression{" + "infix=" + infix + ", postfix=" + postfix + ", result=" + result + '}';
    }

}

public class Assignment_5 extends javax.swing.JFrame {

    private Expression test[];

    /**
     * Creates new form Assignment_5
     */
    public Assignment_5() {
        initComponents();
        this.setTitle("เจ้ากรรม นายเวร");
        this.jTextField1.setText("Operations on Expressions: 07610XXX Ms.Grim Reaper");
        this.jTextField1.setEditable(false);
        this.jTextArea1.setText("INFIX");
        this.jTextArea2.setText("POSTFIX");
        this.jTextArea3.setText("EVALUATE");
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
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setFont(new java.awt.Font("Angsana New", 0, 24)); // NOI18N
        jTextField1.setText("jTextField1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox1.setText("integer ");

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jCheckBox2.setText("parentheses");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Infix → Postfix");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Evaluate");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jCheckBox1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jCheckBox2))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jCheckBox1)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBox2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean number = jCheckBox1.isSelected();//เก็บค่าว่าจะให้เป็น ตัวเลขมั้ย
        System.out.println(number);//(true = ตัวเลข, false = ตัวอักษร)
        boolean p = jCheckBox2.isSelected();///เก็บค่าว่าจะให้มีวงเล็บหรือไม่
        System.out.println(p);//(true = มีวงเล็บ, false = ไม่มีวงเล็บ)
        test = new Expression[10];//สร้าง array วัตถุจำนวน 10 วัตถุ
        String a1 = "";//เก็บค่า infix
        int num[] = {3,5,7,9,11,13};//เลขคี่ 3-13
        for (int i = 0; i < 10; i++) {//สร้างวัตถุ 10 ครั้ง
            test[i] = new Expression(num[new Random().nextInt(num.length)], number, p);
            //สร้าง วัตถุโดยเรียกตัวสร้าง(สุ่มตัวเลขที่อยู่ใน 3-13,boolean ตัวเลขหรือไม่,มีวงเล็บหรือไม่)
            a1 += test[i].getInfix() + "\n";//เก็บค่า infix พร้อม "\n" เพื่อขึ้นบรรทัดใหม่
        }
        System.out.println(a1);//print infix ออกมา
        jTextArea1.setText(a1);//นำไปแสดงใน jTextArea1

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String a2 = "";//เก็บค่า postfix
        for (int i = 0; i < test.length; i++) {//วนลูปเท่ากับจำนวนวัตถุใน array
            test[i].infix2postfix();//เรียก method infix2postfix() จาก infix>>postfix
            a2 += test[i].getPostfix() + "\n";//เก็บค่า postfix พร้อม "\n" เพื่อขึ้นบรรทัดใหม่
        }
        System.out.println(a2);//print postfix ออกมา
        jTextArea2.setText(a2);//นำไปแสดงใน jTextArea2
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         boolean number = jCheckBox1.isSelected();//เก็บค่าว่าจะให้เป็น ตัวเลขมั้ย
        System.out.println(number);//(true = ตัวเลข, false = ตัวอักษร)
        String a3 = "";//เก็บค่า postfix
        for (int i = 0; i < test.length; i++) {//วนลูปเท่ากับจำนวนวัตถุใน array
            test[i].postfixEvaluation(number);//คำนวณผลลัพธ์
            a3 += test[i].getResult() + "\n";//เก็บค่า ผลลัพธ์ พร้อม "\n" เพื่อขึ้นบรรทัดใหม่
        }
        System.out.println(a3);//print ผลลัพธ์ออกมา ออกมา
        jTextArea3.setText(a3);//นำไปแสดงใน jTextArea3
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Assignment_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Assignment_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Assignment_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Assignment_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Assignment_5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
