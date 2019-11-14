package Eunsung.com;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


public class newsActivitybackup extends AppCompatActivity {

    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter mAdapter;
    private InterstitialAd mInterstitialAd;

    private RecyclerView.LayoutManager mLayoutManager;
    //RequestQueue queue = Volley.newRequestQueue(this);
    RequestQueue queue;
    EditText edit;
    private Button newButton;
    ArrayList<String> arrStr;

    List<NewsData> news = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Log.d("Start", "yeah!");
        arrStr = new ArrayList<String>();

        loadNewsInfo();
        AdTogether();
        mrecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        newButton = (Button) findViewById(R.id.newButton);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mrecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(mLayoutManager);

        edit = (EditText)findViewById(R.id.EditView_get);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override    // 입력한 데이터를 파일에 추가로 저장하기
            public void onClick(View v) {
                Intent intent = new Intent(newsActivitybackup.this, selectActivity.class);
                startActivity(intent);
            }
        });

        edit.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String getText = edit.getText().toString();
                news = new ArrayList<>();
                searchNaver(getText,1);
                // 입력되는 텍스트에 변화가 있을 때
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                // 입력하기 전에

            }

        });

        // specify an adapter (see also next example)

      // getNews();
        //1. 화면이 로딩 -> 뉴스정보 받아온다
        //3, 어뎁터 -> 셋팅
    }

    private void AdTogether(){

        // banner -->
        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        //adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");  // 테스트
        adView.setAdUnitId("ca-app-pub-1420948259689687/1657581892");  // 리얼
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        // <-- banner

        //Interstitial Ad -->

        mInterstitialAd = new InterstitialAd(this);
        //mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712"); // 테스트
        mInterstitialAd.setAdUnitId("ca-app-pub-1420948259689687/5213683523");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        //  <-- Interstitial Ad

    }
    public void searchNaver(final String searchObject, final int start) { // 검색어 = searchObject로 ;
        final String clientId = "EMDmdlzofwv0_tyE3SmA";//애플리케이션 클라이언트 아이디값";
        final String clientSecret = "aD4knYwaN7";//애플리케이션 클라이언트 시크릿값";
        final int display = 100; // 보여지는 검색결과의 수
        // 네트워크 연결은 Thread 생성 필요
        new Thread() {

            @Override
            public void run() {
                try {
                    String text = URLEncoder.encode(searchObject, "UTF-8");
                    String apiURL = "https://openapi.naver.com/v1/search/news?query=" + text + "&display=" + display + "&sort=sim&start = "+start; // json 결과
                    // Json 형태로 결과값을 받아옴.
                    URL url = new URL(apiURL);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    con.setRequestProperty("X-Naver-Client-Id", clientId);
                    con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
                    con.connect();

                    int responseCode = con.getResponseCode();
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    if(responseCode==200) { // 정상 호출
                        br = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    } else {  // 에러 발생
                        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
                    }

                    StringBuilder searchResult = new StringBuilder();
                    String inputLine;
                    while ((inputLine = br.readLine()) != null) {
                        searchResult.append(inputLine + "\n");
                    }
                    br.close();
                    con.disconnect();

                    String data = searchResult.toString();
                    String[] array;
                    array = data.split("\\{");
                    String[] originallink = new String[display+2];
                    String[] title = new String[display+2];
                    String[] link = new String[display+2];
                    String[] description = new String[display+2];
                    String[] pubDate = new String[display+2];

                    int k = 0;

                    for (int i = 2; i < array.length; i++) {

                        for (int count=0;count<arrStr.size();count++){
                            String[] linkAddr = arrStr.get(count).split("\t");
                            if (array[i].contains(linkAddr[0])){
                                NewsData newsData = new NewsData();
                                String[]  bylines = array[i].split("\n");
                                for (int line = 0; line < bylines.length; line++){
                                    if (bylines[line].contains("originallink")){
                                        String origStr=bylines[line].substring(15);
                                        originallink[k] = origStr;
                                        Log.d("origStr : ", ""+ origStr);
                                        newsData.setOriginallink(origStr);
                                    }

                                    if (bylines[line].contains("title")){
                                        String titleStr=  bylines[line].substring(9);
                                        titleStr= titleStr.replaceAll("\"","");
                                        titleStr= titleStr.replaceAll("<b>","");
                                        titleStr= titleStr.replaceAll("</b>","");
                                        titleStr= titleStr.replaceAll("&quot;","\"");
                                        title[k] = titleStr;
                                        newsData.setTitle(titleStr);
                                    }
                                    if (bylines[line].contains("link")){
                                        String linkStr=bylines[line].substring(7);
                                        link[k] = linkStr;
                                        newsData.setLink(linkStr);
                                    }

                                    if (bylines[line].contains("description")){

                                        String descStr = bylines[line];
                                        descStr= descStr.substring(14);
                                        descStr= descStr.replaceAll("\"","");
                                        descStr= descStr.replaceAll("<b>","");
                                        descStr= descStr.replaceAll("</b>","");
                                        descStr= descStr.replaceAll("&quot;","\"");
                                        description[k] = descStr;
                                        newsData.setContent(descStr);}

                                    if (bylines[line].contains("pubDate")) {
                                        String pubStr=bylines[line].substring(10);
                                        pubDate[k] = pubStr;
                                        newsData.setPubDate(pubStr);
                                        k++;
                                    }


                                }
                                news.add(newsData);
                            }
                        }
                    }

                    // title[0], link[0], bloggername[0] 등 인덱스 값에 맞게 검색결과를 변수화하였다.
                    //2 정보 -> 어뎁터
                   mAdapter = new MyAdapter(news, newsActivitybackup.this, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Object obj = v.getTag();
                            if(obj !=null){
                                int position =(int)obj;
                                ((MyAdapter)mAdapter).getNews(position);
                            }
                        }
                    });
                    mrecyclerView.setAdapter(mAdapter);
                } catch (Exception e) {
                }
            }
        }.start();

    }
 
    public void getNews(){

        // Request 초기화
        String url = "https://newsapi.org/v2/top-headlines?country=kr&apiKey=3c94e09f7c544418bd31048568685903";
        queue = Volley.newRequestQueue(this);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            JSONArray arrayArticles =  jsonObj.getJSONArray("articles");

                            List<NewsData> news = new ArrayList<>();
                            for(int i=0, j= arrayArticles.length(); i<j; i++ ){

                                    JSONObject obj = arrayArticles.getJSONObject(i);


                            if(obj.getString("title").contains("조국")) {
                                NewsData newsData = new NewsData();

                                newsData.setTitle(obj.getString("title"));

                                //newsData.setUrlToImage(obj.getString("urlToImage"));

                                newsData.setContent(obj.getString("content"));

                                news.add(newsData);
                           }
                            }
                            // - response -> NewDATA CALSS 분류

                            //2 정보 -> 어뎁터
                            mAdapter = new MyAdapter(news, newsActivitybackup.this, new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.d("여기까지222 : ",  " " + "오옴");
                                       Object obj = v.getTag();
                                       if(obj !=null){
                                           int position =(int)obj;
                                           ((MyAdapter)mAdapter).getNews(position);

                                       }
                                }
                            });
                            mrecyclerView.setAdapter(mAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }




                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    private void loadNewsInfo(){
        // 파일의 내용을 읽어서 TextView 에 보여주기
        try {
            // 파일에서 읽은 데이터를 저장하기 위해서 만든 변수
            StringBuffer data = new StringBuffer();
            FileInputStream fis = openFileInput("myNewsList.txt");//파일명
            BufferedReader buffer = new BufferedReader
                    (new InputStreamReader(fis));
            String str = ""; // 파일에서 한줄을 읽어옴

            for (int k=0; str != null ;k++){
                str = buffer.readLine();
                if (!str.equals(null) && !str.equals("")) {
                    arrStr.add(str);
                }
            }
            buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
