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

        viewHolder.binding.fleet.text = posts[position].fleetType
        viewHolder.binding.longitude.text = String.format("%.2f", posts[position].coordinate.longitude)
        viewHolder.binding.latitude.text = String.format("%.2f",  posts[position].coordinate.latitude)


        viewHolder.binding.carItemLayout.setOnClickListener {
            onPostClickListener?.setOnPostClickListener(posts[position].id)

//            startActivity(Intent(viewHolder.binding.carItemLayout.context, MainActivity::class.java))
//            Log.e("Click", posts[position].id.toString())
           // startActivity(Intent(this@context, MainActivity::class.java))
//
//            val activity = viewHolder.binding.carItemLayout.context as Activity
           var intent =  Intent(context, MapsActivity::class.java)
            intent.putExtra("lat", posts[position].coordinate.latitude.toString())
            intent.putExtra("lon", posts[position].coordinate.longitude.toString())
            intent.putExtra("id", posts[position].id)
            intent.putExtra("heading", posts[position].heading.toString())
            context.startActivity(intent)
//            startActivity(activity, intent, null)

        }

    }

    override fun getItemCount() = posts.size

    fun provideList(newPosts: List<PoiUIModel>?) {
        newPosts?.let {
            posts.addAll(it)
            val uniquePostList = posts.distinctBy { post ->
                post.id
            }
            posts.clear()
            posts.addAll(uniquePostList)
            notifyDataSetChanged()
        }
    }

    @Suppress("unused")
    fun clear() {
        posts.clear()
        notifyDataSetChanged()
    }

    interface OnPostClickListener {
        fun setOnPostClickListener(VehicleDataId: Int)
    }

    class ViewHolder(val binding: BreedItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}
