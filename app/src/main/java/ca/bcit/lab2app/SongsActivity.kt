package ca.bcit.lab2app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class SongsActivity : AppCompatActivity()
{
    private val EXTRA_DATA1 = "ca.bcit.lab2app.DATA1"

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songs)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // data is a string
        val data = intent?.getStringArrayExtra(EXTRA_DATA1)

        if(data != null)
        {
            setupSpinner(intent.getStringArrayExtra(EXTRA_DATA1)!!)
        } else
        {
            setupSpinner2()
        }
    }

    private fun setupSpinner(songArr: Array<String>)
    {
        // use adapter to bridge data from array to spinner
        val arrAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, songArr)

        // set layout resource to create the dropdown views
        arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // point to the spinner
        val mySpinner = findViewById<Spinner>(R.id.songs_spinner)

        // set array adapter to spinner adapter
        mySpinner.adapter = arrAdapter
    }

    private fun setupSpinner2()
    {
        // use adapter to bridge data from array to spinner
        val arrAdapter = ArrayAdapter.createFromResource(this, R.array.songs2, android.R.layout.simple_spinner_item)

        // set layout resource to create the dropdown views
        arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // point to the spinner
        val mySpinner = findViewById<Spinner>(R.id.songs_spinner)

        // set array adapter to spinner adapter
        mySpinner.adapter = arrAdapter
    }

    /**
     * Destroys SongActivity and returns to the MainActivity screen
     * by clicking the <- button
     *
     * @return the previous activity screen
     */
    override fun onSupportNavigateUp(): Boolean
    {
        // destroys this activity
        finish()
        // go back to previous activity (MainActivity)
        return super.onSupportNavigateUp()
    }
}