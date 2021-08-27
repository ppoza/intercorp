package com.ppoza.intercorp.ui.login;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.facebook.CallbackManager;
import com.ppoza.intercorp.databinding.LoginFragmentBinding;
import com.ppoza.intercorp.ui.MainViewModel;

public class LoginFragment extends Fragment {

    private LoginViewModel mLoginViewModel;
    private CallbackManager mCallbackManager;
    private LoginFragmentBinding mBinding;
    private MainViewModel mMainViewModel;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = LoginFragmentBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        

        mLoginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        mMainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        listenData();

        mBinding.loginButton.setPermissions(mLoginViewModel.permissions);
        mBinding.loginButton.registerCallback(mLoginViewModel.callbackManager, mLoginViewModel.facebookCallback);
    }

    private void listenData() {
        mMainViewModel.activityResultLiveData.observe(getViewLifecycleOwner(), activityResult -> {
            mLoginViewModel.callbackManager.onActivityResult(activityResult.getRequestCode(),
                                                             activityResult.getResultCode(),
                                                             activityResult.getData());
        });

        mLoginViewModel.loginResultLiveData.observe(getViewLifecycleOwner(), loginResult -> {
            Log.i("", "");
        });
    }

}