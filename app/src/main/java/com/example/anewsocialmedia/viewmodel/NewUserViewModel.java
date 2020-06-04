package com.example.anewsocialmedia.viewmodel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.anewsocialmedia.services.repository.FireAuthRepository;

public class NewUserViewModel extends ViewModel {

    MutableLiveData<String> registerSuccess = new MutableLiveData<>();

    public void createUserInFire(String email, String password){
        FireAuthRepository.getInstance().createUserInFirebase(email, password, new FireAuthRepository.ResultCallback() {
            @Override
            public void newCallback(String b) {
                registerSuccess.setValue(b);
            }
        });
    }

    public MutableLiveData<String> getRegisterSuccess() {
        return registerSuccess;
    }
}
