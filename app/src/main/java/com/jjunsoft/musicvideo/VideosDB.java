package com.jjunsoft.musicvideo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.SimpleMultiPartRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/**
 * Created by alfo06-05 on 2018-05-16.
 */

public class VideosDB {
    Context context;
    String respon;


    public VideosDB(Context context) {
        this.context = context;
    }


    void uploadDB(String title, String img, String video, String contents, String email){

        String serverUrl = "http://wjdwnsgnl.dothome.co.kr/rookiestar/videoInsertDB.php";


        //php에보낼 파일전송요청 객체 생성
        SimpleMultiPartRequest multiPartRequest = new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //php의 echo결과 보여주기
                Log.i("yyyyyyyy", response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        Log.i("qqqqqqqqqqq",""+title+""+img+""+video+""+contents);
        //요청 객체에 데이터추가하기
        multiPartRequest.addStringParam("title",title);

        multiPartRequest.addStringParam("contents",contents);

        multiPartRequest.addStringParam("email",email);

        if(img!=null){
            multiPartRequest.addFile("img", img);
        }

        if(video!=null){
            multiPartRequest.addFile("video", video);
        }


        //요청큐 객체 생성하기
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        Log.i("wwww",requestQueue+"");
        //요청큐에 요청객체 추가하기

        requestQueue.add(multiPartRequest);



    }

    String loadDB(){

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(context);
        String email = account.getEmail();

        String serverUrl = "http://wjdwnsgnl.dothome.co.kr/rookiestar/videoLoadDB.php";
        final SimpleMultiPartRequest multiPartRequest = new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //insertDB.php의 echo결과 보여주기

                Log.i("responsedata","responsedata"+response);

                respon = response.toString();



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("error1 : ", error+"");

            }
        });


        //요청큐 객체 생성하기
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        multiPartRequest.addStringParam("email",email);

        Log.i("wwww",requestQueue+"");
        //요청큐에 요청객체 추가하기
        requestQueue.add(multiPartRequest);




        return respon;
    }

}
