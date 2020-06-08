package com.example.anewsocialmedia.ui.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.anewsocialmedia.R;
import com.example.anewsocialmedia.viewmodel.NewUserViewModel;

public class NewUserActivity extends AppCompatActivity {

    private final int GALLERY_GET_CODE = 0;
    ImageView newUserPhoto;
    EditText userEmail, userPassword, userName;
    NewUserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);

        newUserPhoto = findViewById(R.id.newUserPhoto);
        userEmail = findViewById(R.id.newUserEmail);
        userPassword = findViewById(R.id.newUserPassword);
        userName = findViewById(R.id.newUserName);

        viewModel = new ViewModelProvider(this).get(NewUserViewModel.class);

        viewModel.getRegisterSuccess().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(s!=null){

                    if(s.equals("Success")){
                        Toast.makeText(NewUserActivity.this, "Usuário cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(NewUserActivity.this, MainActivity.class));
                        finish();
                    }

                }
            }
        });
    }

    public void getGalleryImage(View view) {

        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType("image/*");
        startActivityForResult(i, GALLERY_GET_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){

            switch (requestCode){

                case GALLERY_GET_CODE:
                    Uri imUri = data.getData();
                    newUserPhoto.setImageURI(imUri);
                    break;

            }

        }
    }

    public void createUser(View view) {
        viewModel.createUserInFire(userName.getText().toString(), userEmail.getText().toString(), userPassword.getText().toString());
    }
}
