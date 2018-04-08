package `in`.sweassociation.sweresearch

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var steps: ArrayList<Steps>? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.research -> {
                guide_recycler_view.visibility = View.GONE
                return@OnNavigationItemSelectedListener true
            }
            R.id.step -> {
                guide_recycler_view.visibility = View.VISIBLE
                return@OnNavigationItemSelectedListener true
            }
            R.id.application -> {
                guide_recycler_view.visibility = View.GONE
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        steps = ArrayList<Steps>()
        steps?.add(Steps(R.drawable.ic_dashboard_black_24dp, "Find a Topic", "What is Lorem Ipsum? Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the ..."))
        steps?.add(Steps(R.drawable.ic_dashboard_black_24dp, "Find a Topic", "What is Lorem Ipsum? Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the ..."))
        steps?.add(Steps(R.drawable.ic_dashboard_black_24dp, "Find a Topic", "What is Lorem Ipsum? Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the ..."))
        steps?.add(Steps(R.drawable.ic_dashboard_black_24dp, "Find a Topic", "What is Lorem Ipsum? Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the ..."))
        steps?.add(Steps(R.drawable.ic_dashboard_black_24dp, "Find a Topic", "What is Lorem Ipsum? Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the ..."))
        steps?.add(Steps(R.drawable.ic_dashboard_black_24dp, "Find a Topic", "What is Lorem Ipsum? Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the ..."))

        guide_recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        guide_recycler_view.adapter = GuideAdapter(steps!!)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
