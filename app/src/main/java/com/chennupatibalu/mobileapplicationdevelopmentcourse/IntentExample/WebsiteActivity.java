package com.chennupatibalu.mobileapplicationdevelopmentcourse.IntentExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.chennupatibalu.mobileapplicationdevelopmentcourse.R;

import java.util.ArrayList;
import java.util.List;

public class WebsiteActivity extends AppCompatActivity {

    private EditText urlEditText;
    private Button goButton;
    private List<String> domainList;
    private String[] domains;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        urlEditText = findViewById(R.id.urlEditText);
        goButton = findViewById(R.id.goButton);
        domainList = new ArrayList<>();

        domains = new String[]{".com",".in",".uk",".us",".org",".net"};
        for(String d:domains)
            domainList.add(d);
    }

    public void goToWebsite(View view) {
        String defaultDomain = ".com";
        String urlText = urlEditText.getText().toString();
        String domain = checkDomain(urlText);   //Checks the domain in the URL assigns to the variable

        String webUrl = "https://"+urlText;
        String url = "https://www.";
        String nameUrl = url+urlText+defaultDomain;
        Log.d("website", "goToWebsite: "+nameUrl);

        //Checks the URL whether it is in the form "www.website.domain"
        //Example: "www.google.com"
        if(urlText.startsWith("www.") && !urlText.startsWith("https://") && urlText.endsWith(domain))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(webUrl)));
        }

        //Checks the URL whether it is in the form "https://www.website.domain"
        //Example: "https://www.google.com"
        if(urlText.startsWith("https://") && urlText.contains("www.") && urlText.endsWith(domain))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(urlText)));
        }

        //Checks the URL whether it is in the form "website.domain"
        //Example: "google.com"
        if(!urlText.startsWith("https://") && !urlText.contains("www.") && urlText.endsWith(domain))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url+urlText)));
        }

        //Checks the URL whether it is in the form "website"
        //Example: "google"
        if(!urlText.startsWith("https://") && !urlText.contains("www.") && !urlText.endsWith(domain))
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(nameUrl)));
        }
    }
    private String checkDomain(String url)
    {
        String domain = url.substring(url.lastIndexOf("."));
        for(int i=0;i<domainList.size();i++)
        {
            if(domain.equals(domainList.get(i)))
            {
                return domainList.get(i);
            }
        }
        return null;
    }
}