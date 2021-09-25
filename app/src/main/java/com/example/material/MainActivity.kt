package com.example.material

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.customview.widget.ViewDragHelper
import androidx.databinding.DataBindingUtil
import com.example.material.databinding.ActivityMainBinding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        // Говорим размещать наши карточки так, как предусмотрено в xml
        binding?.draggableCard1?.let { binding?.parentCoordinatorLayout?.addDraggableChild(it) }
        binding?.draggableCard2?.let { binding?.parentCoordinatorLayout?.addDraggableChild(it) }
        binding?.draggableCard3?.let { binding?.parentCoordinatorLayout?.addDraggableChild(it) }
        binding?.draggableCard4?.let { binding?.parentCoordinatorLayout?.addDraggableChild(it) }

        // Обращаемся к главному контейнеру (Компановщику)
        binding?.parentCoordinatorLayout?.setViewDragListener(object : DraggableCoordinatorLayout.ViewDragListener {
            // Отвечает за процесс перетаскивания
            override fun onViewCaptured(view: View, i: Int) {

                // При перемещении всегда 1 карточка должна оставаться на месте (К ней перетаскиваем другие)
                when (view.id) {
                    R.id.draggableCard1 -> binding?.draggableCard1?.isDragged = true
                    R.id.draggableCard2 -> binding?.draggableCard2?.isDragged = true
                    R.id.draggableCard3 -> binding?.draggableCard3?.isDragged = true
                }
            }
            // отвечает за процесс после перетаскивания
            override fun onViewReleased(view: View, v: Float, v1: Float) {

                when (view.id) {
                    R.id.draggableCard1 -> binding?.draggableCard1?.isDragged = false
                    R.id.draggableCard2 -> binding?.draggableCard2?.isDragged = false
                    R.id.draggableCard3 -> binding?.draggableCard3?.isDragged = false
                    R.id.draggableCard4 -> binding?.draggableCard4?.isDragged = false
                }
            }
        })
    }
}