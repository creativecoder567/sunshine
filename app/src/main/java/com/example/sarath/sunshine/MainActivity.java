package com.example.sarath.sunshine;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    ImageView imageView;
    int finalHeight, finalWidth;
    private TextView tvHeight,tvWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) this.findViewById(R.id.ivPhoto);

        tvHeight =(TextView) findViewById(R.id.tvHeight);
        tvWidth = (TextView)findViewById(R.id.tvWidth);
        Button photoButton = (Button) this.findViewById(R.id.btnTakePhoto);

        photoButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });




        final ImageView iv = (ImageView)findViewById(R.id.ivPhoto);
        //final TextView tv = (TextView)findViewById(R.id.size_label);
        ViewTreeObserver vto = iv.getViewTreeObserver();
        vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                iv.getViewTreeObserver().removeOnPreDrawListener(this);

                finalHeight = iv.getMeasuredHeight();
                finalWidth = iv.getMeasuredWidth();

                Log.i("sarath","Height: " + finalHeight + " Width: " + finalWidth);

                tvHeight.setText(String.valueOf(finalHeight));
                tvWidth.setText(String.valueOf(finalWidth));

                return true;
            }
        });
    }
    protected void onActivityResult(int requestcode,int resultcode,Intent data){
        if(requestcode==CAMERA_REQUEST){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}

