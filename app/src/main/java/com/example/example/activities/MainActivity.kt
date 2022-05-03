package com.example.example.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.example.R
import com.example.example.adapters.AssetAdapter
import com.example.example.adapters.ButtonAdapter
import com.example.example.databinding.ActivityMainBinding
import com.example.example.models.Asset
import com.example.example.models.ButtonType
import com.example.example.models.CustomButton

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        val buttons = createButtons()
        val rvButtons = findViewById<RecyclerView>(R.id.rv_btn_list)
        rvButtons.adapter = ButtonAdapter(this, buttons)
        rvButtons.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)

        val assets = createAssets()
        val rvAssets = findViewById<RecyclerView>(R.id.rv_list)
        rvAssets.adapter = AssetAdapter(this, assets)
        rvAssets.layoutManager = LinearLayoutManager(this)
    }

    private fun createButtons() = listOf<CustomButton>(
        CustomButton("Navigation", View.OnClickListener {
            print("Navigation tap")
        }, ButtonType.ButtonWithIcon),
        CustomButton("All", View.OnClickListener {
            print("All tap")
        }, ButtonType.RoundedButton),
        CustomButton("Audiobooks", View.OnClickListener {
            print("Audiobooks tap")
        }, ButtonType.RoundedButton),
        CustomButton("Cartoons", View.OnClickListener {
            print("Cartoons tap")
        }, ButtonType.RoundedButton),
    )


    private fun createAssets(): List<Asset> {
        val assets = mutableListOf<Asset>()
        for (i in 1..10) assets.add(Asset("Asset id = #$i", "Description"))
        return assets
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}