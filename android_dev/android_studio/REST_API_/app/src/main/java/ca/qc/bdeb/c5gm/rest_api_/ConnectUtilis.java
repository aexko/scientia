package ca.qc.bdeb.c5gm.rest_api_;

public class ConnectUtilis {
    private String authId;
    private String authToken;

    public ConnectUtilis(String authId, String authToken) {
        this.authId = authId;
        this.authToken = authToken;
    }

    public void connecter() {

    }

    public String getAuthId() {
        return authId;
    }

    public String getAuthToken() {
        return authToken;
    }
}
