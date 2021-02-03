package kr.ukinas.partsmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.database.getIntOrNull
import androidx.core.database.getStringOrNull
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.barteksc.pdfviewer.util.FitPolicy
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = DBHelper(this)
        val db = dbHelper.writableDatabase
        val resultList = ArrayList<Part>()
        val queryResults = db.rawQuery("SELECT * FROM parts", null) // 쿼리
        queryResults.moveToFirst()
        while (!queryResults.isAfterLast) {

            resultList.add(
                Part(
                    queryResults.getInt(0),
                    queryResults.getString(1),
                    queryResults.getStringOrNull(2),
                    queryResults.getIntOrNull(3),
                    queryResults.getIntOrNull(4),
                    queryResults.getStringOrNull(5),
                    queryResults.getIntOrNull(6),
                    queryResults.getIntOrNull(7),
                    queryResults.getStringOrNull(8),
                    queryResults.getStringOrNull(9),
                    queryResults.getStringOrNull(10),
                    queryResults.getStringOrNull(11)
                )
            )
            queryResults.moveToNext()
        }
        queryResults.close()

        val adapter = PartAdapter(resultList, this)
        parts_list_view.layoutManager = LinearLayoutManager(this)
        parts_list_view.adapter = adapter

        // pdf viewer initializing
        pdfViewer()
    }

    fun onPartListClick(pdfFile: String) {
        pdfViewer(pdfFile)
    }

    private fun pdfViewer(fileName: String = "sample.pdf") {
        pdfView.fromAsset(fileName)
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .defaultPage(0)
            .enableAnnotationRendering(true)
            .password(null)
            .scrollHandle(null)
            .enableAntialiasing(true)
            .spacing(0)
            .pageFitPolicy(FitPolicy.WIDTH)
            .load()
    }

}