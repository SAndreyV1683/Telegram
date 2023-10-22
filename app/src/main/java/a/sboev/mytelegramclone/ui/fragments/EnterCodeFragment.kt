package a.sboev.mytelegramclone.ui.fragments


import a.sboev.mytelegramclone.R
import a.sboev.mytelegramclone.databinding.FragmentEnterCodeBinding
import a.sboev.mytelegramclone.utils.AppTextWatcher
import a.sboev.mytelegramclone.utils.showToast
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast


class EnterCodeFragment : BaseFragment(R.layout.fragment_enter_code) {
    private lateinit var mBinding: FragmentEnterCodeBinding
    override fun onStart() {
        super.onStart()
        mBinding = FragmentEnterCodeBinding.inflate(layoutInflater)
        mBinding.registerTextEnterCode.addTextChangedListener(AppTextWatcher {
            val string = mBinding.registerInputCode.text
            if (string.length == 6) {
                verifyCode()
            }
        })
    }

    private fun verifyCode() {
        showToast("OK")
    }

}