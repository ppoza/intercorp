package com.ppoza.intercorp.interactors;

public class Interactors {

    private LogoutUseCase logoutUseCase;

    public Interactors(LogoutUseCase logoutUseCase) {
        this.logoutUseCase = logoutUseCase;
    }

    public LogoutUseCase getLogoutUseCase() {
        return logoutUseCase;
    }
}
