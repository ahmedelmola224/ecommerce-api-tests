package pojo;

public class LoginRequest {

        private String userEmail;
        private String userPassword;

        // Constructor
        public LoginRequest(String email, String password) {
            this.userEmail = email;
            this.userPassword = password;
        }

        // Getters (required for Jackson serialization)
        public String getUserEmail() { return userEmail; }
        public String getUserPassword() { return userPassword; }

}
