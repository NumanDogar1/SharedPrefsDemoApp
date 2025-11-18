package com.example.assignment2; // ✅ Updated to match your actual file path

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    EditText etUsername, etEmail, etTheme;
    Button btnSave;

    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        etUsername = view.findViewById(R.id.etUsername);
        etEmail = view.findViewById(R.id.etEmail);
        etTheme = view.findViewById(R.id.etTheme);
        btnSave = view.findViewById(R.id.btnSave);

        if (getActivity() != null) { // ✅ Prevent NullPointerException
            sharedPreferences = getActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        }

        btnSave.setOnClickListener(v -> savePreferences());

        return view;
    }

    private void savePreferences() {

        String username = etUsername.getText().toString();
        String email = etEmail.getText().toString();
        String theme = etTheme.getText().toString();

        if (username.isEmpty() || email.isEmpty()) {
            Toast.makeText(getActivity(), "Please fill all fields.", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("email", email);
        editor.putString("theme", theme);
        editor.apply();

        Toast.makeText(getActivity(), "Preferences saved.", Toast.LENGTH_SHORT).show();
    }
}
