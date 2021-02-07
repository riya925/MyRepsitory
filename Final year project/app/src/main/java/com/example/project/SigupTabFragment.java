package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class SigupTabFragment extends Fragment
{
    EditText email,pass,phonno,cp;
    Button btn_submit;
    Float v= Float.valueOf(0);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ViewGroup root=(ViewGroup) inflater.inflate(R.layout.sigup_tab_fragment,container,false);

        email = root.findViewById(R.id.email);
        pass = root.findViewById(R.id.pass);
        phonno=root.findViewById(R.id.phoneno);

        btn_submit=root.findViewById(R.id.btn_submit);

        email.setTranslationY(300);
        pass.setTranslationY(300);
        phonno.setTranslationY(300);
        btn_submit.setTranslationY(300);

        email.setAlpha(v); //used for opacity
        pass.setAlpha(v);
        phonno.setAlpha(v);
        btn_submit.setAlpha(v);

        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        pass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        phonno.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        btn_submit.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),BottomNavigation.class);
                startActivity(i);
            }
        });

        return root;
    }
}
