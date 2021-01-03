package com.athis.my.mobapphelloworld;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button activiBox = (Button) findViewById(R.id.btn_act2);
        activiBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                secondAct(v);
            }
        });

        Button dialogBox = (Button) findViewById(R.id.btn_dia);
        final String[] studentsArray = getResources().getStringArray(R.array.students);
        dialogBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("3. Group's Dialog")
                    .setMultiChoiceItems(R.array.students, null, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            if (isChecked) {
                                Toast.makeText(MainActivity.this, studentsArray[which] + " checked", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(MainActivity.this, studentsArray[which] + " unchecked", Toast.LENGTH_LONG).show();
                            }
                        }
                    })
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id){
                            Toast.makeText(MainActivity.this, "You clicked OK", Toast.LENGTH_LONG).show();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id){
                            Toast.makeText(MainActivity.this, "You closed dialog", Toast.LENGTH_LONG).show();
                        }
                    });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    public void secondAct(View v) {
        startActivity(new Intent(this, MainActivity2.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
    }

}
