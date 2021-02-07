package com.example.project.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

//import androidx.appcompat.widget.Toolbar;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.project.R;

//import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class ProfileFragment extends Fragment {

    private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_profile, container, false);
//        final TextView textView = root.findViewById(R.id.text_profile);

        Toolbar toolbar=root.findViewById(R.id.toolbar);
//        getActivity().setSupportActionBar(toolbar);
        getActivity().setActionBar(toolbar);

        toolbar.inflateMenu(R.menu.frag_menu_items);
        Menu menu = toolbar.getMenu();

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.toolbar_items) {
                    Toast.makeText(getActivity(),"Menu Done"+item.getTitle().toString(),Toast.LENGTH_LONG).show();
//                            T.showToastBro(getActivity(), item.getTitle().toString());
                }
                return true;
            }
        });

        profileViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);

                AppCompatActivity activity = (AppCompatActivity) getActivity();

                //code block

// or use this instead of set support Action Bar
//                ((AppCompatActivity) getActivity()).getDelegate().setSupportActionBar(toolbar);

//                for using import android.widget.Toolbar; dependencies
//                getActivity().setActionBar(toolbar);

                //complete
            }
        });
        return root;
    }
}