package com.example.oza_idgaf.Home.Pertemuan12.note

import android.Manifest
import android.app.AlarmManager
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.oza_idgaf.BaseActivity
import com.example.oza_idgaf.Home.Pertemuan12.data.AppDatabase
import com.example.oza_idgaf.Home.Pertemuan12.data.NoteEntity
import com.example.oza_idgaf.databinding.ActivityNoteFormBinding
import com.example.oza_idgaf.Home.Pertemuan14.utils.PermissionHelper
import com.example.oza_idgaf.Home.Pertemuan14.utils.ReminderHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NoteFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNoteFormBinding
    private lateinit var db: AppDatabase

    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (!isGranted) {
                Toast.makeText(this, "Izin notifikasi ditolak, reminder mungkin tidak muncul", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getInstance(this)

        if (PermissionHelper.isNotificationPermissionRequired()) {
            val permission = Manifest.permission.POST_NOTIFICATIONS
            if (!PermissionHelper.hasPermission(this, permission)) {
                PermissionHelper.requestPermission(
                    notificationPermissionLauncher,
                    permission
                )
            }
        }

        checkAndRequestExactAlarmPermission()

        binding.btnSaveNote.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            val content = binding.etContent.text.toString().trim()

            if (title.isNotBlank() && content.isNotBlank()) {
                val note = NoteEntity(
                    title = title,
                    content = content,
                    createdAt = System.currentTimeMillis()
                )

                lifecycleScope.launch(Dispatchers.IO) {
                    db.noteDao().insert(note)

                    withContext(Dispatchers.Main) {
                        ReminderHelper.setReminder(
                            context = this@NoteFormActivity,
                            secondsDelay = 5,
                            title = "Catatan Baru Ditambahkan",
                            message = "Catatan berjudul \"$title\" berhasil disimpan ke database!",
                            targetActivity = BaseActivity::class.java
                        )

                        Toast.makeText(this@NoteFormActivity, "Catatan disimpan! Tunggu 5 detik...", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            } else {
                Toast.makeText(this, "Judul dan konten tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkAndRequestExactAlarmPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            if (!alarmManager.canScheduleExactAlarms()) {
                Toast.makeText(this, "Aktifkan izin alarm presisi agar reminder berfungsi!", Toast.LENGTH_LONG).show()
                val intent = Intent().apply {
                    action = Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM
                    data = Uri.parse("package:$packageName")
                }
                startActivity(intent)
            }
        }
    }
}