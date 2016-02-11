package io.pivotal.controllers;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.builder.api.DefaultApi10a;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth10aService;
import io.pivotal.YelpApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VendorController {

    private static final String PROTECTED_RESOURCE_URL = "https://api.yelp.com/v2/search?category_filter=coffee&ll=47.6,-122.3&radius_filter=1000";
    private static final String CONSUMER_KEY = "_I5idAPp9nWBIXRphxc7dQ";
    private static final String CONSUMER_SECRET = "YjiqP_hOtdOF6MYm8FJFh2VhpcQ";
    private static final String TOKEN = "eC5-h2pa1u4lAMhA5GeoZvQtwjxggcr0";
    private static final String TOKEN_SECRET = "et4ODdXlcvet81K1VShGBAIp_qc";

    @RequestMapping("hello")
    public static @ResponseBody String doTheThing(){
        final OAuth10aService service = new ServiceBuilder()
                .apiKey(CONSUMER_KEY)
                .apiSecret(CONSUMER_SECRET)
                .build(new YelpApi());

        Token yelpToken = new Token(TOKEN, TOKEN_SECRET);

        final OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL, service);
        service.signRequest(yelpToken, request);
        final Response response = request.send();
        return response.getBody();
    }
}