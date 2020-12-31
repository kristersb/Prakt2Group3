package com.example.prakt2kb;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;








public class Second extends AppCompatActivity {


private Button button1;
    private Button button3;



@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_second);

button1 = (Button) findViewById(R.id.button2);
button1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
popup();


}
});


    button3 = (Button) findViewById(R.id.button3);
    button3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            goBack();



        }
    });

}

    public void goBack(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

private void popup(){


    AlertDialog.Builder groupMembers = new AlertDialog.Builder(Second.this);
    groupMembers.setTitle("3 Group’s Dialog");
    String[] group3 = {"Kristers Bērziņš", "Mikus Lērme", "Uldis Mārtiņš Kuzma"};
    boolean[] checkedItems = {false, false, false};
    groupMembers.setMultiChoiceItems(group3, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int i, boolean isChecked) {

           if(isChecked){
               Toast.makeText(getApplicationContext(),  group3[i] + " checked", Toast.LENGTH_SHORT).show();
           }else {
               Toast.makeText(getApplicationContext(),  group3[i] + " unchecked", Toast.LENGTH_SHORT).show();
           }
        }
    });
    groupMembers.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int i) {
            Toast.makeText(getApplicationContext(),"You clicked OK",
                    Toast.LENGTH_SHORT).show();
        }
    });
    groupMembers.setNegativeButton("Close", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int i) {
            Toast.makeText(getApplicationContext(),"You closed dialog",
                    Toast.LENGTH_SHORT).show();
        }
    });

    AlertDialog dialog = groupMembers.create();
    dialog.show();

}




}