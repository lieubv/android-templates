package co.nimblehq.template.ui.screens

import android.view.LayoutInflater
import androidx.activity.viewModels
import co.nimblehq.template.databinding.ActivityMainBinding
import co.nimblehq.template.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = { inflater -> ActivityMainBinding.inflate(inflater) }

    override val viewModel by viewModels<MainViewModel>()
}
