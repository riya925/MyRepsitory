package com.example.project.ui.notes;

import android.app.Dialog;
import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.project.MainActivity;
import com.example.project.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotesFragment extends Fragment
{
    // initializing the components
    static ListView note_lv;
    Button note_add_btn;
    static ArrayAdapter <String> arrayAdapter;
    private NotesViewModel notesViewModel;
    public static ArrayList<String> notes =null;
    HashMap<String,String> map;

    EditText et_note_title,et_note_body;
    Button note_dialog_save_button,note_dialog_cancel_button,note_dialog_delete_button;
    //complete

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        //list of notes
        notes=new ArrayList<>();
        //complete
        notesViewModel =
                ViewModelProviders.of(this).get(NotesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notes, container, false);
//        final TextView textView = root.findViewById(R.id.text_notes);

        //code block
        note_lv=(ListView)root.findViewById(R.id.note_lv);
        note_add_btn=(Button)root.findViewById(R.id.note_add_btn);

        note_lv.setLongClickable(true);

        note_lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"delete",Toast.LENGTH_LONG).show();
                return true;
            }
        });

        //dialog code
        et_note_title=root.findViewById(R.id.et_note_title);
        et_note_body=root.findViewById(R.id.et_note_body);
        note_dialog_save_button=root.findViewById(R.id.note_dialog_save_button);
        note_dialog_cancel_button=root.findViewById(R.id.note_dialog_cancel_button);
        //complete

//        notes.add("DEMO");
        arrayAdapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,notes);
        arrayAdapter.setNotifyOnChange(true);
        note_lv.setAdapter(arrayAdapter);

        note_lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
//                Intent intent=new Intent(getActivity(),NoteEditor.class);
//                intent.putExtra("noteId",""+i);
//                startActivity(intent);

                //for finding the key
                String strKey="";
                for(Map.Entry<String,String> entry: map.entrySet()){
                    if(notes.get(i).equals(entry.getValue())){
                        strKey = entry.getKey();
                        break; //breaking because its one to one map
                    }
                }
                openDialog(notes.get(i),strKey,i);
            }
        });

        note_add_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                openDialog();
            }
        });

        return root;
    }

    private void openDialog() {
        final Dialog dialog=new Dialog(getActivity(),R.style.CustomDialogTheme);
        LayoutInflater layoutInflater=this.getLayoutInflater();
        View customDialog=layoutInflater.inflate(R.layout.note_custom_dialog,null);

        et_note_title=customDialog.findViewById(R.id.et_note_title);
        et_note_body=customDialog.findViewById(R.id.et_note_body);

        note_dialog_save_button=customDialog.findViewById(R.id.note_dialog_save_button);
        note_dialog_cancel_button=customDialog.findViewById(R.id.note_dialog_cancel_button);

        note_dialog_save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //also title of the dialog is not displayed in the output

                String title=et_note_title.getText().toString();
                String body=et_note_body.getText().toString();

                map=new HashMap<>();
                map.put(title,body);

                Toast.makeText(getActivity(),"Note Saved",Toast.LENGTH_LONG).show();
                arrayAdapter.add(map.get(title));

                dialog.dismiss();
            }
        });

        note_dialog_cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });

        //setting the layout for the dialog
        dialog.setContentView(customDialog);

        //set dialog title
//        dialog.setTitle("Modify the Note");

        dialog.show();
        //complete
    }

    private void openDialog(final String description, final String title, final int position) {
        final Dialog dialog=new Dialog(getActivity(),R.style.CustomDialogTheme);
        LayoutInflater layoutInflater=this.getLayoutInflater();
        View customDialog=layoutInflater.inflate(R.layout.note_custom_dialog_listview,null);

        et_note_title=customDialog.findViewById(R.id.et_note_title);
        et_note_body=customDialog.findViewById(R.id.et_note_body);

        et_note_title.setText(title);
        et_note_body.setText(description);

        note_dialog_save_button=customDialog.findViewById(R.id.note_dialog_save_button);
        note_dialog_delete_button=customDialog.findViewById(R.id.note_dialog_delete_button);


        note_dialog_save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //also title of the dialog is not displayed in the output
                arrayAdapter.remove(description);
                String updatedTitle=et_note_title.getText().toString();
                String body=et_note_body.getText().toString();

                //not able to update data app closes
                //not able to update /click on the static notes only for title
                map.replace(updatedTitle,body);
                Toast.makeText(getActivity(),"Note Updated Successfully....",Toast.LENGTH_LONG).show();
                arrayAdapter.insert(map.get(updatedTitle),position);

                dialog.dismiss();
            }
        });

        note_dialog_delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayAdapter.remove(map.get(title));
                dialog.dismiss();
            }
        });

        //setting the layout for the dialog
        dialog.setContentView(customDialog);

//        set dialog title
//        dialog.setTitle("Modify the Note");

        dialog.show();
        //complete
    }
}