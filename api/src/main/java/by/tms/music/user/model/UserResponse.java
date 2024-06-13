package by.tms.music.user.model;

import by.tms.music.enums.UserRole;
import by.tms.music.song.model.SongResponse;
import by.tms.music.subscription.model.SubscriptionResponse;
import lombok.Data;

import java.util.Collection;

@Data
    public class UserResponse {
        private Long id;
        private String name;
        private String login;
        private String password;
        private SubscriptionResponse subscription;
        private Collection<SongResponse> favoriteSongs;
        private UserRole role;
    }
