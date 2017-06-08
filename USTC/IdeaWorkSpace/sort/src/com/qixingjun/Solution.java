package com.qixingjun;

/**
 * @Author XingJun Qi
 * @MyBlog www.qixingjun.tech
 * @Version 1.0.0
 * @Date 2017/3/13
 * @Description
 *
 *
 * java中String的常用方法

java中String的常用方法
1、length() 字符串的长度
　　例：char chars[]={'a','b'.'c'};
　　　　String s=new String(chars);
　　　　int len=s.length();

2、charAt() 截取一个字符
　　例：char ch;
　　　　ch="abc".charAt(1); 返回'b'

3、 getChars() 截取多个字符
　　void getChars(int sourceStart,int sourceEnd,char target[],int targetStart)
　　sourceStart指定了子串开始字符的下标，sourceEnd指定了子串结束后的下一个字符的下标。因此， 子串包含从sourceStart到sourceEnd-1的字符。接收字符的数组由target指定，target中开始复制子串的下标值是targetStart。
　　例：String s="this is a demo of the getChars method.";
　　　　char buf[]=new char[20];
　　　　s.getChars(10,14,buf,0);

4、getBytes()
　　替代getChars()的一种方法是将字符存储在字节数组中，该方法即getBytes()。

5、toCharArray()

6、equals()和equalsIgnoreCase() 比较两个字符串

7、regionMatches() 用于比较一个字符串中特定区域与另一特定区域，它有一个重载的形式允许在比较中忽略大小写。
　　boolean regionMatches(int startIndex,String str2,int str2StartIndex,int numChars)
　　boolean regionMatches(boolean ignoreCase,int startIndex,String str2,int str2StartIndex,int numChars)

8、startsWith()和endsWith()　　startsWith()方法决定是否以特定字符串开始，endWith()方法决定是否以特定字符串结束

9、equals()和==
　　equals()方法比较字符串对象中的字符，==运算符比较两个对象是否引用同一实例。
　　例：String s1="Hello";
　　　　String s2=new String(s1);
　　　　s1.eauals(s2); //true
　　　　s1==s2;//false

10、compareTo()和compareToIgnoreCase() 比较字符串

11、indexOf()和lastIndexOf()
　　indexOf() 查找字符或者子串第一次出现的地方。
　　lastIndexOf() 查找字符或者子串是后一次出现的地方。

12、substring()　　它有两种形式，第一种是：String substring(int startIndex)
　　　　　　　　 第二种是：String substring(int startIndex,int endIndex)

13、concat() 连接两个字符串

14 、replace() 替换
　　它有两种形式，第一种形式用一个字符在调用字符串中所有出现某个字符的地方进行替换，形式如下：
　　String replace(char original,char replacement)
　　例如：String s="Hello".replace('l','w');
　　第二种形式是用一个字符序列替换另一个字符序列，形式如下：
　　String replace(CharSequence original,CharSequence replacement)

15、trim() 去掉起始和结尾的空格

16、valueOf() 转换为字符串

17、toLowerCase() 转换为小写

18、toUpperCase() 转换为大写

19、StringBuffer构造函数
　　StringBuffer定义了三个构造函数：
　　StringBuffer()
　　StringBuffer(int size)
　　StringBuffer(String str)
　　StringBuffer(CharSequence chars)

(1)、length()和capacity()　　　　一个StringBuffer当前长度可通过length()方法得到,而整个可分配空间通过capacity()方法得到。

(2)、ensureCapacity() 设置缓冲区的大小
　　　　void ensureCapacity(int capacity)

　　(3)、setLength() 设置缓冲区的长度
　　　　void setLength(int len)

　　(4)、charAt()和setCharAt()
　　　　char charAt(int where)
　　　　void setCharAt(int where,char ch)

　　(5)、getChars()
　　　　void getChars(int sourceStart,int sourceEnd,char target[],int targetStart)

　　(6)、append() 可把任何类型数据的字符串表示连接到调用的StringBuffer对象的末尾。
　　　　例：int a=42;
　　　　　　StringBuffer sb=new StringBuffer(40);
　　　　　　String s=sb.append("a=").append(a).append("!").toString();

　　(7)、insert() 插入字符串
　　　　StringBuffer insert(int index,String str)
　　　　StringBuffer insert(int index,char ch)
　　　　StringBuffer insert(int index,Object obj)
　　　　index指定将字符串插入到StringBuffer对象中的位置的下标。

　　(8)、reverse() 颠倒StringBuffer对象中的字符
　　　　StringBuffer reverse()

　　(9)、delete()和deleteCharAt() 删除字符
　　　　StringBuffer delete(int startIndex,int endIndex)
　　　　StringBuffer deleteCharAt(int loc)

　　(10)、replace() 替换
　　　　StringBuffer replace(int startIndex,int endIndex,String str)

　　(11)、substring() 截取子串
　　　　String substring(int startIndex)
　　　　String substring(int startIndex,int endIndex)

例子：
//String所给出的方法均可以直接调用
public class Test{
public static void main(String[] args){
String s = "Welcome to Java World!";
String s1 = " sun java ";
System.out.println(s.startsWith("Welcome"));//字符串以Welcome开头
System.out.println(s.endsWith("World"));//字符串以World结尾
String sL = s.toLowerCase();//全部转换成小写
String sU = s.toUpperCase();//全部转换成大写
System.out.println(sL);
System.out.println(sU);
String b = s.substring(11);//从第十一位开始
System.out.println(b);
String c = s.substring(8,11);//从第八位开始在第十一位结束
System.out.println(c);
String d = s1.trim();//去掉首尾的空格
System.out.println(d);
String s2 = "我是程序员，我在学java";
String e = s2.replace("我","你");
System.out.println(e);
int f = 5;
String s3 = String.valueOf(f);
System.out.println(s3);
String s4 = "我是,这的,大王";
String[] g = s4.split(",");
System.out.println(g[0]);
当把字符串转换成基本类型时，例如，int，integer.praseInt(String s)
当把基本类型转换成字符串时，例如，static String valueOf(int i)
 *
 */

//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            String str = sc.nextLine();
//            char[] arr = str.toCharArray();
//            Map<Character,Integer> map = new LinkedHashMap<>();
//            for(char a:arr){
//                if(!map.containsKey(a)){
//                    map.put(a,1);
//                }else{
//                    map.put(a,map.get(a)+1);
//                }
//            }
//            for(Character a:map.keySet()){
//                if(map.get(a)==1){
//                    System.out.println(a);
//                    return;
//                }
//            }
//            System.out.println(-1);
//        }
//    }




import java.util.Arrays;
import java.util.Scanner;
//public class Solution {
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        String str1 = sc.nextLine();
//        String str2 = sc.nextLine();
//        String str3 = sc.nextLine();
////        String str4 = sc.nextLine();
////        String str5 = sc.nextLine();
//        String[] arrStr1 = str1.split(" ");
//        String[] arrStr2 = str1.split(" ");
//        String[] arrStr3 = str1.split(" ");
////        String[] arrStr4 = str1.split(" ");
////        String[] arrStr5 = str1.split(" ");
//
//        int[] arrInt1 = new int[arrStr1.length];
//        for (int i = 0; i < arrStr1.length; i++) {
//            arrInt1[i] = Integer.parseInt(arrStr1[i]);
//        }
//
//        int[] arrInt2 = new int[arrStr2.length];
//        for (int i = 0; i < arrStr2.length; i++) {
//            arrInt2[i] = Integer.parseInt(arrStr2[i]);
//        }
//
//        int[] arrInt3 = new int[arrStr3.length];
//        for (int i = 0; i < arrStr3.length; i++) {
//            arrInt3[i] = Integer.parseInt(arrStr3[i]);
//        }
//
//        String[] arrStr  = new String[arrInt1[1]];
//        for (int i = 0; i < arrInt1[1]; i++) {
//            arrStr[i] = sc.nextLine();
//            for (int j = 0; j < arrStr4.length; j++) {
//                arrInt4[i] = Integer.parseInt(arrStr4[i]);
//            }
//        }
//    }
//}


//    public static void main(String[] args) {
//
//    }
//}


import java.util.*;

public class Solution{
    public static void main(String args[]){
        int n,k;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            n=sc.nextInt();
            k=sc.nextInt();
            Solution s = new Solution();
            int[] arr = s.iterator(n,n);
            int count=0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i]>=k){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public int[] iterator(int n , int m) {
        int[] arr = new int[m];
        for (int i = n-1; i >= 0; i--) {
            arr[i] = i;
            if (m == 1) {
                return null;
            } else
                this.iterator(n - i, m - 1);
        }
        return arr;
    }
}











