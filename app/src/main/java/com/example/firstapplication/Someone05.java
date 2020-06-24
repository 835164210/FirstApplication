package com.example.firstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Someone05 extends AppCompatActivity {
 WebView forbesPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_someone05);
        //variables
        forbesPage = (WebView) findViewById(R.id.forbes_category);
        webpage();//is this the best way to set a page based on previous values?
    }

    public void webpage(){
        //Display webpage based on user's choice: Industry related to their dream
        SharedPreferences npreferences = getSharedPreferences("WHO", MODE_PRIVATE);
        int choice = npreferences.getInt("categoryd",0);;
        forbesPage.setWebViewClient(new WebViewClient());

        switch (choice) {
            case 0:
                //Automotive
                forbesPage.loadUrl("https://www.forbes.com/profile/elon-musk/?list=forbes-400");

                break;
            case 1:
                //Construction & Engineering
                forbesPage.loadUrl("https://www.forbes.com/profile/diane-hendricks/?list=forbes-400");
                break;
            case 2:
                //Diversified
                forbesPage.loadUrl("https://www.forbes.com/profile/charles-koch/?list=forbes-400");
                break;
            case 3:
                //Energy
                forbesPage.loadUrl("https://www.forbes.com/profile/harold-hamm/?list=forbes-400");
                break;
            case 4:
                //Fashion & Retail
                forbesPage.loadUrl("https://www.forbes.com/profile/jim-walton/?list=forbes-400");

                break;
            case 5:
                //Food and Beverage
                forbesPage.loadUrl("https://www.forbes.com/profile/jacqueline-mars/?list=forbes-400");
                break;

            case 6:
                //Finance & Investments
                forbesPage.loadUrl("https://www.forbes.com/profile/sheldon-adelson/?list=forbes-400");
                break;

            case 7:
                //Gambling & Casinos
                forbesPage.loadUrl("https://www.forbes.com/profile/sheldon-adelson/?list=forbes-400");
                break;
            case 8:
                //Healthcare
                forbesPage.loadUrl("https://www.forbes.com/profile/thomas-frist-jr/?list=forbes-400");
                break;
            case 9:
                //Logistics
                forbesPage.loadUrl("https://www.forbes.com/profile/dennis-washington/?list=forbes-400");

                break;

            case 10:
                //Manufacturing
                forbesPage.loadUrl("https://www.forbes.com/profile/herbert-kohler-jr/?list=forbes-400");
                break;

            case 11:
                //Media and Entertainment
                forbesPage.loadUrl("https://www.forbes.com/profile/michael-bloomberg/?list=forbes-400");
                break;

            case 12:
                //Real State
                forbesPage.loadUrl("https://www.forbes.com/profile/donald-bren/?list=forbes-400");
                break;

            case 13:
                //Service
                forbesPage.loadUrl("https://www.forbes.com/profile/micky-arison/?list=forbes-400");

                break;
            case 14:
                //Sports
                forbesPage.loadUrl("https://www.forbes.com/profile/arthur-blank/?list=forbes-400");
                break;
            case 15:
                //Technology
                forbesPage.loadUrl("https://www.forbes.com/profile/larry-ellison/?list=forbes-400");
                break;
            case 16:
                //Telecom
                forbesPage.loadUrl("https://www.forbes.com/profile/rocco-commisso/?list=forbes-400");
                break;
        }


    }
    //Next Activity
    public void openActivity(View view) {
        Intent intent = new Intent(this, Menu03.class);
        startActivity(intent);
        finish();//no return
    }
}
