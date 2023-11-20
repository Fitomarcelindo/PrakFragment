package by.marcel.myapplication

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import by.marcel.myapplication.databinding.ActivityMainBinding
import by.marcel.myapplication.ui.home.HomeFragment
import by.marcel.myapplication.ui.notifications.NotificationsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val fraghome :  Fragment = HomeFragment()
    val fraginfo : Fragment = NotificationsFragment()
    val fm : FragmentManager = supportFragmentManager
    var active : Fragment = fraghome

    private lateinit var  menu : Menu
    private lateinit var  menuitem : MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

    }

    private fun BottomNavigationView(){
        fm.beginTransaction().add(R.id.nav_host_fragment_activity_main, fraghome).show(fraghome).commit()
        fm.beginTransaction().add(R.id.nav_host_fragment_activity_main, fraginfo).show(fraginfo).commit()




        menuitem = menu.getItem(0)
        menuitem.isChecked = true


    }
}