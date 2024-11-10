package com.example.cekkodam; // Ganti dengan nama paket Anda

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class KhodamActivity extends AppCompatActivity {

    private EditText editTextName;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khodam); // Ganti dengan nama layout Anda jika berbeda

        editTextName = findViewById(R.id.editTextText);
        textViewResult = findViewById(R.id.textView2);
        Button buttonCheck = findViewById(R.id.button);
        Button buttonBack = findViewById(R.id.buttonback);
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkKhodam();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(KhodamActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }

    private void checkKhodam() {
        String name = editTextName.getText().toString().trim();
        if (!name.isEmpty()) {
            // Logika untuk menentukan hasil khodam berdasarkan nama
            String result = getKhodamResult(name);
            textViewResult.setText(result);
        } else {
            textViewResult.setText("Silakan masukkan nama Anda.");
        }
    }

    private String getKhodamResult(String name) {
        // Daftar khodam yang lucu
        String[] khodams = {
                "Harimau",
                "Naga",
                "Kucing",
                "Kelelawar",
                "Elang",
                "Gurita",
                "Beruang",
                "Serigala",
                "Kuda",
                "Panda",
                "Kera",
                "Rusa",
                "Kambing",
                "Gajah",
                "Buaya",
                "Hiu",
                "Penyu",
                "Cheetah",
                "Puma",
                "Kucing Hutan",
                "Kijang",
                "Anjing Laut",
                "Orang Utan",
                "Lumba-lumba",
                "Singa",
                "Jelajah",
                "Kumbang",
                "Kupu-kupu",
                "Ikan Salmon",
                "Cicak",
                "Ular"
        };
        // Membuat objek Random
        Random random = new Random();
        // Mengambil khodam secara acak dari daftar
        String randomKhodam = khodams[random.nextInt(khodams.length)];

        // Mengembalikan hasil khodam acak
        return "Khodam Anda adalah " + randomKhodam ;
    }

}
