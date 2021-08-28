package com.ppoza.intercorp.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.ppoza.intercorp.R;
import com.ppoza.intercorp.databinding.FragmentProfileBinding;
import com.ppoza.intercorp.utils.IntercorpViewModelFactory;

public class ProfileFragment extends Fragment {

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

        mBinding.logoutButtoon.setOnClickListener( button -> {
                mProfileViewModel.logout();
                NavHostFragment.findNavController(ProfileFragment.this)
                        .navigate(R.id.action_profile_to_login);
            }
        );
    }

    private void checkLogged() {
        if(!mProfileViewModel.isLogged()) {
            mNavController.navigate(R.id.login_fragment);
        }
    }

    private void listenData() {
        mProfileViewModel.userLiveData.observe(getViewLifecycleOwner(),  dataResponse -> {

        });
    }


    private void requestData() {
        mProfileViewModel.requestUser();
    }

}