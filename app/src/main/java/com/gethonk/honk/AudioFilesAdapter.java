package com.gethonk.honk;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hapie on 26/6/15.
 */
public class AudioFilesAdapter extends RecyclerView.Adapter<AudioFilesAdapter.AudioListViewHolder> {

    public static ArrayList<File> audioList = new ArrayList<>();
    private LayoutInflater inflater;
    public static Context mContext;

    public AudioFilesAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    public void setDataSource(List<File> audioList) {
        this.audioList = (ArrayList<File>) audioList;
        notifyDataSetChanged();
    }

    @Override
    public AudioListViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.audio_file_item, parent, false);
        AudioListViewHolder viewHolder = new AudioListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AudioListViewHolder audioListViewHolder, int i) {
        String audioName = audioList.get(i).getName();
        audioListViewHolder.audio.setText(audioName);
    }

    @Override
    public int getItemCount() {
        return (null != audioList ? audioList.size() : 0);
    }


    static public class AudioListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView audio;

        public AudioListViewHolder(View view) {
            super(view);
            this.audio = (TextView) view.findViewById(R.id.audio_item);
            this.audio.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // TODO (hapie): Play audio files on click or maybe something else.
        }
    }
}
