package com.ppoza.intercorp.interactors;

public class Interactors {

    private LogoutUseCase logoutUseCase;
    private LoginCaseUse loginCaseUse;

    public Interactors(
            LoginCaseUse loginCaseUse,
            LogoutUseCase logoutUseCase
    ) {
        this.logoutUseCase = logoutUseCase;
        this.loginCaseUse = loginCaseUse;
    }

    public LogoutUseCase getLogoutUseCase() {
        return logoutUseCase;
    }

    public LoginCaseUse getLoginCaseUse() {
        return loginCaseUse;
    }

}
