package com.example.lab2_cau3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Employee> List_Employee;
    ArrayAdapter<Employee> adapter;

    EditText edittext_employee_id;
    EditText edittext_employee_name;
    RadioGroup radiogr_employee_type;
    Button button_add_employee;
    ListView lv_employee;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_add_employee = (Button) findViewById(R.id.button_add_employee);
        edittext_employee_id = (EditText) findViewById(R.id.edittext_employee_id);
        edittext_employee_name = (EditText) findViewById(R.id.edittext_employee_name);
        radiogr_employee_type = (RadioGroup) findViewById(R.id.radiogr_employee_type);
        lv_employee = (ListView) findViewById(R.id.lv_employee);

        List_Employee = new ArrayList<>();
        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1,List_Employee);
        lv_employee.setAdapter(adapter);

        button_add_employee.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String employee_id = edittext_employee_id.getText().toString();
                String employee_name = edittext_employee_name.getText().toString();
                int SelectedID = radiogr_employee_type.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = findViewById(SelectedID);
                String employee_type = selectedRadioButton.getText().toString();

                Employee new_employee;
                if (employee_type.equals("Chính thức")){
                    new_employee = new EmployeeFulltime(employee_id, employee_name, 1);
//                    List_Employee.add(new_employee);
//                    adapter.notifyDataSetChanged();
                } else{
                    new_employee = new EmployeeParttime(employee_id, employee_name, 0);
//                    List_Employee.add(new_employee);
//                    adapter.notifyDataSetChanged();
                }
//                new_employee.SetID(employee_id);
//                new_employee.SetName(employee_name);
                List_Employee.add(new_employee);
                adapter.notifyDataSetChanged();
            }
        }));

        }

//    EditText etId;
//    EditText etName;
//    RadioButton rd_chinhthuc, rdBtnKhong;
//    RadioGroup rgType;
//    Button btnNhap;
//    ListView lvNV;
//    ArrayList<Employee> employees;
//    ArrayAdapter<Employee> adapter;
//    Employee employee;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        etId = (EditText) findViewById(R.id.edittext_employee_id);
//        etName = (EditText) findViewById(R.id.edittext_employee_name);
//        rgType = (RadioGroup) findViewById(R.id.radiogr_employee_type);
//        btnNhap = (Button) findViewById(R.id.button_add_employee);
//        lvNV = (ListView) findViewById(R.id.lv_employee);
//        employees = new ArrayList<Employee>();
//        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1,employees);
//        lvNV.setAdapter(adapter);
//        btnNhap.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int radId = rgType.getCheckedRadioButtonId();
//                String id = etId.getText().toString();
//                String name = etName.getText().toString();
//                if (radId == R.id.radio_fulltime) {
//                    //tạo instance là FullTime
//                    employee = new EmployeeFulltime();
//                } else {
//                    //Tạo instance là Partime
//                    employee = new EmployeeParttime();
//                }
//                //FullTime hay Partime thì cũng là Employee nên có các hàm này là hiển nhiên
//                employee.SetID(id);
//                employee.SetName(name);
//                //Đưa employee vào ArrayList
//                employees.add(employee);
//                //Cập nhập giao diện
//                adapter.notifyDataSetChanged();
//            }
//        });
//    }
}