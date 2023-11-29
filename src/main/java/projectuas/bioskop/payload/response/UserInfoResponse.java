package projectuas.bioskop.payload.response;

import org.bson.types.ObjectId;

import java.util.List;

public class UserInfoResponse {
    private ObjectId id;
    private String username;
    private String email;
    private List<String> roles;

    public UserInfoResponse(ObjectId id, String username, String email, List<String> roles) {
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
