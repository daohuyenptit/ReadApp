package com.example.dell.tt_readartist.Retrofit;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import javax.xml.parsers.DocumentBuilderFactory;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Dell on 4/23/2018.
 */

public class RetrofitClient {
    public static GitHubService api() throws XmlPullParserException {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .baseUrl("https://vnexpress.net/")
                .build();
        return retrofit.create(GitHubService.class);
    }
}
