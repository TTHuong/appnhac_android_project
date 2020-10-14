package com.example.appnhac.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appnhac.Adapter.DanhsachbaihatAdapter_QL;
import com.example.appnhac.Fragment.Fragment_Quan_Ly;
import com.example.appnhac.Model.BaiHat_QL;
import com.example.appnhac.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XoaBaiHatActivity extends AppCompatActivity {

    Button trove;

    ListView listView;
    ArrayList<BaiHat_QL> arraylist_baihat_ql;

    String url="https://doanappnhac.000webhostapp.com/server/xoa_baihat.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xoa_bai_hat);

        trove=(Button)findViewById(R.id.button_activity_xoa_bai_hat_tro_ve);
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(XoaBaiHatActivity.this, Fragment_Quan_Ly.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
                finish();
            }
        });

        listView=(ListView)findViewById(R.id.listview_xoadanhsach);
        arraylist_baihat_ql=new ArrayList<BaiHat_QL>();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new docJON().execute("https://doanappnhac.000webhostapp.com/server/tatcabaihat.php");
            }
        });
    }

    class  docJON extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... strings) {
            return docNoiDung_Tu_URL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {
//            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            try {
                JSONArray mangJON=new JSONArray(s);
                for(int i=0;i<mangJON.length();i++){
                    JSONObject bh=mangJON.getJSONObject(i);
                    arraylist_baihat_ql.add(new BaiHat_QL(
                            bh.getString("TenBaiHat"),
                            bh.getString("HinhBaiHat"),
                            bh.getString("Casi"),
                            bh.getString("LinkBaiHat"),
                            bh.getInt("idBaiHat"),
                            bh.getInt("LuotThich")
                    ));
                }
//                DanhsachbaihatAdapter_QL adapter_ql=new DanhsachbaihatAdapter_QL(
//                        getApplicationContext(),
//                        R.layout.activity_dong_bai_hat,
//                        arraylist_baihat_ql);
                DanhsachbaihatAdapter_QL adapter_ql=new DanhsachbaihatAdapter_QL(getApplicationContext(),R.layout.activity_dong_bai_hat,arraylist_baihat_ql);
                listView.setAdapter(adapter_ql);
//                Toast.makeText(getApplicationContext(),arraylist_baihat_ql.size(),Toast.LENGTH_LONG).show();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static  String docNoiDung_Tu_URL(String theUrl){
        StringBuilder content=new StringBuilder();
        try {
            URL url=new URL(theUrl);
            URLConnection urlConnection=url.openConnection();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line=bufferedReader.readLine())!=null){
                content.append(line+"\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  content.toString();
    }


}
