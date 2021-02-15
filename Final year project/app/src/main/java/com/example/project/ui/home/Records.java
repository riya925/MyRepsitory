package com.example.project.ui.home;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.project.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Records extends Activity
{

    // initializing the components
    ListView records_lv;
    Button records_add_btn,records_dialog_cancel_button,records_dialog_save_button,records_dialog_update_button,records_dialog_delete_button;
    TextView records_dialog_name;
    EditText records_dialog_et_name;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> records =null;
    HashMap<String,String> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        //list of notes
        records=new ArrayList<>();
        //complete

        //dialog code
        records_dialog_name=findViewById(R.id.records_dialog_name);
        records_dialog_et_name=findViewById(R.id.records_dialog_et_name);
        records_dialog_save_button=findViewById(R.id.records_dialog_save_button);
        records_dialog_cancel_button=findViewById(R.id.records_dialog_cancel_button);
        //complete


        records_lv=findViewById(R.id.records_lv);
        records_add_btn=findViewById(R.id.records_add_btn);

        records.add("DEMO");
        arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,records);
        arrayAdapter.setNotifyOnChange(true);
        records_lv.setAdapter(arrayAdapter);

        records_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //for finding the key
//                String strKey="";
//                for(Map.Entry<String,String> entry: map.entrySet()){
//                    if(records.get(position).equals(entry.getValue())){
//                        strKey = entry.getKey();
//                        break; //breaking because its one to one map
//                    }
//                }


//                openDialog(records.get(position),strKey,position);
            }
        });

        records_add_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openDialog();
            }
        });



    }

    //for listview onclick

//    private void openDialog(final String description, final String title, final int position) {
//        final Dialog dialog=new Dialog(getApplicationContext(),R.style.CustomDialogTheme);
//        LayoutInflater layoutInflater=this.getLayoutInflater();
//        View customDialog=layoutInflater.inflate(R.layout.records_custom_dialog_listview,null);
//
//        records_dialog_name=customDialog.findViewById(R.id.records_dialog_name);
//        records_dialog_et_name=customDialog.findViewById(R.id.records_dialog_et_name);
//        records_dialog_update_button = customDialog.findViewById(R.id.records_dialog_update_button);
//        records_dialog_delete_button=customDialog.findViewById(R.id.records_dialog_delete_button);
//
////        et_note_title.setText(title);
////        et_note_body.setText(description);
//
//        records_dialog_update_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                //also title of the dialog is not displayed in the output
////                arrayAdapter.remove(description);
////                String updatedTitle=et_note_title.getText().toString();
////                String body=et_note_body.getText().toString();
////
////                //not able to update data app closes
////                //not able to update /click on the static notes only for title
////                map.replace(updatedTitle,body);
////                Toast.makeText(getActivity(),""+updatedTitle+" - "+body,Toast.LENGTH_LONG).show();
////                arrayAdapter.insert(map.get(updatedTitle),position);
////
////                dialog.dismiss();
//            }
//        });
//
//        records_dialog_delete_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                arrayAdapter.remove(map.get(title));
//                dialog.dismiss();
//            }
//        });
//
//        //setting the layout for the dialog
//
//        dialog.setContentView(customDialog);
//
//        //set dialog title
//        dialog.setTitle("Modify the Note");
//
//        dialog.show();
//
//        //complete
//    }





    //add button dialog
    private void openDialog() {
        final Dialog dialog=new Dialog(this, R.style.CustomDialogTheme);
        LayoutInflater layoutInflater=this.getLayoutInflater();
        View customDialog=layoutInflater.inflate(R.layout.records_custom_dialog,null);

        records_dialog_name=customDialog.findViewById(R.id.records_dialog_name);
        records_dialog_et_name=customDialog.findViewById(R.id.records_dialog_et_name);
        records_dialog_save_button = customDialog.findViewById(R.id.records_dialog_save_button);
        records_dialog_cancel_button=customDialog.findViewById(R.id.records_dialog_cancel_button);

        records_dialog_save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        records_dialog_cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        //setting the layout for the dialog

        dialog.setContentView(customDialog);

        //set dialog title
        dialog.setTitle("ADD RECORD ");

        dialog.show();

        //complete

    }
}