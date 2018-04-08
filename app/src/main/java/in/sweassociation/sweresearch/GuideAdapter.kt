package `in`.sweassociation.sweresearch

import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.guide_item.view.*

class GuideAdapter(val steps: ArrayList<Steps>) : RecyclerView.Adapter<GuideAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val feedView = inflater.inflate(R.layout.guide_item, parent, false)
        val viewholder = ViewHolder(feedView)

        return viewholder
    }

    override fun getItemCount(): Int {
        return steps.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(steps[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(step: Steps) {
            itemView.step_image.setBackgroundResource(step.imgId)
            itemView.step_heading.text = step.head
            itemView.step_content.text = step.content
            itemView.setOnClickListener {
                if (itemView.step_content.maxLines == 4)
                    itemView.step_content.maxLines = 20
                else
                    itemView.step_content.maxLines = 4
            }
        }
    }
}