package com.azheng.icongeneratedemo

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import com.blankj.utilcode.util.ImageUtils
import com.blankj.utilcode.util.ToastUtils
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener {
            setImage()
        }

    }

    private fun setImage() {
        val usdtImage = findViewById<IconImageView>(R.id.usdtImage)
        lifecycleScope.launch {
            val mBitmap = ImageUtils.view2Bitmap(usdtImage)
            val mFile = ImageUtils.save2Album(mBitmap, Bitmap.CompressFormat.PNG, 100)
            mFile?.let {
                mBitmap?.recycle()
                ToastUtils.showLong("保存成功")
            }
        }
    }

}