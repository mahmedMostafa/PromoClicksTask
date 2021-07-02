package com.mohamed.mostafa.promoclickstask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mohamed.mostafa.promoclickstask.databinding.ActivityMainBinding
import com.mohamed.mostafa.promoclickstask.features.categories.CategoriesFragment
import com.mohamed.mostafa.promoclickstask.features.home.presentation.HomeFragment
import com.mohamed.mostafa.promoclickstask.features.more.MoreFragment
import com.mohamed.mostafa.promoclickstask.features.saved.SavedFragment
import dagger.hilt.android.AndroidEntryPoint

const val FRAGMENT_TAG = "fragment_tag"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var lastActiveFragmentTag: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState != null) {
            lastActiveFragmentTag = savedInstanceState.getString(FRAGMENT_TAG)
        } else {
            loadFragment(R.id.fragmentHome)
        }
        init()
    }


    private fun init() {
        binding.bottomAppBar.setOnNavigationItemSelectedListener { menutItem ->
            loadFragment(menutItem.itemId)
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun loadFragment(itemId: Int) {
        val tag = itemId.toString()
        var fragment = supportFragmentManager.findFragmentByTag(tag)
        if (fragment == null) {
            when (itemId) {
                R.id.fragmentHome -> fragment = HomeFragment()
                R.id.fragmentCategories -> fragment = CategoriesFragment()
                R.id.fragmentSaved -> fragment = SavedFragment()
                R.id.fragmentMore -> fragment = MoreFragment()
                else -> fragment = null
            }
        }
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (lastActiveFragmentTag != null) {
            val lasFragment = supportFragmentManager.findFragmentByTag(lastActiveFragmentTag)
            if (lasFragment != null) fragmentTransaction.hide(lasFragment)
        }
        if (!fragment!!.isAdded) {
            fragmentTransaction.add(R.id.fragment_container, fragment, tag)
        } else {
            fragmentTransaction.show(fragment)
        }
        fragmentTransaction.commit()
        lastActiveFragmentTag = tag
    }

    override fun onBackPressed() {
        if (binding.bottomAppBar.selectedItemId != R.id.fragmentHome) {
            binding.bottomAppBar.selectedItemId = R.id.fragmentHome
        } else {
            super.onBackPressed()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(FRAGMENT_TAG, lastActiveFragmentTag)
    }
}