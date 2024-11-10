package com.example.cekkodam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DaftartugasActivity extends AppCompatActivity {

    private EditText inputTaskEditText;
    private ArrayList<String> taskList;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftartugas);


        ListView taskListView = findViewById(R.id.taskListView);
        Button addTaskButton = findViewById(R.id.button10);
        inputTaskEditText = findViewById(R.id.inputTaskEditText);

        // Inisialisasi daftar tugas
        taskList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        taskListView.setAdapter(adapter);

        // Menambahkan tugas baru saat tombol ditekan
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = inputTaskEditText.getText().toString().trim();
                if (!task.isEmpty()) {
                    // Menambah tugas ke dalam daftar
                    taskList.add(task);
                    adapter.notifyDataSetChanged(); // Update ListView
                    inputTaskEditText.setText(""); // Kosongkan EditText setelah tugas ditambahkan
                    Toast.makeText(DaftartugasActivity.this, "Tugas ditambahkan!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DaftartugasActivity.this, "Masukkan tugas terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Menghapus tugas ketika item di ListView diklik
        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Menghapus tugas yang dipilih
                taskList.remove(position);
                adapter.notifyDataSetChanged(); // Update ListView
                Toast.makeText(DaftartugasActivity.this, "Tugas dihapus!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent();
        intent.putStringArrayListExtra("taskList", taskList);
        setResult(RESULT_OK, intent);
        finish();
    }

}
