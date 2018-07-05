package com.acadview.asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button imagebutton,toastbutton;
    ImageView imageView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagebutton = findViewById(R.id.imagebutton);
        toastbutton = findViewById(R.id.toastbutton);
        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);

        //toast

        toastbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "iam in toast", Toast.LENGTH_SHORT).show();
            }
        });

        //image button click


        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                loadImage();
                new LoadiconTask().execute(R.drawable.shaun);
            }
        });
    }


        class LoadiconTask extends AsyncTask<Integer, Integer, Bitmap> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                progressBar.setVisibility(progressBar.VISIBLE);
            }

            @Override
            protected Bitmap doInBackground(Integer... integers) {

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.shaun);
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                imageView.setImageBitmap(bitmap);
                progressBar.setVisibility(progressBar.INVISIBLE);
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
                progressBar.setProgress(0);
            }
        }
    }


//    private void loadImage() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.shaun);
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        imageView.setImageBitmap(bitmap);
//                    }
//                });
//
//
//                }
//        }).start();
//
//    }



