package algorithmbyamit.amit.algorithmbyamitapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button[][] bttn = new Button[8][8];
    Boolean[][] vis = new Boolean[8][8];

    int mat[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 1, 0, 1, 1},
            {1, 2, 2, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 0, 1, 0},
            {1, 1, 1, 2, 2, 2, 2, 0},
            {1, 1, 1, 1, 1, 2, 1, 1},
            {1, 1, 1, 1, 1, 2, 2, 1},
    };

    int sr = 4, sc = 4, color = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                vis[i][j]=false;
            }
        }


        for(int j=0;j<8;j++) {
            for(int i=0;i<8;i++){
                bttn[j][i] = new Button(this);
                bttn[j][i].setLayoutParams (new LinearLayout.LayoutParams(100, LinearLayout.LayoutParams.WRAP_CONTENT));
                bttn[j][i].setText(String.valueOf(mat[i][j]));
                bttn[j][i].setTextSize(TypedValue.COMPLEX_UNIT_PX, 40);
                bttn[j][i].setTextColor(Color.parseColor("#a8a8a8"));
                bttn[j][i].setBackgroundColor(Color.WHITE);
            }
        }




        LinearLayout linear = (LinearLayout)findViewById(R.id.buttonlayout);
        linear.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params2.gravity = Gravity.CENTER;
        linear.setLayoutParams(params2);


        for(int j=0;j<8;j++){

            LinearLayout layout2 = new LinearLayout(MainActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, 100);
            layout2.setLayoutParams(params);
            for (int i = 0; i < 8; i++) {
                layout2.addView(bttn[j][i]);
            }
            linear.addView(layout2);

        }

    }


    private void late(int sr, int sc, int[][] mat, int color, Boolean[][] vis, int i){
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after


                dfs(sr,sc,mat,color,vis,i);


            }
        }, 1500);
    }

    private void dfs(int sr, int sc, int[][] mat, int color, Boolean[][] vis, int i) {

        vis[sr][sc]=true;
        mat[sr][sc]=color;
        bttn[sr][sc].setText(String.valueOf(color));
        bttn[sr][sc].setTextColor(Color.parseColor("#FF283593"));



        int[] delRow ={-1,0,+1,0};
        int[] delCol ={0,+1,0,-1};

        for(int p=0;p<4;p++){
            int nrow=sr+delRow[p];
            int ncol=sc+delCol[p];

            if(nrow>=0&&nrow<8&&ncol>=0&&ncol<8&&!vis[nrow][ncol]){
                bttn[nrow][ncol].setBackgroundColor(Color.parseColor("#deffe7"));
            }


            if(nrow>=0&&nrow<8&&ncol>=0&&ncol<8
                    &&mat[nrow][ncol]==i&&!vis[nrow][ncol]){
                late(nrow,ncol,mat,color,vis,i);
            }
        }



    }

    public void Start(View view) {
        late(sr,sc,mat,color,vis,mat[sr][sc]);
        bttn[sr][sc].setBackgroundColor(Color.parseColor("#deffe7"));
    }
}