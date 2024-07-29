import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tracker.task.Task
import kotlinx.coroutines.*
import java.time.LocalDateTime

class TaskViewModel(val task: Task) : ViewModel() {
    var timeDifference by mutableLongStateOf(calculateTimeDifference(task.time))
        private set

    init {
        viewModelScope.launch {
            while (isActive) {
                timeDifference = calculateTimeDifference(task.time)
                delay(1000L)
            }
        }
    }

    private fun calculateTimeDifference(taskTime: LocalDateTime): Long {
        val currentTime = LocalDateTime.now()
        return java.time.Duration.between(taskTime, currentTime).seconds
    }
}