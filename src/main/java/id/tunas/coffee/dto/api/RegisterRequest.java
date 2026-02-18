package id.tunas.coffee.dto.api;

public class RegisterRequest {
    private String username;
    private String email;
    private String mobilePhoneNumber;
    private String password;

    public RegisterRequest(String username, String email, String mobilePhoneNumber, String password) {
        this.username = username;
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobilePhoneNumber;
    }

    public void setMobile(String mobile) {
        this.mobilePhoneNumber = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
