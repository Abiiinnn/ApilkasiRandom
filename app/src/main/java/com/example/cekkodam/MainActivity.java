package com.example.cekkodam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;  // Request code untuk DaftartugasActivity
    private TextView textViewTugas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTugas = findViewById(R.id.textViewTugas);

        Button buttonkhodam = findViewById(R.id.button2);
        Button buttonmotivasi = findViewById(R.id.button3);
        Button buttondaftartugas = findViewById(R.id.button6);

        buttonkhodam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentkhodam = new Intent(MainActivity.this, KhodamActivity.class);
                startActivity(intentkhodam);
            }
        });

        buttonmotivasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentmotivasi = new Intent(MainActivity.this, MotivasiActivity.class);
                startActivity(intentmotivasi);
            }
        });

        buttondaftartugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDaftarTugas = new Intent(MainActivity.this, DaftartugasActivity.class);
                startActivityForResult(intentDaftarTugas, REQUEST_CODE);
            }
        });
    }

    // Menangani hasil yang dikirimkan oleh DaftartugasActivity

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            // Mengambil daftar tugas yang dikirimkan
            ArrayList<String> taskList = data.getStringArrayListExtra("taskList");
            if (taskList != null) {
                // Menampilkan daftar tugas di TextView
                StringBuilder tugasText = new StringBuilder("Daftar Tugas:\n");
                for (String tugas : taskList) {
                    tugasText.append("- ").append(tugas).append("\n");
                }
                textViewTugas.setText(tugasText.toString());  // Menampilkan tugas di TextView
                Toast.makeText(this, "Daftar tugas diperbarui", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
