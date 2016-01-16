package com.paringer.dashmedia;

import android.content.Context;
import android.os.Bundle;

/**
 * Simple Dash Media video/audio Streaming client
 *
 */
public interface DashClient {
    /**
     * DashClient Builder
     * constructs Dash Client for streaming channel
     */
    public static final class Builder{
        /**
         * constructs Dash Media video/audio streaming client
         * @param sample media stream source
         * @return this DashClient
         */
        public static DashClient build(Samples.Sample sample){
            return new DashClientImpl(sample);
        }

        /**
         * constructs Dash Media video/audio streaming client
         * @param name title
         * @param uri media stream source
         * @param type type of stream decoding
         * @return this DashClient
         */
        public static DashClient build(String name, String uri, int type){
            return new DashClientImpl(name, uri, type);
        }

        /**
         * constructs Dash Media video/audio streaming client
         * @param name title
         * @param uri media stream source
         * @param type type of stream decoding
         * @return this DashClient
         */
        public static DashClient build(String name, String contentId, String provider, String uri, int type){
            return new DashClientImpl(name, contentId, provider, uri, type);
        }
    }

    /**
     * starts play video
     * @param context android Context
     * @return this DashClient
     */
    public DashClient play(Context context);
    /**
     * starts play video
     * @param context android Context
     * @param options additional options
     * @return this DashClient
     */
    public DashClient play(Context context, Bundle options);
}
