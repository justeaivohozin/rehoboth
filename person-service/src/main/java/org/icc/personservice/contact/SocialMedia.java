package org.icc.personservice.contact;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class SocialMedia {

    @Column(name = "SOCIAL_MEDIA_FACEBOOK")
    private String facebook;

    @Column(name = "SOCIAL_MEDIA_INSTAGRAM")
    private String instagram;

    @Column(name = "SOCIAL_MEDIA_LINKEDIN")
    private String linkedIn;

    @Column(name = "SOCIAL_MEDIA_SNAPCHAT")
    private String snapChat;

}
