package me.simonpojok.weatherapp.common

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min

private const val ALL_ITEMS = 0

class ItemsListAdapter<LIST_ITEM_TYPE>(
    private val viewHolderProvider: (parent: ViewGroup, viewType: Int) -> ViewHolder<LIST_ITEM_TYPE>
) : RecyclerView.Adapter<ItemsListAdapter.ViewHolder<LIST_ITEM_TYPE>>() {

    val adapterItems: MutableList<LIST_ITEM_TYPE> = mutableListOf()

    var maxItemsToShow: Int = ALL_ITEMS
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var dataSetChangedHandler: () -> Unit = {}

    fun setAdapterItems(items: List<LIST_ITEM_TYPE> = listOf()) {
        adapterItems.clear()
        adapterItems.addAll(items)
        notifyDataSetChanged()
        dataSetChangedHandler()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        viewHolderProvider(parent, viewType)

    override fun onBindViewHolder(holder: ViewHolder<LIST_ITEM_TYPE>, position: Int) =
        holder.bind(adapterItems[position])

    override fun getItemCount() =
        if (maxItemsToShow == ALL_ITEMS) {
            adapterItems.size
        } else {
            min(adapterItems.size, maxItemsToShow)
        }

    abstract class ViewHolder<LIST_ITEM_TYPE>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: LIST_ITEM_TYPE)
    }
}
