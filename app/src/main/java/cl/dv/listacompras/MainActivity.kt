package cl.dv.listacompras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_order -> {
                //val intentSettings = Intent(this, SettingsActivity::class.java)
                //startActivity(intentSettings)
                return true
            }
            R.id.action_add -> {
                //val intentAbout = Intent(this, AboutActivity::class.java)
                //startActivity(intentAbout)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}

