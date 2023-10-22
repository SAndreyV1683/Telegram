package a.sboev.mytelegramclone.ui.fragments

import a.sboev.mytelegramclone.ui.activities.MainActivity
import a.sboev.mytelegramclone.R
import a.sboev.mytelegramclone.databinding.FragmentSettingsBinding
import a.sboev.mytelegramclone.ui.activities.RegisterActivity
import a.sboev.mytelegramclone.utils.AUTH
import a.sboev.mytelegramclone.utils.replaceActivity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem


class SettingsFragment : BaseFragment(R.layout.fragment_settings) {

    private lateinit var mBinding: FragmentSettingsBinding

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.settings_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.settings_menu_exit -> {
                AUTH.signOut()
                (activity as MainActivity).replaceActivity(RegisterActivity())
            }
        }
        return true
    }

}