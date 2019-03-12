package com.example.lem.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.PermissionUtil;

public class MainActivity extends AppCompatActivity {
    private List<Pro> proList = new ArrayList<>();
    private final int REQUEST_CODE = 2;//请求码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //如果已经拥有权限
            if (PermissionUtil.isOwnPermisson(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Log.i("request", "down");
            } else {
                //没有改权限，需要进行请求
                Log.d("没有权限", "meiyouquanxian");
                PermissionUtil.requestPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, REQUEST_CODE);
            }
        } catch (Exception e) {
            Log.w("错误", e.getMessage());
        }

        //content_main

        initPro();
        Button btn1 = (Button) findViewById(R.id.btn_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pro proTest = new Pro();
                proTest.setName("apple" + new Date());
                proTest.setImageId(R.drawable.p_01);
                proList.add(proTest);
                System.out.println("是否储存成功" + proTest.save());

                System.out.println("读取");
                searchPro();

            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ProAdapter adapter = new ProAdapter(proList);
        recyclerView.setAdapter(adapter);
    }

    private void initPro() {
        proList = LitePal.findAll(Pro.class);
    }

    private void searchPro() {
        List<Pro> resultList = LitePal.findAll(Pro.class);
        System.out.println(resultList);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.i("request", "success");
                } else {
                    Log.i("request", "failed");
                }
            }
        }
    }
}
