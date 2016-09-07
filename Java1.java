package pack1;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;

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

public  class Java1   {

    public static void printSomething(Object obj){

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

    static class stuComp implements Comparator<Student>{

        public int compare(Student stu1,Student stu2){
            int num = stu1.getName().compareTo(stu2.getName());
            if (num == 0)
                return stu1.getAge()-stu2.getAge();
            return num;



        }
    }
    public static void showInfo(HashMap<String,String> hashMap){
            Set<Map.Entry<String,String>> set = hashMap.entrySet();
            Iterator<Map.Entry<String,String>> it =set.iterator();
            while (it.hasNext()){
                Map.Entry<String,String> temp = it.next();
                printSomething(temp.getKey()+" .. "+temp.getValue());



        }


    }
    public  static void stringSort(){
        TreeSet<String> list = new TreeSet<String>(Collections.reverseOrder(new stringCom()));
        list.add("asd");
        list.add("s22ds333333");
        list.add("s23323");
        list.add("abc");





    }
    public static void showArray(int ... arr){
        for(int i : arr){
            printSomething(i);
        }



    }
    public static void random(){

        DecimalFormat dc = new DecimalFormat("0.00");
        double getDouble = Double.parseDouble(dc.format(2.3292323));
        printSomething(getDouble);
    }
    public static void main(String[] args) throws IOException {
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

        */

            /*FileWriter fileWriter = null;
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
        FileReader fileReader = new FileReader("demo.txt");
        MyFinalLineNumReader myFinalLineNumReader = new MyFinalLineNumReader(fileReader);
        myFinalLineNumReader.setLineNumber(100);
        String forPrint = null;
        while ((forPrint = myFinalLineNumReader.myFinalLineReader()) != null){
            System.out.println(myFinalLineNumReader.getLineNumber()+" : "+forPrint);
        }













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


    }






