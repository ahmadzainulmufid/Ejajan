package com.mnrf.ejajan.view.main.merchant.ui.setting.balance

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mnrf.ejajan.R
import com.mnrf.ejajan.view.main.merchant.ui.home.HomeMerchantFragment

class ConfirmationDisbursementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_merchant_confirmation_disbursement)

        val btnBack = findViewById<Button>(R.id.btn_backHome)

        btnBack.setOnClickListener {
            val intent = Intent(this, HomeMerchantFragment::class.java)
            startActivity(intent)
        }

    }
}