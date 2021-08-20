package com.mplcoding.spoonacular.ui.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.mplcoding.spoonacular.R
import com.mplcoding.spoonacular.databinding.FragmentInstructionBinding
import com.mplcoding.spoonacular.models.Result
import com.mplcoding.spoonacular.utils.Constants

class InstructionFragment : Fragment() {

    private var _binding: FragmentInstructionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInstructionBinding.inflate(inflater, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(Constants.RECIPE_RESULT_KEY)

        binding.instructionWebview.webViewClient = object : WebViewClient(){}
        val websiteUrl: String = myBundle!!.sourceUrl
        binding.instructionWebview.loadUrl(websiteUrl)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}