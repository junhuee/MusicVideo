package com.jjunsoft.musicvideo;

import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddVideoActivity extends AppCompatActivity {

    VideoView vv;
    EditText title;
    EditText contents;
    Bitmap img;
    Uri videos;
    String video;
//    ImageView iv;
    File file;
    String email;
    String nickname;
    String photo;
    int num;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_video);


        vv = findViewById(R.id.vv);
        title = findViewById(R.id.edit_title);
        contents = findViewById(R.id.edit_contents);
//        iv = findViewById(R.id.iv);

        Intent intent = getIntent();
        videos = intent.getData();

        vv.setVideoURI(videos);
        vv.start();


        img = ThumbnailUtils.createVideoThumbnail(PathConverter.getPath(this, videos), MediaStore.Video.Thumbnails.MINI_KIND);
        File path = Environment.getExternalStorageDirectory();

        String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        file = new File(path,"IMG_"+time+"_"+".jpg");
        OutputStream out = null;

        try
        {
            file.createNewFile();
            out = new FileOutputStream(file);

            img.compress(Bitmap.CompressFormat.JPEG, 100, out);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                out.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }


        video = getRealPathFromUri(videos);
//        iv.setImageBitmap(img);

    }
    String getRealPathFromUri(Uri uri){


        String[] proj = {MediaStore.Video.Media.DATA};
        CursorLoader loader = new CursorLoader(this, uri,proj,null,null,null);//$result
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }


    public void clickOk(View v){
        //혹시 타이틀에 아무것도 안적히면 확인 하지마
        if(title.toString()!=null){
            Log.i("qqqqqqqqqqq",""+title.toString()+""+file.getAbsolutePath()+""+video.toString()+""+contents.toString());
            Log.i("qqqqqqqqqqq",""+title.toString());
            Log.i("qqqqqqqqqqq",""+PathConverter.getPath(this, videos));
            Log.i("qqqqqqqqqqq",""+file.getAbsolutePath());
            Log.i("qqqqqqqqqqq",""+contents.toString());
            Log.i("qqqqqqqqqqq",""+email);
            VideosDB videosDB = new VideosDB(this);
            videosDB.uploadDB(title.getText().toString(),file.getAbsolutePath(),video,contents.getText().toString(),email);
            Intent intent = new Intent(this,DetailVideoActivity.class);
            intent.putExtra("title",title.getText().toString());
            intent.putExtra("video",video);
            intent.putExtra("contents",contents.getText().toString());
            startActivity(intent);
            finish();

        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("제목을 적어주세요");
            builder.setIcon(android.R.drawable.ic_dialog_dialer);
            AlertDialog dialog = builder.create();
            dialog.setCanceledOnTouchOutside(true);

            dialog.show();
        }

    }

    public void clickCancel(View v){

        finish();

    }





}
