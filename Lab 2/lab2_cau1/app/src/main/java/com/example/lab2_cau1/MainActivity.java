package com.example.lab2_cau1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv_name;
    ArrayAdapter<String> adapter;
    ArrayList<String> arr_name;
//    Button btn_add;
    TextView txt_person;
//    EditText edittext_name;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arr_name = new ArrayList<>();
        arr_name.add("Tèo");
        arr_name.add("Tý");
        arr_name.add("Bin");
        arr_name.add("Bo");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr_name);

        lv_name = (ListView) findViewById(R.id.lv_name);
        lv_name.setAdapter(adapter);

        txt_person = (TextView) findViewById(R.id.txt_person);
//        edittext_name = (EditText) findViewById(R.id.edittext_name);
//        btn_add = (Button) findViewById(R.id.btn_add);
//        btn_add.setOnClickListener((new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String new_name = edittext_name.getText().toString();
//                arr_name.add(new_name);
//                adapter.notifyDataSetChanged();
//                edittext_name.setText("");
//            }
//        }));
//
        lv_name.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = lv_name.getItemAtPosition(i).toString();
                txt_person.setText("position :" + i + " ; value =" + value);
            }
        }));
//
//        lv_name.setOnItemLongClickListener((new AdapterView.OnItemLongClickListener(){
//            @Override
//            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
//                                           int pos, long id) {
//                arr_name.remove(pos);
//                adapter.notifyDataSetChanged();
//                return false;
//            }
//        }));
    }
}