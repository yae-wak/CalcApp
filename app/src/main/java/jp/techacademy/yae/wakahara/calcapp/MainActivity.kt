package jp.techacademy.yae.wakahara.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // イベントリスナを設定します。
        plusButton.setOnClickListener(this)
        minusButton.setOnClickListener(this)
        timesButton.setOnClickListener(this)
        divButton.setOnClickListener(this)
    }

    /**
     * ボタン押下時の動作を定義します。
     */
    override fun onClick(v: View) {
        // 空文字の場合は実行しません。
        var message: String? = null
        if (editText1.text.isEmpty() && editText2.text.isEmpty())  message = "数値1と数値2"
        else if (editText1.text.isEmpty()) message = "数値1"
        else if (editText2.text.isEmpty()) message = "数値2"
        if (message != null) {
            message += "を入力してください"
            showSnackBar(v, message)
            return
        }

        // 0 で割る場合も実行しません。
        if (v.id == R.id.divButton && editText2.text.toString().toFloat() == 0f) {
            showSnackBar(v, "0 で割ることはできません")
            return
        }

        // インテントを生成します。
        val intent = Intent(this, ResultActivity::class.java)

        // ResultActivity に渡すデータを設定します。
        intent.putExtra("Num1", editText1.text.toString().toFloat())
        intent.putExtra("Num2", editText2.text.toString().toFloat())
        intent.putExtra("ButtonId", v.id)

        // 画面遷移します。
        startActivity(intent)
    }

    /**
     * SnackBar を表示します。
     */
    private fun showSnackBar(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_INDEFINITE)
            .setAction("OK"){}.show()
    }
}
