
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import javax.swing.tree.DefaultMutableTreeNode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 * ขอขอบคุณอัลกอลิทึมจาก LevelOrderTraversalQ https://www.geeksforgeeks.org/level-order-traversal-line-line-set-3-using-one-queue/
 */
public class LevelOrderTraversalQ {

    static int i = 0;//level
    static String BFSQ = "";
    static String Level = "";//LevelOrderTraver
// Prints level order traversal line 
// by line using two queues. 

    static void levelOrder(DefaultMutableTreeNode root) {
        /**
         * เช็คว่ามีข้อมูลใน tree มั้ย
         */
        if (root == null) {
            return;
        }

        //คิวที่มี datatype DefaultMutableTreeNode เก็บการท่องในต้นไม้
        Queue<DefaultMutableTreeNode> q = new LinkedList<>();

        // Pushing root node into the queue. 
        //ใส่ root เข้าไปในคิว
        q.add(root);

        // Pushing delimiter into the queue. 
        //ใส่ null เพื่อเช็ค level
        q.add(null);

        // Executing loop till queue becomes 
        // empty 
        /**
         * print level 0 or Root
         */
        System.out.print("Level " + i + " ==> ");
        Level += "Level " + i + " ==> ";
        i++;//level++
        while (!q.isEmpty()) {

            DefaultMutableTreeNode curr = q.remove();
            //นำต้นไม้ในคิวออกมา

            // condition to check the 
            // occurence of next level 
            if (curr == null) {//print level อื่นๆ
                if (!q.isEmpty()) {
                    q.add(null);

                    System.out.println();
                    System.out.print("Level " + i + " ==> ");
                    Level += "\nLevel " + i + " ==> ";
                    i++;
                }
            } else {
                // Pushing left child current node 
                if (curr.getChildCount() > 0) {
                    //มีลูกมากกว่า 0 แสดงว่ามีข้างซ้าย และอาจมีด้านขวา
                    DefaultMutableTreeNode left = curr.getNextNode();
                    //นำโหนดลูกด้านซ้ายออกมา
                    if (!left.toString().equals("")) {
                        //เช็คว่ามีค่ามั้ยถ้ามี เก็บเข้าในคิว
                        q.add(left);
                    }
                }

                // Pushing right child current node 
                if (curr.getChildCount() > 1) {
                    //มีลูกมากกว่า 1 แสดงว่ามีทั้งลูกด้านซ้าย-ขวา
                    DefaultMutableTreeNode right = curr.getNextNode().getNextSibling();
                    //นำโหนดลูกด้านขวาออกมา
                    if (!right.toString().equals("")) {
                         //เช็คว่ามีค่ามั้ยถ้ามี เก็บเข้าในคิว
                        q.add(right);
                    }
                }
                BFSQ += curr.toString() + " ";//เก็บค่าเพื่อการท่องแบบ BFS
                System.out.print(curr.toString() + " ");
                Level += curr.toString() + " ";//เก็บค่าโหนดในแต่ละ level
            }
        }
        System.out.println("");
    }

    //=====>>>Binary Tree Diagram
    public static String traversePreOrder(DefaultMutableTreeNode root) {

        if (root == null) {
            return "";
        }
        DefaultMutableTreeNode rootTree = (DefaultMutableTreeNode) root.getRoot();
        StringBuilder sb = new StringBuilder();
        sb.append(rootTree.toString());

        //System.out.println("ch count " + rootTree.getChildCount());
        DefaultMutableTreeNode L = rootTree.getNextNode();
        DefaultMutableTreeNode R = rootTree.getNextNode().getNextSibling();

        String pointerRight = "└──";
        String pointerLeft = (rootTree.getNextNode().getNextSibling() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, L, R != null);
        traverseNodes(sb, "", pointerRight, R, false);

        return sb.toString();
    }

    public static void traverseNodes(StringBuilder sb, String padding, String pointer, DefaultMutableTreeNode node,
            boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.toString());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }
            //System.out.println("ch count " + node.getChildCount());
            if (node.getChildCount() > 0) {
                DefaultMutableTreeNode L = node.getNextNode();
                DefaultMutableTreeNode R = node.getNextNode().getNextSibling();
                String paddingForBoth = paddingBuilder.toString();
                String pointerRight = "└──";
                String pointerLeft = (R != null) ? "├──" : "└──";

                traverseNodes(sb, paddingForBoth, pointerLeft, L, R != null);
                traverseNodes(sb, paddingForBoth, pointerRight, R, false);
            }
        }
    }
    //<<<=====Binary Tree Diagram

// This code is Contributed by Rishabh Jindal 
    /**
     * @param args the command line arguments
     */
// Driver function 
    public static void main(String[] args) {
        // TODO code application logic here
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(1);
        DefaultMutableTreeNode L = new DefaultMutableTreeNode(2);
        DefaultMutableTreeNode R = new DefaultMutableTreeNode(3);
        root.add(L);
        root.add(R);
        L.add(new DefaultMutableTreeNode(4));
        L.add(new DefaultMutableTreeNode(5));
        R.add(new DefaultMutableTreeNode(null));
        R.add(new DefaultMutableTreeNode(6));

        levelOrder(root);
        System.out.println(BFSQ);
        System.out.println(traversePreOrder(root));
        
        System.out.println(Level);

    }

}
