package com.jjunsoft.musicvideo;

import android.content.Context;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.SimpleMultiPartRequest;
import com.android.volley.toolbox.Volley;


/**
 * Created by alfo06-05 on 2018-05-10.
 */

public class MemberDB {
    Context context;

    public MemberDB(Context context) {
        this.context = context;

    }


    void uploadDB(final String email , final String nickname, final String photo){

        String serverUrl = "http://wjdwnsgnl.dothome.co.kr/rookiestar/memberInsertDB.php";


        //php에보낼 파일전송요청 객체 생성
        SimpleMultiPartRequest multiPartRequest = new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //php의 echo결과 보여주기
               Log.i("test1", response);
                Log.i("photo : ",photo+"");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        Log.i("llllll",photo+"");

        //요청 객체에 데이터추가하기
        multiPartRequest.addStringParam("email",email);
        multiPartRequest.addStringParam("nickname",nickname);
        multiPartRequest.addStringParam("photo",photo);



        //요청큐 객체 생성하기
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        //요청큐에 요청객체 추가하기

        requestQueue.add(multiPartRequest);



    }

    void loadDB(final String email, final String nickname, final String photo,final int num){
        Log.i("tttttttt","email"+email+nickname+photo);
        System.out.println("a1");
        String serverUrl = "http://wjdwnsgnl.dothome.co.kr/rookiestar/memberLoadDB.php";
        SimpleMultiPartRequest multiPartRequest = new SimpleMultiPartRequest(Request.Method.POST, serverUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //php의 echo결과 보여주기
                Log.i("test1", response);

                if (response.equals("yes")){

                    Intent intent = new Intent(context,MyProfileActivity.class);
                    context.startActivity(intent);

                }else if (response.equals("no")){

                    if(num ==1){
                        Log.i("test1", "1: " + email + ", 2: " + nickname + ", 3: " + photo);
                        MemberDB memberDB = new MemberDB(context);
                        memberDB.uploadDB(email,nickname,photo);
                        Intent intent = new Intent(context,MyProfileActivity.class);
                        context.startActivity(intent);

                    }else{
//                        MemberDB memberDB = new MemberDB(context);
//                        Log.i("test11",""+nickname+""+email+""+photo+"");
//                        memberDB.uploadDB(email,nickname,photo);
//                        Intent intent = new Intent(context,MyProfileActivity.class);
//                        context.startActivity(intent);
                    }

                }else {
                    Toast.makeText(context, "실패", Toast.LENGTH_SHORT).show();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



        System.out.println(multiPartRequest);
        System.out.println("a4");
        multiPartRequest.addStringParam("email",email);
        multiPartRequest.addStringParam("nickname",nickname);
        multiPartRequest.addStringParam("photo",photo);

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        System.out.println("a5");
        requestQueue.add(multiPartRequest);
        System.out.println("a6");


    }





}
