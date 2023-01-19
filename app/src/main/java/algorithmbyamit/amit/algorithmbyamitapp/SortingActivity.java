package algorithmbyamit.amit.algorithmbyamitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SortingActivity extends AppCompatActivity {


    LinearLayout buuble_sort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorting);

        buuble_sort = findViewById(R.id.buuble_sort);
        buuble_sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SortingActivity.this,SortingPlayActivity.class);
                startActivity(intent);
            }
        });
    }
}