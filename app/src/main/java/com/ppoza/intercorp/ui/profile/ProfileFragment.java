package com.ppoza.intercorp.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.ppoza.intercorp.R;
import com.ppoza.intercorp.databinding.FragmentProfileBinding;
import com.ppoza.intercorp.ui.BaseFragment;
import com.ppoza.intercorp.ui.login.LoginFragment;
import com.ppoza.intercorp.utils.IntercorpViewModelFactory;

public class ProfileFragment extends BaseFragment {

    private FragmentProfileBinding mBinding;
    private ProfileViewModel mProfileViewModel;
    private NavController mNavController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mBinding = FragmentProfileBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mNavController = Navigation.findNavController(view);
        mProfileViewModel = new ViewModelProvider(this, IntercorpViewModelFactory.getInstance()).get(ProfileViewModel.class);

        checkLogged();
        listenData();
        requestData();

        mBinding.logoutButton.setOnClickListener( button -> {
                mProfileViewModel.logout();
            }
        );
    }

    @Override
    public void onStart() {
        super.onStart();
        showToolbar();
    }

    private void checkLogged() {
        if(!mProfileViewModel.isLogged()) {
            mNavController.navigate(R.id.login_fragment);
        }
    }

    private void listenData() {
        mProfileViewModel.userLiveData.observe(getViewLifecycleOwner(),  dataResponse -> {
            mBinding.setUserDataResponse(dataResponse);
        });

        mProfileViewModel.logoutResponseLiveData.observe(getViewLifecycleOwner(),  dataResponse -> {
            mBinding.setLogoutDataResponse(dataResponse);
            switch (dataResponse.getResponseType()) {
                case SUCCESS: {
                    NavHostFragment.findNavController(ProfileFragment.this)
                            .navigate(R.id.action_profile_to_login);
                    break;
                }
                case ERROR: {
                    Toast.makeText(requireActivity(), dataResponse.getMessage(), Toast.LENGTH_LONG);
                    break;
                }
            }
        });
    }


    private void requestData() {
        mProfileViewModel.requestUser();
    }

}