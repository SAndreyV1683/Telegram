package a.sboev.mytelegramclone.ui.fragments

import a.sboev.mytelegramclone.R
import a.sboev.mytelegramclone.databinding.FragmentSettingsBinding
import android.view.Menu
import android.view.MenuInflater


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    private lateinit var mBinding: FragmentSettingsBinding

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.settings_action_menu, menu)
    }

}