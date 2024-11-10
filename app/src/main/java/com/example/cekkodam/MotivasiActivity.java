package com.example.cekkodam;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MotivasiActivity extends AppCompatActivity {

    // Deklarasi komponen UI
    private Button buttonBack;
    private Button buttonShare;
    private TextView textViewMotivasi;

    // Array berisi 20 kata-kata motivasi
    private String[] motivasiList = {
            "Tetap semangat! Setiap hari adalah kesempatan baru untuk sukses.",
            "Jangan pernah menyerah, karena kegagalan adalah bagian dari perjalanan menuju sukses.",
            "Kamu lebih kuat dari yang kamu kira. Percaya pada dirimu sendiri.",
            "Keberhasilan bukanlah kunci kebahagiaan, kebahagiaan adalah kunci keberhasilan.",
            "Jangan takut untuk memulai sesuatu yang baru. Setiap langkah kecil adalah kemajuan.",
            "Hidup ini penuh dengan tantangan. Teruslah berusaha dan jangan menyerah.",
            "Setiap kegagalan adalah kesempatan untuk memulai lagi dengan lebih bijak.",
            "Kamu tidak pernah tahu seberapa kuat dirimu sampai menjadi kuat adalah satu-satunya pilihan.",
            "Impianmu tidak akan bekerja, kecuali kamu juga bekerja untuk mewujudkannya.",
            "Belajarlah dari masa lalu, nikmati hari ini, dan persiapkan masa depan yang lebih baik.",
            "Jangan menunggu kesempurnaan, karena kesempurnaan datang dengan usaha dan waktu.",
            "Keberhasilan adalah hasil dari persiapan, kerja keras, dan belajar dari kegagalan.",
            "Jangan biarkan kegagalan menghentikanmu. Setiap langkah membawa kita lebih dekat ke tujuan.",
            "Percayalah bahwa setiap usaha yang kamu lakukan akan membuahkan hasil yang setimpal.",
            "Hidup ini singkat, jangan sia-siakan waktu untuk meragukan diri sendiri.",
            "Tindakanmu hari ini akan menentukan masa depanmu. Jangan ragu untuk bergerak maju.",
            "Jangan hanya berpikir besar, tapi bertindaklah dengan cara yang besar.",
            "Jika kamu tidak berusaha untuk berubah, kamu akan tetap berada di tempat yang sama.",
            "Setiap hari adalah kesempatan baru untuk belajar, tumbuh, dan menjadi lebih baik.",
            "Kamu bisa melakukannya! Jangan pernah meragukan kekuatanmu."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motivasi);


        buttonBack = findViewById(R.id.buttonback);
        buttonShare = findViewById(R.id.button4);
        textViewMotivasi = findViewById(R.id.textView4);


        Random random = new Random();
        int randomIndex = random.nextInt(motivasiList.length);
        textViewMotivasi.setText(motivasiList[randomIndex]);


        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MotivasiActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk membagikan teks motivasi
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, textViewMotivasi.getText().toString());
                startActivity(Intent.createChooser(shareIntent, "Bagikan Motivasi"));
            }
        });
    }
}
