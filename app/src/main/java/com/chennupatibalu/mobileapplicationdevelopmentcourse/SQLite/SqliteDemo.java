package com.chennupatibalu.mobileapplicationdevelopmentcourse.SQLite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chennupatibalu.mobileapplicationdevelopmentcourse.DatabaseHelper;
import com.chennupatibalu.mobileapplicationdevelopmentcourse.R;

public class SqliteDemo extends AppCompatActivity {

    private EditText nameEditText,surnameEditText,cgpaEditText,dobEditText,modifyDataEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_demo);

        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        cgpaEditText = findViewById(R.id.cgpaEditText);
        dobEditText = findViewById(R.id.dobEditText);

        modifyDataEditText = findViewById(R.id.modifyEditText);

    }

    public void insert(View view) {
        modifyDataEditText.setVisibility(View.INVISIBLE);
        if(new DatabaseHelper(this).insertData
                (nameEditText.getText().toString(),
                surnameEditText.getText().toString(),
                Float.parseFloat(cgpaEditText.getText().toString()),
                Integer.parseInt(dobEditText.getText().toString())))
        {
            Toast.makeText(this, "Data inserted Successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Data not inserted", Toast.LENGTH_SHORT).show();
        }
    }

    public void update(View view) {
        modifyDataEditText.setVisibility(View.VISIBLE);
        if(modifyDataEditText.getVisibility()==View.VISIBLE && !modifyDataEditText.getText().toString().equals("") &&
           new DatabaseHelper(this).updateData
                   (modifyDataEditText.getText().toString(),nameEditText.getText().toString(),
                           surnameEditText.getText().toString(),
                           Float.parseFloat(cgpaEditText.getText().toString()),
                           Integer.parseInt(dobEditText.getText().toString())))
        {
            Toast.makeText(this, "Data updated Successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Data is not updated", Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(View view) {
        modifyDataEditText.setVisibility(View.VISIBLE);
        if(modifyDataEditText.getVisibility()==View.VISIBLE && !modifyDataEditText.getText().toString().equals("") && new DatabaseHelper(this).deleteData(modifyDataEditText.getText().toString())==1)
        {
            Toast.makeText(this, "Data deleted Successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Data is not deleted", Toast.LENGTH_SHORT).show();
        }
    }

    public void display(View view) {
        modifyDataEditText.setVisibility(View.INVISIBLE);
        Cursor res = new DatabaseHelper(this).getData();

        StringBuilder buffer = new StringBuilder();
        while(res.moveToNext())
        {
            buffer.append("ID: "+res.getString(0)+"\n");
            buffer.append("NAME: "+res.getString(1)+"\n");
            buffer.append("SURNAME: "+res.getString(2)+"\n");
            buffer.append("CGPA: "+res.getString(3)+"\n");
            buffer.append("DOB: "+res.getString(4)+"\n");
        }
        showMessage("Data",buffer.toString());
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setCancelable(true);
        adb.setTitle(title);
        adb.setMessage(message);
        adb.show();
    }
}