package com.example.appnhac.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appnhac.R;

import java.util.HashMap;
import java.util.Map;

public class ThemBaiHatActivity extends AppCompatActivity {

    Button btn_trove,btnluu;
    TextView tenbaihat,hinhbaihat,casi,linkbaihat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_bai_hat);

        btn_trove=(Button)findViewById(R.id.button_activity_them_bai_hat_tro_ve);
        btn_trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ThemBaiHatActivity.this, Fragment_Quan_Ly.class);
////                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
                finish();
            }
        });

        tenbaihat=(TextView)findViewById(R.id.text_tenbaihat);
        hinhbaihat=(TextView)findViewById(R.id.text_hinhbaihat);
        casi=(TextView)findViewById(R.id.text_casi);
        linkbaihat=(TextView)findViewById(R.id.text_linkbaihat);
        btnluu=(Button)findViewById(R.id.button_activity_them_bai_hat_insert);

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tenbaihat.getText().length()>0){
                    if(hinhbaihat.getText().length()>0){
                        if(casi.getText().length()>0){
                            if(linkbaihat.getText().length()>0){
                                thembaihat("https://doanappnhac.000webhostapp.com/server/insert_baihat.php");
//                                Toast.makeText(ThemBaiHatActivity.this,"Thêm thành công",Toast.LENGTH_LONG).show();

                            }
                        }
                    }
                }
            }
        });

    }

    private void thembaihat(String url){
        RequestQueue requestQueue=Volley.newRequestQueue(ThemBaiHatActivity.this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(ThemBaiHatActivity.this,"Thêm thành công",Toast.LENGTH_LONG).show();
                            finish();
//                            Intent intent=new Intent(ThemBaiHatActivity.this, Fragment_Quan_Ly.class);
//                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                            startActivity(intent);
                        }else{
                            Toast.makeText(ThemBaiHatActivity.this,"Lỗi thêm !!",Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ThemBaiHatActivity.this,"Xảy ra lỗi !",Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("idAlbum","0");
                params.put("idTheLoai","0");
                params.put("idPlayList","0");
                params.put("TenBaiHat",tenbaihat.getText().toString());
                params.put("HinhBaiHat",hinhbaihat.getText().toString());
                params.put("Casi",casi.getText().toString());
                params.put("LinkBaiHat",linkbaihat.getText().toString());
                params.put("LuotThich","0");
                return params;
            }
        };

        requestQueue.add(stringRequest);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
