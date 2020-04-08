package com.example.sqlite5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button insert ,delete, update, select;

    EditText name_button, id_button, gender_button, department_button, salary_button;

    String name,gender,department,salary;
    Integer id;
    private DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = findViewById(R.id.insert);
        delete = findViewById(R.id.delete);
        update = findViewById(R.id.update);
        select = findViewById(R.id.select);

        name_button = findViewById(R.id.name);
        id_button = findViewById(R.id.code);
        gender_button = findViewById(R.id.gender);
        department_button = findViewById(R.id.department);
        salary_button = findViewById(R.id.salary);

        mydb = new DBHelper(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();
                mydb.insertContact(id,name,gender,department,salary);
                Toast.makeText(getApplicationContext(), "inserted", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValues();
                mydb.updateContact(id,name,gender,department,salary);
                Toast.makeText(getApplicationContext(), "inserted", Toast.LENGTH_SHORT).show();
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = Integer.parseInt(id_button.getText().toString());
                Cursor rs = mydb.getData(id);
                rs.moveToFirst();
                String nam = rs.getString(0);
                String codeid = rs.getString(1);
                String gender = rs.getString(2);
                String dep = rs.getString(3);
                String sal = rs.getString(4);

                String details = "Contact details\n\nName : \t" + nam + "\nId : \t" + codeid + "\nGender : \t" + gender + "\nDepartment : \t" + dep + "\nSalary : \t" + sal;
                Toast.makeText(getApplicationContext(), details , Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,DisplayActivity.class);
                intent.putExtra("det",details);
                startActivity(intent);
            }
        });
    }

    public void getValues(){
        name = name_button.getText().toString();
        id = Integer.parseInt(id_button.getText().toString());
        gender = gender_button.getText().toString();
        department = department_button.getText().toString();
        salary = salary_button.getText().toString();
    }

}
