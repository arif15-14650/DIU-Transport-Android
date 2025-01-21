package com.example.anproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    TextView myTextView, gitView, faciView, comView, vsView, caView;
    ImageView myImageView, gitImage, faciImage, comImage, vsImage, caImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_id);
        toolbar = findViewById(R.id.toolbar);

        myTextView = findViewById(R.id.glID);
        gitView = findViewById(R.id.gitID);
        faciView = findViewById(R.id.facID);
        comView = findViewById(R.id.comID);
        vsView = findViewById(R.id.vsID);
        caView = findViewById(R.id.caID);
        caImage = findViewById(R.id.createID);
        vsImage = findViewById(R.id.schedule);
        comImage = findViewById(R.id.community);
        faciImage = findViewById(R.id.facilities);
        gitImage = findViewById(R.id.gettouch);
        myImageView = findViewById(R.id.guideline);
        myTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, glActivity2.class);
                startActivity(myIntent);
            }
        });
        myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, glActivity2.class);
                startActivity(myIntent);
            }
        });

        gitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, gitActivity3.class);
                startActivity(myIntent);
            }
        });

        gitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, gitActivity3.class);
                startActivity(myIntent);
            }
        });

        faciView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, facilitiesActivity4.class);
                startActivity(myIntent);
            }
        });
        faciImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, facilitiesActivity4.class);
                startActivity(myIntent);
            }
        });

        comView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, communityActivity5.class);
                startActivity(myIntent);
            }
        });

        comImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, communityActivity5.class);
                startActivity(myIntent);
            }
        });

        vsView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, vsActivity6.class);
                startActivity(myIntent);
            }
        });

        vsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, vsActivity6.class);
                startActivity(myIntent);
            }
        });

        caView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, regActivity.class);
                startActivity(myIntent);
            }
        });

        caImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, regActivity.class);
                startActivity(myIntent);
            }
        });

        setSupportActionBar(toolbar);
        //menu

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation item clicks here using if-else
                int itemId = item.getItemId();
                if (itemId == R.id.nav_notice) {
                    Intent noticeIntent = new Intent(MainActivity.this, notice.class);
                    startActivity(noticeIntent);
                    return true;
                } else if (itemId == R.id.nav_sportal) {
                    Intent portalIntent = new Intent(MainActivity.this, studentPortal.class);
                    startActivity(portalIntent);
                    return true;
                } else if (itemId == R.id.nav_request) {
                    Intent applyIntent = new Intent(MainActivity.this, CardApplyActivity.class);
                    startActivity(applyIntent);
                    return true;
                } else if (itemId == R.id.nav_verification) {
                    Intent verifyIntent = new Intent(MainActivity.this, VerifyCard.class);
                    startActivity(verifyIntent);
                    return true;
                } else if (itemId == R.id.nav_login) {
                    // Handle the "Login" item click
                    Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                    return true;
                } else if (itemId == R.id.nav_profile) {
                    // Handle the "Profile" item click
                    return true;
                } else if (itemId == R.id.nav_logout) {
                    // Handle the "Logout" item click
                    return true;
                } else if (itemId == R.id.nav_email) {
                    // Handle the "E-mail" item click
                    return true;
                } else if (itemId == R.id.nav_phone) {
                    // Handle the "Call" item click
                    return true;
                } else {
                    // Handle the default case
                    return false;
                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
