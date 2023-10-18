package a.sboev.mytelegramclone.ui.fragments

import a.sboev.mytelegramclone.R
import a.sboev.mytelegramclone.databinding.FragmentSettingsBinding
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuInflater
import android.view.View


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    private lateinit var mBinding: FragmentSettingsBinding

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {

        activity?.menuInflater?.inflate(R.menu.settings_action_menu, menu)
    }

}