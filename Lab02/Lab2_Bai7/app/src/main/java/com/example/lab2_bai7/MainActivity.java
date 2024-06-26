package com.example.lab2_bai7;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btnAdd;
    private EditText etId;
    private EditText etName;
    private CheckBox checkBox;
    private ArrayList<Employee> employees;
    private EmployeeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_Result);
        btnAdd = findViewById(R.id.bt_add);
        etId =  findViewById(R.id.eT_id);
        etName =  findViewById(R.id.eT_name);
        checkBox =  findViewById(R.id.chbxManager);
        employees = new ArrayList<>();
        adapter = new EmployeeAdapter(this,employees);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            public void onClick(View arg0) {
                Employee employee = new Employee();
                employee.setId(etId.getText().toString());
                employee.setFullName(etName.getText().toString());
                employee.setManager(checkBox.isChecked());
                employees.add(employee);
                adapter.notifyDataSetChanged();
                etId.setText(null);
                etName.setText(null);
                etName.clearFocus();
                checkBox.setChecked(false);
            }
        });
    }
}