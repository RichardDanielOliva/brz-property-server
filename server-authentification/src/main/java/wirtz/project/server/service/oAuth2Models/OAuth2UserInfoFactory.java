package wirtz.project.server.service.oAuth2Models;

import wirtz.project.server.exception.OAuth2AuthenticationProcessingException;
import wirtz.project.server.persistence.entities.AuthProvider;
import wirtz.project.server.service.oAuth2Models.impl.FacebookOAuth2UserInfo;
import wirtz.project.server.service.oAuth2Models.impl.GithubOAuth2UserInfo;
import wirtz.project.server.service.oAuth2Models.impl.GoogleOAuth2UserInfo;

import java.util.Map;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
            return new FacebookOAuth2UserInfo(attributes);
        } else if (registrationId.equalsIgnoreCase(AuthProvider.github.toString())) {
            return new GithubOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
}
