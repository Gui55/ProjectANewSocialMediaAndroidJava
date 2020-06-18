package com.example.anewsocialmedia.services.repository;

import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.anewsocialmedia.services.model.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class FirebaseDatabaseRefRepository {

    static FirebaseDatabaseRefRepository INSTANCE;

    private DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
    private StorageReference stRef = FirebaseStorage.getInstance().getReference();

    public void saveInDB(User user){
        dbRef.child("usuarios").child(user.getUid()).setValue(user);

        //Compressão da imagem
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        user.getImage().compress(Bitmap.CompressFormat.JPEG, 70, baos);
        byte[] imageData = baos.toByteArray();

        //Upar a imagem no Firebase
        UploadTask uploadTask = stRef.child("imagens").child("perfil").child(user.getUid()+".jpeg").putBytes(imageData);
    }

    public static FirebaseDatabaseRefRepository getInstance(){
        if(INSTANCE==null){
            INSTANCE = new FirebaseDatabaseRefRepository();
        }

        return INSTANCE;
    }

}
