package smarteq.whatsappsmartguide;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayAdapter<String> arrayAdapter2;
    private ArrayAdapter<String> arrayAdapter3;
    private int detail = 0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    detail = 0;
                    listView.setAdapter(arrayAdapter);
                    listView.requestLayout();
                    return true;
                case R.id.navigation_dashboard:
                    detail = 1;
                    listView.setAdapter(arrayAdapter2);
                    listView.requestLayout();
                    return true;
                case R.id.navigation_notifications:
                    detail = 2;
                    listView.setAdapter(arrayAdapter3);
                    listView.requestLayout();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, getResources().getStringArray(R.array.Hidden_Features_Title));
        arrayAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, getResources().getStringArray(R.array.New_Update_Title));
        arrayAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, getResources().getStringArray(R.array.Video_Title));
        listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(this);

        Locale locale = new Locale("ru");
        Locale.setDefault(locale);
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra("detail", detail);
        intent.putExtra("detail_number", i);
        startActivity(intent);
    }
}
