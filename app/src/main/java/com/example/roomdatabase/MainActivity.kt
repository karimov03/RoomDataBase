package com.example.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.Db.MyDbHelp
import com.example.roomdatabase.classs.RvAdapter
import com.example.roomdatabase.classs.User
import com.example.roomdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var list: ArrayList<User>
    private lateinit var rvAdapter: RvAdapter
    private lateinit var database: MyDbHelp
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        list = ArrayList()

        database = MyDbHelp.newInstanse(this)
        list = database.userDao().getAllUsers() as ArrayList<User>
        rvAdapter = RvAdapter(list)

        binding.rv.adapter = rvAdapter

        binding.btnSaqlash.setOnClickListener {
            val user = User(
                binding.edtName.text.toString(),
                binding.edtNumber.text.toString().toInt()
            )
            database.userDao().addUser(user)
            list.add(user)
            Toast.makeText(this, "Saqlandi", Toast.LENGTH_SHORT).show()
            rvAdapter.notifyDataSetChanged()
        }
    }
}
