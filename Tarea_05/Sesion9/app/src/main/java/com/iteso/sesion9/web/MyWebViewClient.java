package com.iteso.sesion9.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.iteso.sesion9.ActivityPrivacyPolicy;

public class MyWebViewClient extends WebViewClient {

    private Context context;

    public MyWebViewClient(Context context) {
        this.context = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//        if(Uri.parse(url).getHost().equals("www.linkedin.com")) {
//            return false;
//        }
//        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//        context.startActivity(i);
//
//        return true;

          if(url.equals("hrupin://ActivityPrivacyPolicy")){
            Intent intent = new Intent(context, ActivityPrivacyPolicy.class);
            context.startActivity(intent);
            return true;
          }
          return super.shouldOverrideUrlLoading(view, url);

    }

}