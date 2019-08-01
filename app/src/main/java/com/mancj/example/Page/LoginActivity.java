package com.mancj.example.Page;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mancj.example.MainActivity;
import com.mancj.example.R;
import com.mancj.example.api.ErrorAPI;
import com.mancj.example.api.RetrofitClientInstance;
import com.mancj.example.pojo.Auth;
import com.mancj.example.pojo.AuthData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextEmail;
    private EditText editTextPass;
    private Button btnSignIn;
    private Button btnFacebook;
    private Button btnGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPass = findViewById(R.id.editTextPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        btnGoogle = findViewById(R.id.googleSignIn);
        btnFacebook = findViewById(R.id.facebookSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(editTextEmail.getText().toString().trim(), editTextPass.getText().toString().trim());
            }
        });

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInWithGoogle();
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInWithFacebook();
            }
        });


    }

    private void signInWithGoogle() {
    }

    private void signInWithFacebook() {
    }

    private void signIn(String email, String pass) {
        if (editTextEmail.getText().toString().trim().equals("") || editTextPass.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Username or password is still empty", Toast.LENGTH_SHORT).show();
        } else {
            if (ErrorAPI.checkConnection(this)) {
                getTargetUser(email, pass);
            } else {
                Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getTargetUser(String email, String pass) {
        RetrofitClientInstance.GetAuth getAuth = RetrofitClientInstance.getRetrofitInstance(this).create(RetrofitClientInstance.GetAuth.class);
        Call<AuthData> call = getAuth.getAuth("flip123", email, pass);
        call.enqueue(new Callback<AuthData>() {
            @Override
            public void onResponse(Call<AuthData> call, Response<AuthData> response) {
                Log.d("Response code :", String.valueOf(response.code()));
                if (response.isSuccessful()) {
                    if (response.body() == null) {
//                    Log.d("response", response.toString());

                        Toast.makeText(LoginActivity.this, "Email or password is wrong", Toast.LENGTH_SHORT).show();
                    } else {
                        Auth auth = response.body().getAuth();
                        Log.d("Auth :", auth.toString());
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }
                } else {
//                    if () {
//
//                    }
                }
            }

            @Override
            public void onFailure(Call<AuthData> call, Throwable t) {
                Log.d("Response code", t.getMessage());
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
//        if (email.equalsIgnoreCase("ujang")) {
//            if (pass.equalsIgnoreCase("ujang")) {
//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                finish();
//            } else {
//                editTextPass.setError("Wrong password");
//                editTextPass.requestFocus();
//            }
//        } else {
//            editTextEmail.setError("Wrong email");
//            editTextEmail.requestFocus();
//        }
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
}
