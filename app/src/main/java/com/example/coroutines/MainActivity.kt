package com.example.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
//        GlobalScope.launch(Dispatchers.) {
//            val networkcallanswer=doNetworkCall()
//           // val networkcallanswer2=doNetworkCall2()
//           Log.d(TAG,networkcallanswer)
//            //Log.d(TAG,networkcallanswer2)
//            //delay(5000L)
//            //Log.d(TAG,"Coroutine says hello from thread ${Thread.currentThread().name}")
//        }
        //Log.d(TAG,"Hello from thread ${Thread.currentThread().name}")
//        GlobalScope.launch(Dispatchers.IO) {
//            Log.d(TAG,"Starting coroutine in thread ${Thread.currentThread().name}")
//            val answer= doNetworkCall()
//            withContext(Dispatchers.Main){
//                Log.d(TAG,"Setting text in thread ${Thread.currentThread().name}")
//                binding.tvDummy.text=answer
//            }
//
//
//
//        }

        Log.d(TAG,"Before run blocking")
        runBlocking {
            Log.d(TAG,"Just entered into the runblocking ")
            delay(5000L)
            launch(Dispatchers.IO) {
                delay(3000L)
                Log.d(TAG,"Finished toc coroutine 1")
            }
            launch(Dispatchers.IO) {
                delay(3000L)
                Log.d(TAG,"Finished to coroutine 2")

            }
            Log.d(TAG,"Start of the runblocking")
            Log.d(TAG,"End of the runblocking")
        }
        Log.d(TAG,"after the runblocking")
        GlobalScope.launch {
            Log.d(TAG,"Logging in the global scope")
        }


    }
}

    //suspended fun call

//    suspend fun doNetworkCall():String{
//        delay(3000L)
//        return "This is the answer"
//
//    }

//    suspend fun doNetworkCall2():String{
//        delay(3000L)
//        return "This is the answer"
//    }
//}