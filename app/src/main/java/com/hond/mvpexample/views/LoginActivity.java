package com.hond.mvpexample.views;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.hond.mvpexample.R;
import com.hond.mvpexample.Utils.UtilFunction;
import com.hond.mvpexample.presenters.ILoginPresenter;
import com.hond.mvpexample.presenters.LoginPresenterImpl;

/**
 * Created by hond on 11/17/2016.
 */

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {
    private ProgressBar mProgressBar;
    private EditText username;
    private EditText password;
    private ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(R.string.title_login);

        mProgressBar = UtilFunction.createProgressBar(this);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);

        mLoginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onDestroy() {
        mLoginPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setLoginError() {
        username.setError(getString(R.string.login_error));
        password.setError(getString(R.string.login_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, CityListActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        mLoginPresenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }
}
