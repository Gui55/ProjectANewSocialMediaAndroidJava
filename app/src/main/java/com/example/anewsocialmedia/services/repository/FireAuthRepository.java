package com.example.anewsocialmedia.services.repository;

import com.example.anewsocialmedia.services.model.User;
import com.google.firebase.auth.FirebaseAuth;

public class FireAuthRepository {

    FirebaseAuth auth;
    private static FireAuthRepository INSTANCE;

    public FireAuthRepository(){
        auth = FirebaseAuth.getInstance();
    }

    public void createUserInFirebase(String name, String email, String password, ResultCallback resultCallback){

        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {

            if(task.isComplete()){

                User user = new User();
                user.setUid(auth.getUid());
                user.setName(name);
                user.setEmail(email);
                user.setPassword(password);

                FirebaseDatabaseRefRepository.getInstance().saveInDB(user);

                resultCallback.newCallback("Success");
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
