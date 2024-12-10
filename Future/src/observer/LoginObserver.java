package observer;

public interface LoginObserver {
    void onLoginSuccess(String username);
    void onLoginFailure();
}
