package id.my.tabin.ligabola

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import kotlinx.android.synthetic.main.activity_main.*

class RecyclerViewAdapter (private val items:List<Tim>): RecyclerView.Adapter<ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder{
        return ViewHolder(TimListUI().createView(AnkoContext.create(parent.context,parent)))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }
    override fun getItemCount(): Int = items.size
}

class TimListUI:AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>): View = with(ui) {
        cardView {
            lparams {
                width = wrapContent
                height = wrapContent
                topMargin = dip(4)
                bottomMargin = dip(4)
                leftMargin = dip(8)
                rightMargin = dip(8)
            }
            relativeLayout {
                lparams(width = matchParent, height = wrapContent)
                imageView(R.drawable.american_mayor_league){
                    id = R.id.team_image
                }.lparams(
                    width = dip(50),
                    height = dip(50)
                )
                textView {
                    id = R.id.team_name
                    textSize = 15f
                }.lparams {
                    bottomOf(R.id.team_image)
                }
            }
        }
    }
}

class ViewHolder(containerView: View) : RecyclerView.ViewHolder(containerView){
    private val teamImage: ImageView = containerView.find(R.id.team_image)
    private val teamName: TextView = containerView.find(R.id.team_name)

    fun bindItem(items:Tim){
        teamName.text = items.name
        items.image?.let { Picasso.get().load(it).fit().into(teamImage)}
    }
}


