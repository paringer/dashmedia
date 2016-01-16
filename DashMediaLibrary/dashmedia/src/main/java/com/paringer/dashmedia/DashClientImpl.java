package com.paringer.dashmedia;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer.demo.PlayerActivity;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Locale;

/**
 * Created by Zhenya on 14.01.2016.
 */
public class DashClientImpl implements DashClient {

    private final Samples.Sample mSample;

    DashClientImpl(Samples.Sample sample){
        mSample = new Samples.Sample(sample);
    }
    DashClientImpl(String name, String uri, int type){
        mSample = new Samples.Sample(name, uri, type);
    }

    DashClientImpl(String name, String contentId, String provider, String uri, int type){
        mSample = new Samples.Sample(name, contentId, provider, uri, type);
    }

    @Override
    public DashClient play(Context context){
        sendIntentToPlayer(context, mSample, null);
        return this;
    }

    @Override
    public DashClient play(Context context, Bundle options) {
        sendIntentToPlayer(context, mSample, options);
        return this;
    }

    private void sendIntentToPlayer(Context context, Samples.Sample sample, Bundle options){
        if(options == null) options = Bundle.EMPTY;
        Intent mpdIntent = new Intent(context, PlayerActivity.class)
                .setData(Uri.parse(sample.uri))
                .putExtra(PlayerActivity.CONTENT_ID_EXTRA, sample.contentId)
                .putExtra(PlayerActivity.CONTENT_TYPE_EXTRA, sample.type)
                .putExtra(PlayerActivity.PROVIDER_EXTRA, sample.provider)
                .putExtras(options);
        context.startActivity(mpdIntent);
    }
}
