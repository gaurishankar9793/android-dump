import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.my.MainRepository
import com.example.my.currentData.CurrentData
import com.example.my.currentLocation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val currentlist = MutableLiveData<List<CurrentData>>()
    val errorMessage = MutableLiveData<String>()

    fun getCurrentWeather() {

        val response = repository.getCurrentWeather(currentLocation.lat,currentLocation.long)
        response.enqueue(object : Callback<List<CurrentData>> {
            override fun onResponse(call: Call<List<CurrentData>>, response: Response<List<CurrentData>>) {
                currentlist.postValue(response.body())
            }

            override fun onFailure(call: Call<List<CurrentData>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}