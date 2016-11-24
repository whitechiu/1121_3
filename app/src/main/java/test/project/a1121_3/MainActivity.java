package test.project.a1121_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
//        StringRequest request = new StringRequest("http://data.ntpc.gov.tw/od/data/api/BF90FA7E-C358-4CDA-B579-B6C84ADC96A1?$format=json",
        StringRequest request = new MyUTF8StringRequest("http://udn.com/rssfeed/news/1",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        Log.d("NET", response);
//                        Gson gson = new Gson();
//                        Animal loc[] = gson.fromJson(response, Animal[].class);
//                        for (Animal a : loc)
//                        {
//                            Log.d("NET", a.district);
//                        }

//                        try{
//                            JSONArray array = new JSONArray(response);
//                            for(int i=0;i<array.length();i++)
//                            {
//                                JSONObject obj = array.getJSONObject(i);
//                                String str = obj.getString("district");
//                                Log.d("NET",str);
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
        queue.start();
        Log.d("NET", "queue start");
    }
}
