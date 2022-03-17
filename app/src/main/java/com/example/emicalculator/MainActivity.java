package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String am,in,y,m;

    double a = 0,
            b = 0,
            c = 0,
            d = 0,
            total_month = 0,
            total_interest = 0,
            emi = 0,final_month = 0,
            final_emi = 0,pay = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clc_btn=findViewById(R.id.clc_btn);
        Button reset_btn=findViewById(R.id.reset_btn);
        Button details_btn=findViewById(R.id.details_btn);
        EditText amt_edt=findViewById(R.id.amt_edt);
        EditText int_edt=findViewById(R.id.int_edt);
        EditText year_edt=findViewById(R.id.year_edt);
        EditText mnt_edt=findViewById(R.id.mnt_edt);
        TextView emi_txt=findViewById(R.id.emi_txt);
        TextView emi_tbl=findViewById(R.id.emi_tbl);
        TextView total_txt=findViewById(R.id.total_txt);
        TextView pay_txt=findViewById(R.id.pay_txt);
        TableLayout table_tbl=findViewById(R.id.table_tbl);

        clc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                am = amt_edt.getText().toString();
                in = int_edt.getText().toString();
                y = year_edt.getText().toString();
                m = mnt_edt.getText().toString();

                a=Double.parseDouble(am);
                b=Double.parseDouble(in);
                c=Double.parseDouble(y);
                d=Double.parseDouble(m);

                if(d==0){

                    total_month =c*12;

                    total_interest = (a * (b/100));
                    emi = total_interest/total_month;
                    pay = a+total_interest;


                    final_month = a/total_month;
                    final_emi = emi+final_month;
                    emi_txt.setText(""+final_emi);

                }

                else {

                    total_month = c*12;

                    total_interest = (a * b)/100;
                    emi = total_interest/total_month;
                    pay = a+total_interest;

                    final_month = a/total_month;
                    final_emi = emi+final_month;
                    emi_txt.setText(""+final_emi);
                }
//                emi_txt.setText(final_emi+"");
            }
        });

        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                amt_edt.setText("");
                int_edt.setText("");
                year_edt.setText("");
                mnt_edt.setText("");
                emi_txt.setText("");
                emi_tbl.setText("0");
                total_txt.setText("0");
                pay_txt.setText("0");
                table_tbl.setVisibility(View.INVISIBLE);
            }
        });

        details_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table_tbl.setVisibility(View.VISIBLE);
                emi_tbl.setText(final_emi+"");
                total_txt.setText(total_interest+"");
                pay_txt.setText(pay+"");

            }
        });

    }


}
