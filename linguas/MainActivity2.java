package com.example.linguas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
@SuppressWarnings("unchecked")
public class MainActivity2 extends AppCompatActivity {

    TextView context_2;
    private RequestQueue mQueue;

    Button button;




    public StringBuilder match(List<String> list1, String word) {
        StringBuilder content = new StringBuilder();
        List<String> list_final = new ArrayList<String>();
        for (String str : list1) {
            if (str.contains(word)) {
                content.append(str);
                content.append('\n');
            }

        }

        return content ;
    }

    public StringBuilder match2(String s1, String word) {
        StringBuilder content = new StringBuilder();
            if (s1.contains(word)) {
                content.append(s1);
                content.append('\n');
            }

        return content ;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        context_2 = (TextView) findViewById(R.id.context_2);

        button = (Button) findViewById(R.id.button);

        mQueue = Volley.newRequestQueue(this);


        HashMap<String, ArrayList<String>> map_context = new HashMap<String, ArrayList<String>>();
        map_context.put("- 况且刚才阮晔也说了", new ArrayList<String>(Arrays.asList("Besides, as Ruan Ye said", "Ikuàng qiě  gāng cái  ruǎn yè  yě  shuō  le ")));
        map_context.put("- 我现在已经不属于法务部了", new ArrayList<String>(Arrays.asList("I don't anymore", "wǒ  xiàn zài  yǐ jīng  bù  shǔ yú  fǎ wù bù  le ")));
        map_context.put("- 那么现在此时此刻", new ArrayList<String>(Arrays.asList("So right here, right now,", "nà me  xiàn zài  cǐ shí cǐ kè ")));
        map_context.put("- 现在学校给我们下最后通牒了", new ArrayList<String>(Arrays.asList("The school has issued a final warning. We have to move out now.", "xiàn zài  xué xiào  gěi  wǒ men  xià  zuì hòu  tōng dié  le ràng  wǒ men  bì xū  bān  chū qù  ")));
        map_context.put("- 你说一个男人准备那样的求婚场面 为什么还有很多女人会喜欢", new ArrayList<String>(Arrays.asList("Tell me. Why do so many women like", "nǐ  shuō  yí gè  nán rén  zhǔn bèi  nà yàng  de  qiú hūn  chǎng miàn    wèi shén me  hái yǒu  hěn duō  nǚ rén  huì  xǐ huān  ？ ")));
        map_context.put("- 但是一个外地人来上海打拼", new ArrayList<String>(Arrays.asList("For an outlander to come to Shanghai", "dàn shì  yí gè  wài dì rén  lái  shàng hǎi  dǎ pīn  ")));

        String key = getIntent().getStringExtra("key");

        Set<String> keySet_context = map_context.keySet();
        List<String> keyList_context = new ArrayList<>(keySet_context);


        button.setOnClickListener(new View.OnClickListener() {
            HashMap<String, ArrayList<String>> map_test = new HashMap<String, ArrayList<String>>();
            @Override
            public void onClick(View v) {
                jsonParse();
            }
        });

    }
        public void jsonParse() {

            String url = "https://raw.githubusercontent.com/omartsan/linguas/main/hsk_phrases.json";
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            String allstr = "";

                            ArrayList<String> ar = new ArrayList<String>();
                            List<String> arf = new ArrayList<>();


                            try {
                                JSONArray jsonArray = response.getJSONArray("hsk");
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject employee = jsonArray.getJSONObject(i);
                                    String key = getIntent().getStringExtra("key");

                                    String p1 = employee.getString("p1");
                                    String py = employee.getString("py");
                                    String p2 = employee.getString("p2");
                                    String lvl = String.valueOf(employee.getInt("lvl"));
                                    String keys = employee.getString("key");

                                    allstr = p1;
                                    context_2.append(allstr);


                                }



                            }



                            catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }


                    }   , new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            mQueue.add(request);


/*        String url = "https://raw.githubusercontent.com/omartsan/linguas/main/context.json";

            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                JSONArray jsonArray = response.getJSONArray("context_phrases");

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject employee = jsonArray.getJSONObject(i);

                                    String p1 = employee.getString("p1");
                                    String p2 = employee.getString("p2");
                                    String pinyin = employee.getString("pinyin");

                                   // List<String> listall = new ArrayList<>();
                                    //listall.add(p1 + "\n\n");


                                    StringBuilder all_context = new StringBuilder();
                                    all_context.append(p1 + "\n\n");
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            mQueue.add(request);*/


        }
        //context_2.setText(match(keyList_context, key).toString());




}