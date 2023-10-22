package a.sboev.mytelegramclone.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import a.sboev.mytelegramclone.R
import a.sboev.mytelegramclone.databinding.FragmentEnterPhoneNumberBinding
import a.sboev.mytelegramclone.utils.replaceFragment
import a.sboev.mytelegramclone.utils.showToast
import android.widget.Toast


class EnterPhoneNumberFragment : Fragment(R.layout.fragment_enter_phone_number) {


    private lateinit var mBinding: FragmentEnterPhoneNumberBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentEnterPhoneNumberBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onStart() {
        super.onStart()
        mBinding.registerBtnNext.setOnClickListener {
            sendCode()
        }
    }

    private fun sendCode() {
        if(mBinding.registerInputPhoneNumber.text.isNullOrEmpty()/*registerInputPhoneNumber.text.isNullOrEmpty()*/) {
            showToast(getString(R.string.register_toast_enter_phone))
        } else {
            replaceFragment(EnterCodeFragment())
        }
    }

}