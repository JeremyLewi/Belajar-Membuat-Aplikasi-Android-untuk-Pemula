package com.example.submissionakhir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.submissionakhir.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Car>("DATA")


        binding.tvItemName.text = data?.name
        binding.tvItemDescription.text = data?.description
        binding.tvManufactureName.text = data?.manufacture
        binding.tvProductionDetail.text = data?.production
        Glide.with(this)
            .load(data?.photo)
            .into(binding.imgItemPhoto)

        binding.actionShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_SUBJECT, "Sharing ${data?.name}")
            intent.putExtra(Intent.EXTRA_TEXT, "${data?.description}")
            startActivity(Intent.createChooser(intent, "Share to"))
        }
    }




}