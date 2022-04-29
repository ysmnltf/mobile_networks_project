package com.example.project1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.project1.databinding.FragmentSignupBinding
import com.google.android.material.snackbar.Snackbar

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignupFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentSignupBinding? = null
//     This property is only valid between onCreateView and
//     onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentSignupBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.goToSignupBtn.setOnClickListener {
            findNavController().navigate(R.id.action_SignupFragment_to_LoginFragment)
        }

        binding.BackBtn.setOnClickListener {
            findNavController().navigate(R.id.action_SignupFragment_to_LoginFragment)
        }

        binding.signupBtn.setOnClickListener {

            // conditions for sign up
            var isPhoneValid = true
            var isEmailVaid = true
            var isPasswordValid = true

            // validate phone number
            if (!(PhoneValidator.IsPhoneValid(binding.phoneField.editText.toString().trim()))) {
                binding.phoneField.error = "Phone number is invalid"
                isPhoneValid = false
            }

            // validate email address
            if (!(EmailValidator.IsEmailValid(binding.emailField.editText.toString().trim()))) {
                binding.emailField.error = "Email address is invalid"
                isEmailVaid = false
            }

            if (!(binding.passwordField.editText.toString()
                    .trim() == binding.confirmPasswordField.editText.toString().trim())
            ) {
                binding.confirmPasswordField.error = "Passwords are not same"
                isPasswordValid = false
            }

            if (isEmailVaid && isPasswordValid && isPhoneValid) {
                Snackbar.make(it, "User Created", Snackbar.LENGTH_LONG).show()
            }
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignupFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignupFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}