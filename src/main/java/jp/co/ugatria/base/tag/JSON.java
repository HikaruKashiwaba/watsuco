package jp.co.ugatria.base.tag;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSON {

    public static String encode(Object obj) {
    	Gson gson = new GsonBuilder().create();
        return gson.toJson(obj);
    }
}
