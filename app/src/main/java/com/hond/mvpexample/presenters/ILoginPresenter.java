package com.hond.mvpexample.presenters;

/**
 * Created by hond on 11/17/2016.
 */

public interface ILoginPresenter {
    boolean validateCredentials(String username, String password);

    void onDestroy();
}
