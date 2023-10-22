package a.sboev.mytelegramclone.ui.fragments


import a.sboev.mytelegramclone.ui.activities.MainActivity
import a.sboev.mytelegramclone.R
import a.sboev.mytelegramclone.databinding.FragmentEnterCodeBinding
import a.sboev.mytelegramclone.ui.activities.RegisterActivity
import a.sboev.mytelegramclone.utils.AUTH
import a.sboev.mytelegramclone.utils.AppTextWatcher
import a.sboev.mytelegramclone.utils.replaceActivity
import a.sboev.mytelegramclone.utils.showToast
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.auth.PhoneAuthProvider


class EnterCodeFragment(private val mPhoneNumber: String, val id: String) : Fragment(R.layout.fragment_enter_code) {
    private lateinit var mBinding: FragmentEnterCodeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentEnterCodeBinding.inflate(layoutInflater)
        return mBinding.root
    }


    override fun onStart() {
        super.onStart()
        (activity as RegisterActivity).title = mPhoneNumber
        mBinding.registerInputCode.addTextChangedListener(AppTextWatcher {
            val string = mBinding.registerInputCode.text.toString()
            if (string.length == 6) {
                enterCode()
            }
        })
    }

    private fun enterCode() {
        val code = mBinding.registerInputCode.text.toString()
        val credential = PhoneAuthProvider.getCredential(id, code)
        AUTH.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) {
                showToast("Welcome")
                (activity as RegisterActivity).replaceActivity(MainActivity())
            } else showToast(it.exception?.message.toString())
        }
    }

}