package com.example.assignment2;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
public class MainActivity extends AppCompatActivity {
    Button btnSettings, btnProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSettings = findViewById(R.id.btnSettings);
        btnProfile = findViewById(R.id.btnProfile);

        loadFragment(new SettingsFragment());

        btnSettings.setOnClickListener(v ->
                loadFragment(new SettingsFragment()));

        btnProfile.setOnClickListener(v ->
                loadFragment(new ProfileFragment()));
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment) // ✅ Ensure fragmentContainer exists in activity_main.xml
                .commit();
    }

}
