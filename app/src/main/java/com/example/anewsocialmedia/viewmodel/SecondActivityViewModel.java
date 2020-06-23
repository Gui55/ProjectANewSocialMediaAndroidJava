package com.example.anewsocialmedia.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.anewsocialmedia.services.repository.FireAuthRepository;

import java.util.ArrayList;

public class SecondActivityViewModel extends ViewModel {

    public SecondActivityViewModel(){
    }

    public void signOUtUser() {
        FireAuthRepository.getInstance().signOutTheUser();
    }
}
