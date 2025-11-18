package com.example.assignment2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    TextView tvUsername, tvEmail, tvTheme;
    SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        tvUsername = view.findViewById(R.id.tvUsername);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvTheme = view.findViewById(R.id.tvTheme);

        if (getActivity() != null) {
            sharedPreferences = getActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
            loadPreferences();
        }

        return view;
    }

    private void loadPreferences() {
        String username = sharedPreferences.getString("username", "No username saved");
        String email = sharedPreferences.getString("email", "No email saved");
        String theme = sharedPreferences.getString("theme", "No theme saved");
        tvUsername.setText(getString(R.string.username_display, username));
        tvEmail.setText(getString(R.string.email_display, email));
        tvTheme.setText(getString(R.string.theme_display, theme));

    }
}
