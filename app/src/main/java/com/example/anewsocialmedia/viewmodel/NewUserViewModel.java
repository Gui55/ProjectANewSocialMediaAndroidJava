package com.example.anewsocialmedia.viewmodel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.anewsocialmedia.services.repository.FireAuthRepository;

public class NewUserViewModel extends ViewModel {

    MutableLiveData<String> registerSuccess = new MutableLiveData<>();

    public void createUserInFire(String name, String email, String password){
        FireAuthRepository.getInstance().createUserInFirebase(name, email, password, b -> registerSuccess.setValue(b));
    }

    public MutableLiveData<String> getRegisterSuccess() {
        return registerSuccess;
    }
}
