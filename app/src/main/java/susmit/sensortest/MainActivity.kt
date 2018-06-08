package susmit.sensortest

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    var tv1:TextView?=null
    var tv2:TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv1=findViewById(R.id.tv1)
        tv2=findViewById(R.id.tv2)
        var sManager:SensorManager=getSystemService(Context.SENSOR_SERVICE)as SensorManager
        var S:Sensor=sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        sManager.registerListener(object :SensorEventListener{
            override fun onSensorChanged(event: SensorEvent?) {
                val values=event?.values
                tv1?.text=values?.get(0).toString()
                tv2?.text=values?.get(1).toString()

            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

            }
        },S,SensorManager.SENSOR_DELAY_GAME)


    }
}
