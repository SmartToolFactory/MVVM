/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.test.tutorial2_5livedata_multiplefragments.fragment;


import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.test.tutorial2_5livedata_multiplefragments.R;
import com.test.tutorial2_5livedata_multiplefragments.viewmodel.SeekBarViewModel;

/**
 * Shows a SeekBar that is synced with a value in a ViewModel.
 */
public class FragmentC extends Fragment {

    private SeekBar mSeekBar;

    private SeekBarViewModel mSeekBarViewModel;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        System.out.println("FragmentC onAttach: " + this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("FragmentC onCreate: " + this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("FragmentC onCreateView: " + this);


        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment3, container, false);
        mSeekBar = root.findViewById(R.id.seekBar);

        mSeekBarViewModel = ViewModelProviders.of(getActivity()).get(SeekBarViewModel.class);

        subscribeSeekBar();

        return root;
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        System.out.println("FragmentC onViewCreated: " + this);
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("FragmentC onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("FragmentC onResume()");
    }


    @Override
    public void onPause() {
        super.onPause();
        System.out.println("FragmentC onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("FragmentC onStop()");
    }
    
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("FragmentC onDestroyView: " + this);
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("FragmentC onDestroy: " + this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        System.out.println("FragmentC onDetach: " + this);
    }


    private void subscribeSeekBar() {

        // Update the ViewModel when the SeekBar is changed.
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mSeekBarViewModel.seekbarValue.setValue(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Update the SeekBar when the ViewModel is changed.
        mSeekBarViewModel.seekbarValue.observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer value) {

                System.out.println("FragmentC observe() lifeCycle: " + getActivity().getLifecycle().getCurrentState());

                if (value != null) {
                    mSeekBar.setProgress(value);
                }
            }
        });
    }
}
