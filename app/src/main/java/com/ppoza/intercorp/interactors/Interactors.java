package com.ppoza.intercorp.interactors;

public class Interactors {

    private final GetUserUseCase mGetUserUseCase;
    private final LogoutUseCase mLogoutUseCase;
    private final LoginUseCase mLoginCaseUse;
    private final IsLoggedUseCase mIsLoggedUseCase;
    private final CreateUserUseCase mCreateUserUseCase;

    public Interactors(
            LoginUseCase loginCaseUse,
            LogoutUseCase logoutUseCase,
            IsLoggedUseCase isLoggedUseCase,
            GetUserUseCase getUserUseCase,
            CreateUserUseCase createUserUseCase
    ) {
        this.mLogoutUseCase = logoutUseCase;
        this.mLoginCaseUse = loginCaseUse;
        this.mIsLoggedUseCase = isLoggedUseCase;
        this.mGetUserUseCase = getUserUseCase;
        this.mCreateUserUseCase = createUserUseCase;
    }

    public LogoutUseCase getLogoutUseCase() {
        return mLogoutUseCase;
    }

    public LoginUseCase getLoginCaseUse() {
        return mLoginCaseUse;
    }

    public IsLoggedUseCase getIsLoggedUseCase() {
        return mIsLoggedUseCase;
    }

    public GetUserUseCase getGetUserUseCase() {
        return mGetUserUseCase;
    }

    public CreateUserUseCase getCreateUserUseCase() {
        return mCreateUserUseCase;
    }
}
