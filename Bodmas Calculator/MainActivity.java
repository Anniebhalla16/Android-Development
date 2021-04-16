package com.example.bodmascalculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bodmascalculator.R;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private Button clear, back, div, mul, add, sub, percent, power, equal, one, two, three, four, five, six, seven, eight, nine, zero, point;
    private TextView Screen;
    String input, answer;
    Stack<Double> stack2 = new Stack<Double>();
    Stack<Character> stack1 = new Stack<Character>();
 //   Deque<String> postfix= new ArrayDeque<String>();


    public void buttonclick(View v) {
        if (v.getId() == one.getId()) {
            input = Screen.getText().toString() + "1";
            Screen.setText(input);
        }
        if (v.getId() == two.getId()) {
            input = Screen.getText().toString() + "2";
            Screen.setText(input);
        }
        if (v.getId() == three.getId()) {
            input = Screen.getText().toString() + "3";
            Screen.setText(input);
        }
        if (v.getId() == four.getId()) {
            input = Screen.getText().toString() + "4";
            Screen.setText(input);
        }
        if (v.getId() == five.getId()) {
            input = Screen.getText().toString() + "5";
            Screen.setText(input);
        }
        if (v.getId() == six.getId()) {
            input = Screen.getText().toString() + "6";
            Screen.setText(input);
        }
        if (v.getId() == seven.getId()) {
            input = Screen.getText().toString() + "7";
            Screen.setText(input);
        }
        if (v.getId() == eight.getId()) {
            input = Screen.getText().toString() + "8";
            Screen.setText(input);
        }
        if (v.getId() == nine.getId()) {
            input = Screen.getText().toString() + "9";
            Screen.setText(input);
        }
        if (v.getId() == zero.getId()) {
            input = Screen.getText().toString() + "0";
            Screen.setText(input);
        }
        if (v.getId() == point.getId()) {
            input = Screen.getText().toString() + ".";
            Screen.setText(input);
        }
        if (v.getId() == add.getId()) {
            input = Screen.getText().toString() + "+";
            Screen.setText(input);
        }
        if (v.getId() == sub.getId()) {
            input = Screen.getText().toString() + "-";
            Screen.setText(input);
        }
        if (v.getId() == percent.getId()) {
            input = Screen.getText().toString() + "%";
            Screen.setText(input);
        }
        if (v.getId() == power.getId()) {
            input = Screen.getText().toString() + "^";
            Screen.setText(input);
        }
        if (v.getId() == div.getId()) {
            input = Screen.getText().toString() + "/";
            Screen.setText(input);
        }
        if (v.getId() == mul.getId()) {
            input = Screen.getText().toString()+"*" ;
            Screen.setText(input);
        }


    }

//    int precedence(char c)
//    {
//        if(c=='^')
//        {
//            return 3;
//        }
//        else if(c=='*' || c=='/')
//        {
//            return 2;
//        }
//        else if(c=='+' || c=='-')
//        {
//            return 1;
//        }
//        else
//        {
//            return -1;
//        }
//
//    }
//
//
//// function to check for valid operator
//
//   public boolean check_OP(char x)
//    {
//        if( x=='+' || x=='-' || x=='*' || x=='/' || x=='^')
//            return true;
//        else
//            return false;
//    }
//
//
//// function to convert from infix to postfix
//
//    public String  convert(String  in_exp)
//    {
//
//        for(int i=0 ; i<in_exp.length() ; i++)
//        {
//            char ch= in_exp.charAt(i);
//            if(ch>='0' && ch<='9' )
//            {
//                String temp=""+ch;
//                while(!check_OP(ch) || i<in_exp.length())
//                {
//                    temp+=in_exp.charAt(++i);
//                }
//                postfix.add(temp);
//            }
//
//            else if( ch=='(')
//            {
//                stack2.push(ch);
//            }
//
//            else if(ch==')')
//            {
//                while((stack2.peek()!='(') && (!stack2.isEmpty()))
//                {
//                    char temp = stack2.peek();
//                    postfix.add("temp");
//                    stack2.pop();
//                }
//                if(stack2.peek()=='(')
//                    stack2.pop();
//            }
//
//            else if( check_OP(ch))
//            {
//                if(stack2.isEmpty())
//                    stack2.push(ch);
//
//                else
//
//                {
//                    if((precedence(ch)) > (precedence(stack2.peek())))
//                        stack2.push(ch);
//
//                    else if((precedence(ch)) == precedence(stack2.peek()) && ch=='^')
//                    {
//                        stack2.push(ch);
//                    }
//                    else
//                    {
//                        while((!stack2.isEmpty()) && precedence(ch)<=precedence(stack2.peek()))
//                        {
//                            char temp=stack2.peek();
//                           postfix.add("temp");
//                            stack2.pop();
//                        }
//                        stack2.push(ch);
//                    }
//                }
//            }
//        }
//
//        while(!stack2.isEmpty())
//        {
//            postfix.add(stack2.peek().toString());
//            stack2.pop();
//        }
//        return evaluate();
//    }
//
//
//// to evaluate the postfix expression
//
//   public String evaluate()
//    {
//
//        Double op1 , op2 ;  // op = operand
//        Iterator<String> iter= postfix.iterator();
//
//       while(iter.hasNext())
//        {
//            String item= postfix.peek();
//            postfix.pop();
//            char ch = item.charAt(0);
//            if(!(check_OP(ch)))
//            {
//              Double value= Double.parseDouble(item);
//              stack1.push(value);
//            }
//            else if(check_OP(ch))
//            {
//                op1 = stack1.peek();
//                stack1.pop();
//                op2 = stack1.peek();
//                stack1.pop();
//                double val=0;
//                switch(ch)
//                {
//
//                    case '+' :
//                    {
//                        val= op1+op2;
//                        stack1.push(val);
//                        break;
//                    }
//
//                    case '-' :
//                    {
//                        val= op2-op1;
//                        stack1.push(val);
//                        break;
//                    }
//
//                    case '*' :
//                    {
//                        val= op1*op2;
//                        stack1.push(val);
//                        break;
//                    }
//
//                    case '/' :
//                    {
//                        val= op2/op1;
//                        stack1.push(val);
//                        break;
//                    }
//
//                    case '^' :
//                    {
//                        val=Math.pow(op2,op1);
//                        stack1.push(val);
//                        break;
//                    }
//
//
//                }
//            }
//
//        }
//        return stack1.peek()+" ";
//    }


    int precedence(char c)
    {
        if(c=='^')
        {
            return 3;
        }
        else if(c=='*' || c=='/')
        {
            return 2;
        }
        else if(c=='+' || c=='-')
        {
            return 1;
        }
        else
        {
            return -1;
        }

    }


// function to check for valid operator

    boolean check_OP(char x)
    {
        if( x=='+' || x=='-' || x=='*' || x=='/' || x=='^')
            return true;
        else
            return false;
    }


// function to convert from infix to postfix

    public String convert(String in_exp)
    {
        String postfix="";
        for(int i=0 ; i<in_exp.length() ; i++)
        {
            char ch= in_exp.charAt(i);
            if(ch>='0' && ch<='9' )
            {
                int val = ch- '0';
                postfix+=ch;
            }

            else if( ch=='(')
            {
                stack1.push(ch);
            }

            else if(ch==')')
            {
                while((stack1.peek()!='(') && (!stack1.isEmpty()))
                {
                    char temp = stack1.peek();
                    postfix+=temp;
                    stack1.pop();
                }
                if(stack1.peek()=='(')
                    stack1.pop();
            }

            else if( check_OP(ch))
            {
                if(stack1.isEmpty())
                    stack1.push(ch);

                else

                {
                    if((precedence(ch)) > (precedence(stack1.peek())))
                        stack1.push(ch);

                    else if((precedence(ch)) == precedence(stack1.peek()) && ch=='^')
                    {
                        stack1.push(ch);
                    }
                    else
                    {
                        while((!stack1.isEmpty()) && precedence(ch)<=precedence(stack1.peek()))
                        {
                            char temp=stack1.peek();
                            postfix+=temp;
                            stack1.pop();
                        }
                        stack1.push(ch);
                    }
                }
            }
        }

        while(!stack1.isEmpty())
        {
            postfix+=stack1.peek();
            stack1.pop();
        }
        return evaluate(postfix);
    }


// to evaluate the postfix expression

    public String evaluate( String post_exp)
    {

        Double val=0.0;
        Double op1 , op2 ;  // op = operand
        for(int i=0; i<post_exp.length() ; i++)
        {
            char c= post_exp.charAt(i);
            if(!(check_OP(c)))
            {
                Double x= Double.parseDouble(String.valueOf(c));
                stack2.push(x);
            }
            else if(check_OP(c))
            {

                char K = c;
                op1 = stack2.peek();
                stack2.pop();

                op2 = stack2.peek();
                stack2.pop();

                switch(K)
                {

                    case '+' :
                    {
                        val= op1+op2;
                        stack2.push(val);

                        break;
                    }

                    case '-' :
                    {
                        val=  (op2-op1);
                        stack2.push(val);
                        break;
                    }

                    case '*' :
                    {
                        val= op1*op2;

                        stack2.push(val);
                        break;
                    }

                    case '/' :
                    {

                        val= op2/op1;
                        stack2.push(val);
                        break;
                    }

                    case '^' :
                    {
                        val=Math.pow(op2,op1);
                        stack2.push(val);
                        break;
                    }


                }
            }

        }
        return stack2.peek()+" ";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clear = (Button) findViewById(R.id.clear);
        back = (Button) findViewById(R.id.back);
        mul = (Button) findViewById(R.id.mul);
        add = (Button) findViewById(R.id.add);
        div = (Button) findViewById(R.id.div);
        sub = (Button) findViewById(R.id.sub);
        percent = (Button) findViewById(R.id.percent);
        power = (Button) findViewById(R.id.power);
        equal = (Button) findViewById(R.id.equal);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.two);
        three = (Button) findViewById(R.id.three);
        four = (Button) findViewById(R.id.four);
        five = (Button) findViewById(R.id.five);
        six = (Button) findViewById(R.id.six);
        seven = (Button) findViewById(R.id.seven);
        eight = (Button) findViewById(R.id.eight);
        nine = (Button) findViewById(R.id.nine);
        zero = (Button) findViewById(R.id.zero);
        point = (Button) findViewById(R.id.dot);

        Screen = (TextView) findViewById(R.id.screen);


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Screen.setText("");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = Screen.getText().toString();
                newText = newText.substring(0, newText.length() - 1);
                Screen.setText(newText);
            }
        });
//
//        add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(Screen.getText()==null)
//                    Screen.setText(" ");
//                else{
//                    res1= Float.parseFloat(Screen.getText()+" ");
//                    addition= true;
//                  //  Screen.setText(" ");
//                }
//            }
//        });
//
//        sub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(Screen.getText()==null)
//                    Screen.setText(" ");
//                else{
//                    res1= Float.parseFloat(Screen.getText()+" ");
//                    subtraction= true;
//                  //  Screen.setText(" ");
//                }
//            }
//        });
//
//        mul.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(Screen.getText()==null)
//                    Screen.setText(" ");
//                else{
//                    res1= Float.parseFloat(Screen.getText()+" ");
//                    multiplication= true;
//                  //  Screen.setText(" ");
//                }
//            }
//        });
//
//        div.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(Screen.getText()==null)
//                    Screen.setText(" ");
//                else{
//                    res1= Float.parseFloat(Screen.getText()+" ");
//                    division= true;
//                  //  Screen.setText(" ");
//                }
//            }
//        });
//
//        power.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(Screen.getText()==null)
//                    Screen.setText(" ");
//                else{
//                    res1= Float.parseFloat(Screen.getText()+" ");
//                    pow= true;
//                   // Screen.setText(" ");
//                }
//            }
//        });
//
//        percent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(Screen.getText()==null)
//                    Screen.setText(" ");
//                else{
//                    input = Screen.getText().toString()+"%";
//                    Screen.setText(input);
//                    res1= Float.parseFloat(Screen.getText()+" ");
//                    per= true;
//                 //   Screen.setText(" ");
//                }
//            }
//        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = convert(input);
                Screen.setText(answer);
            }
        });

    }

}