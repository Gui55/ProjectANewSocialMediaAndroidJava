package com.example.anewsocialmedia.services.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FireAuthRepository {

    FirebaseAuth auth;
    private static FireAuthRepository INSTANCE;

    public FireAuthRepository(){
        auth = FirebaseAuth.getInstance();
    }

    public void createUserInFirebase(String email, String password, ResultCallback resultCallback){

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isComplete()){
                    resultCallback.newCallback("Success");
                }

            }
        });

    }

    public static FireAuthRepository getInstance(){
        if(INSTANCE==null){
            INSTANCE = new FireAuthRepository();
        }

        return INSTANCE;
    }

    public interface ResultCallback{
        void newCallback(String b);
    }
}
