package ca.bcit.lab2app

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity()
{
    private val EXTRA_DATA1 = "ca.bcit.lab2app.DATA1"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // hides the action bar; change ALL action bars in res>values>themes>themes.xml
        supportActionBar?.hide()

        changeTextColor(findViewById<TextView>(R.id.textView_main))
        changeButtonColor(findViewById<Button>(R.id.songs1button_main))
        changeButtonColor(findViewById<Button>(R.id.songs2button_main))
    }

    private fun changeTextColor(view: TextView)
    {
        if (view.id == R.id.textView_main)
        {
            view.setTextColor(Color.GREEN)
        }
    }

    private fun changeButtonColor(view: Button?)
    {
        if (view != null)
        {
            if (view.id == R.id.songs1button_main)
            {
                view.setBackgroundColor(Color.CYAN)
            } else
            {
                view.setBackgroundColor(Color.MAGENTA)
            }
        }
    }

    fun goToNextScreen(view: View)
    {
        // from 'this' (main) screen, to the 'SecondActivity' screen
        val intent = Intent(this, SongsActivity::class.java)
        // launch the second screen
        startActivity(intent)
    }

    fun goToNextScreenWithData(view: View)
    {
        val intent = Intent(this, SongsActivity::class.java)
        val songs1 = arrayOf(
            "gettin jiggy with it",
            "watcha say",
            "yellow submarine",
            "single ladies",
            "uptown funk"
        )

        // add data to intent
        intent.putExtra(EXTRA_DATA1, songs1)

        startActivity(intent)
    }
}