package com.example.anewsocialmedia.viewmodel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.anewsocialmedia.services.repository.FireAuthRepository;


public class MainViewModel extends ViewModel {

    MutableLiveData<Boolean> someoneLogged = new MutableLiveData<>();

    public void loginTheUser(String email, String password) {
        FireAuthRepository.getInstance().loginThisUser(email, password, new FireAuthRepository.LoginCallback() {
            @Override
            public void isLogged(boolean b) {
                someoneLogged.setValue(b);
            }
        });
    }

    public MutableLiveData<Boolean> getSomeoneLogged() {
        return someoneLogged;
    }
}
