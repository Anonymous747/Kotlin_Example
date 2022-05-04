package com.example.example.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.example.R
import com.example.example.view.adapters.AssetAdapter
import com.example.example.view.adapters.ButtonAdapter
import com.example.example.databinding.FragmentFirstBinding
import com.example.example.models.data.Asset
import com.example.example.models.ButtonType
import com.example.example.models.CustomButton

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttons = createButtons()
        val rvButtons = view.findViewById<RecyclerView>(R.id.rv_btn_list)
        rvButtons.adapter = ButtonAdapter(view.context, buttons)
        rvButtons.layoutManager = LinearLayoutManager(view.context, RecyclerView.HORIZONTAL, false)

        val assets = createAssets()
        val rvAssets = view.findViewById<RecyclerView>(R.id.rv_list)
        rvAssets.adapter = AssetAdapter(view.context, assets)
        rvAssets.layoutManager = LinearLayoutManager(view.context)
    }

    private fun createButtons() = listOf<CustomButton>(
        CustomButton("Navigation", View.OnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_NavigationFragment)
        }, ButtonType.ButtonWithIcon),
        CustomButton("All", View.OnClickListener {
            Log.d("TAG", "createButtons: All tap")
        }, ButtonType.RoundedButton),
        CustomButton("Audiobooks", View.OnClickListener {
            Log.d("TAG", "createButtons: Audiobooks tap")
        }, ButtonType.RoundedButton),
        CustomButton("Cartoons", View.OnClickListener {
            Log.d("TAG", "createButtons: Cartoons tap")
        }, ButtonType.RoundedButton),
    )

    private fun createAssets(): List<Asset> {
        val assets = mutableListOf<Asset>()
        for (i in 1..10) assets.add(Asset("Asset id = #$i", "Description"))
        return assets
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}