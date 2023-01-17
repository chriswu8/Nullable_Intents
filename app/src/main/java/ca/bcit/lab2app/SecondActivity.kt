package ca.bcit.lab2app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class SecondActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupSpinner()
    }

    /**
     * Destroys SecondActivity and returns to the MainActivity screen
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

    /**
     * Spinner = view that resembles a drop-down menu
     * --> provides easy way to select an item from a group
     * --> found under the "containers" section
     * --> ignore no speakable text present error
     */

    /**
     * ArrayAdapter:
     *  - takes 3 arguments: 1) context 2) layout resource 3) Array of objects
     */

    private fun setupSpinner()
    {
        // populate spinner w/ Array
        val songs1 = arrayOf("gettin jiggy with it", "watcha say", "yellow submarine", "single ladies", "uptown funk")

        // use adapter to bridge data from array to spinner
        val arrAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, songs1)

        // set layout resource to create the dropdown views
        arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // point to the spinner
        val mySpinner = findViewById<Spinner>(R.id.spinner_second)

        // set array adapter to spinner adapter
        mySpinner.adapter = arrAdapter
    }
}