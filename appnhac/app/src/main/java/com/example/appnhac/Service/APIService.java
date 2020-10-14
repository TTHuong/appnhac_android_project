package com.example.appnhac.Service;

public class APIService {
    private static  String base_url="https://doanappnhac.000webhostapp.com/server/";

    public  static  Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);

    }
}
