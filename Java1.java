package pack1;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;


class Student implements Comparable<Student>{
    private String name;
    private int age;
    Student(String name, int age){
        this.age = age;
        this.name = name;
    }

    public int compareTo(Student student){
        int num = this.age - student.age;
        if(num == 0)
            return this.name.compareTo(student.name);
        return  num;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    public int hashCode(){

        return age*3+name.hashCode();
    }
    public boolean equals(Object obj){
        if(!(obj instanceof Student))
            throw new ClassCastException("类型错误");
        return this.name.equals(((Student) obj).name) && this.age == ((Student) obj).age;


    }

}







/**
 * Created by Root on 2016/7/19.
 */
/*    interface NewInterface<T>{
       public <T> void show(T t);
}
 class Fanxing<T>{
     private T obj;
    public Fanxing(T obj){
        this.obj = obj;
    }
     public void setObj(T obj){
         this.obj = obj;
     }
     public T getObj(){
         return obj;
     }


}
 class Demo <T> implements NewInterface<T>{
     public<T> void show(T t){
        Java1.printSomething(t);


     }



 }
 class Person implements Comparable{
     private String name;
     private int age;
    Person(String name,int age){
        this.name = name;
        this.age = age;



    }
    public int compareTo(Object obj){
        if(!(obj instanceof Person))
            throw new RuntimeException("Not Person");
        Person p =(Person)obj;
        if(p.getAge()-this.getAge() == 0)
            return this.name.compareTo(p.getName());
        return this.getAge()-p.getAge();


    }
    /*public boolean equals(Object obj){
        if(!(obj instanceof Person))
            return false;
        return this.name.equals(((Person) obj).name)&& this.age == ((Person) obj).age;

    }*/
/*
    public int hashCode(){
        return name.hashCode()+age*3;


    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }



    

}
class MyCompare implements Comparator{
    public int compare(Object o1,Object o2){

        Person p1 = (Person)o1;
        Person p2 = (Person)o2;
        int comp = p1.getName().compareTo(p2.getName());
        if(comp == 0)
            return p1.getAge()-p2.getAge();
        return comp;


    }





}
*/
class stringCom implements Comparator<String>{
    public int compare(String s1,String s2){
        if(s1.length()-s2.length() == 0)
            return s1.compareTo(s2);
        return s1.length()-s2.length();


    }


}
class Singleton {
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton (){}
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
class MyBufferedReader extends Reader{
    private Reader fileReader;

    MyBufferedReader(Reader fileReader){
        this.fileReader = fileReader;
    }
    public int read(char []cbuf, int off ,int len) throws IOException{
        return fileReader.read(cbuf,off,len);
    }
    public void close() throws IOException{
        fileReader.close();

    }
    public String myReadLine() throws IOException{
        StringBuilder stringBuilder = new StringBuilder();
        int ch = 0;
        while ((ch = fileReader.read()) != -1){
            char chr = (char)ch;
            if (chr == '\r' )
                continue;
            if (chr == '\n')
                return stringBuilder.toString();
            stringBuilder.append(chr);
        }
        if (stringBuilder.length() != 0)
            return stringBuilder.toString();
        return "";


    }




}
class MyLineReader{
    private FileReader fileReader;
    MyLineReader(FileReader fileReader){
        this.fileReader = fileReader;
    }
    public void myReadLineNum() throws IOException{
        LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
        String ch = null;
        lineNumberReader.setLineNumber(100);
        while ((ch = lineNumberReader.readLine()) != null){
            Java1.printSomething(lineNumberReader.getLineNumber()+" : "+ch);
        }

    lineNumberReader.close();
    }





}


class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Integer[] array = {1, 2, 3, -1, 0, -2, -3, -1};
        Integer[][] store = new Integer[50][3];
        Integer i, j, k, m = 0;
        for (i = 0; i < array.length; i++)
            for (j = i + 1; j < array.length; j++)
                for (k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] == 0) {
                        store[m][0] = array[i];
                        store[m][1] = array[j];
                        store[m][2] = array[k];
                        m++;
                    }

                }
        k = 0;
        List<Integer> temp_list = new ArrayList<>();
        for (i = 0; i < m; i++) {
            Arrays.sort(store[i]);
            for (j = i + 1; j < m; j++) {
                Arrays.sort(store[j]);
                if (!Arrays.equals(store[i], store[j]))
                    k++;
            }

            if (k == m - i - 1) {
                Integer count_this = 0;

                for (; count_this < 3; count_this++)
                    temp_list.add(store[i][count_this]);
                list.add(temp_list);
                temp_list.clear();


            }
            k = 0;
        }
        return list;

    }
}


class MyFinalLineNumReader{
    private int  lineNumber = 0;
    private Reader reader;
    MyFinalLineNumReader(Reader reader){
        this.reader = reader;


    }
    public int getLineNumber(){
        return lineNumber;
    }
    public void setLineNumber(int lineNumber){
        this.lineNumber = lineNumber;
    }
    public String myFinalLineReader() throws IOException{
        lineNumber++;
        StringBuilder stringBuilder = new StringBuilder();
        int ch = 0;
        while ((ch = reader.read()) != -1){
            char chr = (char)ch;
            if (chr == '\r')
                continue;
            if (chr == '\n'){
                return stringBuilder.toString();}
            stringBuilder.append(chr);





        }
        if(stringBuilder.length() != 0)
            return stringBuilder.toString();



        return null;


    }


    public void myClose() throws IOException{
        reader.close();
    }


}
class LinkList{
    abstract static class Node{
        private Object firstNode;
        private Object object;
        private Node nextNode;
        public void setFirstNode(Object firstNode){
            this.firstNode = firstNode;
        }
        public void setNode(Object object,Node nextNode){
                this.object = object;
                this.nextNode = nextNode;


        }
        abstract public void getNode(Object object,Node nextNode);





    }










}









public  class Java1 {

    public static void printSomething(Object obj) {

        System.out.println(obj);
    }


    /*public static ArrayList getUniqueElem(ArrayList al){

        ArrayList temp_al = new ArrayList();
        Iterator it = al.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            if(!temp_al.contains(obj)){
                temp_al.add(obj);
            }
        }
        return temp_al;

    }*/

    static class stuComp implements Comparator<Student> {

        public int compare(Student stu1, Student stu2) {
            int num = stu1.getName().compareTo(stu2.getName());
            if (num == 0)
                return stu1.getAge() - stu2.getAge();
            return num;


        }
    }

    public static void showInfo(HashMap<String, String> hashMap) {
        Set<Map.Entry<String, String>> set = hashMap.entrySet();
        Iterator<Map.Entry<String, String>> it = set.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> temp = it.next();
            printSomething(temp.getKey() + " .. " + temp.getValue());


        }


    }

    public static void stringSort() {
        TreeSet<String> list = new TreeSet<String>(Collections.reverseOrder(new stringCom()));
        list.add("asd");
        list.add("s22ds333333");
        list.add("s23323");
        list.add("abc");


    }

    public static void showArray(int... arr) {
        for (int i : arr) {
            printSomething(i);
        }


    }

    public static void random() {

        DecimalFormat dc = new DecimalFormat("0.00");
        double getDouble = Double.parseDouble(dc.format(2.3292323));
        printSomething(getDouble);
    }
    public static void  writeFileStream() throws IOException{
        FileOutputStream fostream = new FileOutputStream("demo.txt");
        fostream.write("1234".getBytes());
        fostream.close();




    }
    public static void  readFileStream() throws IOException{
        FileInputStream fistream = new FileInputStream("demo.txt");
        byte buf[] = new byte[fistream.available()];
        fistream.read(buf);
        printSomething(new String(buf));

        fistream.close();




    }
    public static void countBinaryOnes() {
        int counter = 0,get_num ;
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner2 = new Scanner(System.in);
        get_num = scanner.nextInt();
        String str = "12333334";
        printSomething(str);
        printSomething(get_num);
        char[] array = str.toCharArray();
        int[] int_array = new int[array.length];
        for (int i = 0; i < int_array.length; i++) {
            int_array[i] = (int) array[i];


        }
        int []count_array = new int[get_num];
        for (int begin = 0,end = begin+get_num-1;end<int_array.length;begin++,end++){
            for (int j=0,begin_inner = begin;j<get_num;j++,begin_inner++){
                count_array[j] = int_array[begin_inner];
            }
            Arrays.sort(count_array);
            char result =  (char) (count_array[get_num-1]);
            System.out.print(result+",");

        }

    }

    public static void main(String[] args) throws IOException {
        //countBinaryOnes();
        String str = "aaabbv**accc**q****2";
        String strings[] = str.split("[**]");
        for (String s:
             strings) {
            if (!s.equals(""))
            printSomething(s);

        }
        printSomething(strings.length);
        /*showArray(2,3,4,5,1,2,3,6);
        String [] strArr ={"123","232","2323"};
        List <String>list = asList(strArr);
        for(String tmp : list){
            printSomething(tmp);
        }
        HashMap<Integer,String> hm = new HashMap<>();
        hm.put(123,"222");
        hm.put(124,"223");
        hm.put(153,"222");
        for(Map.Entry<Integer,String> me :hm.entrySet()){
            printSomething(me.getKey()+"  ..  "+me.getValue());


        }









            /*writeFileStream();
        readFileStream();
            FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("D:\\demo.txt");
            fileWriter.write("fff");
            fileWriter.write("mdzz");
        }
        catch (IOException ioe){
            printSomething("IO异常");
        }
        finally {
            try {
                fileWriter.close();
            }
            catch (NullPointerException npe){
                printSomething("空指针异常");
            }

        }
        */














        /*HashMap<String,List<Student>> company = new HashMap<>();
        List<Student> class1list = new ArrayList<>();
        class1list.add(new Student("zhangsan",14));
        class1list.add(new Student("lsis",14));
        class1list.add(new Student("wangwu",14));
        List<Student> class2list = new ArrayList<>();
        class2list.add(new Student("zhangsan",18));
        class2list.add(new Student("maliu",18));
        class2list.add(new Student("zhangsan",18));
        company.put("class1",class1list);
        company.put("class2",class2list);
        Set<Map.Entry<String,List<Student>>> entrySet = company.entrySet();
        Iterator<Map.Entry<String,List<Student>>> iterator = entrySet.iterator();

        while (iterator.hasNext()){
            Map.Entry<String,List<Student>> temp = iterator.next();
            printSomething("class  = "+temp.getKey());
            Iterator <Student> studentIterator = temp.getValue().iterator();
            while (studentIterator.hasNext()){
                Student tempStu = studentIterator.next();
                printSomething(tempStu.getName()+"  ..  "+tempStu.getAge());
            }


        }*/


    }
    public static void copy_exe() throws IOException{
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\ccsetup509pro.exe"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\1121.exe"));
        int ch = 0;
        while ((ch = bufferedInputStream.read())!= -1){
            bufferedOutputStream.write(ch);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();


    }


}







