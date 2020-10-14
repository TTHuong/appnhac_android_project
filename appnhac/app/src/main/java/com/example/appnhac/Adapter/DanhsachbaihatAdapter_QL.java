package com.example.appnhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appnhac.Activity.SuaBaiHatActivity;
import com.example.appnhac.Activity.ThemBaiHatActivity;
import com.example.appnhac.Activity.XoaBaiHatActivity;
import com.example.appnhac.Fragment.Fragment_Quan_Ly;
import com.example.appnhac.Model.BaiHat_QL;
import com.example.appnhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhsachbaihatAdapter_QL extends ArrayAdapter<BaiHat_QL> {

    private Context context=getContext();
    private XoaBaiHatActivity manhinhxoa;
    String url="https://doanappnhac.000webhostapp.com/server/xoa_baihat.php";


    public DanhsachbaihatAdapter_QL(@NonNull Context context, int resource) {
        super(context, resource);
        this.context = context;
    }

    public DanhsachbaihatAdapter_QL(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
        this.context = context;
    }

    public DanhsachbaihatAdapter_QL(@NonNull Context context, int resource, @NonNull BaiHat_QL[] objects) {
        super(context, resource, objects);
        this.context = context;
    }

    public DanhsachbaihatAdapter_QL(@NonNull Context context, int resource, int textViewResourceId, @NonNull BaiHat_QL[] objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
    }

    public DanhsachbaihatAdapter_QL(@NonNull Context context, int resource, @NonNull List<BaiHat_QL> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    public DanhsachbaihatAdapter_QL(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<BaiHat_QL> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v=convertView;
        if(v==null){
            LayoutInflater vi;
            vi=LayoutInflater.from(getContext());
            v=vi.inflate(R.layout.activity_dong_bai_hat,null);
        }
        final BaiHat_QL bh=getItem(position);
        if(bh!=null){
            TextView tenbaihat=(TextView)v.findViewById(R.id.text_tenbaihat);
            tenbaihat.setText(bh.getTenBaiHat());
            TextView tencasi=(TextView)v.findViewById(R.id.text_tencasibaihat);
            tencasi.setText(bh.getCasi());
            ImageView anhbaihat=(ImageView)v.findViewById(R.id.image_anhbaihat);
            Picasso.with(getContext())
                    .load(bh.getHinhBaiHat())
                    .placeholder(R.drawable.logo)
                    .error(R.drawable.ic_error)
                    .into(anhbaihat);

            ImageView edit=(ImageView)v.findViewById(R.id.btn_edit_baihat);

            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, SuaBaiHatActivity.class);
                    intent.putExtra("databaihat",bh);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });

            ImageView xoa=(ImageView)v.findViewById(R.id.btn_remove_baihat);

            xoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RequestQueue requestQueue= Volley.newRequestQueue(context);
                    StringRequest stringRequest=new StringRequest(Request.Method.POST, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    if(response.trim().equals("success")){
                                        Toast.makeText(context,"Xóa thành công",Toast.LENGTH_LONG).show();

                                        Intent intent = new Intent(context, XoaBaiHatActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                        context.startActivity(intent);

//                            startActivity(new Intent(XoaBaiHatActivity.this,XoaBaiHatActivity.class));

//                                        runOnUiThread(new Runnable() {
//                                            @Override
//                                            public void run() {
//                                                new XoaBaiHatActivity.docJON().execute("https://doanappnhac.000webhostapp.com/server/tatcabaihat.php");
//                                            }
//                                        });

                                    }else{
                                        Toast.makeText(context,"Lỗi Xóa bài hát !!",Toast.LENGTH_LONG).show();
                                    }
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(context,"Xảy ra lỗi !",Toast.LENGTH_LONG).show();
                                }
                            }
                    ){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params=new HashMap<>();
                            params.put("idBaiHat",String.valueOf(bh.getIdBaiHat()));
                            return params;
                        }
                    };

                    requestQueue.add(stringRequest);
                }

            });

        }
        return v;
    }
}
