// Java 프로그래밍 - 변수와 자료형_1


import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

//      1. 변수 사용하기
        System.out.println("== 변수 사용하기 ==");
        int age =10;
        System.out.println(age);
        String country = "Korea";
        System.out.println(country);

//      2. 변수 이름 규칙
        System.out.println("== 변수 이름 규칙 ==");
//      2-1. 문자, 숫자, _(underscore), $ 사용 가능
        int apple = 2000;
        int apple3 = 2000;
        int _apple = 2000;
        int $apple = 2000;
        System.out.println(apple);
        System.out.println("#apple = " + $apple);

//      2-2. 숫자로 시작 X
//        int 3apple = 2000;

//      2-3. 대소문자 구분

//      2-4. 공백 사용 X

//      2-5. 예약어 사용 X
//      예약어 예시: true, false, if, switch, for, continue, break, ...
//        int true = 1;
//      참고) 한글 사용 가능

        
//      3. 표기법
//      3-1. 카멜 표기법 (camelCase)
//      변수, 함수

        
//      3-2. 파스칼 표기법 (PascalCase)
//      클래스

        
//      참고) 스네이크 표기법 (snake_case)
//      사용 X

        //===============================================================================
//      1. 자료형 - 숫자
        System.out.println("== 숫자 ==");
//      1-1. 정수

//      1-2. 실수

//      1-3. 2진수 / 8진수 / 16진수


//      2. 자료형 - 부울
        System.out.println("== 부울 ==");


//      3. 자료형 - 문자
        System.out.println("== 문자 ==");


        //===============================================================================
        //      1. 자료형 - 문자열
        System.out.println("== 문자열 ==");
        String s1= "Hello world";
        System.out.println(s1);
        String s2 = "0123";
        System.out.println(s2);

//      1-1. equals
        String s3= "HI";
        String s4= "HI";
        System.out.println("s3.equals(s4) : " + s3.equals(s4)); // true
        String s5 = new String("HI");
        System.out.println("s3.equals(s4) : " + s3.equals(s5)); // true
        System.out.println("s3.equals(s4) : " + s3 == s5); // false

        // == 는 주소값을 비교
        // equals 는 문자를 비교


//      1-2. indexOf
        String s6="Hello World!";
        System.out.println(s6.indexOf("!"));

//      1-3. replace


//      1-4. substring


//      1-5. toUpperCase



//      2. 자료형 - StringBuffer
        System.out.println("== StringBuffer ==");



//      3. 자료형 - 배열
        System.out.println("== 배열 ==");

        int[] myArray1 = {1,2,3,4,5};
        System.out.println(myArray1[0]);
        System.out.println(myArray1[3]);
        System.out.println(myArray1[4]);

        String[] makeArray = new String[3];
        makeArray[0] = "Hello";
        makeArray[1] = " ";
        makeArray[2] = "World!";

        System.out.println(makeArray[0] +makeArray[1] +makeArray[2]);


        //===============================================================================

//      1. 자료형 - 리스트
        System.out.println("== 리스트 ==");
        ArrayList l1 = new ArrayList();

//      1-1. add
        l1.add(1);
        l1.add("hello");
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add("world!");
        System.out.println("l1 = " + l1);

        l1.add(0, 1);
        System.out.println("l1 = " + l1);
//      1-2. get

        System.out.println(l1.get(0));
        System.out.println(l1.get(2));

//      1-3. size
        System.out.println(l1.size());

//      1-4. remove
        System.out.println(l1.remove(0));
        System.out.println("l1 = " + l1);

        System.out.println(l1.remove(Integer.valueOf("1")));
        System.out.println("l1 = " + l1);

//      1-5. clear
        l1.clear();
        System.out.println("l1 = " + l1);

//      1-6. sort
        ArrayList l2= new ArrayList();
        l2.add(6);
        l2.add(7);
        l2.add(5);
        System.out.println("l2 =" + l2);

        l2.sort(Comparator.naturalOrder());
        System.out.println("l2 =" + l2);
        l2.sort(Comparator.reverseOrder());
        System.out.println("l2 =" + l2);

//      1-7. contains



//      2. Maps
        System.out.println("== Maps ==");


//      2-1. put


//      2-2. get


//      2-3. size

//      2-4. remove


//      2-5. containsKey



//      3. Generics
        System.out.println("== Generics ==");



    }
}

