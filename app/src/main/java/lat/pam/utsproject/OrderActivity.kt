package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    private lateinit var etServings : EditText
    private lateinit var etName : EditText
    private lateinit var btnOrder : Button
    private lateinit var etNotes : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val foodName = intent.getStringExtra("FOOD_NAME")
        findViewById<TextView>(R.id.etFoodName).text = foodName

        etServings = findViewById(R.id.etServings)
        etName = findViewById(R.id.etName)
        etNotes = findViewById(R.id.etNotes)
        btnOrder = findViewById(R.id.btnOrder)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnOrder.setOnClickListener{
            if(validateInput()){
                val intent = Intent(this, ConfirmationActivity::class.java).apply {
                    putExtra("FOOD_NAME", foodName)
                    putExtra("Number_Of_Servings", etServings.text.toString())
                    putExtra("Ordering_Name", etName.text.toString())
                    putExtra("Aditional_Note", etNotes.text.toString())

                }
                startActivity(intent)
            }
        }
    }

    private fun validateInput(): Boolean {
        val servings = etServings.text.toString().trim()
        val name = etName.text.toString().trim()

        return when {
            servings.isEmpty() -> {
                etServings.error = "jumlah pesanan harus diisi"
                false
            }
            name.isEmpty() -> {
                etName.error = "nama tidak boleh kosong"
                false
            }
            else -> true
        }
    }
}