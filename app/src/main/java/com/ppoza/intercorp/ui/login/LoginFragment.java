package com.ppoza.intercorp.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.ppoza.intercorp.R;
import com.ppoza.intercorp.databinding.FragmentLoginBinding;
import com.ppoza.intercorp.ui.BaseFragment;
import com.ppoza.intercorp.ui.main.MainViewModel;
import com.ppoza.intercorp.utils.IntercorpViewModelFactory;

public class LoginFragment extends BaseFragment {

    private LoginViewModel mLoginViewModel;
    private MainViewModel mMainViewModel;
    private FragmentLoginBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = FragmentLoginBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mLoginViewModel = new ViewModelProvider(this, IntercorpViewModelFactory.getInstance()).get(LoginViewModel.class);
        mMainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        listenData();

        mBinding.loginButton.setPermissions(mLoginViewModel.permissions);
        mBinding.loginButton.registerCallback(mLoginViewModel.callbackManager, mLoginViewModel.facebookCallback);
    }

    @Override
    public void onStart() {
        super.onStart();
        hideToolbar();
    }

    private void listenData() {
        mMainViewModel.activityResultLiveData.observe(getViewLifecycleOwner(), activityResult -> mLoginViewModel.callbackManager.onActivityResult(activityResult.getRequestCode(),
                                                         activityResult.getResultCode(),
                                                         activityResult.getData()));

        mLoginViewModel.loginResultLiveData.observe(getViewLifecycleOwner(), loginResult -> {
            mBinding.setIsLoading(loginResult.isLoading());
            switch (loginResult.getResponseType()) {
                case LOADING: {
                    break;
                }
                case SUCCESS: {
                    NavHostFragment.findNavController(LoginFragment.this)
                            .navigate(R.id.action_login_to_user_profile);
                    break;
                }
                case ERROR: {
                    Toast.makeText(requireActivity(), loginResult.getMessage(), Toast.LENGTH_LONG).show();
                    break;
                }
            }
        });
    }

}