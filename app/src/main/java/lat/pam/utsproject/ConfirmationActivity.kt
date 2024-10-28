package lat.pam.utsproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import lat.pam.utsproject.R.id.tvFoodName

class ConfirmationActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val foodName = intent.getStringExtra("FOOD_NAME")
        val servings = intent.getStringExtra("Number_Of_Servings")
        val orderingName = intent.getStringExtra("Ordering_Name")
        val additionalNote = intent.getStringExtra("Aditional_Note")

        // Display the data in the appropriate TextViews
        findViewById<TextView>(R.id.tvFoodName).text = "Food Name: $foodName"
        findViewById<TextView>(R.id.tvServings).text = "Number of Servings: $servings pax"
        findViewById<TextView>(R.id.tvName).text = "Ordering Name: $orderingName"
        findViewById<TextView>(R.id.tvNotes).text = "Additional Notes: $additionalNote"

        findViewById<Button>(R.id.backtoMenu).setOnClickListener{
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}