package com.example.anewsocialmedia.ui.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.anewsocialmedia.R;
import com.example.anewsocialmedia.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    //Criação da instância da viewModel da MainActivity (esta activity)
    MainViewModel viewModel;

    //Elementos de UI
    ImageView userPhoto;
    EditText email, password;
    Button login, newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Atribuição de valor para esta viewModel
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        //Função para atribuir valores aos elementos de UI
        assignUIComponentsValues();

    }

    private void assignUIComponentsValues(){
        userPhoto = findViewById(R.id.loginUserPhoto);
        email = findViewById(R.id.loginEmailText);
        password = findViewById(R.id.loginPasswordText);
        login = findViewById(R.id.loginButton);
        newUser = findViewById(R.id.newUserButton);
    }

    public void goToNewUser(View view) {
        startActivity(new Intent(this, NewUserActivity.class));
        finish();
    }
}
