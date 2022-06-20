package com.meishe.msvideoanalysis;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.zhihu.matisse.Matisse;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.engine.impl.GlideEngine;
import com.zhihu.matisse.internal.entity.CaptureStrategy;

import java.util.List;

public class MaterialSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_select);
        showMatisse();
    }

    private void showMatisse() {
        Matisse.from(this).choose(MimeType.ofVideo())
                /*用户选择数字是否自增*/
                .countable(true)
                /*最多选择的数量 最大可选计数。默认值为 1*/
                .maxSelectable(1)
                .capture(false)
                .gridExpectedSize(getResources().getDimensionPixelSize(R.dimen.dp190))
                .restrictOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED)
                /*照片缩略图的比例与视图的大小相比。它应该是 (0.0, 1.0] 中的浮点值。*/
                .thumbnailScale(1f)
                .imageEngine(new GlideEngine())
                .captureStrategy(new CaptureStrategy(true,"com.meishe.piccompres"))
                .showPreview(false)
                .forResult(Constants.REQUEST_CODE_CHOOSE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==Constants.REQUEST_CODE_CHOOSE&&resultCode== RESULT_OK){
            List<Uri> uris = Matisse.obtainResult(data);
            Log.d("lpf","uris.size()"+uris.size()+" uri:"+uris.get(0));
        }
    }
}