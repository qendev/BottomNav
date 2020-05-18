package com.example.bottomnav.ui.users;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bottomnav.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class UsersFragment extends Fragment {

    private UsersViewModel usersViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        usersViewModel = ViewModelProviders.of(this).get(UsersViewModel.class);
         View view = inflater.inflate(R.layout.fragement_users,container,false);

       final TextView users = view.findViewById(R.id.text_users);

        usersViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                users.setText(s);
            }
        });

        return view;
    }
}
