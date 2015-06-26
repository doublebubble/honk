package com.gethonk.honk;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hapie on 26/6/15.
 */
public class ShowAudioFiles extends ActionBarActivity {


    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private AudioFilesAdapter audioFilesAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_audio_files);

        recyclerView = (RecyclerView) findViewById(R.id.audio_files);
        audioFilesAdapter = new AudioFilesAdapter(this);
        recyclerView.setAdapter(audioFilesAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<File> audioFiles = getAudioFiles(new File(Environment.getExternalStorageDirectory() + "/" + MainActivity.AUDIO_RECORDER_FOLDER));
        audioFilesAdapter.setDataSource(audioFiles);
    }

    List<File> getAudioFiles(File parentDir) {
        ArrayList<File> inFiles = new ArrayList<File>();
        File[] files = parentDir.listFiles();
        for (File file : files) {
            if (!file.isDirectory()) {
                inFiles.add(file);
            }
        }
        return inFiles;
    }

}
