package com.apptoko.app.ui.surah

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.apptoko.app.R
import com.apptoko.app.data.model.Surah
import com.apptoko.app.databinding.ItemSurahBinding
import com.apptoko.app.ui.base.BaseAdapter
import com.bumptech.glide.Glide

class SurahAdapter(val context: Context) : BaseAdapter<Surah>(R.layout.item_surah) {
    override fun onBind(binding: ViewDataBinding?, data: Surah) {
        val mBinding = binding as ItemSurahBinding
        Glide.with(context).load(data.audio).into(mBinding.itemAudio)
    }

    override fun onClick(binding: ViewDataBinding?, data: Surah) {
        val intent = Intent(context, SurahActivity::class.java)
        intent.putExtra(SurahActivity.OPEN_SURAH, data)
        context.startActivity(intent)
    }
}

