package ca.bcit.lab2app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner

class ThirdActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

//        // hides the action bar; change ALL action bars in res>values>themes>themes.xml
//        supportActionBar?.hide()

        // ???
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setupSpinner()
    }

    /**
     * Destroys ThirdActivity and returns to the MainActivity screen
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
        // use adapter to bridge data from array to spinner
//        val arrAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, songs2)
        val arrAdapter = ArrayAdapter.createFromResource(this, R.array.songs2, android.R.layout.simple_spinner_item);

        // set layout resource to create the dropdown views
        arrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // point to the spinner
        val mySpinner = findViewById<Spinner>(R.id.spinner_third)

        // set array adapter to spinner adapter
        mySpinner.adapter = arrAdapter
    }
}