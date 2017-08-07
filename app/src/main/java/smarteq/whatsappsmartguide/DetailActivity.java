package smarteq.whatsappsmartguide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView textView_detail = (TextView) findViewById(R.id.textView_detail);

        Bundle extras = getIntent().getExtras();
        int detail = extras.getInt("detail");
        int detail_number = extras.getInt("detail_number");
        String text = "";

        switch (detail) {
            case 0:
                text = getResources().getStringArray(R.array.Hidden_Features_Desc)[detail_number];
                break;
            case 1:
                text = getResources().getStringArray(R.array.New_Update_Desc)[detail_number];
                break;
            case 2:
                text = getResources().getStringArray(R.array.Video_Url)[detail_number];
                break;
        }

        textView_detail.setText(text);
    }
}
