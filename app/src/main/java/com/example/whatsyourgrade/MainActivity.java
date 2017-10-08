package com.example.whatsyourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nNameEditText,nScoreEditText;
    private Button nFindButton,nExitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nNameEditText = (EditText)findViewById(R.id.Name_Text);
        nScoreEditText = (EditText)findViewById(R.id.Score_Text);
        nFindButton = (Button)findViewById(R.id.Find);
        nExitButton = (Button)findViewById(R.id.Exit);

        nFindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nametext = nNameEditText.getText().toString();
                Integer scoreText = Integer.valueOf(nScoreEditText.getText().toString());
                String ResultScoreText = getGrade(scoreText);
                if (nametext.equals(null)) {
                    nNameEditText.setError("ป้อนชื่อ");
                } else if (scoreText == null) {
                    nScoreEditText.setError("ป้อนคะแนน");
                }
                Intent intent = new Intent(MainActivity.this, FindYourGradeActivity.class);
                intent.putExtra("Name_text", nametext);
                intent.putExtra("Score", ResultScoreText);
                startActivity(intent);
            }

        });
        nExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this); //สร้าง dialog
                dialog.setTitle("ืConfirm Exit");
                dialog.setMessage("แน่ใจว่าต้องการออกจากแอพ");
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });
                dialog.show();
            }
        });

    }
    private String getGrade(int scoreText) {
        String  ResultScoreText = "";
        if (scoreText < 50) {
            ResultScoreText = "F";
        } else if (scoreText < 60) {
            ResultScoreText = "D";
        } else if (scoreText < 70) {
            ResultScoreText = "C";
        }else if (scoreText < 80) {
            ResultScoreText = "B";
        } else {
            ResultScoreText = "A)";
        }
        return  ResultScoreText;
    }
}
