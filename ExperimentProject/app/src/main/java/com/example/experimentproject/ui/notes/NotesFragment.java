package com.example.project.ui.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.experimentproject.ui.notes.NoteEditor;
import com.example.experimentproject.ui.notes.NotesViewModel;
import com.example.experimentproject.R;

import java.util.ArrayList;

public class NotesFragment extends Fragment
{

    // initializing the components
    ListView listView;
    Button note_btn;
    ArrayAdapter <String> arrayAdapter;
    private NotesViewModel notesViewModel;
    //complete

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        //list of notes
        ArrayList<String> notes=new ArrayList<>();
        //complete
        notesViewModel =
                ViewModelProviders.of(this).get(NotesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notes, container, false);
//        final TextView textView = root.findViewById(R.id.text_notes);

        //code block
        listView=(ListView)root.findViewById(R.id.listView);
        note_btn=(Button)root.findViewById(R.id.note_btn);

        notes.add("Sample Note");

        arrayAdapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,notes);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent=new Intent(getActivity(), NoteEditor.class);
                intent.putExtra("noteId",i);
                startActivity(intent);
            }
        });

        //complete
        return root;
    }
}