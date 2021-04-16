package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    Button clear,back,b1,b2,sin,cos,tan,log,sq,root,fact,reciprocal,one,two,three,four,five,six,seven,eight,nine,zero,plus,minus,mul,divide,bpi,equals;
    TextView Screen;
    String input;
    String pi= "3.14159265";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clear= findViewById(R.id.clear);
        back= findViewById(R.id.back);
        b1= findViewById(R.id.brack1);
        b2= findViewById(R.id.brack2);
        sin= findViewById(R.id.sin);
        cos= findViewById(R.id.cos);
        tan= findViewById(R.id.tan);
        log= findViewById(R.id.ln);
        sq= findViewById(R.id.sq);
        root= findViewById(R.id.root);
        fact= findViewById(R.id.fact);
        reciprocal = findViewById(R.id.reciprocal);
        one= findViewById(R.id.one);
        two= findViewById(R.id.two);
        three= findViewById(R.id.three);
        four= findViewById(R.id.four);
        five= findViewById(R.id.five);
        six= findViewById(R.id.six);
        seven= findViewById(R.id.seven);
        eight= findViewById(R.id.eight);
        nine= findViewById(R.id.nine);
        zero= findViewById(R.id.zero);
        plus= findViewById(R.id.add);
        minus= findViewById(R.id.sub);
        mul= findViewById(R.id.multiply);
        divide= findViewById(R.id.divide);
        bpi= findViewById(R.id.pi);
        equals= findViewById(R.id.equal);
        Screen= findViewById(R.id.screen);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input= " ";
                Screen.setText(" ");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input.substring(0,input.length()-1);
                Screen.setText(input);
            }
        });

        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inp= Screen.getText().toString();
                Screen.setText("√"+inp);
                Double  val=  Math.sqrt(Double.parseDouble(inp));
                Screen.setText(String.valueOf(val));
            }
        });

        fact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer ans =1;
                String inp= Screen.getText().toString();
                Screen.setText(inp+"!");
                int val= Integer.parseInt(inp);
                for(int i=val;i>=1;i--)
                    ans *=i;
                    Screen.setText(String.valueOf(ans));
            }

        });

        bpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Screen.setText(Screen.getText().toString()+ pi);

            }
        });

        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Screen.setText(Screen.getText() +"sin");
            }
        });

        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Screen.setText(Screen.getText() +"tan");
            }
        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Screen.setText(Screen.getText() +"cos");
            }
        });

        sq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double d= Double.parseDouble(Screen.getText().toString());
                Double a = d*d;
                Screen.setText(String.valueOf(a));
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = Screen.getText().toString();
                double result = eval(val);
                Screen.setText(String.valueOf(result));
            }
        });


    }



    // button click function to display in  text  view
    public void buttonclick(View v){
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

//        if (v.getId() == point.getId()) {
//            input = Screen.getText().toString() + ".";
//            Screen.setText(input);
//        }
        if (v.getId() == plus.getId()) {
            input = Screen.getText().toString() + "+";
            Screen.setText(input);
        }
        if (v.getId() == minus.getId()) {
            input = Screen.getText().toString() + "-";
            Screen.setText(input);
        }


        if (v.getId() == divide.getId()) {
            input = Screen.getText().toString() + "/";
            Screen.setText(input);
        }
        if (v.getId() == mul.getId()) {
            input = Screen.getText().toString() + "*";
            Screen.setText(input);
        }
        if (v.getId() == b1.getId()) {
            input = Screen.getText().toString() + "(";
            Screen.setText(input);
        }
        if (v.getId() == b2.getId()) {
            input = Screen.getText().toString() + ")";
            Screen.setText(input);
        }
        if (v.getId() == reciprocal.getId()) {
            input = "1/"+Screen.getText().toString() ;
            Screen.setText(input);
        }

    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;
            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }


}