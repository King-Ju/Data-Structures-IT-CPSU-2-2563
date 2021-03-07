
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class Citizen implements Comparable<String>{

    private String id, name, gender, address, occupation;
    private int age, salary;

    public Citizen() {
        this.id = genId()+"-"+genId();
//        String allname[] = readFile("passengerNames.txt");
        this.name = NewJFrame.allname[new Random().nextInt(NewJFrame.allname.length)];
        String[] genderRan = {"Male", "Female"};
        this.gender = genderRan[new Random().nextInt(genderRan.length)];
//        String alladdress[] = readFile("address.txt");
        this.address = NewJFrame.alladdress[new Random().nextInt(NewJFrame.alladdress.length)];
//        String alloccupation[] = readFile("gistfile1.txt");
        this.occupation = NewJFrame.alloccupation[new Random().nextInt(NewJFrame.alloccupation.length)];
        this.age = new Random().nextInt(70) + 31;
        this.salary = new Random().nextInt(9999999) + 311;
    }

    private String genId() {
        String tets = genRandomInt(13) + genRandomString(10, true);
        System.out.println(tets);
        return tets;
    }

    public static String genRandomString(int n, boolean all) {//method สุ่มStringตามตวามยาวที่ใส่ใน( n ความยาว)
        Random random = new Random();
        String str = "";
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();//แปลง String a-z ยัดและแบ่งใส่ array charแบบถึกๆ
        for (int i = 0; i < n; i++) {//วนลูปตามความยาวที่ถูกใส่เข้ามา
            str += letters[random.nextInt(26)];//สุ่มว่าจะได้ตัวอักษรไหนจากการ สุ่มเลข index ของ array letters
            if (i == 0) {//ตัวแรกของ String
                str = str.toUpperCase();//ทำให้เป็นตัวพิมพ์ใหญ่ด้วย toUpperCase()
            }
        }
        if (all) {
            str = str.toUpperCase();//ทำให้เป็นตัวพิมพ์ใหญ่ด้วย toUpperCase()
        }
        return str; //คืนค่า String สุ่มตามความยาวที่ต้องการแล้ว
    }

    public static String genRandomInt(int n) {
        Random random = new Random();
        String str = "";
        char[] letters = "0123456789".toCharArray();
        for (int i = 0; i < n; i++) {
            str += letters[random.nextInt(10)];
        }
        return str;
    }

   public static String[] readFile(String nametxt) {//อ่านไฟล์ .txt
        String[] namePass = null;
        String name = "";//เก็บชื่อที่อ่านจากไฟล์ .txt
        try {
            File myObj = new File(nametxt);//ชื่อไฟล์และตำแหน่งต้องถูกต้องนะ
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
                name += data + "%";//คั่นแต่ละชื่อที่อ่านด้วย "%"

            }
            namePass = name.split("%");//จากนั้น ทำให้มันอยกในรูปของ Array ด้วยการ split("%")
            System.out.println(Arrays.toString(namePass));//print เช็คดูว่าค่าเข้ามาหรือไม่
            myReader.close();
        } catch (FileNotFoundException e) {
            //ข้อความแจ้งเมื่อเกิดข้อผิดพลาด
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return namePass;
    }

    @Override
    public String toString() {
        return "Citizen{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", address=" + address + ", occupation=" + occupation + ", age=" + age + ", salary=" + salary + '}';
    }

    public static void main(String[] args) {
//        long start = System.currentTimeMillis();
//        Citizen test = new Citizen();
//        System.out.println(test.toString());
//        long finish = System.currentTimeMillis();
//        long timeElapsed = finish - start;
        
        

    }

    @Override
    public int compareTo(String o) {
        return this.getId().compareTo(o);
    }

    public String getId() {
        return id;
    }
}
