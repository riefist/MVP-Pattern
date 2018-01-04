package com.muhamadarief.ngulikmvppattern.views.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.muhamadarief.ngulikmvppattern.R;
import com.muhamadarief.ngulikmvppattern.model.User;
import com.muhamadarief.ngulikmvppattern.presenter.register.RegisterPresenter;
import com.muhamadarief.ngulikmvppattern.presenter.register.RegisterPresenterImpl;
import com.muhamadarief.ngulikmvppattern.views.main.MainActivity;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    private RegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initPresenter();
        onAttachView();
    }

    private void initPresenter(){
        presenter = new RegisterPresenterImpl();
    }

    @Override
    public void onAttachView() {
        presenter.onAttach(this);
        //initToolbar();
        addButtonListener();
    }

    @Override
    public void onDetachView() {
        presenter.onDetach();
    }

    @Override
    public void onSuccess(User user) {
        startActivity(new Intent(RegisterActivity.this, MainActivity.class)
        .putExtra("user", user));
    }

    @Override
    public void onFailed(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        onDetachView();
        super.onDestroy();
    }

    private void addButtonListener(){
        Button btnRegister = findViewById(R.id.btn_register);
        final EditText edtEmail = findViewById(R.id.edt_email);
        final EditText edtPassword = findViewById(R.id.edt_password);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                presenter.registerUser(email, password);
            }
        });
    }
}
