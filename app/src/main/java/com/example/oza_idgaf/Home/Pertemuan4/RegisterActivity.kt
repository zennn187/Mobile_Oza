package com.example.oza_idgaf.Home.Pertemuan4

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.oza_idgaf.Home.Pertemuan6.SharedPreferences
import com.example.oza_idgaf.databinding.ActivityRegisterBinding
import java.util.Calendar

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = SharedPreferences(this)

        binding.etRegisterBirthDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val dateString = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    binding.etRegisterBirthDate.setText(dateString)
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        binding.btnRegister.setOnClickListener {
            val name = binding.etRegisterName.text?.toString()?.trim().orEmpty()
            val email = binding.etRegisterEmail.text?.toString()?.trim().orEmpty()
            val birthDate = binding.etRegisterBirthDate.text?.toString()?.trim().orEmpty()
            val username = binding.etRegisterUsername.text?.toString()?.trim().orEmpty()
            val password = binding.etRegisterPassword.text?.toString()?.trim().orEmpty()
            val confirmPassword = binding.etRegisterConfirmPassword.text?.toString()?.trim().orEmpty()

            val selectedGenderId = binding.rgGender.checkedRadioButtonId
            val gender = if (selectedGenderId != -1) {
                findViewById<RadioButton>(selectedGenderId).text.toString()
            } else {
                ""
            }

            binding.etRegisterName.error = null
            binding.etRegisterEmail.error = null
            binding.etRegisterBirthDate.error = null
            binding.etRegisterUsername.error = null
            binding.etRegisterPassword.error = null
            binding.etRegisterConfirmPassword.error = null

            if (name.isEmpty()) {
                binding.etRegisterName.error = "Nama tidak boleh kosong"
                return@setOnClickListener
            }
            if (email.isEmpty()) {
                binding.etRegisterEmail.error = "Email tidak boleh kosong"
                return@setOnClickListener
            }
            if (birthDate.isEmpty()) {
                binding.etRegisterBirthDate.error = "Tanggal lahir harus dipilih"
                return@setOnClickListener
            }
            if (gender.isEmpty()) {
                Toast.makeText(this, "Silakan pilih jenis kelamin Anda", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (username.isEmpty()) {
                binding.etRegisterUsername.error = "Username tidak boleh kosong"
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                binding.etRegisterPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }
            if (confirmPassword.isEmpty()) {
                binding.etRegisterConfirmPassword.error = "Konfirmasi password tidak boleh kosong"
                return@setOnClickListener
            }

            sharedPreferences.saveRegistrationData(
                nama = name,
                email = email,
                tglLahir = birthDate,
                gender = gender,
                username = username,
                passwordKey = password,
                confirmPasswordKey = confirmPassword
            )

            Toast.makeText(this, "Data pendaftaran disimpan", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.tvToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}