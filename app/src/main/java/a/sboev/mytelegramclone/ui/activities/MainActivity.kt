package a.sboev.mytelegramclone.ui.activities

import a.sboev.mytelegramclone.databinding.ActivityMainBinding
import a.sboev.mytelegramclone.ui.activities.RegisterActivity
import a.sboev.mytelegramclone.ui.fragments.ChatsFragment
import a.sboev.mytelegramclone.ui.objects.AppDrawer
import a.sboev.mytelegramclone.utils.AUTH
import a.sboev.mytelegramclone.utils.replaceActivity
import a.sboev.mytelegramclone.utils.replaceFragment
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mToolbar: Toolbar
    private lateinit var mAppDrawer: AppDrawer



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    private fun initFunc() {
        if (AUTH.currentUser != null){
            setSupportActionBar(mToolbar)
            mAppDrawer.create()
            replaceFragment(ChatsFragment(), false)
        } else {
            replaceActivity(RegisterActivity())
        }
    }

    private fun initFields() {
        mToolbar = mBinding.mainToolbar
        mAppDrawer = AppDrawer(this, mToolbar)
        AUTH = FirebaseAuth.getInstance()
    }


}