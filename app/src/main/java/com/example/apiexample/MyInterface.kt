package com.example.apiexample

import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

interface MyInterface {

    fun getPictures(adapter: MyAdapter, string: String,  list: ArrayList<String>) {

        val VALUE = API_KEY
        list.clear()

        // introducing url request variable
        val urlReq = ""

        val requestQueue = Volley.newRequestQueue(APP_ACTIVITY)
        val jsonObjectRequest: JsonObjectRequest = object : JsonObjectRequest(
            Method.GET, urlReq, null,
            Response.Listener { response ->
                try {
                    //getting json array
                    val jsonArray = ""
                    val photoArray = response.getJSONArray(jsonArray)
                    for (i in 0 until photoArray.length()) {
                        val obj = photoArray.getJSONObject(i)

                        // getting object and its parameter
                        val target: String = ""
                        val parameter: String = ""

                        val url = obj.getJSONObject(target).getString(parameter)
                        list.add(url)
                    }
                    adapter.notifyDataSetChanged()
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            Response.ErrorListener {
                Toast.makeText(
                    APP_ACTIVITY,
                    "Fail to find picture!!",
                    Toast.LENGTH_SHORT
                ).show()
            }) {
            @Throws(AuthFailureError::class)
            override fun getHeaders(): HashMap<String, String> {
                val map = HashMap<String, String>()
                map[KEY] = VALUE
                return map
            }
        }
        requestQueue.add(jsonObjectRequest)
    }
}