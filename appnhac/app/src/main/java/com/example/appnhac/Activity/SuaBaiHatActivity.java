package com.example.appnhac.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appnhac.Fragment.Fragment_Quan_Ly;
import com.example.appnhac.Model.BaiHat_QL;
import com.example.appnhac.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class SuaBaiHatActivity extends AppCompatActivity {

    Button btn_trove,btnluu;
    TextView tenbaihat,hinhbaihat,casi,linkbaihat;
    ImageView suahinhbaihat;
    Integer id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_bai_hat);

        Intent intent=getIntent();
        BaiHat_QL baiHat_ql= (BaiHat_QL) intent.getSerializableExtra("databaihat");

        id=baiHat_ql.getIdBaiHat();

        btn_trove=(Button)findViewById(R.id.button_activity_sua_bai_hat_tro_ve);
        btn_trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(SuaBaiHatActivity.this, XoaBaiHatActivity.class);
//                startActivity(intent);
                finish();
            }
        });

        tenbaihat=(TextView)findViewById(R.id.text_suatenbaihat);
        hinhbaihat=(TextView)findViewById(R.id.text_suahinhbaihat);
        casi=(TextView)findViewById(R.id.text_suacasi);
        linkbaihat=(TextView)findViewById(R.id.text_sualinkbaihat);
        btnluu=(Button)findViewById(R.id.button_activity_sua_bai_hat_update);
        suahinhbaihat=(ImageView)findViewById(R.id.image_suahinhbaihat);

        tenbaihat.setText(baiHat_ql.getTenBaiHat());
        hinhbaihat.setText(baiHat_ql.getHinhBaiHat());
        casi.setText(baiHat_ql.getCasi());
        linkbaihat.setText(baiHat_ql.getLinkBaiHat());
        Picasso.with(SuaBaiHatActivity.this)
                .load(baiHat_ql.getHinhBaiHat())
                .placeholder(R.drawable.logo)
                .error(R.drawable.ic_error)
                .into(suahinhbaihat);

        btnluu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tenbaihat.getText().length()>0){
                    if(hinhbaihat.getText().length()>0){
                        if(casi.getText().length()>0){
                            if(linkbaihat.getText().length()>0){
                                capnhat("https://doanappnhac.000webhostapp.com/server/update_baihat.php");
                            }
                        }
                    }
                }
            }
        });
    }

    private void capnhat(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(SuaBaiHatActivity.this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(SuaBaiHatActivity.this,"Cập nhật thành công",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(SuaBaiHatActivity.this,XoaBaiHatActivity.class));
                        }else{
                            Toast.makeText(SuaBaiHatActivity.this,"Lỗi Cập nhật !!",Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SuaBaiHatActivity.this,"Xảy ra lỗi !",Toast.LENGTH_LONG).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("idBaiHat",String.valueOf(id));
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

}
