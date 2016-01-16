package com.paringer.androidmediaplayerexercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.paringer.dashmedia.Samples;

public /*static*/ class SampleAdapter extends ArrayAdapter<Object> {

        public SampleAdapter(Context context) {
            super(context, 0);
            SampleAdapter sampleAdapter = this;
            sampleAdapter.add(new Samples.Header("YouTube DASH"));
            sampleAdapter.addAll((Object[]) Samples.YOUTUBE_DASH_MP4);
//            sampleAdapter.addAll((Object[]) Samples.YOUTUBE_DASH_WEBM);

//            sampleAdapter.add(new Samples.Header("Widevine DASH Policy Tests (GTS)"));
//            sampleAdapter.addAll((Object[]) Samples.WIDEVINE_GTS);
//            sampleAdapter.add(new Samples.Header("Widevine HDCP Capabilities Tests"));
//            sampleAdapter.addAll((Object[]) Samples.WIDEVINE_HDCP);
            sampleAdapter.add(new Samples.Header("Widevine DASH: MP4,H264"));
            sampleAdapter.addAll((Object[]) Samples.WIDEVINE_H264_MP4_CLEAR);
            sampleAdapter.addAll((Object[]) Samples.WIDEVINE_H264_MP4_SECURE);
//            sampleAdapter.add(new Samples.Header("Widevine DASH: WebM,VP9"));
//            sampleAdapter.addAll((Object[]) Samples.WIDEVINE_VP9_WEBM_CLEAR);
//            sampleAdapter.addAll((Object[]) Samples.WIDEVINE_VP9_WEBM_SECURE);
//            sampleAdapter.add(new Samples.Header("Widevine DASH: MP4,H265"));
//            sampleAdapter.addAll((Object[]) Samples.WIDEVINE_H265_MP4_CLEAR);
//            sampleAdapter.addAll((Object[]) Samples.WIDEVINE_H265_MP4_SECURE);
            sampleAdapter.add(new Samples.Header("SmoothStreaming"));
            sampleAdapter.addAll((Object[]) Samples.SMOOTHSTREAMING);
            sampleAdapter.add(new Samples.Header("HLS"));
            sampleAdapter.addAll((Object[]) Samples.HLS);
            sampleAdapter.add(new Samples.Header("Misc"));
            sampleAdapter.addAll((Object[]) Samples.MISC);
            sampleAdapter.add(new Samples.Header("DASH"));
            sampleAdapter.addAll((Object[]) Samples.TEST_DASH_VIDEO_H264_MP4_CLEAR);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                int layoutId = getItemViewType(position) == 1 ? android.R.layout.simple_list_item_1
                        : com.paringer.dashmedia.R.layout.sample_chooser_inline_header;
                view = LayoutInflater.from(getContext()).inflate(layoutId, null, false);
            }
            Object item = getItem(position);
            String name = null;
            if (item instanceof Samples.Sample) {
                name = ((Samples.Sample) item).name;
            } else if (item instanceof Samples.Header) {
                name = ((Samples.Header) item).name;
            }
            ((TextView) view).setText(name);
            return view;
        }

        @Override
        public int getItemViewType(int position) {
            return (getItem(position) instanceof Samples.Sample) ? 1 : 0;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

    }
