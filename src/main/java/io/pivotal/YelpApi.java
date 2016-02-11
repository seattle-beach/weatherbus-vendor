package io.pivotal;

import com.github.scribejava.core.builder.api.DefaultApi10a;
import com.github.scribejava.core.model.Token;

/**
 * Created by pivotal on 2/11/16.
 */
public class YelpApi extends DefaultApi10a {

    @Override
    public String getRequestTokenEndpoint() {
        return null;
    }

    @Override
    public String getAccessTokenEndpoint() {
        return null;
    }

    @Override
    public String getAuthorizationUrl(Token requestToken) {
        return null;
    }
}
