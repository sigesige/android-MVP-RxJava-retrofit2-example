package com.hond.mvpexample.views;

/**
 * Created by hond on 11/17/2016.
 */

public interface ILoginView {
    void showProgress();

    void hideProgress();

    void setLoginError();

    void navigateToHome();
}
