package com.example.grammar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

// private : 상속 X, 다른 곳 X
// protected : 상속 O, 다른 곳 X
// public : 상속 O, 다른 곳 O

class Student1 {
    static final String schoolName = "sungju";

    // static : 공용으로 사용함을 의미하는 keyword, 보통 객체.XX 쓰지 않고, class.XX 라고 쓴다.
    // final : 상수(값이 변하지 않는 것)
    static int number = 10;

    public int korean; // 멤버 변수
    public int english;


    // Overload : 함수 이름이 같지만, 함수의 파라미터가 달라서 알아서 구분해 주는 것을 의미함.
    // 생성자 : 이름이 같고, 리턴형을 생
    public Student1() {

    }

    public Student1(int korean, int english) {
        this.korean = korean;
        this.english = english;

    }

    // 멤버 함수
    public int getAverage() {
        int sum = korean + english;
        // 상수는 값을 쓸수 없다.
        //schoolName = "asdfdsf";
        Log.d("kihoon.kim", "schoolName = " + schoolName);
        return sum/2;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "schoolName='" + schoolName + '\'' +
                ", korean=" + korean +
                ", english=" + english +
                ", number=" + number +
                '}';
    }
};

// extends 를 이용해서 상속한다.
class HighSchoolStudent extends Student1 {
    private int science;

    public HighSchoolStudent(int korean, int english, int science) {
        super(korean, english);
        this.science = science;
    }

    // 재정의, override
    @Override
    public int getAverage() {
        int sum = this.korean + this.english + science;
        return sum/3;
        //return super.getAverage();
    }
}


public class MainActivity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button)findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("kihoon.kim", "Hello World");
                // 변수 : 값을 저장하는 공간
                // Primitive Type (원시적인)(기본형)
                // int : 정수형 (4byte)
                // boolean : true, false
                // char : 한글자 (1byte)
                // byte : 정수형 (1byte)
                // short : 정수형 (2byte)
                // long : 정수형 (8byte)
                // float : 소수형 (4byte)
                // double : 소수형 (8byte)

                int score = 100;
                Log.d("kihoon.kim", "score = " + score);
                boolean isYerim = true;
                if(isYerim) {
                    Log.d("kihoon.kim", "OK!!!  isYerim = " + isYerim);
                } else {
                    Log.d("kihoon.kim", "Not OK!!!  isYerim = " + isYerim);
                }

                int korean = 80;
                int math = 77;
                int english = 69;

                int sum = korean + math + english;
                float average = (float)sum / 3;
                Log.d("kihoon.kim", "average = " + average);

                // 타입 캐스팅 : 타입 변경
                //int --> float 변경을 하고자 한다면, (float)sum 앞에 (float)를 붙여 준다.

                String strText = "Hello world";
                char ch = strText.charAt(4);
                Log.d("kihoon.kim", "ch = " + ch);

                // 2. Reference type (참조형) : new 로 생성한다.
                // String , class, array....
                String strText1 = new String("Hello World");
                // String 에서 +
                //"Hello" + "World" => "HelloWorld" : concat
                // 문자열 + 정수 ==> 문자열
                //

                Log.d("kihoon.kim", "strText1 = " + strText1);
                int [] arr = new int[4];
                arr[0] = 10;
                arr[1] = 20;
                arr[2] = 35;
                arr[3] = 30;

                for(int i = 0;i < arr.length; i++) {
                    Log.d("kihoon.kim", "arr[] = " + arr[i]);
                }

                int [] arr2 = { 10, 20, 30, 40};

                for(int i = 0;i < arr2.length; i++) {
                    Log.d("kihoon.kim", "arr2[] = " + arr2[i]);
                }

                int [][]matrix = new int[5][5];
                int count = 0;
                for(int i= 0; i < 5;i++){
                    for(int j=0;j<5;j++) {
                        matrix[i][j] = count++;
                        Log.d("kihoon.kim", "matrix[i][j] = " + matrix[i][j]);
                    }
                }

                class Student {
                    int korea;
                    int english;
                    int math;

                    @Override
                    public String toString() {
                        return "Student{" +
                                "korea=" + korea +
                                ", english=" + english +
                                ", math=" + math +
                                '}';
                    }

                    public Student() {

                    }

                    public Student(int korea, int english, int math) {
                        this.korea = korea;
                        this.english = english;
                        this.math = math;
                    }
                }

                Student [] students = new Student[3];
                students[0]= new Student();
                students[0].korea = 100;
                students[0].math = 100;
                students[0].english = 100;

                students[1]= new Student();
                students[1].korea = 90;
                students[1].math = 80;
                students[1].english = 70;

                students[2]= new Student();
                students[2].korea = 30;
                students[2].math = 30;
                students[2].english = 20;

                for(int i = 0; i< students.length; i++) {
                    Log.d("kihoon.kim", "students[i] = " + students[i]);
                }

                Student[] students2 = {
                        new Student(100, 100, 100),
                        new Student(90, 80, 70),
                        new Student(20, 20, 20),
                };

                for(int i = 0; i< students2.length; i++) {
                    Log.d("kihoon.kim", "students2[i] = " + students2[i]);
                }


                Student student = new Student();
                student.korea = 100;
                student.english = 70;
                student.math = 80;

                Log.d("kihoon.kim", "student = " + student);

                // 연산자
                // +, -, *, /, % (모듈러: 나머지)

                int a = 10;
                int b = a / 3;
                int c = a % 3;
                Log.d("kihoon.kim", "b = " + b + ", c = " + c);

                // ++, --
                // ++ ==>  count = count + 1 , count += 1
                // count %= 2 ==> count = count % 2
                int count2 = 0;

                while(true) {
                    if(count2 > 10) {
                        break;
                    }
                    Log.d("kihoon.kim", "count2 = " + count2++);
                }

                Log.d("kihoon.kim", "================");

                count2 = 0;
                while(true) {
                    if(count2 > 10) {
                        break;
                    }
                    Log.d("kihoon.kim", "count2 = " + (++count2));
                }

                // 비교 연산자
                // >, <, <=, >= , == , !=
                // 논리 연산자
                // && : AND
                // || : OR

                // 삼항 연산자
                // ? :

                int value1 = true ? 3 : 5;
                int value2 = false ? 3 : 5;

//                int value1 = true ? 3 : 5;
//                if(true) {
//                    value1 = 3;
//                } else {
//                    value1 = 5;
//                }

                Log.d("kihoon.kim", "value1 = " + value1);
                Log.d("kihoon.kim", "value2 = " + value2);


                // if, switch, for, while, do while
                // break, countinue;
                int value3 = 100;
                if (value3 == 100) {
                    Log.d("kihoon.kim", "OK value3 = " + value3);
                } else {
                    Log.d("kihoon.kim", "NOT OK value3 = " + value3);
                }

                //if () {
                //
                //} else if () {
                //} else if () {
                //}

                Log.d("kihoon.kim", "=======switch=========");

                value3 = 30;
                switch(value3) {
                    case 1 :
                        Log.d("kihoon.kim", "case 1");
                        break;
                    case 2 :
                        Log.d("kihoon.kim", "case 2");
                        break;
                    case 30 :
                        Log.d("kihoon.kim", "case 30");
                        break;
                    default:
                        Log.d("kihoon.kim", "etc");
                        break;
                }
                Log.d("kihoon.kim", "=======switch-end========");
                for(int i = 0; i < 10; i++) {
                    Log.d("kihoon.kim", "i = " + i);
                }

                Log.d("kihoon.kim", "=================");
                int i = 0;
                while(i < 10) {
                    i++;
                    if(i == 5) {
                        break;
                    }
                    if(i == 3) {
                        continue;
                    }
                    Log.d("kihoon.kim", "i = " + i);
                }

                // break; 는 자기 자신의 for loop 문을 빠져 나온다.
                //for() {
                //    for() {
                //        break;
                //    }
                //    break;
                //}
                Log.d("kihoon.kim", "=================");
                count = 0;
                do {
                    count++;
                    Log.d("kihoon.kim", "count = " + count);
                }while(count < 10);




                // class 는 단순 정의다.
                // 활용을 하려면, 객체를 만들어서 사용한다. 객체는 변수라고 생각하면 된다.

                Student1 student1 = new Student1();
                Student1 student2 = new Student1(100, 100);
                //student1.korean = 100;

                Log.d("kihoon.kim", "average = " + student2.getAverage() );

                //scope : private , public, default, protected.

                HighSchoolStudent highSchoolStudent = new HighSchoolStudent(100, 80, 80);

                Log.d("kihoon.kim", "average = " + highSchoolStudent.getAverage() );

                Student1 student3 = new Student1(100, 100);
                Student1.number = 33;
                Log.d("kihoon.kim", "student3 = " + student3);
                Student1 student4 = new Student1(80, 70);
                Student1.number = 55;
                Log.d("kihoon.kim", "student3 = " + student3);
                Log.d("kihoon.kim", "student4 = " + student4);

            }
        });
    }
}
//
//    Window 키 + R
//
//        cmd
//
//
//        cd : change directory
//
//        cd ..
//        cd grammar
//
//        dir : 모든 파일들을 볼때.
//
//        git clone http://xxxx
//
//        git add . : 소스를 staging 영역에 올릴때
//
//        git status : 현재 상태를 봄
//
//        git commit -a -m "initial commit"
//
//        git log : history 를 볼때.
//
//        git config

// git add .
// git commit -a -m "implement button"
// git push : 소스 올릴때


// git pull : 올라온 거 땡길때
// git clone : 소스 받을때