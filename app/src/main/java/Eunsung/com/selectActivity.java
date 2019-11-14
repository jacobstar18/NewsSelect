package Eunsung.com;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdListener;
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
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


public class selectActivity extends FragmentActivity {

    private InterstitialAd mInterstitialAd;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9,checkBox10,
            checkBox11,checkBox12,checkBox13,checkBox14,checkBox15,checkBox16,checkBox17,checkBox18,checkBox19,checkBox20
            ,checkBox21,checkBox22,checkBox23,checkBox24,checkBox25,checkBox26 ,checkBox27,checkBox28 ,checkBox29,checkBox30
            ,checkBox31,checkBox32,checkBox33,checkBox34 ,checkBox35,checkBox36,checkBox37,checkBox38,checkBox39,checkBox40
            ,checkBox41,checkBox42,checkBox43,checkBox44 ,checkBox45,checkBox46,checkBox47,checkBox48,checkBox49 ,checkBox50
            ,checkBox51,checkBox52,checkBox53,checkBox54,checkBox55,checkBox56,checkBox57,checkBox58,checkBox59,checkBox60
            ,checkBox61,checkBox62,checkBox63,checkBox64,checkBox65,checkBox66,checkBox67
    ;


    Button close_btn, unckecked, allchecked, save_btn;
    private Button newButton;
    String[] NewsLists = new String[100];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.d("Start", "yeah!");

        setContentView(R.layout.activity_select_news);
        AdTogether();
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);
        checkBox9 = findViewById(R.id.checkBox9);
        checkBox10 = findViewById(R.id.checkBox10);
        checkBox11 = findViewById(R.id.checkBox11);
        checkBox12 = findViewById(R.id.checkBox12);
        checkBox13 = findViewById(R.id.checkBox13);
        checkBox14 = findViewById(R.id.checkBox14);
        checkBox15 = findViewById(R.id.checkBox15);
        checkBox16 = findViewById(R.id.checkBox16);
        checkBox17 = findViewById(R.id.checkBox17);
        checkBox18 = findViewById(R.id.checkBox18);
        checkBox19 = findViewById(R.id.checkBox19);
        checkBox20 = findViewById(R.id.checkBox20);
        checkBox21 = findViewById(R.id.checkBox21);
        checkBox22 = findViewById(R.id.checkBox22);
        checkBox23 = findViewById(R.id.checkBox23);
        checkBox24 = findViewById(R.id.checkBox24);
        checkBox25 = findViewById(R.id.checkBox25);
        checkBox26 = findViewById(R.id.checkBox26);
        checkBox27 = findViewById(R.id.checkBox27);
        checkBox28 = findViewById(R.id.checkBox28);
        checkBox29 = findViewById(R.id.checkBox29);
        checkBox30 = findViewById(R.id.checkBox30);
        checkBox31 = findViewById(R.id.checkBox31);
        checkBox32 = findViewById(R.id.checkBox32);
        checkBox33 = findViewById(R.id.checkBox33);
        checkBox34 = findViewById(R.id.checkBox34);
        checkBox35 = findViewById(R.id.checkBox35);
        checkBox36 = findViewById(R.id.checkBox36);
        checkBox37 = findViewById(R.id.checkBox37);
        checkBox38 = findViewById(R.id.checkBox38);
        checkBox39 = findViewById(R.id.checkBox39);
        checkBox40 = findViewById(R.id.checkBox40);
        checkBox41 = findViewById(R.id.checkBox41);
        checkBox42 = findViewById(R.id.checkBox42);
        checkBox43 = findViewById(R.id.checkBox43);
        checkBox44 = findViewById(R.id.checkBox44);
        checkBox45 = findViewById(R.id.checkBox45);
        checkBox46 = findViewById(R.id.checkBox46);
        checkBox47 = findViewById(R.id.checkBox47);
        checkBox48 = findViewById(R.id.checkBox48);
        checkBox49 = findViewById(R.id.checkBox49);
        checkBox50 = findViewById(R.id.checkBox50);
        checkBox51 = findViewById(R.id.checkBox51);
        checkBox52 = findViewById(R.id.checkBox52);
        checkBox53 = findViewById(R.id.checkBox53);
        checkBox54 = findViewById(R.id.checkBox54);
        checkBox55 = findViewById(R.id.checkBox55);
        checkBox56 = findViewById(R.id.checkBox56);
        checkBox57 = findViewById(R.id.checkBox57);
        checkBox58 = findViewById(R.id.checkBox58);
        checkBox59 = findViewById(R.id.checkBox59);
        checkBox60 = findViewById(R.id.checkBox60);
        checkBox60 = findViewById(R.id.checkBox60);
        checkBox61 = findViewById(R.id.checkBox61);
        checkBox62 = findViewById(R.id.checkBox62);
        checkBox63 = findViewById(R.id.checkBox63);
        checkBox64 = findViewById(R.id.checkBox64);
        checkBox65 = findViewById(R.id.checkBox65);
        checkBox66 = findViewById(R.id.checkBox66);
        checkBox67 = findViewById(R.id.checkBox67);

        loadChecking();

        save_btn = findViewById(R.id.save_btn);

            save_btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    try {
                        FileOutputStream fos = openFileOutput
                                ("myNewsList.txt", // 파일명 지정
                                        Context.MODE_PRIVATE);// 저장모드
                        PrintWriter out = new PrintWriter(fos);
                        if (checkBox1.isChecked()){out.println("dailian.co.kr\t데일리안");}
                        if (checkBox2.isChecked()){out.println("news.joins.com\t뉴스조인(중앙일보)");}
                        if (checkBox3.isChecked()){out.println("ohmynews.com\t오마이뉴스");}
                        if (checkBox4.isChecked()){out.println("sedaily.com\t서울경제");}
                        if (checkBox5.isChecked()){out.println("fnnews.com\t파이낸셜뉴스");}
                        if (checkBox6.isChecked()){out.println("tbs.seoul.kr\ttbs");}
                        if (checkBox7.isChecked()){out.println("newswhoplus.com\t뉴스후");}
                        if (checkBox8.isChecked()){out.println("hankyung.com\t한국경제");}
                        if (checkBox9.isChecked()){out.println("chosun.com\tTVCHOSUN");}
                        if (checkBox10.isChecked()){out.println("etoday.co.kr\t이투데이");}
                        if (checkBox11.isChecked()){out.println("slist.kr\tSINGL LIST");}
                        if (checkBox12.isChecked()){out.println("lawtimes.co.kr\t 법률신문");}
                        if (checkBox13.isChecked()){out.println("pressian.com\t프레시안");}
                        if (checkBox14.isChecked()){out.println("mbn.co.kr/\tMBN");}
                        if (checkBox15.isChecked()){out.println("segye.com/\t세계일보");}
                        if (checkBox16.isChecked()){out.println("anewsa.com\t아시아뉴스통신");}
                        if (checkBox17.isChecked()){out.println("news.mk.co.kr/\t매일경제");}
                        if (checkBox18.isChecked()){out.println("ytn.co.kr\tYTN");}
                        if (checkBox19.isChecked()){out.println("dt.co.kr/\t디지털타임스");}
                        if (checkBox20.isChecked()){out.println("nocutnews.co.kr\t노컷뉴스");}
                        if (checkBox21.isChecked()){out.println("mbn.mk.co.kr\tMBN");}
                        if (checkBox22.isChecked()){out.println("sisafocus.co.kr\t시사포커스");}
                        if (checkBox23.isChecked()){out.println("yna.kr/\t연합뉴스");}
                        if (checkBox24.isChecked()){out.println("g-enews.com\t글로벌이코노믹");}
                        if (checkBox25.isChecked()){out.println("theleader.mt.co.kr\tThe Leader");}
                        if (checkBox26.isChecked()){out.println("skyedaily.com\t스카이데일리");}
                        if (checkBox27.isChecked()){out.println("wowtv.co.kr\t한국경제TV");}
                        if (checkBox28.isChecked()){out.println("dtnews24.com\t디트NEWS24");}
                        if (checkBox29.isChecked()){out.println("joseilbo.com\t조세일보");}
                        if (checkBox30.isChecked()){out.println("ichannela.com\t채널에이");}
                        if (checkBox31.isChecked()){out.println("newsfreezone.co.kr\t뉴스프리존");}
                        if (checkBox32.isChecked()){out.println("newstomato.com\t뉴스토마토");}
                        if (checkBox33.isChecked()){out.println("newstnt.com\t뉴스티앤티");}
                        if (checkBox34.isChecked()){out.println("kukinews.com\t쿠키뉴스");}
                        if (checkBox35.isChecked()){out.println("speconomy.com/\t스페셜경제");}
                        if (checkBox36.isChecked()){out.println("newsis.com\t뉴시스");}
                        if (checkBox37.isChecked()){out.println("news.imaeil.com\t매일일보");}
                        if (checkBox38.isChecked()){out.println("news1.kr\tNews1");}
                        if (checkBox39.isChecked()){out.println("yonhapnewstv.co.kr\t연합뉴스TV");}
                        if (checkBox40.isChecked()){out.println("shinailbo.co.kr\t신아일보");}
                        if (checkBox41.isChecked()){out.println("news.sbs.co.kr\tSBS");}
                        if (checkBox42.isChecked()){out.println("news.mt.co.kr\t머니투데이");}
                        if (checkBox43.isChecked()){out.println("newspim.com\t뉴스핌");}
                        if (checkBox44.isChecked()){out.println("huffingtonpost.kr\t허프포스트");}
                        if (checkBox45.isChecked()){out.println("news.tf.co.kr\t더팩트");}
                        if (checkBox46.isChecked()){out.println("newscj.com\t천지일보");}
                        if (checkBox47.isChecked()){out.println("sisain.co.kr\t시사인");}
                        if (checkBox48.isChecked()){out.println("gukjenews.com\t국제뉴스");}
                        if (checkBox49.isChecked()){out.println("viewsnnews.com\t뷰스뉴스");}
                        if (checkBox50.isChecked()){out.println("sisajournal.com\t시사저널");}
                        if (checkBox51.isChecked()){out.println("asiatoday.co.kr\t아시아투데이");}
                        if (checkBox52.isChecked()){out.println("edaily.co.kr/\t이데일리");}
                        if (checkBox53.isChecked()){out.println("naeil.com\t내일일보");}
                        if (checkBox54.isChecked()){out.println("news.khan.co.kr\t경향신문");}
                        if (checkBox55.isChecked()){out.println("donga.com\t동아일보");}
                        if (checkBox56.isChecked()){out.println("news.heraldcorp.com\t헤럴드");}
                        if (checkBox57.isChecked()){out.println("asiae.co.krr\t아시아경제");}
                        if (checkBox58.isChecked()){out.println("kwnews.co.kr\t케이더블유뉴스");}
                        if (checkBox59.isChecked()){out.println("news.kmib.co.kr\t국민일보");}
                        if (checkBox60.isChecked()){out.println("mediatoday.co.kr\t미디어투데이");}
                        if (checkBox61.isChecked()){out.println("seoul.co.kr\t서울신문");}
                        if (checkBox62.isChecked()){out.println("hankookilbo.com\t한국일보");}
                        if (checkBox63.isChecked()){out.println("hani.co.kr\t한겨레");}
                        if (checkBox64.isChecked()){out.println("imnews.imbc.com\tMBC");}
                        if (checkBox65.isChecked()){out.println("news.kbs.co.kr\tKBS");}
                        if (checkBox66.isChecked()){out.println("jbnews.com\t중부매일");}
                        if (checkBox67.isChecked()){out.println("munhwa.com\t문화일보");}

                        out.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });


        close_btn = findViewById(R.id.close_btn);
        close_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        unckecked = findViewById(R.id.unckecked);
        unckecked.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkBoxSetting(false);
            }
        });

        allchecked = findViewById(R.id.allchecked);
        allchecked.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkBoxSetting(true);
            }
        });


    }

    private void loadChecking() {
            // 파일의 내용을 읽어서 TextView 에 보여주기
            try {
                // 파일에서 읽은 데이터를 저장하기 위해서 만든 변수
                StringBuffer data = new StringBuffer();
                FileInputStream fis = openFileInput("myNewsList.txt");//파일명
                BufferedReader buffer = new BufferedReader
                        (new InputStreamReader(fis));
                String str = ""; // 파일에서 한줄을 읽어옴
                checkBoxSetting(false);
                for (int k=0; str != null ;k++){
                    str = buffer.readLine();
                    if (!str.equals(null) && !str.equals("")) {
                        if(str.contains("데일리안")){checkBox1.setChecked(true);}
                        if(str.contains("중앙일보")){checkBox2.setChecked(true);}
                        if(str.contains("오마이뉴스")){checkBox3.setChecked(true);}
                        if(str.contains("서울경제")){checkBox4.setChecked(true);}
                        if(str.contains("파이낸셜뉴스")){checkBox5.setChecked(true);}
                        if(str.contains("tbs")){checkBox6.setChecked(true);}
                        if(str.contains("뉴스후")){checkBox7.setChecked(true);}
                        if(str.contains("한국경제")){checkBox8.setChecked(true);}
                        if(str.contains("TVCHOSUN")){checkBox9.setChecked(true);}
                        if(str.contains("이투데이")){checkBox10.setChecked(true);}
                        if(str.contains("SINGL LIST")){checkBox11.setChecked(true);}
                        if(str.contains(" 법률신문")){checkBox12.setChecked(true);}
                        if(str.contains("프레시안")){checkBox13.setChecked(true);}
                        if(str.contains("MBN")){checkBox14.setChecked(true);}
                        if(str.contains("세계일보")){checkBox15.setChecked(true);}
                        if(str.contains("아시아뉴스통신")){checkBox16.setChecked(true);}
                        if(str.contains("매일경제")){checkBox17.setChecked(true);}
                        if(str.contains("YTN")){checkBox18.setChecked(true);}
                        if(str.contains("디지털타임스")){checkBox19.setChecked(true);}
                        if(str.contains("노컷뉴스")){checkBox20.setChecked(true);}
                        if(str.contains("MBN")){checkBox21.setChecked(true);}
                        if(str.contains("시사포커스")){checkBox22.setChecked(true);}
                        if(str.contains("연합뉴스")){checkBox23.setChecked(true);}
                        if(str.contains("글로벌이코노믹")){checkBox24.setChecked(true);}
                        if(str.contains("The Leader")){checkBox25.setChecked(true);}
                        if(str.contains("스카이데일리")){checkBox26.setChecked(true);}
                        if(str.contains("한국경제TV")){checkBox27.setChecked(true);}
                        if(str.contains("디트NEWS24")){checkBox28.setChecked(true);}
                        if(str.contains("조세일보")){checkBox29.setChecked(true);}
                        if(str.contains("채널에이")){checkBox30.setChecked(true);}
                        if(str.contains("뉴스프리존")){checkBox31.setChecked(true);}
                        if(str.contains("뉴스토마토")){checkBox32.setChecked(true);}
                        if(str.contains("뉴스티앤티")){checkBox33.setChecked(true);}
                        if(str.contains("쿠키뉴스")){checkBox34.setChecked(true);}
                        if(str.contains("스페셜경제")){checkBox35.setChecked(true);}
                        if(str.contains("뉴시스")){checkBox36.setChecked(true);}
                        if(str.contains("매일일보")){checkBox37.setChecked(true);}
                        if(str.contains("News1")){checkBox38.setChecked(true);}
                        if(str.contains("연합뉴스TV")){checkBox39.setChecked(true);}
                        if(str.contains("신아일보")){checkBox40.setChecked(true);}
                        if(str.contains("SBS")){checkBox41.setChecked(true);}
                        if(str.contains("머니투데이")){checkBox42.setChecked(true);}
                        if(str.contains("뉴스핌")){checkBox43.setChecked(true);}
                        if(str.contains("허프포스트")){checkBox44.setChecked(true);}
                        if(str.contains("더팩트")){checkBox45.setChecked(true);}
                        if(str.contains("천지일보")){checkBox46.setChecked(true);}
                        if(str.contains("시사인")){checkBox47.setChecked(true);}
                        if(str.contains("국제뉴스")){checkBox48.setChecked(true);}
                        if(str.contains("뷰스뉴스")){checkBox49.setChecked(true);}
                        if(str.contains("시사저널")){checkBox50.setChecked(true);}
                        if(str.contains("아시아투데이")){checkBox51.setChecked(true);}
                        if(str.contains("이데일리")){checkBox52.setChecked(true);}
                        if(str.contains("내일일보")){checkBox53.setChecked(true);}
                        if(str.contains("경향신문")){checkBox54.setChecked(true);}


                        if(str.contains("동아일보")){checkBox55.setChecked(true);}
                        if(str.contains("헤럴드")){checkBox56.setChecked(true);}
                        if(str.contains("아시아경제")){checkBox57.setChecked(true);}
                        if(str.contains("케이더블유뉴스")){checkBox58.setChecked(true);}
                        if(str.contains("국민일보")){checkBox59.setChecked(true);}
                        if(str.contains("미디어투데이")){checkBox60.setChecked(true);}
                        if(str.contains("서울신문")){checkBox61.setChecked(true);}
                        if(str.contains("한국일보")){checkBox62.setChecked(true);}
                        if(str.contains("한겨레")){checkBox63.setChecked(true);}
                        if(str.contains("MBC")){checkBox64.setChecked(true);}
                        if(str.contains("KBS")){checkBox65.setChecked(true);}
                        if(str.contains("중부매일")){checkBox66.setChecked(true);}
                        if(str.contains("문화일보")){checkBox67.setChecked(true);}
                    }
                }
                buffer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    private void checkBoxSetting(boolean checked) {

        checkBox1.setChecked(checked);
        checkBox2.setChecked(checked);
        checkBox3.setChecked(checked);
        checkBox4.setChecked(checked);
        checkBox5.setChecked(checked);
        checkBox6.setChecked(checked);
        checkBox7.setChecked(checked);
        checkBox8.setChecked(checked);
        checkBox9.setChecked(checked);
        checkBox10.setChecked(checked);
        checkBox11.setChecked(checked);
        checkBox12.setChecked(checked);
        checkBox13.setChecked(checked);
        checkBox14.setChecked(checked);
        checkBox15.setChecked(checked);
        checkBox16.setChecked(checked);
        checkBox17.setChecked(checked);
        checkBox18.setChecked(checked);
        checkBox19.setChecked(checked);
        checkBox20.setChecked(checked);
        checkBox21.setChecked(checked);
        checkBox22.setChecked(checked);
        checkBox23.setChecked(checked);
        checkBox24.setChecked(checked);
        checkBox25.setChecked(checked);
        checkBox26.setChecked(checked);
        checkBox27.setChecked(checked);
        checkBox28.setChecked(checked);
        checkBox29.setChecked(checked);
        checkBox30.setChecked(checked);
        checkBox31.setChecked(checked);
        checkBox32.setChecked(checked);
        checkBox33.setChecked(checked);
        checkBox34.setChecked(checked);
        checkBox35.setChecked(checked);
        checkBox36.setChecked(checked);
        checkBox37.setChecked(checked);
        checkBox38.setChecked(checked);
        checkBox39.setChecked(checked);
        checkBox40.setChecked(checked);
        checkBox41.setChecked(checked);
        checkBox42.setChecked(checked);
        checkBox43.setChecked(checked);
        checkBox44.setChecked(checked);
        checkBox45.setChecked(checked);
        checkBox46.setChecked(checked);
        checkBox47.setChecked(checked);
        checkBox48.setChecked(checked);
        checkBox49.setChecked(checked);
        checkBox50.setChecked(checked);
        checkBox51.setChecked(checked);
        checkBox52.setChecked(checked);
        checkBox53.setChecked(checked);
        checkBox54.setChecked(checked);
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





}
