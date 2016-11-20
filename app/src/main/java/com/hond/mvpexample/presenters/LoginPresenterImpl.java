package com.hond.mvpexample.presenters;

import android.os.Handler;

import com.hond.mvpexample.views.ILoginView;

/**
 * Created by hond on 11/17/2016.
 */

public class LoginPresenterImpl implements ILoginPresenter {

    private ILoginView mLoginView;

    public LoginPresenterImpl(ILoginView loginView) {
        this.mLoginView = loginView;
    }

    @Override
    public boolean validateCredentials(String username, String password) {
        if (mLoginView != null) {
            mLoginView.showProgress();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //用来模拟和服务器的延迟过程
            }
        }, 2000);

        if (username == null || password == null || username.length() == 0 || password.length() == 0) {
            if (mLoginView != null) {
                mLoginView.setLoginError();
                mLoginView.hideProgress();
            }
            return false;
        }
        if (mLoginView != null) {
            mLoginView.navigateToHome();
        }
        return true;
    }

    @Override
    public void onDestroy() {
        mLoginView = null;
    }
}
