package com.example.anewsocialmedia.services.repository;

import com.example.anewsocialmedia.services.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseDatabaseRefRepository {

    static FirebaseDatabaseRefRepository INSTANCE;

    private DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();

    public void saveInDB(User user){
        dbRef.child("usuarios").child(user.getUid()).setValue(user);
    }

    public static FirebaseDatabaseRefRepository getInstance(){
        if(INSTANCE==null){
            INSTANCE = new FirebaseDatabaseRefRepository();
        }

        return INSTANCE;
    }

}
