package jp.techacademy.yae.wakahara.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // 数値を取得します。
        val num1 = intent.getFloatExtra("Num1", 0f)
        val num2 = intent.getFloatExtra("Num2", 0f)

        // 計算を実行し、演算子の文字列を取得します。
        var result: Float = 0f
        var operator: String = ""
        when(intent.getIntExtra("ButtonId", 0)) {
            R.id.plusButton -> {
                result = num1 + num2
                operator = "+"
            }
            R.id.minusButton -> {
                result = num1 - num2
                operator = "-"
            }
            R.id.timesButton -> {
                result = num1 * num2
                operator = "*"
            }
            R.id.divButton -> {
                result = num1 / num2
                operator = "/"
            }
        }

        // 計算結果を表示します。
        resultTextView.text = "  $num1 $operator $num2 = $result"
    }
}
