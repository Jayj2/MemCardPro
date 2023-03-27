package com.example.memcardpro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CategoriesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                CategoriesFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}

//override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//    val view = inflater.inflate(R.layout.fragment_collection, container, false)
//    val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
//
//    val items = listOf(
//        CollectionItem("Item 1", "Description 1", R.drawable.item1),
//        CollectionItem("Item 2", "Description 2", R.drawable.item2),
//        CollectionItem("Item 3", "Description 3", R.drawable.item3),
//        CollectionItem("Item 4", "Description 4", R.drawable.item4),
//        CollectionItem("Item 5", "Description 5", R.drawable.item5),
//    )
//
//    val adapter = CollectionAdapter(items)
//    recyclerView.adapter = adapter
//
//    return view
//}
//class CollectionAdapter(private val items: List<CollectionItem>) : RecyclerView.Adapter<CollectionAdapter.ViewHolder>() {
//
//    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        init {
//            itemView.setOnClickListener {
//                val position = adapterPosition
//                val item = items[position]
//                // Handle item click
//            }
//        }
//
//        fun bind(item: CollectionItem) {
//            itemView.findViewById<TextView>(R.id.name_text_view).text = item.name
//            itemView.findViewById<TextView>(R.id.description_text_view).text = item.description
//            itemView.findViewById<ImageView>(R.id.image_view).setImageResource(item.imageResId)
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.collection_item, parent, false)
//        return ViewHolder(itemView)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val item = items[position]
//        holder.bind(item)
//    }
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//}