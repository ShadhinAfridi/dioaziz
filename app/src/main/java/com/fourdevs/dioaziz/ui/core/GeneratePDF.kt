package com.fourdevs.dioaziz.ui.core

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.drawable.Icon
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfRenderer
import android.os.Build
import android.os.Environment
import android.os.ParcelFileDescriptor
import android.service.chooser.ChooserAction
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.FileProvider
import androidx.core.content.res.ResourcesCompat
import com.fourdevs.dioaziz.R
import com.fourdevs.dioaziz.ui.data.PassportData
import com.fourdevs.dioaziz.utils.CustomDate
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject


class GeneratePDF @Inject constructor(
    @ApplicationContext private val context: Context,
    private val customDate: CustomDate
) {

    fun editAndGeneratePDF(
        passportData: PassportData,
        newPassportData: (PassportData?) -> Unit
    ) {
        // Open the PDF file from the raw resources
        val pdfFile = File(context.filesDir, "sample_pdf.pdf")
        context.resources.openRawResource(R.raw.passport_form).use { input ->
            pdfFile.outputStream().use { output ->
                input.copyTo(output)
            }
        }

        val pdfRenderer =
            PdfRenderer(ParcelFileDescriptor.open(pdfFile, ParcelFileDescriptor.MODE_READ_ONLY))
        val pageCount = pdfRenderer.pageCount

        // High DPI settings
        val dpi = 300 // Higher DPI for better quality
        val a4Width = (8.27 * dpi).toInt() // 8.27 inches = 210 mm (A4 width)
        val a4Height = (11.69 * dpi).toInt() // 11.69 inches = 297 mm (A4 height)

        val pdfDocument = PdfDocument()

        val typeface: Typeface = ResourcesCompat.getFont(context, R.font.tiro_bangla_regular)!!
        //val typefaceSerif: Typeface = ResourcesCompat.getFont(context, R.font.noto_serif)!!

        for (i in 0 until pageCount) {
            val page = pdfRenderer.openPage(i)

            // Create a bitmap with high DPI
            val bitmap = Bitmap.createBitmap(a4Width, a4Height, Bitmap.Config.ARGB_8888)
            val scale =
                (a4Width.toFloat() / page.width).coerceAtMost(a4Height.toFloat() / page.height)
            val translateX = (a4Width - page.width * scale) / 2
            val translateY = (a4Height - page.height * scale) / 2

            val canvas = android.graphics.Canvas(bitmap)
            canvas.translate(translateX, translateY)
            canvas.scale(scale, scale)

            page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY)
            page.close()

            // Create a new page in the PdfDocument with A4 size and high DPI
            val pageInfo = PdfDocument.PageInfo.Builder(a4Width, a4Height, i + 1).create()
            val pdfPage = pdfDocument.startPage(pageInfo)
            pdfPage.canvas.drawBitmap(bitmap, 0f, 0f, null)

            val textItems = listOf(
                Triple("মোঃ আব্দুল আজিজ", 246f to 73f, 9f),
                Triple(passportData.pvrNo, 400f to 73f, 9f),
                Triple("ফরিদপুর", 234f to 86f, 9f),
                Triple(passportData.date, 340f to 86f, 9f),
                Triple(passportData.endDate, 314f to 99f, 9f),
                Triple(passportData.applicantName, 115f to 160f, 10f),
                Triple(passportData.enrollId, 115f to 181.5f, 10f),
                Triple(passportData.nidBrcNo, 130f to 203.5f, 10f),
                Triple(passportData.father, 65f to 225.5f, 10f),
                Triple(passportData.mother, 65f to 247.5f, 10f),
                Triple(passportData.dob, 110f to 268.5f, 10f),
                Triple(passportData.occupation, 65f to 291f, 10f),
                Triple(passportData.permanentAddress, 110f to 312.5f, 10f),
                Triple(passportData.permanentPost, 65f to 334.5f, 10f),
                Triple(passportData.permanentThana, 65f to 356f, 10f),
                Triple(passportData.permanentZilla, 188f to 356f, 10f),
                Triple(passportData.presentAddress, 118f to 378f, 10f),
                Triple(passportData.presentPost, 65f to 400f, 10f),
                Triple(passportData.presentThana, 65f to 421.5f, 10f),
                Triple(passportData.presentZilla, 188f to 421.5f, 10f),
                Triple(passportData.applicantMobileNo, 90f to 443.5f, 10f),
                Triple(passportData.personOneName, 325f to 573.5f, 9f),
                Triple(passportData.personOneRelation, 333f to 588f, 9f),
                Triple(passportData.personOneRelation, 350f to 603.5f, 9f),
                Triple(passportData.personTwoName, 325f to 633.5f, 9f),
                Triple(passportData.personTwoRelation, 333f to 648f, 9f),
                Triple(passportData.personTwoMobileNo, 350f to 663.5f, 9f)
            )

            textItems.forEach { (text, position, size) ->
                makeText(
                    bitmap,
                    typeface,
                    pdfPage,
                    scale,
                    text,
                    position.first,
                    position.second,
                    size
                )
            }
            pdfDocument.finishPage(pdfPage)
        }

        try {
            val directory = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                "DioAziz/${customDate.convertTimestampToDate(System.currentTimeMillis())}"
            )
            // Create the directory if it doesn't exist
            if (!directory.exists()) {
                directory.mkdirs()
            }
            val file = File(directory, "${passportData.enrollId}.pdf")

            if(!file.exists()){
                pdfDocument.writeTo(FileOutputStream(file))
                Toast.makeText(context, file.absolutePath, Toast.LENGTH_SHORT).show()
                val newData = passportData.copy(
                    fileName = file.absolutePath
                )
                newPassportData(newData)
            } else {
                Toast.makeText(context, "File exists on "+file.absolutePath, Toast.LENGTH_SHORT).show()
            }

        } catch (e: Exception) {
            Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        } finally {
            pdfRenderer.close()
            pdfDocument.close()
        }
    }

    private fun makeText(
        bitmap: Bitmap,
        typeface: Typeface,
        pdfPage: PdfDocument.Page,
        scale: Float,
        text: String,
        positionX: Float,
        positionY: Float,
        textSize: Float
    ) {
        val paint = Paint().apply {
            color = android.graphics.Color.BLACK
            this.textSize = textSize * (bitmap.width / 595f) // Scale the text size appropriately
            this.typeface = typeface // Apply custom font
        }
        pdfPage.canvas.drawText(text, positionX * scale, positionY * scale, paint)
    }

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    fun sendFile(pdfFile: File) {
        val fileUri = FileProvider.getUriForFile(
            context,
            "${context.packageName}.provider",
            pdfFile
        )

        val sendIntent = Intent(Intent.ACTION_SEND).apply {
            type = "application/pdf"
            putExtra(Intent.EXTRA_STREAM, fileUri) // Attach the PDF file
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

        val shareIntent = Intent.createChooser(sendIntent, null)

        val customActions = arrayOf(
            ChooserAction.Builder(
                Icon.createWithResource(context, R.drawable.ic_hourglass_bottom),
                "Custom",
                PendingIntent.getBroadcast(
                    context,
                    1,
                    Intent(Intent.ACTION_VIEW),
                    PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_CANCEL_CURRENT
                )
            ).build()
        )

        shareIntent.putExtra(Intent.EXTRA_CHOOSER_CUSTOM_ACTIONS, customActions)
        context.startActivity(shareIntent)
    }

}

