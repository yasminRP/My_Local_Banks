package sg.edu.rp.c346.id22026024.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDBS;
    Button btnOCBC;
    Button btnUOB;

    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDBS = findViewById(R.id.buttonDBS);
        btnOCBC = findViewById(R.id.buttonOCBC);
        btnUOB = findViewById(R.id.buttonUOB);

        registerForContextMenu(btnDBS);
        registerForContextMenu(btnOCBC);
        registerForContextMenu(btnUOB);


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //…
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            //item.getItemId().setText("Hello ");
            btnDBS.setText("DBS English");
            btnOCBC.setText("OCBC English");
            btnUOB.setText("UOB English");

            return true;
        } else if (id == R.id.MalaySelection) {
            // tvTranslatedText.setText("Ciao");
            btnDBS.setText("DBS Malay");
            btnOCBC.setText("OCBC Malay");
            btnUOB.setText("UOB Malay");
            return true;
        } else {
            //tvTranslatedText.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (btnDBS.isActivated() == true) {
            if (item.getItemId() == 0) {
                url = "https://www.dbs.com.sg";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " +18001111111));
                startActivity(intentCall);

            }

        } else if (btnOCBC.isActivated() == true) {
            if (item.getItemId() == 0) {
                url = "https://www.ocbc.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " +18003633333));
                startActivity(intentCall);

            }
        } else if (btnUOB.isActivated() == true) {
            if (item.getItemId() == 0) {
                url = "https://www.uobgroup.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);

            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " +18002222121));
                startActivity(intentCall);

            }


        }
        return super.onContextItemSelected(item);
    }
}



