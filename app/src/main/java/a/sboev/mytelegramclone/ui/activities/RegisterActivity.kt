package a.sboev.mytelegramclone.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import a.sboev.mytelegramclone.R
import a.sboev.mytelegramclone.databinding.ActivityRegisterBinding
import a.sboev.mytelegramclone.ui.fragments.EnterPhoneNumberFragment
import androidx.appcompat.widget.Toolbar

class RegisterActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRegisterBinding
    private lateinit var mToolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        mToolbar = mBinding.registerToolbar
        setSupportActionBar(mToolbar)
        title = getString(R.string.register_title_your_phone)
        supportFragmentManager.beginTransaction().add(R.id.register_data_container, EnterPhoneNumberFragment()).commit()
    }
}