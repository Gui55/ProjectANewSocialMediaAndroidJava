package com.example.anewsocialmedia.ui.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.anewsocialmedia.R;
import com.example.anewsocialmedia.viewmodel.SecondActivityViewModel;

public class SecondActivity extends AppCompatActivity {

    SecondActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbar = findViewById(R.id.toolbarA);
        toolbar.setTitle("Início");
        setSupportActionBar(toolbar);

        viewModel = new ViewModelProvider(this).get(SecondActivityViewModel.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.little_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.itemA:
                //Deslogar
                viewModel.signOUtUser();
                startActivity(new Intent(this, MainActivity.class));
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
