package com.hadi.kwg.presentation.view.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hadi.dogsapp.R
import com.hadi.dogsapp.databinding.BreedItemBinding
import com.hadi.dogsapp.presentation.models.BreedUIModel


class BreedListAdapter  : RecyclerView.Adapter<BreedListAdapter.ViewHolder>() {


    private val breeds: MutableList<BreedUIModel> = ArrayList()
    private var layoutInflater: LayoutInflater? = null
    private lateinit var context: Context

    var onPostClickListener: OnPostClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        context = parent.context

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }

        val binding: BreedItemBinding  =
            DataBindingUtil.inflate(layoutInflater!!, R.layout.breed_item, parent, false)

        return ViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.binding.textViewName.text = breeds[position].name



//        viewHolder.binding.carItemLayout.setOnClickListener {
//            onPostClickListener?.setOnPostClickListener(breeds[position].name.toInt())
//
////            startActivity(Intent(viewHolder.binding.carItemLayout.context, MainActivity::class.java))
////            Log.e("Click", breeds[position].id.toString())
//           // startActivity(Intent(this@context, MainActivity::class.java))
////
////            val activity = viewHolder.binding.carItemLayout.context as Activity
////           var intent =  Intent(context, MapsActivity::class.java)
////            intent.putExtra("lat", breeds[position].coordinate.latitude.toString())
////            intent.putExtra("lon", breeds[position].coordinate.longitude.toString())
////            intent.putExtra("id", breeds[position].id)
////            intent.putExtra("heading", breeds[position].heading.toString())
//           // context.startActivity(intent)
////            startActivity(activity, intent, null)
//
//        }

    }

    override fun getItemCount() = breeds.size

    fun provideList(newbreeds: List<BreedUIModel>?) {
        newbreeds?.let {
            breeds.addAll(it)
            val uniquePostList = breeds.distinctBy { post ->
                post.name
            }
            breeds.clear()
            breeds.addAll(uniquePostList)
            notifyDataSetChanged()
        }
    }

    @Suppress("unused")
    fun clear() {
        breeds.clear()
        notifyDataSetChanged()
    }

    interface OnPostClickListener {
        fun setOnPostClickListener(VehicleDataId: Int)
    }

    class ViewHolder(val binding: BreedItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}
