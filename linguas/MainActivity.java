package com.example.linguas;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {


    EditText answer;

    Button check;

    Button next;

    Button context;

    Button totest;


    TextView phrase;

    TextView pinyin;

    Switch switch1;

    private RequestQueue mQueue;

/*

    public String randomobj() {

        Map<String, String> map = new HashMap<String, String>();
        map.put("Wǒ xiǎng qù bàn gè xìnyòngkǎ","我想去办个信用卡");
        map.put("Xiànzài wǒ hěn shǎo kàn diànshì","现在我很少看电视");
        map.put("Qízhōng yīgè yuányīn shì","其中一个原因是");
        Set<String> keySet = map.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        int size = keyList.size();
        int randIdx = new Random().nextInt(size);
        String randomKey = keyList.get(randIdx);
        String randomValue = map.get(randomKey);

        return randomKey;
        //return randomValue;
    }
*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        answer = (EditText) findViewById(R.id.answer);

        check = (Button) findViewById(R.id.check);

        next = (Button) findViewById(R.id.next);

        totest = (Button) findViewById(R.id.totest);


        context = (Button) findViewById(R.id.context);

        phrase = (TextView) findViewById(R.id.phrase);

        pinyin = (TextView) findViewById(R.id.pinyin);

        switch1 = (Switch) findViewById(R.id.switch1);

        mQueue = Volley.newRequestQueue(this);






        HashMap<String, ArrayList<String>> map2 = new HashMap<String, ArrayList<String>>();
        map2.put("现在我很少看电视",new ArrayList<String>(Arrays.asList("Xiànzài wǒ hěn shǎo kàn diànshì", "I rarely watch TV now", "4", "现在")));
        map2.put("其中一个原因是",new ArrayList<String>(Arrays.asList("Qízhōng yīgè yuányīn shì", "Among the reasons is", "4", "一个")));
        map2.put("这是你做的饺子？",new ArrayList<String>(Arrays.asList("Gāngcái diànshì lǐ shuōmíng tiān gèng lěng", "It was said on TV that it was colder", "4","刚才" )));
        map2.put("我想去办个信用卡",new ArrayList<String>(Arrays.asList("Xiànzài wǒ hěn shǎo kàn diànshì", "I rarely watch TV now", "4", "现在")));
        map2.put("大家反映了不少管理过程中出现的问题",new ArrayList<String>(Arrays.asList("Qízhōng yīgè yuányīn shì", "Among the reasons is", "4", "一个")));
        map2.put("不管什么时间，也不管什么节目",new ArrayList<String>(Arrays.asList("Gāngcái diànshì lǐ shuōmíng tiān gèng lěng", "It was said on TV that it was colder", "4","刚才" )));
        map2.put("只要你打开电视",new ArrayList<String>(Arrays.asList("Xiànzài wǒ hěn shǎo kàn diànshì", "I rarely watch TV now", "4", "现在")));
        map2.put("浪费我的时间",new ArrayList<String>(Arrays.asList("Qízhōng yīgè yuányīn shì", "Among the reasons is", "4", "一个")));

        Set<String> keySet2 = map2.keySet();
        List<String> keyList2 = new ArrayList<>(keySet2);

         next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pinyin.setText("");
                answer.setText("");

                int size2 = keyList2.size();
                //int size_all = keyListall.size();

                int randIdx2 = new Random().nextInt(size2);
               // int randIdx_all = new Random().nextInt(size_all);

                String randomKey2 = keyList2.get(randIdx2);
               // String randomKey_all = keyList2.get(randIdx_all);

                ArrayList<String> randomValue2 = map2.get(randomKey2);
               // ArrayList<String> randomValue_all = map2.get(randomKey_all);

                if (switch1.isChecked()) {

                    phrase.setText(randomValue2.get(1));

                   // phrase.setText(randomValue_all.get(1));


                } else {

                    phrase.setText(randomKey2);

                    // phrase.setText(randomKey_all);


                }

 /*               switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override


                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {




                    }
                });*/

                check.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        pinyin.setText(randomValue2.get(0));

                       // pinyin.setText(randomValue_all.get(0));


                        if (switch1.isChecked()) {
                          answer.setText(randomKey2);

                          //  answer.setText(randomKey_all);


                        } else {

                            answer.setText(randomValue2.get(1));

                           // answer.setText(randomValue_all.get(1));

                        }


                    }
                });


                context.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(getApplicationContext(),MainActivity2.class);
                        i.putExtra("key",randomValue2.get(3));

                        // i.putExtra("key",randomValue_all.get(3));
                        startActivity(i);
                    }
                });





            }



             public void jsonParse() {

                 String url = "https://raw.githubusercontent.com/omartsan/linguas/main/hsk_phrases.json";

                 JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                         new Response.Listener<JSONObject>() {
                             @Override
                             public void onResponse(JSONObject response) {

                                 HashMap<String, ArrayList<String>> map_all = new HashMap<String, ArrayList<String>>();

                                 try {
                                     JSONArray jsonArray = response.getJSONArray("hsk");
                                     for (int i = 0; i < jsonArray.length(); i++) {
                                         JSONObject employee = jsonArray.getJSONObject(i);
                                         String p1 = employee.getString("p1");
                                         String py = employee.getString("py");
                                         String p2 = employee.getString("p2");
                                         String lvl = String.valueOf(employee.getInt("lvl"));
                                         String keys = employee.getString("key");



                                         // context_2.append(p1 + " " + lvl +"\n\n" );

                                         map_all.put(employee.getString("p1"), new ArrayList<String>(Arrays.asList(employee.getString("py"), employee.getString("p2"), String.valueOf(employee.getInt("lvl")), employee.getString("key"))));
                                         //HashMap<String, ArrayList<String>> mapvalues = jsonParse();




                                     }
                                     Set<String> keySetall = map_all.keySet();
                                     List<String> keyListall = new ArrayList<>(keySetall);

                                     int size_all = jsonArray.length();

                                     int randIdx_all = new Random().nextInt(size_all);

                                     String randomKey_all = keyListall.get(randIdx_all);

                                     ArrayList<String> randomValueAll = map_all.get(randomKey_all);

                                     phrase.setText(randomKey_all);
                                     pinyin.setText(randomValueAll.get(0));
                                     answer.setText(randomValueAll.get(1));


                                 } catch (JSONException e) {
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
        });



    }





    private HashMap<String, ArrayList<String>>  jsonParse() {

        String url = "https://raw.githubusercontent.com/omartsan/linguas/main/hsk_phrases.json";
        HashMap<String, ArrayList<String>> map_all = new HashMap<String, ArrayList<String>>();

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hsk_phrases");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject employee = jsonArray.getJSONObject(i);

                                String p1 = employee.getString("p1");
                                String py = employee.getString("py");
                                String p2 = employee.getString("p2");
                                String lvl = String.valueOf(employee.getInt("lvl"));
                                String key = employee.getString("key");

                                map_all.put(p1,new ArrayList<String>(Arrays.asList(py, p2,lvl,key )));



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

        mQueue.add(request);

        return map_all;
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}