package buu.informatics.s59161073.todayknowledge.vocab

import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import buu.informatics.s59161073.todayknowledge.R

class VocabViewModel : ViewModel() {
    init {
        Log.i("VocabViewModel", "VocabViewModel created!")
    }

    private val _groupVocabText = MutableLiveData<String>()
    val groupVocabText : LiveData<String>
        get() = _groupVocabText

    private val _vocabText1 = MutableLiveData<String>()
    val vocabText1 : LiveData<String>
        get() = _vocabText1

    private val _vocabText2 = MutableLiveData<String>()
    val vocabText2 : LiveData<String>
        get() = _vocabText2

    private val _vocabText3 = MutableLiveData<String>()
    val vocabText3 : LiveData<String>
        get() = _vocabText3

    private val _vocabText4 = MutableLiveData<String>()
    val vocabText4 : LiveData<String>
        get() = _vocabText4

    private val _vocabImage1 = MutableLiveData<Int>()
    val vocabImage1 : LiveData<Int>
        get() = _vocabImage1

    private val _vocabImage2 = MutableLiveData<Int>()
    val vocabImage2 : LiveData<Int>
        get() = _vocabImage2

    private val _vocabImage3 = MutableLiveData<Int>()
    val vocabImage3 : LiveData<Int>
        get() = _vocabImage3

    private val _vocabImage4 = MutableLiveData<Int>()
    val vocabImage4 : LiveData<Int>
        get() = _vocabImage4

    private val _flag = MutableLiveData<Boolean>()
    val flag : LiveData<Boolean>
        get() = _flag

    fun setVocab (group:Int) {


        if (group == 1 ) {
            _groupVocabText.value = "Job"
            _vocabText1.value = "Nurse : นางพยาบาล"
            _vocabText2.value = "Policeman : ตำรวจ"
            _vocabText3.value = "Teacher : คุณครู"
            _vocabText4.value = "Doctor : หมอ"

            _vocabImage1.value = R.drawable.nurse
            _vocabImage2.value = R.drawable.policeman
            _vocabImage3.value = R.drawable.teacher
            _vocabImage4.value = R.drawable.doctor

        }else if (group == 2){
            _groupVocabText.value = "Fruit"
            _vocabText1.value = "Apple : แอปเปิ้ล"
            _vocabText2.value = "Pumpkin : ฟักทอง"
            _vocabText3.value = "Watermelon : แตงโม"
            _vocabText4.value = "Banana : กล้วย"

            _vocabImage1.value = R.drawable.apple
            _vocabImage2.value = R.drawable.pumpkin
            _vocabImage3.value = R.drawable.watermelon
            _vocabImage4.value = R.drawable.banana

        }else if (group == 3 ){
            _groupVocabText.value = "Animal"
            _vocabText1.value = "Tiger : เสือ"
            _vocabText2.value = "Bird : นก"
            _vocabText3.value = "Fish : ปลา"
            _vocabText4.value = "Duck : เป็ด"

            _vocabImage1.value = R.drawable.tiger
            _vocabImage2.value = R.drawable.bird
            _vocabImage3.value = R.drawable.clownfish
            _vocabImage4.value = R.drawable.duckling


        } else if (group == 4 ){
            _groupVocabText.value = "Color"
            _vocabText1.value = "Blue : สีฟ้า"
            _vocabText2.value = "Green : สีเขียว"
            _vocabText3.value = "Red : สีแดง"
            _vocabText4.value = "Yellow : สีเหลือง"

            _vocabImage1.value = R.drawable.buttonblue
            _vocabImage2.value = R.drawable.buttongreen
            _vocabImage3.value = R.drawable.buttonred
            _vocabImage4.value = R.drawable.buttonyellow

        }
        _flag.value = true
    }
    override fun onCleared() {
        super.onCleared()
        Log.i("VocabViewModel", "VocabViewModel destroyed!")
    }
}