package dev.milic.viewmodellivedatapractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class SplitFragmentOne : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_split_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val totalViewModel = ViewModelProvider(requireActivity()).get(TotalsViewModel::class.java)
        totalViewModel.getTotal().observe(
            viewLifecycleOwner, Observer {
                updateText(it)
            }
        )

        view.findViewById<Button>(R.id.fragment_split_one_button).setOnClickListener {
            totalViewModel.increaseTotal()
        }
    }

    private fun updateText(total: Int) {
        view?.findViewById<TextView>(R.id.fragment_split_one_text_view)?.text =
            getString(R.string.total, total)
    }

}