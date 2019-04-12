package com.tareas.tarea_01;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.tareas.tarea_01.beans.Student;

public class ActivityMain extends AppCompatActivity implements DialogErase.DialogEraseListener {

    EditText name, phone, book;
    Spinner spinner;
    Button erase;
    CheckBox checkBox;
    RadioButton female, male;

    Student student;
    Student.Genre genre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.activity_main_name);
        phone = findViewById(R.id.activity_main_phone);
        book = findViewById(R.id.activity_main_book);
        spinner = findViewById(R.id.activity_main_spinner_scholarship);
        erase = findViewById(R.id.activity_main_erase);
        spinner = findViewById(R.id.activity_main_spinner_scholarship);
        checkBox = findViewById(R.id.activity_main_sports);
        female = findViewById(R.id.activity_main_female);
        male = findViewById(R.id.activity_main_male);


//      Working with the spinner so it has items

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.scholarship_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


//      Working with the eraser button
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               confirmErase();
            }
        });

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheckboxClicked(v);
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRadioButtonClicked(v);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_save) {
            saveData();

        }

        return super.onOptionsItemSelected(item);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.activity_main_female:
                if (checked)
                    genre = Student.Genre.FEMALE;
                break;
            case R.id.activity_main_male:
                if (checked)
                    genre = Student.Genre.MALE;
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.activity_main_sports:
                if (checked)
                    checkBox.setSelected(true);
                else
                    checkBox.setSelected(false);
                break;
        }
    }

    void saveData() {
        if (dataFilled()) {
            student = new Student();
            student.setName(name.getText().toString());
            student.setPhone(Integer.parseInt(phone.getText().toString()));
            student.setBook(book.getText().toString());
            student.setGenre(genre);
            student.setScholarship(spinner.getSelectedItemPosition());
            student.setSports(checkBox.isSelected());
//
            eraseData();
            Toast.makeText(this, student.toString(), Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(this, R.string.toast_unfilled, Toast.LENGTH_LONG).show();

    }


    public void confirmErase() {

        DialogFragment newFragment = new DialogErase();
        newFragment.show(getSupportFragmentManager(), "Limpiar");


    }

    void eraseData(){
        name.setText("");
        phone.setText("");
        book.setText("");
        spinner.setSelection(0);
        checkBox.setChecked(false);
        female.setChecked(false);
        male.setChecked(false);
        genre = null;

    }

    boolean dataFilled(){
        if( name.getText().toString().trim()!="" &&
            phone.getText().toString().trim()!="" &&
            book.getText().toString().trim()!="" &&
            (female.isChecked() || male.isChecked())
        )
            return true;
        else
            return false;
    }


    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        eraseData();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        return;
    }
}
