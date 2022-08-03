package com.idnp.fitcoach;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SurveyFragment extends Fragment {

    private SurveyViewModel mViewModel;

    public static SurveyFragment newInstance() {
        return new SurveyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_survey, container, false);
        WebView myWebView = (WebView) view.findViewById(R.id.survey);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //myWebView.setWebViewClient(new Callback());
        myWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdi_VW1-_pdwHl3hFqvpqYwSYTIuQsPueXXhYCcdu-wEaIJLg/viewform?usp=sf_link");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SurveyViewModel.class);
        // TODO: Use the ViewModel
    }

    private class Callback extends WebViewClient {
        @Override
        public boolean shouldOverrideKeyEvent(WebView web, KeyEvent keyEvent){
            return false;
        }
    }

}