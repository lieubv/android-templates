package co.nimblehq.rxjava.ui.screens.home

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.*
import co.nimblehq.rxjava.R
import co.nimblehq.rxjava.domain.data.Data
import co.nimblehq.rxjava.extension.*
import co.nimblehq.rxjava.lib.IsLoading
import co.nimblehq.rxjava.ui.base.BaseFragment
import co.nimblehq.rxjava.ui.helpers.handleVisualOverlaps
import co.nimblehq.rxjava.ui.screens.MainNavigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.view_loading.*
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    @Inject
    lateinit var navigator: MainNavigator

    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var dataAdapter: DataAdapter

    override val layoutRes = R.layout.fragment_home

    override fun setupView() {
        setupDataList()

        btHomeRefresh
            .subscribeOnClick { viewModel.input.refresh() }
            .addToDisposables()
    }

    override fun handleVisualOverlaps() {
        rvHomeData.handleVisualOverlaps(marginInsteadOfPadding = false)
        btHomeRefresh.handleVisualOverlaps()
    }

    override fun bindViewEvents() {
        super.bindViewEvents()
        dataAdapter
            .itemClick
            .subscribeOnItemClick {
                when (it) {
                    is DataAdapter.OnItemClick.Item ->
                        viewModel.input.navigateToDetail(it.data)
                }
            }
            .addToDisposables()
    }

    override fun bindViewModel() {
        viewModel.showLoading bindTo ::showLoading
        viewModel.error bindTo ::displayError
        viewModel.data bindTo ::bindData
        viewModel.navigator bindTo navigator::navigate
    }

    private fun setupDataList() {
        with(rvHomeData) {
            adapter = DataAdapter().also {
                dataAdapter = it
            }
            layoutManager = LinearLayoutManager(requireContext())
            addItemDecoration(
                DividerItemDecoration(
                    context,
                    RecyclerView.VERTICAL
                )
            )
        }
    }

    private fun bindData(data: List<Data>) {
        dataAdapter.items = data
    }

    private fun showLoading(isLoading: IsLoading) {
        btHomeRefresh.isEnabled = !isLoading
        pbLoading.visibleOrGone(isLoading)
    }

}