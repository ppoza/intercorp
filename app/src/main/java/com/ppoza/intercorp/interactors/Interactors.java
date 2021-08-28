package com.ppoza.intercorp.interactors;

public class Interactors {

    private LogoutUseCase logoutUseCase;
    private LoginUseCase loginCaseUse;
    private IsLoggeedUseCase isLoggeedUseCase;

    public Interactors(
            LoginUseCase loginCaseUse,
            LogoutUseCase logoutUseCase,
            IsLoggeedUseCase isLoggeedUseCase
    ) {
        this.logoutUseCase = logoutUseCase;
        this.loginCaseUse = loginCaseUse;
        this.isLoggeedUseCase = isLoggeedUseCase;
    }

    public LogoutUseCase getLogoutUseCase() {
        return logoutUseCase;
    }

    public LoginUseCase getLoginCaseUse() {
        return loginCaseUse;
    }

    public IsLoggeedUseCase getIsLoggeedUseCase() {
        return isLoggeedUseCase;
    }
}
