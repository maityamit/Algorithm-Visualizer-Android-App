package algorithmbyamit.amit.algorithmbyamitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class SortingPlayActivity extends AppCompatActivity {

    private LinearLayout linearLayout;
    private int[] arr = {5, 1, 12, -5, 16, 2, 12, 14};
    private int i = 0, j = 0,min_idx = 0;
    private TextView textView;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorting_play);



        linearLayout = findViewById(R.id.linearLayout);
        textView = findViewById(R.id.textView);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bubbleSort();
            }
        });




    }


    private void selection(){
        if (i < arr.length - 1) {
            if (j < arr.length - i - 1) {
                min_idx = j;
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[k] < arr[min_idx]) {
                        min_idx = k;
                    }
                }
                int temp = arr[min_idx];
                arr[min_idx] = arr[j];
                arr[j] = temp;
                j++;
            } else {
                i++;
                j = i;
            }
            textView.setText(Arrays.toString(arr));
            displayBars();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    selection();
                }
            }, 500); // 500 milliseconds delay
        }
    }

    private void bubbleSort() {
        if (j < arr.length - i - 1) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
            j++;
            displayBars();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    bubbleSort();
                }
            }, 500);
        } else {
            j = 0;
            i++;
            if (i < arr.length) {
                bubbleSort();
            } else {
                button.setEnabled(false);
            }
        }
    }

    private void displayBars() {
        linearLayout.removeAllViews();
        for (int k = 0; k < arr.length; k++) {
            TextView textView = new TextView(this);
            textView.setText(arr[k] + "");
            textView.setTextSize(20);
            textView.setPadding(10, 10, 10, 10);
            if (k == j || k == j + 1) {
                textView.setBackgroundColor(Color.YELLOW);
            } else {
                textView.setBackgroundColor(Color.WHITE);
            }
            linearLayout.addView(textView);
        }
        textView.setText(Arrays.toString(arr));
    }



}