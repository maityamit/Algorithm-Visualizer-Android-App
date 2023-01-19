package algorithmbyamit.amit.algorithmbyamitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.concurrent.TimeUnit;

public class SortingPlayActivity extends AppCompatActivity {

    Button[] bttn = new Button[8];
    int[] arr = {5,3,7,8,1,12,9,5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorting_play);


        for(int j=0;j<8;j++) {
                bttn[j] = new Button(this);
                bttn[j].setLayoutParams (new LinearLayout.LayoutParams(100, LinearLayout.LayoutParams.WRAP_CONTENT));
                bttn[j].setText(String.valueOf(arr[j]));
                bttn[j].setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
                bttn[j].setTextColor(Color.parseColor("#a8a8a8"));
                bttn[j].setBackgroundColor(Color.WHITE);
        }

        LinearLayout linear = (LinearLayout)findViewById(R.id.sorting_array_layout);
        linear.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params2.gravity = Gravity.CENTER;
        linear.setLayoutParams(params2);


        for(int j=0;j<8;j++){
            linear.addView(bttn[j]);
        }

        late(arr.length);


    }

    private void late(int n){
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after
                bubbleSort(n);


            }
        }, 1500);
    }

    void bubbleSort(int n)
    {
        // Base case
        if (n == 1)
            return;

        final int[] count = {0};
        // One pass of bubble sort. After
        // this pass, the largest element
        // is moved (or bubbled) to end.
        for (int i=0; i<n-1; i++) {

            final Handler handler = new Handler(Looper.getMainLooper());
            int finalI = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do something after
                    bttn[finalI].setBackgroundColor(Color.parseColor("#deffe7"));


                    if (arr[finalI] > arr[finalI + 1]) {

                        // swap arr[i], arr[i+1]
                        int temp = arr[finalI];
                        bttn[finalI].setText(String.valueOf(arr[finalI + 1]));
                        bttn[finalI].setTextColor(Color.parseColor("#FF283593"));
                        arr[finalI] = arr[finalI + 1];
                        arr[finalI + 1] = temp;
                        bttn[finalI + 1].setText(String.valueOf(temp));
                        bttn[finalI + 1].setTextColor(Color.parseColor("#FF283593"));

                        count[0] = count[0] +1;

                    }

                }
            }, 1500);



        }

        // Check if any recursion happens or not
        // If any recursion is not happen then return
        if (count[0] == 0)
            return;

        // Largest element is fixed,
        // recur for remaining array
        late(n-1);
    }

    private void swap() {

        int cnt = 0;

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after


            }
        }, 1500);



    }

}