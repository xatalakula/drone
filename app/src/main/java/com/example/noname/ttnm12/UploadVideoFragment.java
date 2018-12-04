package com.example.noname.ttnm12;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UploadVideoFragment extends Fragment {

    Button pick;
    Button sendFile;
    ListView listFile = null;
    TextView filePath;
    static List<Video> listFileTemp = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_upload_video, container, false);
        pick = (Button) view.findViewById(R.id.pick);
        filePath = (TextView) view.findViewById(R.id.filepath);
        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialFilePicker filePicker = new MaterialFilePicker();
                filePicker.withActivity(getActivity())
                        .withRequestCode(1000)
                        .withFilter(Pattern.compile(".*\\.mp4$")) // Filtering files and directories by file name using regexp
                        .withFilterDirectories(false) // Set directories filterable (false by default)
                        .withHiddenFiles(true); // Show hidden files and folders


                startActivityForResult(filePicker.getIntent(),1000);


            }
        });

        sendFile = view.findViewById(R.id.sendfile);
        listFile = view.findViewById(R.id.listfile);
        listFileTemp = getListData();
        listFile.setAdapter(new CustomListVideo(listFileTemp,this.getActivity()));
        final FragmentActivity activity = this.getActivity();
        sendFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = filePath.getText().toString();
                String re[] = text.split("/");
                listFileTemp.add( 0 ,new Video(re[re.length-1], "đã gửi"));
                listFile.setAdapter(new CustomListVideo(listFileTemp,activity));
                filePath.setText("Địa chỉ File");
                Toast.makeText(getActivity(), "Gửi thành công", Toast.LENGTH_SHORT).show();
                
            }
        });
        return view;
    }

    private List<Video> getListData() {
        List<Video> list = new ArrayList<>();

        list.add(new Video("video1.mp4","đã gửi"));
        list.add(new Video("video2.mp4","đã gửi"));


        return list;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == 1000  ) {
            try {
                String file = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
                filePath.setText(file);

            }catch (Exception e){

            }
        }
    }


    private void loadFragMent(Fragment fragment) {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
