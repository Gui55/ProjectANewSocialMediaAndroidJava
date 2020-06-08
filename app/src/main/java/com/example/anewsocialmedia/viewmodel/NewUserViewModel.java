package com.example.anewsocialmedia.viewmodel;
import android.graphics.Bitmap;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.anewsocialmedia.services.repository.FireAuthRepository;

public class NewUserViewModel extends ViewModel {

    MutableLiveData<String> registerSuccess = new MutableLiveData<>();

    public void createUserInFire(Bitmap bitmap, String name, String email, String password){
        FireAuthRepository.getInstance().createUserInFirebase(bitmap, name, email, password, b -> registerSuccess.setValue(b));
    }

    public MutableLiveData<String> getRegisterSuccess() {
        return registerSuccess;
    }
}
