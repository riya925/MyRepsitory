package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;

public class LoginTabFragment extends Fragment
{
    EditText email,pass;
    TextView fp;
    Button btn_login;
    Float v= Float.valueOf(0);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ViewGroup root=(ViewGroup) inflater.inflate(R.layout.login_tab_fragement,container,false);

        email = root.findViewById(R.id.email);
        pass = root.findViewById(R.id.pass);
        fp=root.findViewById(R.id.fp);

        btn_login=root.findViewById(R.id.btn_login);

        email.setTranslationY(300);
        pass.setTranslationY(300);
        fp.setTranslationY(300);
        btn_login.setTranslationY(300);

        email.setAlpha(v); //used for opacity
        pass.setAlpha(v);
        fp.setAlpha(v);
        btn_login.setAlpha(v);

        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        pass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        fp.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        btn_login.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getContext(),BottomNavigation.class);
                startActivity(i);
            }
        });

        return root;
    }
}
