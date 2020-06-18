package com.example.anewsocialmedia.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.anewsocialmedia.services.repository.FireAuthRepository;

public class SecondActivityViewModel extends ViewModel {

    public void signOUtUser() {
        FireAuthRepository.getInstance().signOutTheUser();
    }

}
