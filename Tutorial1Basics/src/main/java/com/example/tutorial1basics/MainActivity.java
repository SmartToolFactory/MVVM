package com.example.tutorial1basics;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.tutorial1basics.databinding.ActivityMainBinding;
import com.example.tutorial1basics.viewmodel.UsersViewModel;

/*
    This tutorial includes
    Binding data to views from UserViewModel onCreate() method
    Updating user names with changeNames() method UserViewModel only updates UserViewModel. To update
    views use ObservableField or LiveData objects.

    ViewModel class survives device rotation and updated values with changeNames() are bound to views on create
    after rotation.
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        UsersViewModel usersViewModel =
                ViewModelProviders.of(this).get(UsersViewModel.class);
        usersViewModel.getUserList();

        activityMainBinding.setViewmodel(usersViewModel);
    }
}