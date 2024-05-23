package by.tms.music.user;

import by.tms.music.enums.UserRole;
import by.tms.music.song.SongResponse;
import by.tms.music.subscription.SubscriptionResponse;
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
