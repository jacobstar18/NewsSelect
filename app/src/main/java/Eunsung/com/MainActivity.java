package Eunsung.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity {
    EditText EditTextEmail,EditPassword ;
    Button TextButton, LottoButton, LinkButton;
    private TextView textView;
    private InterstitialAd mInterstitialAd;
    private Button scaleBtn ;
    ImageView iv, cookiePic;
    ArrayList WinNumber = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        AdTogether();

        //Interstitial Ad
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1420948259689687/5213683523");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        //Interstitial Ad
        // LOG EXAMPLE

        iv = (ImageView)findViewById(R.id.cookiePic);
        iv.setOnClickListener(new MyListener());



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


    class MyListener implements View.OnClickListener {


        @Override
        public void onClick(View v) {

            //Interstitial Ad

            Intent intent = new Intent(MainActivity.this,  newsActivity.class);

            // 1개 추출하고

        //    Collections.shuffle(WinNumber);

        //   String get_string = (String) WinNumber.get(0);
       //     intent.putExtra("getString", get_string);
            startActivity(intent);

        } // end onClick


    } // end MyListener()



    public void searchNaver(final String searchObject) { // 검색어 = searchObject로 ;
        final String clientId = "EMDmdlzofwv0_tyE3SmA";//애플리케이션 클라이언트 아이디값";
        final String clientSecret = "aD4knYwaN7";//애플리케이션 클라이언트 시크릿값";
        final int display = 50; // 보여지는 검색결과의 수
        // 네트워크 연결은 Thread 생성 필요
        new Thread() {

            @Override
            public void run() {
                int count =0;
                try {
                    String text = URLEncoder.encode(searchObject, "UTF-8");
                    String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text + "&display=" + display + "&"; // json 결과
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
                        count++;
                    }
                    br.close();
                    con.disconnect();

                    String data = searchResult.toString();
                    String[] array;
                    array = data.split("\"");
                    String[] title = new String[display];
                    String[] link = new String[display];
                    String[] description = new String[display];
                    String[] bloggername = new String[display];
                    String[] postdate = new String[display];

                    int k = 0;
                    for (int i = 0; i < array.length; i++) {
                        if (array[i].equals("title"))
                            title[k] = array[i + 2];
                        if (array[i].equals("link"))
                            link[k] = array[i + 2];
                        if (array[i].equals("description"))
                            description[k] = array[i + 2];
                        if (array[i].equals("bloggername"))
                            bloggername[k] = array[i + 2];
                        if (array[i].equals("postdate")) {
                            postdate[k] = array[i + 2];
                            k++;
                        }
                    }

                    // title[0], link[0], bloggername[0] 등 인덱스 값에 맞게 검색결과를 변수화하였다.

                } catch (Exception e) {
                }

            }
        }.start();

    }



}
